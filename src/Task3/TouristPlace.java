package Task3;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class TouristPlace implements Serializable {

    String name;
    String workingHour;
//    String city;
//    int entryTicketPrice;
    int noOfRatings;
    float starRating;
//    List<String> famousFor;
//    String category;

//    public TouristPlaces(String name, String workingHour, String city, int entryTicketPrice, String category) {
//        this.name = name;
//        this.workingHour = workingHour;
//        this.city = city;
//        this.entryTicketPrice = entryTicketPrice;
//        this.famousFor = new ArrayList<>();
//        this.category = category;
//        starRating = 0.0f;
//        noOfRatings = 0;
//    }

//    TouristPlace addFamousFor(String famous) {
//        famousFor.add(famous);
//        return this;
//    }

    public TouristPlace rate(int ... rating) {
//        //Calculate total stars
//        float totalStars = noOfRatings * starRating;
//        //Add rating to totalStars
//        totalStars += rating;
//        //Increment noOfRatings by 1 as we add a rating to the tourist place
//        noOfRatings++;
//        //starRating is now
//        starRating = totalStars/noOfRatings;
        for(int rate : rating)
            starRating += (rate - starRating)/(++noOfRatings);

        return this;

    }

    boolean isPlaceOpen() {

        String[] times = workingHour.split(" to ");

        //Parse times
        LocalTime startTime = LocalTime.parse(times[0], DateTimeFormatter.ofPattern("hh:mma"))
                , endTime = LocalTime.parse(times[1], DateTimeFormatter.ofPattern("hh:mma"))
                , currTime = LocalTime.now();

        //startTime.compare(currTime) : -1, 0
        //endTime.compareTo(currTime) : 1, 0
        return startTime.compareTo(currTime) <=0  && endTime.compareTo(currTime) >=0;

    }


    public static TouristPlace newFromUserInput() {
        Scanner scanner = new Scanner(System.in);
        TouristPlace places = new TouristPlace();

        System.out.println("Enter name : ");
        places.name = scanner.next();

        return places;

    }

    @Override
    public String toString() {
        return "TouristPlace{" +
                "name='" + name + '\'' +
                ", noOfRatings=" + noOfRatings +
                ", starRating=" + starRating +
                '}';
    }

}
