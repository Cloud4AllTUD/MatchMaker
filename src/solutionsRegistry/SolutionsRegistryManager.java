package solutionsRegistry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author nkak
 */
public class SolutionsRegistryManager 
{
    Gson gson;
    public String solutionsRegistryFilepath;
    SolutionsRegistryItem[] allSolutionsRegistryItems;
    
    private static SolutionsRegistryManager instance = null;
    
    private SolutionsRegistryManager()
    {
        gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        solutionsRegistryFilepath = "";
    }
    
    public static SolutionsRegistryManager getInstance() 
    {
        if(instance == null) 
            instance = new SolutionsRegistryManager();
        return instance;
    }
    
    public void init()
    {
        try
        {
            allSolutionsRegistryItems = gson.fromJson(new FileReader(new File(solutionsRegistryFilepath)), SolutionsRegistryItem[].class);
            System.out.println("\n\n\n\n***** SOLUTIONS REGISTRY (INPUT) *****");
            System.out.println("***** Test - Read JSON solutions registry from file *****");
            System.out.println("Input File: " + solutionsRegistryFilepath + "\n");
            System.out.println(gson.toJson(allSolutionsRegistryItems));
        }
        catch(Exception e)
        {
            System.out.println("\nSolutionsRegistryManager - init() -> EXCEPTION CAUGHT!\n");
            e.printStackTrace();
        }
    }
    
    public SolutionsRegistryItem getSolutionsRegistryItemByID(String tmpID)
    {
        for(int i=0; i<allSolutionsRegistryItems.length; i++)
        {
            if( allSolutionsRegistryItems[i].id.equals(tmpID) )
                return allSolutionsRegistryItems[i];
        }
        return null;
    }
    
    public void generateOutputForRule1()
    {
        SolutionsRegistryItem WindowsBuiltInMagnifier = getSolutionsRegistryItemByID("com.microsoft.windows.magnifier");
        
        WindowsBuiltInMagnifier.settingsHandlers.get(0).settings = new SettingsClass();
        WindowsBuiltInMagnifier.settingsHandlers.get(0).settings.Invert = true;
        
         SolutionsRegistryItem[] newSolutionsRegistryItems = new SolutionsRegistryItem[1]; 
         newSolutionsRegistryItems[0] = WindowsBuiltInMagnifier;
         
         String outputStr = gson.toJson(newSolutionsRegistryItems);
        
        System.out.println("\n\n\n***** RB-MM OUTPUT *****\n");
        System.out.println(outputStr);

        //save RB-MM output to file
        try
        {
            String outputFilepath = System.getProperty("user.dir") + "\\RBMM_output.json";
            
            FileWriter fstream = new FileWriter(outputFilepath);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(outputStr);
            //Close the output stream
            out.close();

            System.out.println("\n\nRB-MM output created: " + outputFilepath);
        }
        catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
}
