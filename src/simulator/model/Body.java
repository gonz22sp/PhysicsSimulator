package simulator.model;
import org.json.JSONArray;
import org.json.JSONObject;
import simulator.misc.Vector2D;

import java.util.Objects;

public class Body {
    protected String id;
    protected Vector2D velocity;
    protected Vector2D force;
    protected Vector2D position;
    protected double mass;

    public Body(String id, Vector2D velocity, Vector2D position,
                double mass){
        this.id=id;
        this.velocity=velocity;
        this.force=new Vector2D();
        this.position=position;
        this.mass=mass;
    }

    public String getId(){
        return id;
    }

    public Vector2D getVelocity() {
        return velocity;
    }

    public Vector2D getForce() {
        return force;
    }

    public Vector2D getPosition() {
        return position;
    }

    public double getMass() {
        return mass;
    }

     void addForce(Vector2D f){
        force.plus(f);
    }

     void resetForce(){
        force = new Vector2D();
    }

     void move(double t){
       Vector2D a;
        if(mass==0){
            a=new Vector2D();
        }
        else{
            a=force.scale(1/mass);
            position=position.plus(velocity.scale(t).plus(a.scale(0.5).scale(t*t)));
            velocity=velocity.plus(a.scale(t));
        }

    }

    public JSONObject getState(){
        return new JSONObject()
                .put("id", id)
                .put("m",mass)
                .put("p",new JSONArray().put(position.getX()).put(position.getY()))
                .put("v",new JSONArray().put(velocity.getX()).put(velocity.getY()))
                .put("f",new JSONArray().put(force.getX()).put(force.getY()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Body body = (Body) o;
        return Objects.equals(id, body.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString(){
        return getState().toString();
    }

}
