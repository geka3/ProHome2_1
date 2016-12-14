import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Created by 1 on 13.12.2016.
 */
@XmlRootElement(name = "train")
public class Train {

    private int id;
    private String from;
    private String to;
    private String date;
    private String departure;


    public Train(String from, String to, String date, String departure) {
        this.from = from;
        this.to = to;
        this.date = date;
        this.departure = departure;
    }



    public Train() {
    }

    @XmlAttribute(name = "id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @XmlElement(name = "from")
    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }

    @XmlElement(name = "to")
    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }

    @XmlElement(name = "date")

    public String getDate() {      return date;    }
    public void setDate(String date) {        this.date = date; }

    @XmlElement(name = "departure")
    public String getDeparture() {        return departure;    }
    public void setDeparture(String departure) {   this.departure = departure; }

    public Calendar getDepDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        //we use combination of data and time
        try {
            Calendar newCal = new GregorianCalendar();
            newCal.setTime(sdf.parse(date + " " + departure));
            return newCal;


        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Train createConsoleTrain(){
        Scanner sc = new Scanner(System.in);

        System.out.println("would you like create new train");
        if (sc.nextLine().equalsIgnoreCase("y")){

            Train train = new Train();

            System.out.println("input from");
            train.setFrom(sc.nextLine());
            System.out.println("input to");
            train.setTo(sc.nextLine());
            System.out.println("input date");
            train.setDate(sc.nextLine());
            System.out.println("input departure");
            train.setDeparture(sc.nextLine());

            return train;

        }
        return null;
    }
}
