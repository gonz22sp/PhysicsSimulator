package simulator.control;

import org.json.JSONArray;
import org.json.JSONObject;

public class MassEqualStates implements StateComparator {

    public MassEqualStates(){

    }

    @Override
    public boolean equal(JSONObject s1, JSONObject s2) {
        if(s1.getDouble("time")!=s2.getDouble("time")){
            return false;
        }
        JSONArray s1Bodies=s1.getJSONArray("bodies");
        JSONArray s2Bodies=s2.getJSONArray("bodies");

        if(s1Bodies.length()!=s2Bodies.length()){
            return false;
        }
        for(int i=0;i<s1Bodies.length();i++){
            if(!s1Bodies.getJSONObject(i).getString("id").equals(s2Bodies.getJSONObject(i).getString("id"))){
                return false;
            }
            if(s1Bodies.getJSONObject(i).getDouble("m")!=s2Bodies.getJSONObject(i).getDouble("m")){
                return false;
            }
        }
        return true;
    }

}
