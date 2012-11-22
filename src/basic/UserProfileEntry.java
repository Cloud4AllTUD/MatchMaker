package basic;

import java.util.*;
import com.google.gson.JsonPrimitive;
                
public class UserProfileEntry {

    private String name;
    private ArrayList<UserProfileEntry> condition;
    private JsonPrimitive value;

    public UserProfileEntry() {
        this.name = "";
        this.condition = null;
        this.value = null;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String var) {
        this.name = var.split("/")[var.split("/").length-1];
    }
    
    public JsonPrimitive getValue() {
        return this.value;
    }

    public void setValue(JsonPrimitive var) {
        this.value = var;
    }

    public ArrayList<UserProfileEntry> getCondition() {
        return this.condition;
    }

    public void setCondition(ArrayList<UserProfileEntry> list) {
        this.condition = list;
    }

    public String toString() {
        String result = "";
        result = result + "Name = " + getName() + "\n";
        result = result + "value = " + getValue() + "\n";
        if(this.getCondition() != null) {
            result = result + "condition = ";
            for(UserProfileEntry pEntry : this.getCondition())
                result = result + pEntry.getName() + " : " + pEntry.getValue();
        }
        return result;
    }
}
