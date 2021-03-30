package simulator.control;
import simulator.model.PhysicsSimulator;
import simulator.factories.Factory;
import simulator.model.Body;

import java.io.InputStream;
import java.io.OutputStream;

public class Controller {
    PhysicsSimulator ps;
    Factory<Body> bod;

    public void loadBodies(InputStream in){

    }
    public void run(int n, OutputStream out,
                    InputStream expOut,
                    StateComparator cmp){

    }
}
