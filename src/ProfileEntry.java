import java.util.*;
import com.google.gson.JsonPrimitive;
                
public class ProfileEntry {

    private String name;
    private ArrayList<ProfileEntry> condition;
    private JsonPrimitive value;

    public ProfileEntry() {
        this.name = "";
        this.condition = null;
        this.value = null;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String var) {
        this.name = var;
    }
    
    public JsonPrimitive getValue() {
        return this.value;
    }

    public void setValue(JsonPrimitive var) {
        this.value = var;
    }

    public ArrayList<ProfileEntry> getCondition() {
        return this.condition;
    }

    public void setCondition(ArrayList<ProfileEntry> list) {
        this.condition = list;
    }

    public String toString() {
        String result = "";
        result = result + "Name = " + getName() + "\n";
        result = result + "value = " + getValue() + "\n";
        if(this.getCondition() != null) {
            result = result + "condition = ";
            for(ProfileEntry pEntry : this.getCondition())
                result = result + pEntry.getName() + " : " + pEntry.getValue();
        }
        return result;
    }
}
