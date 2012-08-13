import java.util.*;

public class Solution {

    private String name;
    private ArrayList<DeviceProfileEntry> requirements;
    private HashMap<String,ArrayList<String>> solutionList;

    public Solution(String name) {
        this.name = name;
        this.requirements = new ArrayList<DeviceProfileEntry>();
        this.solutionList = new HashMap<String,ArrayList<String>>();
    }

    public void addRequirement(DeviceProfileEntry dEntry) {
        requirements.add(dEntry);
    }

    public ArrayList<DeviceProfileEntry> getRequirements() {
        return this.requirements;
    }

    public void addSolution(String solutionName, ArrayList<String> attributes) {
        solutionList.put(solutionName, attributes);
    }

    public HashMap<String,ArrayList<String>> getSolutions() {
        return this.solutionList;
    }

    public String toString() {
        String result = "Solution: " + this.name + "\n";
        result = result + "requirements:\n";
        for(DeviceProfileEntry dEntry : requirements)
            result = result + dEntry.toString() + "\n";
        result = result + "Solution list:\n";
        for(String key : this.solutionList.keySet()) {
            result = result + key + ": ";
            for(String s : solutionList.get(key))
                result = result + s + ", ";
            result = result + "\n";
        }
        return result;
    }
}
