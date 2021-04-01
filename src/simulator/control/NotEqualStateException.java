package simulator.control;

import org.json.JSONObject;

public class NotEqualStateException extends Exception{
    public NotEqualStateException(JSONObject state, JSONObject expState, int n){
        super("State in step "+ n + " differs from expected state \n state: \n" + state.toString() + "\n expected" +
                "state: \n" + expState.toString());
    }
}
