public class Adress {
    private String street;
    private int streetNumber;
    private String city;
    private int zipCode;

    public String getStreet() {
        return street;
    }

    public Adress() {
    }

    public Adress(String street, int streetNumber, String city, int zipCode) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.city = city;
        this.zipCode = zipCode;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) throws invalidZipCodeException {
        if (!(zipCode >= 10000 && zipCode < 99999) || (zipCode >= 100000000 && zipCode < 999999999)) {
            throw new invalidZipCodeException("This is not valid zipCode, enter code that is 5 or 9 digit zip code!");
        } else {
            this.zipCode = zipCode;
        }

    }

    class invalidZipCodeException extends Exception {
        invalidZipCodeException(String s) {
            super(s);
        }
    }
}