package abdulrahmanjavanrd.com.quakereport_3;

/**
 * Created by nfs05 on 25/12/2017.
 */

public class QuakeInfo {
    private double magnitude ;
    private String quakeLocation ;
    private long quakeData;
    private String uri ;

//    public void setMagnitude(double magnitude) {
//        this.magnitude = magnitude;
//    }
//
//    public void setQuakeLocation(String quakeLocation) {
//        this.quakeLocation = quakeLocation;
//    }
//
//    public void setQuakeData(String quakeData) {
//        this.quakeData = quakeData;
//    }

    public QuakeInfo(double magnitude, String quakeLocation, long quakeData,String theUri) {
        this.magnitude = magnitude;
        this.quakeLocation = quakeLocation;
        this.quakeData = quakeData;
        this.uri = theUri;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getQuakeLocation() {
        return quakeLocation;
    }

    public long getQuakeDate() {
        return quakeData;
    }

    public String getUri() {
        return uri;
    }
}
