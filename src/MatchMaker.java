import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        System.out.println("logger level = " + logger.getLevel());
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

}
