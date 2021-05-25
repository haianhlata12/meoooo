import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Route {
    private ArrayList<City> cities =new ArrayList<City>();
    public Route(ArrayList<City> cities){
        this.cities.addAll(cities);
        Collections.shuffle(this.cities);
    }
    public Route(Route route){route.cities.stream().forEach(x -> cities.add(x));}
    public ArrayList<City> getCities(){return cities;}
    public double getTotalDistance(){
        int citiesSize= this.cities.size();
        return this.cities.stream().mapToDouble(x->{
            int cityIndex= this.cities.indexOf(x);
            double returnValue=0;
            if(cityIndex< citiesSize -1) returnValue =x.measureDistance(this.cities.get(cityIndex+1));
            return returnValue;
        }).sum() +this.cities.get(citiesSize-1).measureDistance(this.cities.get(0));

    }
    public String getTotalStringDistance(){
        String returnValue= String.format("%.2f",this.getTotalStringDistance());
        if(returnValue.length()==7) returnValue=" "+returnValue;
        return returnValue;
    }
    public String toString(){return Arrays.toString(cities.toArray());}


}
