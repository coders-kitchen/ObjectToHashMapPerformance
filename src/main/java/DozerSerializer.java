import org.dozer.DozerBeanMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peter on 20.01.2015.
 */
public class DozerSerializer implements Serializer {
    DozerBeanMapper mapper = new DozerBeanMapper();

    public DozerSerializer() {
        List myMappingFiles = new ArrayList();
        myMappingFiles.add("dozer.xml");
        mapper.setMappingFiles(myMappingFiles);
    }

    @Override
    public Event serialize(MyDataObject myDataObject) {
        Event e = new Event();
        mapper.map(myDataObject, e);
        return e;
    }
}
