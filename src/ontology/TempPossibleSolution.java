package ontology;

/**
 *
 * @author nkak
 */
public class TempPossibleSolution 
{
    String text;
    String comment;
    
    public TempPossibleSolution()
    {
        text = "";
        comment = "";
    }
    
    @Override
    public String toString()
    {
        String result = "\tPossible Solution:";//OntologyManager.getInstance().getClassNameByID(OntologyManager.TempPossibleSolutions_ID);
        
        result = result + "\n\t\t" + text;
        result = result + "\n\t\tComment:" + comment;
       
        return result;
    }
}
