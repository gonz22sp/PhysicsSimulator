package simulator.model;
import simulator.misc.Vector2D;

import java.util.List;
public class MovingTowardsFixedPoint  implements ForceLaws{
    private Vector2D o;
    private double g;
    public MovingTowardsFixedPoint(Vector2D o, double g) {
        this.o = o;
        this.g = g;
    }

    @Override
    public void apply(List<Body> bs) {
        for(Body b: bs){
            Vector2D d= o.minus(b.getPosition());
            b.addForce(d.scale(-g));
        }


    }
    @Override
    public String toString(){
        return "mtfp:{o:" + o.toString() + ",g:" + g + "}";
    }

}

