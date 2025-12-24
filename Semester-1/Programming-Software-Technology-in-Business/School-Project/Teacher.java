public abstract class Teacher {

    String lastName;
    String taxCode;

    public Teacher(String lastName, String taxCode) {
        this.lastName = lastName;
        this.taxCode = taxCode;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public abstract double totalIncome();

}
