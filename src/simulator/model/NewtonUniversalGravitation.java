package simulator.model;

import simulator.misc.Vector2D;

import java.util.List;


public class NewtonUniversalGravitation implements ForceLaws{
    private double G;
    public NewtonUniversalGravitation(double G){
        this.G=G;
    }

    @Override
    public void apply(List<Body> bs) {
        for(int i=0;i<bs.size();i++){
            if(bs.get(i).getMass()!=0){
                for(int j=0;j<bs.size();j++){
                    if(i!=j){
                        if(bs.get(j).getMass()!=0){
                            Vector2D p21=bs.get(j).getPosition().minus(bs.get(i).getPosition());
                            double f=G*((bs.get(i).getMass()*bs.get(j).getMass())/(Math.pow(p21.magnitude(),2)));
                            bs.get(i).addForce(p21.scale(f));
                        }
                    }
                }
            }
        }

    }
    @Override
    public String toString(){
        return "nlug:{G:"+G+"}";
    }

}
