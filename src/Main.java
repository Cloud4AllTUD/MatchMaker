import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    private final static Logger logger = Logger.getLogger("MainLogger");

    public static void main(String[] args) {
        String userProfileFileName = "./data/user_profile.json";
        String deviceProfileFileName = "./data/device_profile.json";
        logger.setLevel(Level.FINE);
        //LogManager.getLogManager().setLevel(Level.FINE);

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
        ArrayList<UserProfileEntry> pList = p.parseUserProfile(userProfile);
        if(pList == null) {
            System.out.println("Parsing error in the user profile");
            System.exit(3);
        }
        System.out.println("User profile list has " + pList.size() + " elements");
        for(UserProfileEntry pEntry : pList)
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
        requirement.setSettingsValue("type", new JsonPrimitive("linux"));
        requirement.setSettingsValue("subtype", new JsonPrimitive("debian"));
        requirement.setSettingsValue("version", new JsonPrimitive(6));
        solution.addRequirement(requirement);
        requirement = new DeviceProfileEntry("os");
        requirement.setSettingsValue("type", new JsonPrimitive("linux"));
        requirement.setSettingsValue("subtype", new JsonPrimitive("ubuntu"));
        requirement.setSettingsValue("version", new JsonPrimitive(12.04));
        solution.addRequirement(requirement);
        requirement = new DeviceProfileEntry("desktop-environment");
        requirement.setSettingsValue("name", new JsonPrimitive("gnome"));
        requirement.setSettingsValue("version", new JsonPrimitive(2.30));
        solution.addRequirement(requirement);
        ArrayList<String> attributes = new ArrayList<String>();
        attributes.add("preferred-lang");
        attributes.add("speech-rate");
        solution.addSolution("screen-reader", attributes);
        sList.add(solution);

        // NVDA
        solution = new Solution("NVDA");
        requirement = new DeviceProfileEntry("os");
        requirement.setSettingsValue("type", new JsonPrimitive("windows"));
        requirement.setSettingsValue("subtype", new JsonPrimitive(""));
        requirement.setSettingsValue("version", new JsonPrimitive("xp"));
        solution.addRequirement(requirement);
        attributes = new ArrayList<String>();
        attributes.add("preferred-lang");
        attributes.add("speech-rate");
        solution.addSolution("screen-reader", attributes);
        sList.add(solution);

        // font-size
        solution = new Solution("Font-Size");
        requirement = new DeviceProfileEntry("os");
        requirement.setSettingsValue("type", new JsonPrimitive("linux"));
        requirement.setSettingsValue("subtype", new JsonPrimitive("debian"));
        requirement.setSettingsValue("version", new JsonPrimitive(6));
        solution.addRequirement(requirement);
        requirement = new DeviceProfileEntry("os");
        requirement.setSettingsValue("type", new JsonPrimitive("linux"));
        requirement.setSettingsValue("subtype", new JsonPrimitive("ubuntu"));
        requirement.setSettingsValue("version", new JsonPrimitive(12.04));
        solution.addRequirement(requirement);
        requirement = new DeviceProfileEntry("os");
        requirement.setSettingsValue("type", new JsonPrimitive("windows"));
        requirement.setSettingsValue("subtype", new JsonPrimitive(""));
        requirement.setSettingsValue("version", new JsonPrimitive("xp"));
        solution.addRequirement(requirement);
        attributes = new ArrayList<String>();
        attributes.add("preferred-font-size");
        solution.addSolution("font-size", attributes);
        sList.add(solution);

        System.out.println("Solution list has " + sList.size() + " elements");
        for(Solution sol : sList)
            System.out.println(sol.getName());

        // start the match making process
        MatchMaker mm = new MatchMaker();
        // first: filter all incompatible solutions from the solution list
        sList = mm.filterIncompatibleSolutions(sList, dList);
        // print solution list afterwards
        System.out.println("All incompatible solutions were filtered.\nSolution list has " + sList.size() + " elements");
        for(Solution sol : sList)
            System.out.println(sol.getName());
        System.out.println("\n");

        // next, match the available solutions with the user profile


    } // end of function "Main"
} // end of class "Main"
