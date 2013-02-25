package inference;
/**
 *
 * @author nkak
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.reasoner.Reasoner;
import com.hp.hpl.jena.reasoner.ReasonerRegistry;
import com.hp.hpl.jena.reasoner.rulesys.GenericRuleReasoner;
import com.hp.hpl.jena.reasoner.rulesys.Rule;
import com.hp.hpl.jena.shared.DoesNotExistException;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import ontology.*;
import solutionsRegistry.SolutionsRegistryManager;

public class RulesManager 
{
    public Model m;
    public BufferedReader br;
    
    //String uri_storeFront_owl;
    //String uri_storeFront_rules;
    String uri_MatchMaker_rules;
    
    private static RulesManager instance = null;
    
    private RulesManager() 
    {
        m = ModelFactory.createDefaultModel();
        
        String currentDir = System.getProperty("user.dir");
        //System.out.println("currentDir: " + currentDir);
        //uri_storeFront_owl = this.getClass().getResource("/ontology/ontologies/storeFront.owl").getPath();
        //uri_storeFront_rules = this.getClass().getResource("/ontology/rules/storeFront.rules").getPath();
        //uri_MatchMaker_rules = this.getClass().getResource(currentDir + "/jena_rules/MatchMakerRules.rules").getPath();
        uri_MatchMaker_rules = currentDir + "/jena_rules/MatchMakerRules.rules";
    }
    
    public static RulesManager getInstance() 
    {
        if(instance == null) 
            instance = new RulesManager();
        return instance;
    }
    
    public void executeMyCloudRulesForFindingHandicapSituations()
    {
        /*System.out.println("\n\n\n\n\n\n");            
        StmtIterator si = OntologyManager.getInstance().model.listStatements();
        Statement s = null;
        while(si.hasNext()) 
        {
            s = si.next();
            System.out.println(s);
        }*/
//DEBUG        
        System.out.println("\n\nINSTANCES BEFORE RULES EXECUTION:");
        
        //get TempUsers
        ArrayList<TempUser> allInstances_TempUsers = OntologyManager.getInstance().getInstances(OntologyManager.TempUsers_ID);
        if(allInstances_TempUsers != null)
        {
            for(int i=0; i<allInstances_TempUsers.size(); i++)
                System.out.println(allInstances_TempUsers.get(i).toString());
        }
        else
            System.out.println("\tThere are no User instances!");
        //get TempEnvironment
        ArrayList<TempEnvironment> allInstances_TempEnvironment = OntologyManager.getInstance().getInstances(OntologyManager.TempEnvironment_ID);
        if(allInstances_TempEnvironment != null)
        {
            for(int i=0; i<allInstances_TempEnvironment.size(); i++)
                System.out.println(allInstances_TempEnvironment.get(i).toString());
        }
        else
            System.out.println("\tThere are no Environment instances!");
        
        //get TempHandicapSituations
        ArrayList<TempHandicapSituation> allInstances_TempHandicapSituations = OntologyManager.getInstance().getInstances(OntologyManager.TempHandicapSituations_ID);
        if(allInstances_TempHandicapSituations != null)
        {
            for(int i=0; i<allInstances_TempHandicapSituations.size(); i++)
                System.out.println(allInstances_TempHandicapSituations.get(i).toString());
        }
        else
            System.out.println("\tThere are no HandicapSituation instances!");
        
        //get TempPossibleSolutions
        ArrayList<TempPossibleSolution> allInstances_TempPossibleSolutions = OntologyManager.getInstance().getInstances(OntologyManager.TempPossibleSolutions_ID);
        if(allInstances_TempPossibleSolutions != null)
        {
            for(int i=0; i<allInstances_TempPossibleSolutions.size(); i++)
                System.out.println(allInstances_TempPossibleSolutions.get(i).toString());
        }
        else
            System.out.println("\tThere are no PossibleSolution instances!");
//-DEBUG       
        
        System.out.println("\nRULES EXECUTION - START");
        List<Rule> rules = Rule.rulesFromURL(uri_MatchMaker_rules);
        GenericRuleReasoner r = new GenericRuleReasoner(rules);
        r.setOWLTranslation(true);           
        r.setTransitiveClosureCaching(true);

        InfModel infmodel = ModelFactory.createInfModel(r, OntologyManager.getInstance().model);
        OntologyManager.getInstance().model.add(infmodel.getDeductionsModel());
        System.out.println("RULES EXECUTION - END");
        
        System.out.println("\nINSTANCES AFTER RULES EXECUTION:");
        
//DEBUG       
        //get TempUsers
        allInstances_TempUsers = OntologyManager.getInstance().getInstances(OntologyManager.TempUsers_ID);
        if(allInstances_TempUsers != null)
        {
            for(int i=0; i<allInstances_TempUsers.size(); i++)
                System.out.println(allInstances_TempUsers.get(i).toString());
        }
        else
            System.out.println("\tThere are no User instances!");
        //get TempEnvironment
        allInstances_TempEnvironment = OntologyManager.getInstance().getInstances(OntologyManager.TempEnvironment_ID);
        if(allInstances_TempEnvironment != null)
        {
            for(int i=0; i<allInstances_TempEnvironment.size(); i++)
                System.out.println(allInstances_TempEnvironment.get(i).toString());
        }
        else
            System.out.println("\tThere are no Environment instances!");
        
        //get TempHandicapSituations
        allInstances_TempHandicapSituations = OntologyManager.getInstance().getInstances(OntologyManager.TempHandicapSituations_ID);
        if(allInstances_TempHandicapSituations != null)
        {
            for(int i=0; i<allInstances_TempHandicapSituations.size(); i++)
                System.out.println(allInstances_TempHandicapSituations.get(i).toString());
        }
        else
            System.out.println("\tThere are no HandicapSituation instances!");
        
        //get TempPossibleSolutions
        allInstances_TempPossibleSolutions = OntologyManager.getInstance().getInstances(OntologyManager.TempPossibleSolutions_ID);
        if(allInstances_TempPossibleSolutions != null)
        {
            for(int i=0; i<allInstances_TempPossibleSolutions.size(); i++)
                System.out.println(allInstances_TempPossibleSolutions.get(i).toString());
        }
        else
            System.out.println("\tThere are no PossibleSolution instances!");
//-DEBUG     
        
        //get TempHandicapSituations
        if(allInstances_TempHandicapSituations != null)
        {
            for(int i=0; i<allInstances_TempHandicapSituations.size(); i++)
            {
                if(allInstances_TempHandicapSituations.get(i).problemWithForegroundAndBackgroundColor)
                {
                    SolutionsRegistryManager.getInstance().generateOutputForRule1();
                    break;
                }
            }
        }
    }
    
    
    
    
    /*public void execute(int command) throws IOException 
    {
        if(command == 1) //[1] Load model
        {
            System.out.print("OWL location: " + uri_storeFront_owl);            
            File f = new File(uri_storeFront_owl);
            if (f.exists() && f.isFile()) 
                m.read("file:" + uri_storeFront_owl);
            else
                System.out.println("Bad file location");
        }
        else if(command == 2) //[2] Run rules
        {
            System.out.println("\n\nEnter rules location: " + uri_storeFront_rules);
            List<Rule> rules = Rule.rulesFromURL(uri_storeFront_rules);
            GenericRuleReasoner r = new GenericRuleReasoner(rules);
            r.setOWLTranslation(true);           
            r.setTransitiveClosureCaching(true);

            InfModel infmodel = ModelFactory.createInfModel(r, m);
            m.add(infmodel.getDeductionsModel());
        }
        else if(command == 3) //[3] Print all statements
        {
            System.out.println("\n\n\n\n\n\n");            
            StmtIterator si = m.listStatements();
            Statement s = null;
            while(si.hasNext()) 
            {
                s = si.next();
                System.out.println(s);
            }
        }
        else if(command == 4) //[4] Query model
        {
            String input = "http://storeFront.com#Bob ? ?";
            System.out.println("\n\n\nEnter a pattern to match: " + input);
            
            String[] pattern = input.split(" ");
            if (pattern.length != 3) 
            {
                System.out.println("Bad query pattern");
                return;
            }
            Resource s = null;
            Property p = null;
            RDFNode o = null;

            if (pattern[0].matches("'.+'"))
                s = getAnonNode(pattern[0].replace("'", ""));
            else if (!pattern[0].equals("?"))
                s = m.getResource(pattern[0]);

            if (pattern[1].matches("'.+'"))
                p = getAnonNode(pattern[1].replace("'", "")).as(Property.class);
            else if (!pattern[1].equals("?"))
                p = m.getProperty(pattern[1]);

            if (pattern[2].matches("'.+'"))
                o = getAnonNode(pattern[2].replace("'", ""));
            else if (pattern[2].matches("\".+\""))
                o = m.createLiteral(pattern[2].replace("\"", ""));
            else if (!pattern[2].equals("?"))
                o = m.getResource(pattern[2]);

            StmtIterator si = m.listStatements(s, p, o);
            Statement st = null;
            while(si.hasNext()) 
            {
                st = si.next();
                System.out.println(st);
            }
        }
        else if(command == 5) //[5] Print number of statements
        {
            System.out.println(m.size());
        }
    }*/

    // This isn't pretty, but right now I can't find a better way to get an anonymous node 
    private Resource getAnonNode(String anonId) 
    {
        StmtIterator si = m.listStatements();
        Statement s = null;
        while(si.hasNext()) 
        {
            s = si.next();
            Resource node = s.getSubject();
            if (node.isAnon() && node.getId().toString().equals(anonId)) 
            {
                    return node;
            }
            node = s.getPredicate();
            if (node.isAnon() && node.getId().toString().equals(anonId)) 
            {
                    return node;
            }	
            if (s.getObject().canAs(Resource.class)) 
            {
                node = s.getObject().as(Resource.class);
                if (node.isAnon() && node.getId().toString().equals(anonId)) 
                {
                        return node;
                }
            }	
        }
        return null;
    }
}