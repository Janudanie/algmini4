package entitites;

public class Routes {
    private String airline;
    private Airport commingFrom;
    private Airport goingTo;
    private float distance;


    public Routes(String airline, Airport commingFrom, Airport goingTo) {
        this.airline = airline;
        this.commingFrom = commingFrom;
        this.goingTo = goingTo;
    }

    public Airport getGoingTo() {
        return goingTo;
    }

    public String getAirlineCode(){
        return airline;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }
}
