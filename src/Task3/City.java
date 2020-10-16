package Task3;

import java.util.ArrayList;
import java.util.List;

public class City {

    List<TouristPlace> touristPlacesList;
    String state, cityName;

    public City(String state, String cityName) {
        this.state = state;
        this.cityName = cityName;
        touristPlacesList = new ArrayList<>();
    }

}
