import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Peter on 20.01.2015.
 */
public class Application {

    public static final int NUM_OF_OBJECTS = 4_000_000;
    static MyDataObject[] myDataObjects = new MyDataObject[NUM_OF_OBJECTS];

    public static void main(String[] args) {

        for(int index = 0; index < myDataObjects.length; index++) {
            MyDataObject ob = new MyDataObject();
            ob.setSomeId((int) (Math.random()*NUM_OF_OBJECTS));
            ob.setAnyBoolean(Math.random()*1000%2==0);
            ob.setAnyString(UUID.randomUUID().toString());
            ob.setSomeDate(new Date());

            myDataObjects[index] = ob;
            if(index != 0 && index % 10000 == 0) {
                System.out.print(".");
                if(index % 800000 == 0) {
                    System.out.println(" " + index);
                }
            }
        }

        System.out.println(" " + NUM_OF_OBJECTS);


        serialize(new DomainSpecificSerializer());
        serialize(new DozerSerializer());
        serialize(new StupidReflectionSerializer());
        serialize(new OptimizedReflectionSerializer());

    }

    private static void serialize(Serializer serializer) {
        Instant start = Instant.now();
        for (int i = 0, myDataObjectsLength = myDataObjects.length; i < myDataObjectsLength; i++) {
            serializer.serialize(myDataObjects[i]);
        }
        Instant end = Instant.now();
        System.out.println(serializer.getClass() + " requires " + Duration.between(start, end) + " for " + myDataObjects.length + " objects");
    }
}
