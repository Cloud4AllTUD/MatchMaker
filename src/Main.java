import java.util.*;

import com.google.gson.*;

//import javax.ws.rs.core.MediaType;
// import com.sun.jersey.api.client.Client;
// import com.sun.jersey.api.client.ClientResponse;
// import com.sun.jersey.api.client.WebResource;

// import com.google.gson.JsonParser;
//import com.google.gson.JsonElement;
//import java.io.FileReader;
//import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        String userProfileFileName = "./data/user_profile.json";
        String deviceProfileFileName = "./data/device_profile.json";

        // load profiles from files
        IOOperations ioController = new IOOperations();
        String userProfile = "";
        String deviceProfile = "";

        // the user profile
        try {
            userProfile = ioController.getFileContents(userProfileFileName);
        } catch(java.io.FileNotFoundException e) {
            System.err.println("File " + userProfileFileName + " not found");
            System.exit(1);
        } catch(java.io.IOException e) {
            System.err.println("IOException " + e);
            System.exit(1);
        }

        // the device profile
        try {
            deviceProfile = ioController.getFileContents(deviceProfileFileName);
        } catch(java.io.FileNotFoundException e) {
            System.err.println("File " + deviceProfileFileName + " not found");
            System.exit(2);
        } catch(java.io.IOException e) {
            System.err.println("IOException " + e);
            System.exit(2);
        }

        // parse the loaded profiles
        Parser p = new Parser();
        ArrayList<ProfileEntry> pList = p.parseUserProfile(userProfile);
        if(pList == null) {
            System.out.println("Parsing error in the user profile");
            System.exit(3);
        }
        System.out.println("User profile list has " + pList.size() + " elements");
        for(ProfileEntry pEntry : pList)
            System.out.println(pEntry.toString());

        ArrayList<DeviceProfileEntry> dList = p.parseDeviceProfile(deviceProfile);
        if(dList == null) {
            System.out.println("Parsing error in the device profile");
            System.exit(4);
        }
        System.out.println("Device profile list has " + dList.size() + " elements");
        for(DeviceProfileEntry dEntry : dList)
            System.out.println(dEntry.toString());


        // create available solutions
        ArrayList<Solution> sList = new ArrayList<Solution>();
        // orca
        Solution solution = new Solution("orca");
        DeviceProfileEntry requirement = new DeviceProfileEntry("os");
        requirement.setValue("type", new JsonPrimitive("linux"));
        requirement.setValue("subtype", new JsonPrimitive("debian"));
        requirement.setValue("version", new JsonPrimitive(6));
        solution.addRequirement(requirement);
        requirement = new DeviceProfileEntry("os");
        requirement.setValue("type", new JsonPrimitive("linux"));
        requirement.setValue("subtype", new JsonPrimitive("ubuntu"));
        requirement.setValue("version", new JsonPrimitive(12.04));
        solution.addRequirement(requirement);
        ArrayList<String> attributes = new ArrayList<String>();
        attributes.add("preferred-lang");
        attributes.add("speech-rate");
        solution.addSolution("screen-reader", attributes);
        sList.add(solution);

        System.out.println("Solution list has " + sList.size() + " elements");
        for(Solution sol : sList)
            System.out.println(sol.toString());

    } // end of function "Main"
} // end of class "Main"
