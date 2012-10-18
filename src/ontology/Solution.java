package ontology;

/**
 *
 * @author nkak
 */
public class Solution 
{
    int classID;

    String hasSolutionName;
    String hasSolutionDescription;
    int freeAllowedNrOfInvocations;
    double hasCost;
    String preferredLang;
    String speechRate;
    String hasSolutionSpecificSetting;
    String hasSolutionVendor;
    String runsOnDevice;
    String runsOnPlatform;
    String hasCostCurrency;
    String hasSolutionVersion;

    public Solution()
    {
        classID = -1;

        hasSolutionName = "";
        hasSolutionDescription = "";
        freeAllowedNrOfInvocations = 0;
        hasCost = 0.0;
        preferredLang = "";
        speechRate = "";
        hasSolutionSpecificSetting = "";
        hasSolutionVendor = "";
        runsOnDevice = "";
        runsOnPlatform = "";
        hasCostCurrency = "";
        hasSolutionVersion = "";
    }

    public String toString()
    {
        String result = OntologyManager.getInstance().getClassNameByID(classID);

        result = result + "\n\thasSolutionName: " + hasSolutionName;
        result = result + "\n\thasSolutionDescription: " + hasSolutionDescription;
        result = result + "\n\tfreeAllowedNrOfInvocations: " + Integer.toString(freeAllowedNrOfInvocations);
        result = result + "\n\thasCost: " + Double.toString(hasCost);
        result = result + "\n\tpreferredLang: " + preferredLang;
        result = result + "\n\tspeechRate: " + speechRate;
        result = result + "\n\thasSolutionSpecificSetting: " + hasSolutionSpecificSetting;
        result = result + "\n\thasSolutionVendor: " + hasSolutionVendor;
        result = result + "\n\trunsOnDevice: " + runsOnDevice;
        result = result + "\n\trunsOnPlatform: " + runsOnPlatform;
        result = result + "\n\thasCostCurrency: " + hasCostCurrency;
        result = result + "\n\thasSolutionVersion: " + hasSolutionVersion;

        return result;
    }
}
