package Dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Address {
    @SerializedName("street")
    @Expose
    private String street;
    @SerializedName("suite")
    @Expose
    private String suite;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("zipcode")
    @Expose
    private String zipcode;
    @SerializedName("geo")
    @Expose
    private Geo geo;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    public static Address createAddress(){
        Address address = new Address();
        address.setStreet("Kile kill");
        address.setSuite("Apt. 200");
        address.setCity("Minsk");
        address.setZipcode("220015");
        address.setGeo(Geo.createGeo());

        return address;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Address: ");
        str.append(String.format("Street: %s, ", getStreet()));
        str.append(String.format("Suite: %s, ", getSuite()));
        str.append(String.format("City: %s, ", getCity()));
        str.append(String.format("%s", getGeo().toString()));

        return str.toString();
    }
}
