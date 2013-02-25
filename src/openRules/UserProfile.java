package openRules;

public class UserProfile
{
    String name;
    boolean usesScreenReader;
    
    public String getName()
    {
        return name;
    }
    public void setName(String tmpName)
    {
        name = tmpName;
    }
    public boolean getUsesScreenReader() {
        return usesScreenReader;
    }
    public void setUsesScreenReader(boolean tmpUsesScreenReader) {
        usesScreenReader = tmpUsesScreenReader;
    }

    public String toString() {
        return "User [name=" + name + ", usesScreenReader=" + usesScreenReader + "]";
    }
}
