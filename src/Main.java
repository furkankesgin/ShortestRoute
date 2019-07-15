import java.util.ArrayList;

public class Main {
        ArrayList<Route> TargetRoads = new ArrayList<Route>();
        static    ArrayList<FoundedRoads> foundedRoutes = new ArrayList<FoundedRoads>(); // Bulunan Yollar

        static    int min = 9999;
        public static void findShortestPath(City Start ,City Finish){
            int min = 9999;
            int totalDistance;
            int temp = 99999;
            String names = "";
            for(int i = 0 ; i < Start.CityRoads.size();i++){
                totalDistance = 0;
                if(!Start.CityRoads.get(i).Finish.equals(Finish)){
                    for(int j = 0; j <Start.CityRoads.get(i).Finish.CityRoads.size(); j++){
                        if(Start.CityRoads.get(i).Finish.CityRoads.get(j).Finish.equals(Finish)){
                            totalDistance +=  Start.CityRoads.get(i).Distance;
                            totalDistance += Start.CityRoads.get(i).Finish.CityRoads.get(j).Distance;
                            temp = totalDistance;
                        }
                    }
                    if(temp<min){
                        min = temp;
                        names = "Start is : " + Start.name + " Mid point is : " + Start.CityRoads.get(i).Finish.name +
                                " Finish is : "  + Finish.name;

                    }


                }

                else if(Start.CityRoads.get(i).Finish.equals(Finish) && Start.CityRoads.get(i).Distance < min){
                    min = Start.CityRoads.get(i).Distance;
                    names = "Start is : " + Start.name +  " Finish is : " + Finish.name;
                }
            }
            System.out.println(names);
            System.out.println(min);
        }

        public static FoundedRoads findRoute(City Start ,City Finish,ArrayList<Route> testRoute,int mydistance){
            int passedThisRoadBefore = 0;
            FoundedRoads tempFoundedRoutes;
            tempFoundedRoutes= new FoundedRoads();
            tempFoundedRoutes.Distance =0;
            Route tempRoute;
            for(int i = 0 ; i < Start.CityRoads.size();i++){
                tempRoute = Start.CityRoads.get(i);
                if(Start.CityRoads.get(i).Finish.equals(Finish)){ // Hedefi buldum
                    mydistance += Start.CityRoads.get(i).Distance;
//	    			if(mydistance< min) {
                    testRoute.add(tempRoute);

//	    			}
                    for(int k=0;k<testRoute.size();k++) {
                        tempFoundedRoutes.route.add(testRoute.get(k));
                    }
//	   				tempFoundedRoutes.route = testRoute;
                    tempFoundedRoutes.Distance = mydistance;
                    foundedRoutes.add(tempFoundedRoutes);
                    testRoute =new ArrayList<Route>();
                }
                else {
                    passedThisRoadBefore = 0;
                    for(int j=0;j<testRoute.size();j++) {
                        if(testRoute.get(j).equals(tempRoute)) {
                            passedThisRoadBefore = 1;
                            j=testRoute.size();
                        }
                    }
                    if(passedThisRoadBefore == 0) {
                        mydistance += Start.CityRoads.get(i).Distance;
                        testRoute.add(tempRoute);
                        tempFoundedRoutes =findRoute(Start.CityRoads.get(i).Finish,Finish,testRoute,mydistance);

                    }

                }

            }
            mydistance =0;
            testRoute =new ArrayList<Route>();
            return tempFoundedRoutes;
        }

        public static void findShortestPathRec(City Start ,City Finish){
            int totalDistance;
            int temp = 99999;
            String names = "";
            FoundedRoads tempFoundedRoutes;
            tempFoundedRoutes= new FoundedRoads();
            ArrayList<Route> myroute = new ArrayList<Route>();
            tempFoundedRoutes =findRoute(Start,Finish,myroute,0);
            for(int i=0;i<foundedRoutes.size();i++) {
                System.out.println();
                System.out.println(i +". çözüm ");
                System.out.println();
                foundedRoutes.get(i).Print();
            }


        }



        public static void main(String[] args) {
            // TODO Auto-generated method stub
            ArrayList<City> cities = new ArrayList<City>();
            City A = new City("A");
            City B = new City("B");
            City C = new City("C");
            City D = new City("D");
            City E = new City("E");
            City F = new City("F");
            Route AB = new Route(A, B, 10);
            Route AC = new Route(A, C, 5);
            Route AD = new Route(A, D, 20);
            Route AE = new Route(A, E, 10);
            Route AF = new Route(A, F, 8);
            Route BD = new Route(B, D, 14);
            Route BE = new Route(B, E, 5);
            Route CD = new Route(C, D, 5);
            Route DE = new Route(D, E, 40);
            Route EF = new Route(E, F, 12);
            Route CF = new Route(C, F, 2);

            A.addRoute(AC);
            A.addRoute(AD);
            A.addRoute(AE);
            A.addRoute(AB);
            A.addRoute(AC);
            A.addRoute(AD);
            A.addRoute(AF);
            B.addRoute(BD);
            B.addRoute(BE);
            C.addRoute(CD);
            D.addRoute(DE);
            E.addRoute(EF);
            C.addRoute(CF);




            cities.add(A);
            cities.add(B);
            cities.add(C);
            cities.add(D);
            cities.add(E);
            cities.add(F);
//        findShortestPathRec(A,E);
            findShortestPath(A,E);
            findShortestPath(A,D);
            findShortestPath(A,F);

        }
}
