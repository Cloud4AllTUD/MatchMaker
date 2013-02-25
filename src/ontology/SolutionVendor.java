package ontology;

/**
 *
 * @author nkak
 */
public class SolutionVendor 
{
    int classID;

    String hasSolutionVendorName;
    String isSolutionVendorOf;

    public SolutionVendor()
    {
        classID = -1;

        hasSolutionVendorName = "";
        isSolutionVendorOf = "";
    }

    public String toString()
    {
        String result = OntologyManager.getInstance().getClassNameByID(classID);

        result = result + "\n\thasSolutionVendorName: " + hasSolutionVendorName;
        result = result + "\n\tisSolutionVendorOf: " + isSolutionVendorOf;

        return result;
    }
}
