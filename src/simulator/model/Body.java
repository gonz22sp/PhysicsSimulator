package simulator.model;
import org.json.JSONObject;
import simulator.misc.Vector2D;

public class Body {
    protected String id;
    protected Vector2D velocity;
    protected Vector2D force;
    protected Vector2D position;
    protected double mass;

    public Body(String id, Vector2D velocity, Vector2D force, Vector2D position,
                double mass){
        this.id=id;
        this.velocity=velocity;
        this.force=force;
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

    protected void addForce(Vector2D f){
        force.plus(f);
    }

    protected void resetForce(){
        force = new Vector2D();
    }

    protected void move(double t){
       Vector2D a;
        if(mass==0){
            a=new Vector2D();
        }
        else{
            a=new Vector2D(force.scale(1/mass));
            position.plus(velocity.scale(t).plus(a.scale(0.5)));
            velocity.plus(a.scale(t));
        }

    }

    public JSONObject getState(){
        return new JSONObject()
                .put("id", id)
                .put("m",mass)
                .put("p",position.toString())
                .put("v",velocity.toString())
                .put("f",force.toString());

    }

    public String toString(){
        return getState().toString();
    }

}
