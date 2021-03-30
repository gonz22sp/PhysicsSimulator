package simulator.model;

import simulator.misc.Vector2D;

import java.util.List;

public class NewtonUniversalGravitation implements ForceLaws{
    @Override
    public void apply(List<Body> bs) {
        double aceleracion=6.67*Math.pow(10,11);
        double f=0;
        double mod;
        for(int i=0;i<bs.size();i++){
            if(bs.get(i).getMass()!=0) {
                for (int j = 0; j < bs.size(); j++) {
                    if (i != j) {
                        Vector2D p1=new Vector2D(bs.get(i).getPosition());
                        Vector2D p2=new Vector2D(bs.get(j).getPosition());
                        p2.minus(p1); //p2=p2-p1
                        mod=Math.pow(p2.magnitude(),2); //mod(p2-p1)^2
                        f=(aceleracion*(bs.get(i).getMass()*bs.get(j).getMass()))/mod;
                        p2.scale(f); //F
                        bs.get(i).addForce(p2);
                    }

                }
            }


        }

    }
}
