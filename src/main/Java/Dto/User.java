package Dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("address")
    @Expose
    private Address address;

    @SerializedName("phone")
    @Expose
    private String phone;

    @SerializedName("website")
    @Expose
    private String website;

    @SerializedName("company")
    @Expose
    private Company company;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public static User createNewUser(){
        User user = new User();
        user.setName("John Gabriel");
        user.setUsername("JG");
        user.setEmail("JohnGabriel@gmail.com");
        user.setAddress(Address.createAddress());
        user.setPhone("1-771-736-8031 x114477");
        user.setWebsite("testEmail.com");
        user.setCompany(Company.createCompany());

        return user;
    }

    @Override
    public String toString() {
        StringBuilder str =new StringBuilder();
        str.append("User: \n");
        str.append(String.format("Name: %s\n", getName()));
        str.append(String.format("User name: %s\n", getUsername()));
        str.append(String.format("Email: %s\n", getEmail()));
        str.append(String.format("%s\n", getAddress().toString()));
        str.append(String.format("Phone: %s\n", getPhone()));
        str.append(String.format("Web site: %s\n", getWebsite()));
        str.append(String.format("%s\n", getCompany().toString()));

        return str.toString();
    }
}
