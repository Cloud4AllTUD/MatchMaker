package basic;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.JsonPrimitive;

/**
 * A little helper class with a few useful functions
 */
public class ProfileManager {
    
    private final static Logger logger = Logger.getLogger("MainLogger");

    public ProfileManager() {}

    /**
     * this funktion checks, if the name of the device profile entry also can be
     * found in the given device profile
     */
    public DeviceProfileEntry isInThatList(String name, ArrayList<DeviceProfileEntry> deviceProfile) {
        for(DeviceProfileEntry dEntry : deviceProfile) {
            if( name.equals(dEntry.getName()) )
                return dEntry;
        }
        return null;
    }

    /**
     * this method compares the settings (HashMaps) of two device profile entrys
     * s1 comes from the requirements list of a solution
     * s2 is a device profile entry
     */
    public Boolean compareDeviceEntrySettings(HashMap<String,JsonPrimitive> s1, HashMap<String,JsonPrimitive> s2) {
        logger.finest("compare two HashMaps");
        for(String key : s1.keySet()) {
            // if a key in s1 can't be found in s2 then they're not equal
            if(s2.get(key) == null)
                return false;
            JsonPrimitive v1 = s1.get(key);
            JsonPrimitive v2 = s2.get(key);
            logger.finest(v1 + " == " + v2);
            // compare version numbers
            if(v1.isNumber() && v2.isNumber()) {
                // for example it's not allowed, that orca requires at least
                // version 6 of debian but the device profile says, that Debian 6
                // is running
                if(v1.getAsFloat() > v2.getAsFloat())
                    return false;
            }
            else if(v1.isString() && v2.isString()) {
                if( !(v1.getAsString().toLowerCase().equals(v2.getAsString().toLowerCase())) )
                    return false;
            }
            else if(! v1.equals(v2))
                return false;
        }
        return true;
    }

    /**
     * This is a helper function of the MatchMaker class
     * It checks, if the condition of a user profile entry is conform with the
     * whole user profile
     * if so, it returns true and the corresponding value of the user profile
     * entry is used for the attribute
     * else it returns false
     */
    public Boolean conditionMatchesUserProfile(UserProfileEntry condition, ArrayList<UserProfileEntry> userProfile) {
        for(UserProfileEntry uEntry : userProfile) {
            if( condition.getName().equals(uEntry.getName()) )
                return true;
            if( condition.getValue().equals(uEntry.getValue()) )
                return true;
        }
        return false;
    }
}
