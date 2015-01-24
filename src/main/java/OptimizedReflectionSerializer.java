import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Peter on 20.01.2015.
 */
public class OptimizedReflectionSerializer implements Serializer {

    private Map<String, Field> fields = new HashMap<>();

    @Override
    public Event serialize(MyDataObject myDataObject) {
        if(this.fields.isEmpty()) {
            Field[] fields = MyDataObject.class.getDeclaredFields();
            for (Field field : fields) {
                Value value = field.getAnnotation(Value.class);
                if(value != null) {
                    this.fields.put(value.name(), field);
                }
            }
        }

        Event event = new Event();
        for (Map.Entry<String, Field> stringFieldEntry : fields.entrySet()) {
            String value = stringFieldEntry.getKey();
            Field field = stringFieldEntry.getValue();
            boolean accessible = field.isAccessible();
            try {
                if(!accessible)
                    field.setAccessible(true);
                event.putValue(value, String.valueOf(field.get(myDataObject)));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } finally {
            }
        }
        return event;
    }
}
