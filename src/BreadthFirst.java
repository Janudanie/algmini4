import entitites.Airport;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BreadthFirst {
    private List<String> markedairports = new ArrayList<>();
    private Stack<Airport> workStack = new Stack<>();

    public void bfs(Airport k, String airlineCode){
       workStack.push(k);
       while(!workStack.isEmpty()) {
           Airport temp = workStack.pop();
           if(!checkMarked(temp.getCode()))
                marked(temp, airlineCode);
       }
    }

    private void marked (Airport airport, String airlineCode){
        markedairports.add(airport.getCode());
        int max = airport.getNumberOfRoutes();
        for (int w= 0 ; w<max;w++){
            if(!checkMarked(airport.getAirportAtroute(w).getCode())) {
                String helpString = airport.getAirlineCode(w);
                if(airport.getAirlineCode(w).equals(airlineCode))
                    workStack.push(airport.getAirportAtroute(w));
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
