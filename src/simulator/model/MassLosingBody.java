package simulator.model;

import simulator.misc.Vector2D;

public class MassLosingBody extends Body{
    protected double lossFactor;
    protected double lossFrequency;
    private double c;
    public MassLosingBody(String id, Vector2D velocity,  Vector2D position, double mass, double lossFactor, double lossFrequency) {
        super(id, velocity, position, mass);
        this.lossFactor = lossFactor;
        this.lossFrequency = lossFrequency;
    }

    @Override
    void move(double t){
        super.move(t);
        c+=t;
        if(c>=lossFrequency)
        {
            mass*=1-lossFactor;
            c=0.0;
        }

    }

}
