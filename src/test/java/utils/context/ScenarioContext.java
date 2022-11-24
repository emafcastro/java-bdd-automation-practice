package utils.context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    public static ScenarioContext instance = null;
    private static Map<String, Object> scenarioContext;

    private ScenarioContext(){
        scenarioContext = new HashMap<>();
    }

    public static ScenarioContext getInstance(){
        if (instance == null){
            instance = new ScenarioContext();
        }
        return instance;
    }

    public void setContext(Context key, Object value){
        scenarioContext.put(key.toString(), value);
    }

    public Object getContext(Context key){
        return scenarioContext.get(key.toString());
    }

    public Boolean isContains(Context key){
        return scenarioContext.containsKey(key.toString());
    }
}
