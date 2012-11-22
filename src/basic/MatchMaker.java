package basic;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.*;

/**
 * The match making class
 */

public class MatchMaker {

    private final static Logger logger = Logger.getLogger("MainLogger");

    public MatchMaker() {}

    /**
     * This function filters out all incompatible solutions
     * for example on a Linux system it would filter out all solutions which
     * work under Windows
     * Input:
     * deviceProfile: a device profile of the currently running machine,
     * contains of a list with DeviceProfileEntrys
     * sList: a list of all defined solutions
     * returns a list with all compatible solutions
     */
    public ArrayList<Solution> filterIncompatibleSolutions(ArrayList<Solution> sList, ArrayList<DeviceProfileEntry> deviceProfile) {
        ArrayList<Solution> compatible = new ArrayList<Solution>();
        ProfileManager pManager = new ProfileManager();
        for(Solution sol : sList) {
            // BooleanisCompatible = ProfileManager.compareDeviceProfiles(sol.getRequirements(), deviceProfile);
            HashMap<String,Boolean> hm = new HashMap<String,Boolean>();
            // walk through all requirements entries in the given solution
            for(DeviceProfileEntry req : sol.getRequirements()) {
                DeviceProfileEntry correspondingDeviceEntry = pManager.isInThatList(req.getName(), deviceProfile);
                // if the requirements name (for example "os") is not specified
                // in the device profile, consider this solution as not
                // compatible
                if(correspondingDeviceEntry == null) {
                    logger.fine(req.getName() + " not in device profile");
                    hm.put(req.getName(), false);
                    break;
                }
                else
                    logger.fine(req.getName() + " in " + sol.getName());

                if(hm.get(req.getName()) == null)
                    hm.put(req.getName(), false);
                if(hm.get(req.getName()) == false) {
                    Boolean compatibleSettings = pManager.compareDeviceEntrySettings(req.getSettings(), correspondingDeviceEntry.getSettings());
                    hm.put(req.getName(), compatibleSettings);
                }
            }
            Boolean isCompatible = true;
            for(String key : hm.keySet()) {
                logger.log(Level.FINE, sol.getName() + ": " + key + ": " + hm.get(key));
                if(hm.get(key) == false) {
                    isCompatible = false;
                    break;
                }
            }
            if(isCompatible)
                compatible.add(sol);
        }
    return compatible;
    }

    /**
     * This method gets a list of solutions and the user profile
     * By means of the user profile it creates a list of solution names which
     * result in the user profile entrys and the supported attributes of the
     * solutions
     * It returns a HashMap, whereat the solution name is the key and a set of
     * solutions is the regarding value
     * As a consequence one solution name, for example "screen-reader" can have
     * more than one concrete solution, for example "Jaws" and "NVDA"
     */
    public HashMap<String,HashSet<Solution>> getSolutionsBasedOnUserProfile( ArrayList<Solution> sList, ArrayList<UserProfileEntry> userProfile ) {
        HashMap<String,HashSet<Solution>> solutionMap = new HashMap<String,HashSet<Solution>>();
        for(UserProfileEntry uEntry : userProfile ) {
            String attrName = uEntry.getName();
            for( Solution sol : sList ) {
                String newSolution = sol.hasAttribute(attrName);
                if( newSolution == null )
                    break;
                // if the HashMap still don't contains a solution named
                // newSsolution then add it as key and instantiate a new
                // ArrayList as value
                HashSet<Solution> foundSolutions = solutionMap.get(newSolution);
                if( foundSolutions == null)
                    foundSolutions = new HashSet<Solution>();
                // add the solution sol to the list
                Boolean b = foundSolutions.add(sol);
                solutionMap.put(newSolution, foundSolutions);
            }
        }
        return solutionMap;
    }

    /**
     * This function gets a user profile and a list of attributes. It returns
     * the attributes and it's corresponding values, which are extracted from
     * the user profile.
     * If an attribute is available in the user profile more than ones the one
     * with a given condition is taken. Of course only, if the condition is
     * fulfilled.
     */
    public HashMap<String,JsonPrimitive> getSettingsForAttributes(ArrayList<UserProfileEntry> userProfile, ArrayList<String> attributes) {
        HashMap<String,JsonPrimitive> settings = new HashMap<String,JsonPrimitive>();
        for(String attr : attributes) {
            for(UserProfileEntry uEntry : userProfile) {
                // if the attribute is not in the user profile entry, jump to the next
                // one
                if(! attr.equals(uEntry.getName()) )
                    continue;

                // if the entry in the user profile has no condition the found
                // value is taken as long as no other match with a condition
                // occurs
                if(uEntry.getCondition() == null) {
                    settings.put(attr, uEntry.getValue());
                    continue;
                }

                // check if the condition of uEntry matches one of the other user profile
                // entrys
                // at the moment, the name and value of the condition are compared
                ProfileManager pm = new ProfileManager();
                Boolean matchConditions = true;
                for( UserProfileEntry cEntry : uEntry.getCondition() ) {
                    if(pm.conditionMatchesUserProfile(cEntry, userProfile) == false) {
                        matchConditions = false;
                        break;
                    }
                }
                if(matchConditions == true) {
                    settings.put(attr, uEntry.getValue());
                    break;
                }
            }
        }
        return settings;
    }
}
