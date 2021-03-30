package simulator.model;
import org.json.JSONObject;
import java.util.List;

public class PhysicsSimulator {
    double dt;
    public ForceLaws FL;
    List<Body> bl;
    public void advance(){
        for(int i=0;i<bl.size();i++){
            bl.get(i).resetForce();
            FL.apply(bl);
            bl.get(i).move(dt);
            dt++;
        }

    }
    public void addBody(Body b) throws  IllegalArgumentException{
        bl.add(b);
    }

    public JSONObject getState(){

    }
    public String toString(){
        return getState().toString();
    }

}
