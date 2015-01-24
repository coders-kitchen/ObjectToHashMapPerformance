import java.lang.reflect.Field;

/**
 * Created by Peter on 20.01.2015.
 */
public class StupidReflectionSerializer implements Serializer {
    @Override
    public Event serialize(MyDataObject myDataObject) {
        Field[] fields = MyDataObject.class.getDeclaredFields();
        Event event = new Event();
        for (Field field : fields) {
            Value value = field.getAnnotation(Value.class);
            if(value != null) {

                boolean accessible = field.isAccessible();
                try {
                    if(!accessible)
                    field.setAccessible(true);
                    event.putValue(value.name(), String.valueOf(field.get(myDataObject)));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } finally {
                }

            }
        }
        return event;
    }
}
