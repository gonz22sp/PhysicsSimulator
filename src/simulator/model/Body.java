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

    public void addForce(Vector2D f){

    }

    public void resetForce(){
        force = new Vector2D();
    }

    public void move(double t){
       Vector2D a;
        if(getMass()==0){
            a=new Vector2D();
        }
        else{
            a=new Vector2D(getForce().scale(1/getMass()));
            getPosition().plus(getVelocity().scale(t).plus(a.scale(0.5)));
            getVelocity().plus(a.scale(t));
        }

    }

    public JSONObject getState(){

        JSONObject jsonObject = getState().getJSONObject("id: " + getId()+"\n"+
                "vel: "+getVelocity().toString()+"\n"
                +"pos: " +getPosition().toString()
                +"force: "+getForce().toString()+"\n"
                +"mass: "+getMass());

        return jsonObject;

    }

    public String toString(){
        return getState().toString();
    }
}
