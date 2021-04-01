package simulator.model;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class PhysicsSimulator {
    private double timePerStep;
    private ForceLaws FL;
    private double time;
    private ArrayList<Body> bl;

    public PhysicsSimulator(double timePerStep, ForceLaws FL) throws  IllegalArgumentException{
        if(timePerStep<=0){
            throw new IllegalArgumentException("Time per Step should be >0");
        }
        if(FL==null){
            throw new IllegalArgumentException("FL should not be null!");
        }
        this.timePerStep=timePerStep;
        this.FL=FL;
        this.time=0;
        this.bl=new ArrayList<Body>();
    }
    public void advance(){

        for(Body b: bl)
            b.resetForce();

        FL.apply(bl);

        for(Body b: bl)
            b.move(timePerStep);
        time+=timePerStep;

    }

    public void addBody(Body b) throws  IllegalArgumentException{
        if(bl.contains(b))
            throw new IllegalArgumentException("Already existing body with id: "+ b.getId());
        bl.add(b);
    }

    public JSONObject getState(){
        return new JSONObject()
                .put("time",time)
                .put("bodies",new JSONArray(bl.stream().map(body -> body.getState())));
    }

    @Override
    public String toString(){
        return getState().toString();
    }

}
