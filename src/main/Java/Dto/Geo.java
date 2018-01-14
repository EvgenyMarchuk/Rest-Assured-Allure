package Dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Geo {
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("lng")
    @Expose
    private String lng;

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public static Geo createGeo(){
        Geo geo = new Geo();
        geo.setLat("-45.78");
        geo.setLng("80.28");
        return geo;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Geo: ");
        str.append(String.format("Lat: %s, ", getLat()));
        str.append(String.format("Lng: %s", getLng()));

        return str.toString();
    }
}
