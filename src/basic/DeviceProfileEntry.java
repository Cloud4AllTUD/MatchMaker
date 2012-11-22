package basic;

import java.util.*;
import com.google.gson.*;

public class DeviceProfileEntry {

    private String name;
    private HashMap<String,JsonPrimitive> settings;

    public DeviceProfileEntry(String name) {
        this.name = name;
        this.settings = new HashMap<String,JsonPrimitive>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String s) {
        this.name = s;
    }

    public HashMap<String,JsonPrimitive> getSettings() {
        return this.settings;
    }

    /**
     * returns the saved setting value for the given key
     * if the map does not contain the key, the method returns null
     */
    public JsonPrimitive getSettingsValue(String key) {
        return this.settings.get(key);
    }

    /**
     * add a key, value pair to the settings map
     * returns null if the key is new
     * otherwise it returns the old, overwritten value
     */
    public JsonPrimitive setSettingsValue(String key, JsonPrimitive value) {
        return this.settings.put(key, value);
    }

    public String toString() {
        String result = this.name + ":\n";
        for(String key : this.settings.keySet())
            result = result + "  " + key + " = " + this.settings.get(key) + "\n";
        return result;
    }

}
