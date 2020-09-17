public class Adress {
    private String street;
    private int streetNumber;
    private String city;
    private int zipCode;


    public Adress(String street, int streetNumber, String city, int zipCode)throws InvalidZipCodeException {
        this.street = street;
        this.streetNumber = streetNumber;
        this.city = city;
        if (!(zipCode >= 10000 && zipCode < 99999) || (zipCode >= 100000000 && zipCode < 999999999)){
            throw new InvalidZipCodeException("This is not valid zipCode, enter code that is 5 or 9 digit zip code!");
        }else{
            this.zipCode = zipCode;
        }
    }



    @Override
    public String toString() {
        return "Street = " + street +
                ",Street Number = " + streetNumber +
                ",City = " + city +
                ",Zip Code = " + zipCode;
    }
}