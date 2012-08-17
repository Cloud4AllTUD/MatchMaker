import java.util.*;

import com.google.gson.*;

public class Parser {

    public Parser() {}

    public ArrayList<UserProfileEntry> parseUserProfile(String jsonFile) throws JsonSyntaxException {
        JsonParser parser = new JsonParser();
        JsonElement jsonElement = parser.parse(jsonFile);
        return recursiveUserProfile(jsonElement, null);
    }

    private ArrayList<UserProfileEntry> recursiveUserProfile(JsonElement jElement, ArrayList<UserProfileEntry> pList) {
        if(jElement.isJsonArray()) {
            ArrayList<UserProfileEntry> profileList = new ArrayList<UserProfileEntry>();
            for(JsonElement jsonArrayElement : jElement.getAsJsonArray())
                profileList = recursiveUserProfile(jsonArrayElement.getAsJsonObject(), profileList);
            return profileList;
        }
        if(jElement.isJsonObject()) {
            JsonObject jObject = jElement.getAsJsonObject();
            UserProfileEntry pEntry = new UserProfileEntry();
            if(jObject.has("name")) {
                JsonPrimitive primitive = jObject.getAsJsonPrimitive("name");
                if (primitive.isString())
                    pEntry.setName(primitive.getAsString());
            }
            if(jObject.has("value"))
                pEntry.setValue(jObject.getAsJsonPrimitive("value"));
            if(jObject.has("condition")) {
                JsonElement cElement = jObject.get("condition");
                if (cElement.isJsonPrimitive())
                    pEntry.setCondition(null);
                else if (cElement.isJsonArray())
                    pEntry.setCondition(recursiveUserProfile(cElement, null));
            }
            pList.add(pEntry);
            return pList;
        }
        return null;
    }

    public ArrayList<DeviceProfileEntry> parseDeviceProfile(String jsonFile) throws JsonSyntaxException {
        JsonParser parser = new JsonParser();
        JsonElement jElement = parser.parse(jsonFile);

        ArrayList<DeviceProfileEntry> dList = new ArrayList<DeviceProfileEntry>();
        if(jElement.isJsonObject()) {
            for(Map.Entry<String, JsonElement> mainOption : jElement.getAsJsonObject().entrySet()) {
                DeviceProfileEntry dEntry = new DeviceProfileEntry(mainOption.getKey());
                if(mainOption.getValue().isJsonObject()) {
                    for(Map.Entry<String, JsonElement> subOption : mainOption.getValue().getAsJsonObject().entrySet()) {
                        if(subOption.getValue().isJsonPrimitive())
                            dEntry.setSettingsValue(subOption.getKey(), subOption.getValue().getAsJsonPrimitive());
                        else
                            return null;
                    }
                    dList.add(dEntry);
                }
                else
                    return null;
            }
        }
        else
            return null;
        return dList;
    }

} // end of class "Parse"
