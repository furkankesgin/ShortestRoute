import java.util.ArrayList;
public class City {
    protected String name;
    protected ArrayList<Route> CityRoads = new ArrayList<>();
    public City(String name){
        this.name = name;
    }
    public void addRoute(Route route){
        CityRoads.add(route);
    }

}
