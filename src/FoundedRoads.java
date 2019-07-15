import java.util.ArrayList;

public class FoundedRoads {
    public ArrayList<Route> route;
    public int Distance;
    public FoundedRoads(){
        this.route=new ArrayList<Route>();
    }
    public void Print() {
        for(int i=0;i<route.size();i++) {
            System.out.print(route.get(i).Start.name + "-" +route.get(i).Finish.name+" ("+route.get(i).Distance+ ")");
        }

    }
}
