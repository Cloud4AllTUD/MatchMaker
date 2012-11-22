package basic;

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

    public String getName() {
        return this.name;
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

    /**
     * checks if a given attribute is supported by one of the solutions
     * if so, the solution name of the belonging attribute is returned
     * otherwise the function returns null
     * at the moment, attributes which belong to more than one solution are not
     * supported, the first match wins and the first solution name is returned
     */
    public String hasAttribute(String attr) {
        for(String solutionName : this.solutionList.keySet()) {
            for( String s : solutionList.get(solutionName) )
                if(s.equals(attr))
                    return solutionName;
        }
        return null;
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
