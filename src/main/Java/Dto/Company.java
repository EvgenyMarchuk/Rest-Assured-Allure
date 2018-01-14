package Dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Company {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("catchPhrase")
    @Expose
    private String catchPhrase;
    @SerializedName("bs")
    @Expose
    private String bs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    public static Company createCompany(){
        Company company = new Company();
        company.setName("Test Ltd.");
        company.setCatchPhrase("We're the fastest.");
        company.setBs("real team");
        return company;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Company: ");
        str.append(String.format("Company name: %s, ", getName()));
        str.append(String.format("CatchPhrase: %s, ", getCatchPhrase()));
        str.append(String.format("Bs: %s", getBs()));

        return str.toString();
    }
}
