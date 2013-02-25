package instantiation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hp.hpl.jena.datatypes.xsd.XSDDatatype;
import com.hp.hpl.jena.ontology.DatatypeProperty;
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Statement;
import inference.RulesManager;
import instantiation.User.Condition;
import instantiation.User.VariableDoubleValue;
import instantiation.User.VariableIntValue;
import instantiation.User.VariableStringValue;
import java.io.*;
import ontology.OntologyManager;

/**
 *
 * @author nkak
 */
public class InstantiationManager 
{
    String SOURCE = "http://www.cloud4all.eu/SemanticFrameworkForContentAndSolutions.owl";
    String NS = SOURCE + "#";
    
    public String sammyFilepath;
    public String environmentProfileFilepath;
    
    private static InstantiationManager instance = null;
    
    private InstantiationManager() 
    {
    }
    
    public static InstantiationManager getInstance() 
    {
        if(instance == null) 
            instance = new InstantiationManager();
        return instance;
    }
    
    public void createInstanceInOntologyForJSONUserPreferencesSet()
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        try
        {
            //read JSON file and put contents to java object
            //User_OLD_JSON_STRUCTURE tmpUser = gson.fromJson(new FileReader(new File(sammyFilepath)), User_OLD_JSON_STRUCTURE.class);
            User tmpUser = gson.fromJson(new FileReader(new File(sammyFilepath)), User.class);
            System.out.println("\n\n\n\n***** INSTANTIATION MANAGER (User) *****");
            System.out.println("***** Test - Read JSON user preferences set from file and add a new instance to the ontology *****");
            System.out.println("Input File: " + sammyFilepath + "\n");
            System.out.println(gson.toJson(tmpUser));
            
            //add to ontology
            Individual tmpUserOntInstance = OntologyManager.getInstance().model.getOntClass(NS + "TempUsers").createIndividual(NS + "TEST_SAMMY");
            
            DatatypeProperty fontSizeProp = OntologyManager.getInstance().model.getDatatypeProperty(NS + "TempUsers_fontSize");
            Literal fontSizeProp_value = OntologyManager.getInstance().model.createTypedLiteral(((VariableIntValue)(tmpUser.fontSize.get(0))).value, XSDDatatype.XSDint);
            Statement fontSizeStat = OntologyManager.getInstance().model.createStatement(tmpUserOntInstance, fontSizeProp, fontSizeProp_value);
            OntologyManager.getInstance().model.add(fontSizeStat);
            
            DatatypeProperty magnificationProp = OntologyManager.getInstance().model.getDatatypeProperty(NS + "TempUsers_magnification");
            Literal magnificationProp_value = OntologyManager.getInstance().model.createTypedLiteral(((VariableDoubleValue)(tmpUser.magnification.get(0))).value, XSDDatatype.XSDfloat);
            Statement magnificationStat = OntologyManager.getInstance().model.createStatement(tmpUserOntInstance, magnificationProp, magnificationProp_value);
            OntologyManager.getInstance().model.add(magnificationStat);
            
            DatatypeProperty foregroundColorProp = OntologyManager.getInstance().model.getDatatypeProperty(NS + "TempUsers_foregroundColor");
            Literal foregroundColorProp_value = OntologyManager.getInstance().model.createTypedLiteral(((VariableStringValue)(tmpUser.foregroundColor.get(0))).value, XSDDatatype.XSDstring);
            Statement foregroundColorStat = OntologyManager.getInstance().model.createStatement(tmpUserOntInstance, foregroundColorProp, foregroundColorProp_value);
            OntologyManager.getInstance().model.add(foregroundColorStat);
            
            DatatypeProperty backgroundColorProp = OntologyManager.getInstance().model.getDatatypeProperty(NS + "TempUsers_backgroundColor");
            Literal backgroundColorProp_value = OntologyManager.getInstance().model.createTypedLiteral(((VariableStringValue)(tmpUser.backgroundColor.get(0))).value, XSDDatatype.XSDstring);
            Statement backgroundColorStat = OntologyManager.getInstance().model.createStatement(tmpUserOntInstance, backgroundColorProp, backgroundColorProp_value);
            OntologyManager.getInstance().model.add(backgroundColorStat);
            
            DatatypeProperty screenReaderTTSEnabled_whenLaunchAtStartupIsTrue_Prop = OntologyManager.getInstance().model.getDatatypeProperty(NS + "TempUsers_ScreenReaderTTSEnabled_whenLaunchAtStartupIsTrue");
            
            if( ((VariableStringValue)tmpUser.screenReaderTTSEnabled.get(0)).condition.operator.property.equals("http://gpii.org/ns/LaunchAtStartup")
                    && ((VariableStringValue)tmpUser.screenReaderTTSEnabled.get(0)).condition.operator.value.toLowerCase().equals("true") )
            {
                Literal screenReaderTTSEnabled_whenLaunchAtStartupIsTrue_Prop_value = null;
                if( ((VariableStringValue)tmpUser.screenReaderTTSEnabled.get(0)).value.toLowerCase().equals("true") )
                    screenReaderTTSEnabled_whenLaunchAtStartupIsTrue_Prop_value = OntologyManager.getInstance().model.createTypedLiteral(true, XSDDatatype.XSDboolean);
                else
                    screenReaderTTSEnabled_whenLaunchAtStartupIsTrue_Prop_value = OntologyManager.getInstance().model.createTypedLiteral(false, XSDDatatype.XSDboolean);
                Statement screenReaderTTSEnabled_whenLaunchAtStartupIsTrue_Stat = OntologyManager.getInstance().model.createStatement(tmpUserOntInstance, screenReaderTTSEnabled_whenLaunchAtStartupIsTrue_Prop, screenReaderTTSEnabled_whenLaunchAtStartupIsTrue_Prop_value);
                OntologyManager.getInstance().model.add(screenReaderTTSEnabled_whenLaunchAtStartupIsTrue_Stat);
            }
        }
        catch(Exception e)
        {
            System.out.println("\ncreateInstanceInOntologyForJSONUserPreferencesSet-> EXCEPTION CAUGHT!\n");
            e.printStackTrace();
        }
    }
    
    public void createInstanceInOntologyForJSONEnvironment()
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        try
        {
            //read JSON file and put contents to java object
            Environment tmpEnvironment = gson.fromJson(new FileReader(new File(environmentProfileFilepath)), Environment.class);
            System.out.println("\n\n\n\n***** INSTANTIATION MANAGER (Environment) *****");
            System.out.println("***** Test - Read JSON environment description from file and add a new instance to the ontology *****");
            System.out.println("Input File: " + environmentProfileFilepath + "\n");
            System.out.println(gson.toJson(tmpEnvironment));
            
            //add to ontology
            Individual tmpEnvironmentOntInstance = OntologyManager.getInstance().model.getOntClass(NS + "TempEnvironment").createIndividual(NS + "TEST_ENVIRONMENT");
            
            DatatypeProperty platformNameProp = OntologyManager.getInstance().model.getDatatypeProperty(NS + "TempEnvironment_platformName");
            Literal platformNameProp_value = OntologyManager.getInstance().model.createTypedLiteral(tmpEnvironment.OS.id, XSDDatatype.XSDstring);
            Statement platformNameStat = OntologyManager.getInstance().model.createStatement(tmpEnvironmentOntInstance, platformNameProp, platformNameProp_value);
            OntologyManager.getInstance().model.add(platformNameStat);
            
            DatatypeProperty platformVersionProp = OntologyManager.getInstance().model.getDatatypeProperty(NS + "TempEnvironment_platformVersion");
            Literal platformVersionProp_value = OntologyManager.getInstance().model.createTypedLiteral(tmpEnvironment.OS.version, XSDDatatype.XSDstring);
            Statement platformVersionStat = OntologyManager.getInstance().model.createStatement(tmpEnvironmentOntInstance, platformVersionProp, platformVersionProp_value);
            OntologyManager.getInstance().model.add(platformVersionStat);
            
            DatatypeProperty windowManagerIdProp = OntologyManager.getInstance().model.getDatatypeProperty(NS + "TempEnvironment_windowManager_id");
            Literal windowManagerIdProp_value = OntologyManager.getInstance().model.createTypedLiteral(tmpEnvironment.windowManager.id, XSDDatatype.XSDstring);
            Statement windowManagerIdStat = OntologyManager.getInstance().model.createStatement(tmpEnvironmentOntInstance, windowManagerIdProp, windowManagerIdProp_value);
            OntologyManager.getInstance().model.add(windowManagerIdStat);
            
            DatatypeProperty windowManagerVersionProp = OntologyManager.getInstance().model.getDatatypeProperty(NS + "TempEnvironment_windowManager_version");
            Literal windowManagerVersionProp_value = OntologyManager.getInstance().model.createTypedLiteral(tmpEnvironment.windowManager.version, XSDDatatype.XSDstring);
            Statement windowManagerVersionStat = OntologyManager.getInstance().model.createStatement(tmpEnvironmentOntInstance, windowManagerVersionProp, windowManagerVersionProp_value);
            OntologyManager.getInstance().model.add(windowManagerVersionStat);
            
            //debug_writeOntologyToFile("D:/CLOUD4ALL/Cloud4All_MatchMaker/src/ontology/ontologies/generatedOntologyWithTestUserAndEnvironmement.owl");
        }
        catch(Exception e)
        {
            System.out.println("\ncreateInstanceInOntologyForJSONEnvironment-> EXCEPTION CAUGHT!\n");
            e.printStackTrace();
        }
    }
    
    public void debug_writeOntologyToFile(String tmpFilepath)
    {
        try
        {
            //OutputStream out = new FileOutputStream("D:/CLOUD4ALL/Cloud4All_MatchMaker/src/ontology/ontologies/generatedOntologyWithTestUserAndEnvironmement.owl");
            OutputStream out = new FileOutputStream(tmpFilepath);
            OntologyManager.getInstance().model.write(out, "RDF/XML-ABBREV"); // readable rdf/xml
            out.close();            
            System.out.println("\nDhmiourghthike new owl! -> " + tmpFilepath);        
        }
        catch(Exception e)
        {
            System.out.println("\ndebug_writeOntologyToFile-> EXCEPTION CAUGHT!\n");
            e.printStackTrace();
        }
    }
}
