package ontology;

/**
 *
 * @author nkak
 */
public class Environment 
{
    int classID;
    
    String hasEnvironmentName;
    
    public Environment()
    {
        classID = -1;
        
        hasEnvironmentName = "";
    }
    
    public String toString()
    {
        String result = OntologyManager.getInstance().getClassNameByID(classID);
        
        result = result + "\n\thasEnvironmentName: " + hasEnvironmentName;
        
        return result;
    }
}
