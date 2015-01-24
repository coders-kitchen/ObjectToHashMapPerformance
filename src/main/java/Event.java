import java.util.HashMap;
import java.util.Map;

/**
 * Created by Peter on 20.01.2015.
 */
public class Event {
    private Map<String, String> payload = new HashMap<>();

    public void putValue(String key, String value) {
        payload.put(key, value);
    }

    public Map<String, String> getPayload() {
        return payload;
    }

    public void setPayload(Map<String, String> payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "Event{" +
                "payload=" + payload +
                '}';
    }
}
