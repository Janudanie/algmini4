import entitites.Airport;

import java.util.ArrayList;
import java.util.List;

public class DepthFirst {
    private List<String> markedairports = new ArrayList<>();

    public void dfs(Airport k, String airlineCode){
        marked(k,airlineCode);
    }

    private void marked(Airport airport, String airlineCode ){
          markedairports.add(airport.getCode());
          int max= airport.getNumberOfRoutes();
        for (int w = 0;w < max;w++ ) {
            if(!checkMarked(airport.getAirportAtroute(w).getCode())) {
                if(airport.getAirlineCode(w).equals(airlineCode))
                dfs(airport.getAirportAtroute(w),airlineCode);
            }
        }
    }

    public boolean checkMarked(String airportcode){
        for (String k : markedairports){
            if(k.equals(airportcode)) return true;
        }
        return false;
    }

    public void printAllMarked(){
        for (String k : markedairports){
            System.out.println(k);
        }
        System.out.println(markedairports.size());
    }

}
