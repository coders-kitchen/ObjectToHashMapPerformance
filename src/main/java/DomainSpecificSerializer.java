/**
 * Created by Peter on 20.01.2015.
 */
public class DomainSpecificSerializer implements Serializer {
    @Override
    public Event serialize(MyDataObject myDataObject) {
        Event e = new Event();
        e.putValue("someId", String.valueOf(myDataObject.getSomeId()));
        e.putValue("anyBoolean", String.valueOf(myDataObject.getAnyBoolean()));
        e.putValue("anyString", myDataObject.getAnyString());
        return e;
    }
}
