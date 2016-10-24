package name.sebastian.vogt.diabetic;

/**
 * Created by sebastian on 24.10.16.
 */
public class Helpers {



    public static double roundDecPlaces(double value, int places) {
        return (Math.round(value * Math.pow(10, places)) / Math.pow(10, places));
    }

}
