import entitites.Airport;
import entitites.Routes;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MyGraph {

    private int V;                 // number of vertices in this digraph
    private int E;                 // number of edges in this digraph
    private List<Airport> adj = new ArrayList<>();         // adj[v] = adjacency list for vertex v
    private int[] indegree;        // indegree[v] = indegree of vertex v
    private Routes[] graphroutes= new Routes[100000] ;
    private int numberOfRoutes = 0;



    public MyGraph() {
        try {
            //Make list of all airports
            Path path = Paths.get(System.getProperty("user.dir") + "/src/data/airports.txt");
            String[] tempArray;
            tempArray = Files.lines(path)
                    .flatMap(line -> Stream.of(line.split(";")))
                    .toArray(String[]::new);
            //CODE;NAME;CITY;COUNTRY;LATITUDE;LONGITUDE
           for(int i = 6; i < tempArray.length -1 ; i=i) {
                String tempCode = tempArray[i++];
                String tempName = tempArray[i++];
                String tempCity = tempArray[i++];
                String tempCountry = tempArray[i++];
                String tempLatitude = tempArray[i++];
                String tempLiongitude = tempArray[i++];
                adj.add(new Airport(tempCode,tempName,tempCity,tempCountry,tempLatitude,tempLiongitude));
                V++;
            }
            //Make list of all routes + add them to correct airport
                path = Paths.get(System.getProperty("user.dir") + "/src/data/routes.txt");
                tempArray = Files.lines(path)
                        .flatMap(line -> Stream.of(line.split(";")))
                        .toArray(String[]::new);
                for(int j = 5; j < tempArray.length; j=j) {
                //AIRLINE_CODE;SOURCE_CODE;DESTINATION_CODE;DISTANCE;TIME
                    String airline_code = tempArray[j++];
                    Airport commingFrom = findAirport(tempArray[j++]);
                    Airport goingTo = findAirport(tempArray[j++]);
                    float distance = Float.parseFloat(tempArray[j++]); //skip distance
                    j++; //skip time
                    Routes temproute = new Routes(airline_code,commingFrom ,goingTo);
                    graphroutes[numberOfRoutes++] = temproute;
                    commingFrom.addOutRoute(temproute);
                    E++;
                }



        } catch(Exception E){
            System.out.println("Exception was catched while creating directed graph from data " + E.getMessage());
        }
    }


    public Airport findAirport (String airportCode){
        for (Airport k  : adj
             ) { if(k.getCode().equals(airportCode)) {
                 return k;
            }
        }
        return null;
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }
}
