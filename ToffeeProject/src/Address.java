public class Address {
    private String street;
    private String city;
    private String district;
    private String governorate;

    public String getCountry() {
        return Country;
    }

    private String Country;

    private String Landmark;

    public Address(String street, String city, String district, String governorate, String Landmark, String Country) {
        this.street = street;
        this.city = city;
        this.district = district;
        this.governorate = governorate;
        this.Landmark = Landmark;
        this.Country = Country;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public String getGovernorate() {
        return governorate;
    }

    public String getLandmark() {
        return Landmark;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setGovernorate(String governorate) {
        this.governorate = governorate;
    }

    public void setLandmark(String landmark) {
        Landmark = landmark;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", governorate='" + governorate + '\'' +
                ", Landmark='" + Landmark + '\'' +
                '}';
    }
}
