package simulator.control;

import org.json.JSONArray;
import org.json.JSONObject;
import simulator.misc.Vector2D;

public class EpsilonEqualStates implements StateComparator{
    private double eps;
    public EpsilonEqualStates(double eps){
        this.eps=eps;
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
        for(int i=0;i<s1Bodies.length();i++) {
            if (!s1Bodies.getJSONObject(i).getString("id").equals(s2Bodies.getJSONObject(i).getString("id"))) {
                return false;
            }
            if(!equalModEpsilon(s1Bodies.getJSONObject(i).getDouble("m"), s2Bodies.getJSONObject(i).getDouble("m"))){
                return false;
            }
            if(!equalModEpsilon(Controller.parseJSONArrayToVector2D(s1Bodies.getJSONObject(i).getJSONArray("p")),
            Controller.parseJSONArrayToVector2D(s2Bodies.getJSONObject(i).getJSONArray("p")))){
                return false;
            }
            if(!equalModEpsilon(Controller.parseJSONArrayToVector2D(s1Bodies.getJSONObject(i).getJSONArray("f")),
                    Controller.parseJSONArrayToVector2D(s2Bodies.getJSONObject(i).getJSONArray("f")))){
                return false;
            }
            if(!equalModEpsilon(Controller.parseJSONArrayToVector2D(s1Bodies.getJSONObject(i).getJSONArray("v")),
                    Controller.parseJSONArrayToVector2D(s2Bodies.getJSONObject(i).getJSONArray("v")))){
                return false;
            }
        }

            return true;
    }

    private boolean equalModEpsilon(double a, double b){
        return Math.abs(a-b)<=eps;
    }

    private boolean equalModEpsilon(Vector2D v1, Vector2D v2){
        return v2.distanceTo(v1)<=eps;
    }




}
