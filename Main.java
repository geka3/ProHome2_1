import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.net.SocketPermission;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 1 on 14.12.2016.
 */
public class Main {
    public static void main(String[] args) {


        Trains trains = JAXBProcessor.read(new File("d:\\trains.xml"));

        //Filtering trains by Date and Time

        System.out.println();

        Trains trainsForDate = Trains.getTrainsByTimeDate(new GregorianCalendar(2013,Calendar.DECEMBER,19,15,0,0),
                new GregorianCalendar(2013,Calendar.DECEMBER,19,19,00,00),
                trains);


        for (Train tr : trainsForDate.getTrains()){
            System.out.println(
                    System.lineSeparator() +
                    "id " + tr.getId() + System.lineSeparator() +
                    "from " + tr.getFrom() + System.lineSeparator() +
                    "to " + tr.getTo() + System.lineSeparator() +
                    "date " + tr.getDate() +  System.lineSeparator() +
                    "departure " + tr.getDeparture()  + System.lineSeparator()
            );

        }

        Train newTrain = Train.createConsoleTrain();
        trains.addTrain(newTrain);


        Train newTrain2 = new Train("Odessa","Kyiv","18.12.2016","23:55");

        trains.addTrain(newTrain2);

        JAXBProcessor.write(trains,"d:\\trains2.xml");








    }
}
