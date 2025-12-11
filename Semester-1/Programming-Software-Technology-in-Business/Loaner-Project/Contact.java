package Loaner_Project;

public class Contact {

    // Q1
    private String address;
    private String town;
    private int zipCode;
    private String phoneNumber;

    // Q2
    public Contact(String newAddress, String newTown, int newZipCode, String newPhoneNumber) {
        address = newAddress;
        town = newTown;
        zipCode = newZipCode;
        phoneNumber = newPhoneNumber;
    }

    // Q3
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Q4
    public void setAddress(String newAddress) {
        address = newAddress;
    }

    public void setTown(String newTown) {
        town = newTown;
    }

    public void setZipCode(int newZipCode) {
        zipCode = newZipCode;
    }

    public void setPhoneNumber (String newPhoneNumber) {
        phoneNumber = newPhoneNumber;
    }

    // Q5
    public void setFullAddress(String newAddress, String newTown, int newZipCode) {
        address = newAddress;
        town = newTown;
        zipCode = newZipCode;
    }

    // Q6
    public String getFullAddress() {
        if (address != null && town != null && zipCode != 0) {
            return address + ", " + town + ", " + zipCode;
        }

        else {
            String missingString = "";
            if (address == null) {
                missingString = missingString + "Missing Address.\n";
            }
            if (town == null) {
                missingString = missingString + "Missing Town.\n";
            }
            if (zipCode == 0) {
                missingString = missingString + "Missing zip code\n";
            }
            return missingString + "Please update!";
            }
        }





}