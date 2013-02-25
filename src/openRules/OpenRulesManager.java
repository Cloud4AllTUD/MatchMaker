package openRules;

import com.openrules.ruleengine.Decision;
import com.openrules.ruleengine.OpenRulesEngine;
import java.util.ArrayList;
import ontology.OntologyManager;
import ontology.Solution;

/**
 *
 * @author nkak
 */
public class OpenRulesManager 
{
    private static OpenRulesManager instance = null;
    
    private OpenRulesManager() 
    {
    }
    
    public static OpenRulesManager getInstance() 
    {
        if(instance == null) 
            instance = new OpenRulesManager();
        return instance;
    }
    
    public void test()
    {
        System.out.println("\n\n\n\n\n*** OpenRules TEST***\n");
        
        String fileName = "file:rules/main/Decision.xls";
        Decision decision = new Decision("DetermineCustomerGreeting",fileName);
        
        UserProfile tmpUserProfile = new UserProfile();    
        tmpUserProfile.setName("User 1");
        tmpUserProfile.setUsesScreenReader(true);
        Response response = new Response();
        decision.put("userProfile", tmpUserProfile);
        decision.put("response", response);        
        decision.execute();
        System.out.println("Decision: " + response.getResult());
        
        if(tmpUserProfile.getUsesScreenReader())
        {
            System.out.println("\n\nSuitable screen readers for " + tmpUserProfile.getName() + ":");
            ArrayList<Solution> screenReadersRunningOnCurrentOS = OntologyManager.getInstance().getSolutionsRunningOnSpecificPlatformType(OntologyManager.ScreenReader_ID, response.getResult());
            for(int i=0; i<screenReadersRunningOnCurrentOS.size(); i++)
                System.out.println(((ontology.Solution)screenReadersRunningOnCurrentOS.get(i)).toString());
        }
        else
            System.out.println("\n\n" + tmpUserProfile.getName() + " doesn't use any screen reader...");
        
        tmpUserProfile = new UserProfile();    
        tmpUserProfile.setName("User 2");
        tmpUserProfile.setUsesScreenReader(false);
        response = new Response();
        decision.put("userProfile", tmpUserProfile);        
        decision.put("response", response);        
        decision.execute();
        System.out.println("Decision: " + response.getResult());
        
        if(tmpUserProfile.getUsesScreenReader())
        {
            System.out.println("\n\nSuitable screen readers for " + tmpUserProfile.getName() + ":");
            ArrayList<Solution> screenReadersRunningOnCurrentOS = OntologyManager.getInstance().getSolutionsRunningOnSpecificPlatformType(OntologyManager.ScreenReader_ID, response.getResult());
            for(int i=0; i<screenReadersRunningOnCurrentOS.size(); i++)
                System.out.println(((ontology.Solution)screenReadersRunningOnCurrentOS.get(i)).toString());
        }
        else
            System.out.println("\n\n" + tmpUserProfile.getName() + " doesn't use any screen reader...");
    }
}
