package by.roger.learnCoursera.weekOne.location;

import java.util.Random;

public class SimpleLocation {
    private double latitude;
    private double longitude;

    public SimpleLocation(){
        Random rnd = new Random();
        this.latitude = rnd.nextDouble() * 360 - 180;
        this.longitude = rnd.nextDouble() * 360 - 180;
    }

    public SimpleLocation(double lat, double lon) {
        this.latitude = lat;
        this.longitude = lon;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLatitude(double latitude) {
        if (latitude < -180 || latitude > 180){
            System.out.println("Illegal value for latitude!");
        }else {
            this.latitude = latitude;
        }

    }

    public void setLongitude(double longitude) {
        if (longitude < -180 || longitude > 180){
            System.out.println("Illegal value for longitude!");
        }else {
            this.longitude = longitude;
        }
    }

    public double distance(SimpleLocation loc){
        double phiLat1 = coordinateToRadian(loc.latitude);
        double phiLat2 = coordinateToRadian(this.latitude);
        double phiLon1 = coordinateToRadian(loc.longitude);
        double phiLon2 = coordinateToRadian(this.longitude);
        double cosLat1 = Math.cos(phiLat1);
        double cosLat2 = Math.cos(phiLat2);
        double sinLat1 = Math.sin(phiLat1);
        double sinLat2 = Math.sin(phiLat2);
        double delta = phiLon2 - phiLon1;
        double deltaCos = Math.cos(delta);
        double deltaSin = Math.sin(delta);
        double y = Math.sqrt(Math.pow(cosLat2 * deltaSin , 2)+Math.pow(cosLat1 * sinLat2 - sinLat1 * cosLat2 * deltaCos, 2));
        double x = sinLat1 * sinLat2 + cosLat1 * cosLat2 * deltaCos;
        double ans = Math.atan2(y, x);
        return ans * 6372.795; //return ans in kilometers
    }
    private double coordinateToRadian(double coordinate){
        return coordinate * Math.PI / 180;
    }

    @Override
    public String toString() {
        String lat = String.format("%3.2f", latitude);
        String lon = String.format("%3.2f", longitude);
        return "Latitude: "+lat+", longitude: "+lon;
    }
}
