import java.util.ArrayList;
import java.util.Arrays;

public class Driver {
    private ArrayList<City> initialCities= new ArrayList<City>(Arrays.asList(
       new City("boston",41.3601,-71.0589),
       new City("houston", 29.7604,-95.3698),
            new City("austin", 30.2672,-97.7431),
            new City("San", 37.7749,-122.4194),
        new City("Denver", 39.7392,-104.9903),
            new City("Los", 34.0522,-118.2437),
            new City("Chicago", 41.8781,-87.6298),
            new City("New york", 40.7128,-74.0059),
            new City("dallas", 32.7767,-96.7970),
            new City("seattle", 47.6062,-122.3321),
            ));

    public static void main(String[] args) {
        Driver driver= new Driver();
        Route route= new Route(driver.initialCities);
        printHeading(route);
        System.out.print(route +"  |       "+ route.getTotalStringDistance());
        new  HillClimbing().findShortestRoute(route);
    }
    public static void printHeading(Route route){
        String headingColumn1= "Route";
        String remainingHeadingColumns= "Distance (in miles) | Compare adjacent to current route";
        int cityNameLength=0;
        for(int x=0;x<route.getCities().size();x++)cityNameLength+=route.getCities().get(x).getName().length();
        int arrayLength= cityNameLength+route.getCities().size()*2;
        int partialLength=(arrayLength-headingColumn1.length())/2;
        for(int x=0;x<partialLength;x++) System.out.print(" ");
        System.out.print(headingColumn1);
        for (int x=0;x<partialLength;x++) System.out.print(" ");
        if((arrayLength%2)==0) System.out.print(" ");
        System.out.println(" | "+remainingHeadingColumns);
        cityNameLength+= remainingHeadingColumns.length()+3;
        for(int x=0;x<cityNameLength+route.getCities().size()*2;x++) System.out.print(" - ");
        System.out.println("");
    }

}
