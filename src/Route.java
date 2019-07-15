
public class Route {
    protected City Start;
    protected City Finish;
    protected   int  Distance;
    public Route(City Start,City Finish,int Distance){
        this.Distance = Distance;
        this.Finish = Finish;
        this.Start = Start;
    }

}
