package simulator.control;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import simulator.misc.Vector2D;
import simulator.model.PhysicsSimulator;
import simulator.factories.Factory;
import simulator.model.Body;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class Controller {
    private PhysicsSimulator ps;
    private Factory<Body> bod;

    public Controller(PhysicsSimulator ps, Factory<Body> bod){
        this.ps=ps;
        this.bod=bod;
    }

    public void loadBodies(InputStream in){
        JSONObject JSONInput=new JSONObject(new JSONTokener(in));
        JSONArray bodies=JSONInput.getJSONArray("bodies");
        for(int i=0;i<bodies.length();i++){
            ps.addBody(bod.createInstance(bodies.getJSONObject(i)));
        }
    }
    public void run(int n, OutputStream out,
                    InputStream expOut,
                    StateComparator cmp)throws NotEqualStateException{
        PrintStream p=new PrintStream(out);
        p.println("{");
        p.println("\"states\":[");
        p.println(ps.getState().toString());

        for(int i=0;i<n;i++){
            ps.advance();
            //TODO:Comparar estados
            p.println(ps.getState().toString());
        }


        p.println("]");
        p.println("}");
    }

    public static Vector2D parseJSONArrayToVector2D(JSONArray v){
        return new Vector2D(v.getDouble(0),v.getDouble(1));
    }
}
