import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;

/**
 * Created by 1 on 13.12.2016.
 */
@XmlRootElement(name = "trains")
public class Trains {
    private List<Train> trains = new ArrayList<>();

    @XmlElement(name = "train")
    public List<Train> getTrains() {
        return trains;
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }

//    public static Trains getTrainsByDate(Calendar from, Calendar to, Trains trains){
//
//        List <Train> newList =new ArrayList<>();
//        for(Train train : trains.getTrains()){
//            if(train.getDate().after(from) && train.getDate().before(to) ){
//                newList.add(train);
//            }
//        }
//        Trains newTrains = new Trains();
//        newTrains.setTrains(newList);
//        return newTrains;
//    }



    public static Trains getTrainsByTimeDate(Calendar from, Calendar to, Trains trains){

        List <Train> newList =new ArrayList<>();
        for(Train train : trains.getTrains()){



            if(train.getDepDate().after(from) && train.getDepDate().before(to) ){
                newList.add(train);
            }
        }

        Trains newTrains = new Trains();
        newTrains.setTrains(newList);
        return newTrains;
    }

    synchronized public void  addTrain(Train train){
        if (train == null){return;}
        int freeIdTrain = getFreeIdTrain(trains);
       // System.out.println("next free number is " + freeIdTrain);
        train.setId(freeIdTrain);
        trains.add(train);




    }



    private int getFreeIdTrain (List <Train> trains){
        boolean trainIdFound = true;
        int result = 0;
        for(int i = 1 ; trainIdFound;i++){
            trainIdFound = false;
            for(Train train : trains){
                if (train.getId() == i){trainIdFound = true;}

            }
            result = i;
        }
        return result;
    }



}
