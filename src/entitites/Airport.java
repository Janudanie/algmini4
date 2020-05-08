package entitites;

import java.util.ArrayList;
import java.util.List;

public class Airport {

    private String code;
    private String name;
    private String city;
    private String country;
    private String latitude;
    private String longitude;



    private Routes[] routes = new Routes[1000];
    private int numberOfRoutes = 0;
    public Airport() {}

    public Airport(String code, String name, String city, String country, String latitude, String longitude) {
        this.code = code;
        this.name = name;
        this.city = city;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void addOutRoute (Routes route) {
        routes[numberOfRoutes++]= route;
    }

    public void printAllRoutes (){
        for (int x = 0 ; x < numberOfRoutes;x++) {

            System.out.print(routes[x].getGoingTo().getName());



        }
    }
    public int getNumberOfRoutes (){
        return numberOfRoutes;
    }

    public Airport getAirportAtroute (int e){
        return routes[e].getGoingTo();
    }

    public String getAirlineCode(int e){
        return routes[e].getAirlineCode();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
