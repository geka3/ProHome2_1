import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by 1 on 14.12.2016.
 */
public class JAXBProcessor {

    public static Trains read(File f){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Trains.class);
            Unmarshaller unmarshaller =  jaxbContext.createUnmarshaller();

            Trains trains =(Trains)unmarshaller.unmarshal(f);
            return trains;

        } catch (JAXBException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    public static void write(Trains trains,String filepath){
        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(Trains.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(trains,new File(filepath));
        }catch (JAXBException e){
            e.printStackTrace();
        }

    }






}
