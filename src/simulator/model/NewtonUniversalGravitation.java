package simulator.model;

import simulator.misc.Vector2D;

import java.util.List;

public class NewtonUniversalGravitation implements ForceLaws{
    @Override

    public void apply(List<Body> bs) {
        double aceleracion=6.67*Math.pow(10,11);
        double f=0;
        double mod;
        Vector2D direccion=new Vector2D();
        for(int i=0;i<bs.size();i++){
            if(bs.get(i).getMass()!=0) {
                for (int j = 0; j < bs.size(); j++) {
                    if (i != j) {
                        bs.get(j).getPosition().minus(bs.get(i).getPosition());
                        mod=bs.get(j).getPosition().magnitude();
                        f=(aceleracion*(bs.get(i).getMass()*bs.get(j).getMass()))/mod;
                        bs.get(i).getForce()=f;
                    }

                }
            }

        }

    }
}
