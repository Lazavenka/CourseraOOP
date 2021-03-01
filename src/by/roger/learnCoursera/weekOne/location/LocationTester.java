package by.roger.learnCoursera.weekOne.location;

public class LocationTester {
    public static void main(String[] args) {
        SimpleLocation loc1 = new SimpleLocation(77.1539, -139.398);
        SimpleLocation loc2 = new SimpleLocation(-77.1804, 139.55);
        System.out.println(loc1);
        System.out.println(loc2);
        System.out.printf("Distance - %5.3f kilometers.",loc1.distance(loc2));
    }
}
