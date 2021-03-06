package basic;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.script.ScriptException;
import ontology.OntologyManager;
import inference.RulesManager;
import instantiation.InstantiationManager;
import java.io.FileInputStream;
import openRules.OpenRulesManager;
import solutionsRegistry.SolutionsRegistryManager;

//import javax.ws.rs.core.MediaType;
// import com.sun.jersey.api.client.Client;
// import com.sun.jersey.api.client.ClientResponse;
// import com.sun.jersey.api.client.WebResource;

public class Main {

    private final static Logger logger = Logger.getLogger("MainLogger");

    public static void main(String[] args) 
    {
        //NIKOS
        Properties prop = new Properties();
        //e.g.D:\CLOUD4ALL\Cloud4All_MatchMaker\nbdist_GIA_TEST>java -jar Cloud4All_MatchMaker.jar D:/cloudSammy.txt D:/cloud_DeviceReporterExample.txt D:/cloud_SolutionsRegistry_win32.txt
        int argCounter = 0;
        for(String s: args) 
        {
            if(argCounter == 0)
                InstantiationManager.getInstance().sammyFilepath = s;
            else if(argCounter == 1)
                InstantiationManager.getInstance().environmentProfileFilepath = s;
            else if(argCounter == 2)
                SolutionsRegistryManager.getInstance().solutionsRegistryFilepath = s;
            System.out.println("args[" + Integer.toString(argCounter) + "]: " + s);
            argCounter++;
        }
        if(argCounter < 3)
        {
            System.out.println("Please provide the necessary arguments: 1)User profile filepath, 2)Device Reporter profile filepath, 3)Solutions registry filepath");
            System.exit(0);
        }
 
    	try {
               //load a properties file
    		prop.load(new FileInputStream("config.properties"));
 
               //get the property value 
                //InstantiationManager.getInstance().sammyFilepath = prop.getProperty("sammyFilepath");
                //InstantiationManager.getInstance().environmentProfileFilepath = prop.getProperty("environmentProfileFilepath");
                
    	} catch (IOException ex) {
    		ex.printStackTrace();
        }
        //-NIKOS
        
        String userProfileFileName = "./data/user_profile.json";
        String deviceProfileFileName = "./data/device_profile.json";
        logger.setLevel(Level.WARNING);
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
        ArrayList<UserProfileEntry> uList = new ArrayList<UserProfileEntry>();
        try {
            uList = p.parseUserProfile(userProfile);
        } catch (JsonSyntaxException e) {
            System.err.println("The json syntax of the user profile is malformed\n" + e);
            System.exit(3);
        }
            
        if(uList == null) {
            System.err.println("The syntax of the user profile is valide but the it's structure is not supported. For a working example look at the example file \"user_profile.json\" in the data directory.");
            System.exit(4);
        }
        /* NIKOS System.out.println("User profile list has " + uList.size() + " elements");
        for(UserProfileEntry pEntry : uList)
            System.out.println(pEntry.toString());
        System.out.println("\n");*/
        
        // parse the device profile
        ArrayList<DeviceProfileEntry> dList = new ArrayList<DeviceProfileEntry>();
        try {
            dList = p.parseDeviceProfile(deviceProfile);
         } catch (JsonSyntaxException e) {
            System.err.println("The json syntax of the device profile is malformed\n" + e);
            System.exit(5);
        }

        if(dList == null) {
            System.err.println("The syntax of the device profile is valide but the it's structure is not supported. For a working example look at the example file \"device_profile.json\" in the data directory.");
            System.exit(6);
        }
        /* NIKOS System.out.println("Device profile list has " + dList.size() + " elements");
        for(DeviceProfileEntry dEntry : dList)
            System.out.println(dEntry.toString());
        System.out.println("\n");*/


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

        /*NIKOS System.out.println("Solution list has " + sList.size() + " elements");
        for(Solution sol : sList)
            System.out.println(sol.getName());*/

        // start the match making process
        MatchMaker mm = new MatchMaker();
        // first: filter all incompatible solutions from the solution list
        sList = mm.filterIncompatibleSolutions(sList, dList);
        // print solution list afterwards
        /*NIKOS System.out.println("All incompatible solutions were filtered.\nSolution list has " + sList.size() + " elements");
        for(Solution sol : sList)
            System.out.println(sol.getName());
        System.out.println("\n");*/

        // next, match the available solutions with the user profile
        // returns a list of solutions which fit the requirements of the user
        // profile
        HashMap<String,HashSet<Solution>> sMap = mm.getSolutionsBasedOnUserProfile(sList, uList);
        /*NIKOS System.out.println("The following solutions with thair settings were found:");
        for(String solutionName : sMap.keySet()) {
            System.out.print(solutionName + ": ");
            for(Solution solEntry : sMap.get(solutionName))
                System.out.print(solEntry.getName() + ", ");
//                for(String attr : solEntry.getSolutions().get(solutionName))
                    //System.out.println(attr + ", ");
            System.out.println("\n");
        }*/

        // find the config values for the given solutions
        // if more than one plugin is available for a solution, the first one
        // will be chosen
        String jsonSettings = "{\n";
        /*NIKOS for(String solutionName : sMap.keySet()) {
            System.out.println("Search for the settings values for the solution: " + solutionName);
            HashSet<Solution> availablePlugins = sMap.get(solutionName);
            if(availablePlugins.isEmpty()) {
                System.out.println("The solution " + solutionName + " has no plugins.");
                continue;
            }
            if(availablePlugins.size() > 1)
                System.out.println("For the solution " + solutionName + " are " + availablePlugins + " plugins available. At the moment, the first in the list is taken");
            Solution chosenPlugin = new Solution("");
            for(Solution plugin : availablePlugins) {
                chosenPlugin = plugin;
                break;
            }
            System.out.println("Find the settings for the plugin: " + chosenPlugin.getName());
            HashMap<String,JsonPrimitive> pluginSettings = mm.getSettingsForAttributes(uList, chosenPlugin.getSolutions().get(solutionName)); 
            if(pluginSettings.isEmpty()) {
                System.out.println("For " + chosenPlugin.getName() + " exist no setting values in the user profile.\nThe solution " + solutionName + " stays unconfigured.");
                continue;
            }
            jsonSettings = jsonSettings + "\t\"" + chosenPlugin.getName() + "\" : {\n";
            for(String settingName : pluginSettings.keySet()) {
                System.out.println(settingName + " = " + pluginSettings.get(settingName));
                jsonSettings = jsonSettings + "\t\t\"" + settingName + "\" : " + pluginSettings.get(settingName) + ",\n";
            }
        jsonSettings = jsonSettings.substring(0, jsonSettings.length()-2) + "\n\t},\n";
        }
        jsonSettings = jsonSettings.substring(0, jsonSettings.length()-2) + "\n}";
        System.out.println("\nThe settings in json format:\n" + jsonSettings);*/
        
        //NIKOS
        /*OntologyManager.getInstance().init();
        OpenRulesManager.getInstance().test();
        try {
            RulesManager.getInstance().execute(1);
            RulesManager.getInstance().execute(4);
            RulesManager.getInstance().execute(2);
            RulesManager.getInstance().execute(4);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        SolutionsRegistryManager.getInstance().init();
        
        InstantiationManager.getInstance().createInstanceInOntologyForJSONUserPreferencesSet();
        InstantiationManager.getInstance().createInstanceInOntologyForJSONEnvironment();
        
        RulesManager.getInstance().executeMyCloudRulesForFindingHandicapSituations();
        
        //InstantiationManager.getInstance().debug_writeOntologyToFile("D:/CLOUD4ALL/Cloud4All_MatchMaker/src/ontology/ontologies/generatedOntology_AFTER_RULES_EXECUTION.owl");
        //-NIKOS
        
    } // end of function "Main"
} // end of class "Main"
