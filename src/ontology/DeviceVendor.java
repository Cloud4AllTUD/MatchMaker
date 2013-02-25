package ontology;

/**
 *
 * @author nkak
 */
public class DeviceVendor 
{
    int classID;

    String hasDeviceVendorName;
    String isDeviceVendorOf;

    public DeviceVendor()
    {
        classID = -1;

        hasDeviceVendorName = "";
        isDeviceVendorOf = "";
    }

    public String toString()
    {
        String result = OntologyManager.getInstance().getClassNameByID(classID);

        result = result + "\n\thasDeviceVendorName: " + hasDeviceVendorName;
        result = result + "\n\tisDeviceVendorOf: " + isDeviceVendorOf;

        return result;
    }
}
