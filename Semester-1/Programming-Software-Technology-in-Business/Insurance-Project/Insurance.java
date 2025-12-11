package Insurance_Project;

public abstract class Insurance {

    protected int insuranceCode;
    protected String lastName;
    protected int insuranceMonths;
    protected double totalCost;

    public Insurance(int insuranceCode, String lastName, int insuranceMonths) {
        this.insuranceCode = insuranceCode;
        this.lastName = lastName;
        this.insuranceMonths = insuranceMonths;
    }

    public int getCode(){
        return insuranceCode;
    }

    public String getName() {
    return lastName;
    }

    public int getMonths(){
        return insuranceMonths;
    }

    public void setCode(int insuranceCode) {
        this.insuranceCode = insuranceCode;
    }

    public void setName(String lastName) {
        this.lastName = lastName;
    }

    public void setMonths(int insuranceMonths) {
        this.insuranceMonths = insuranceMonths;
    }

    public abstract double calcCost();

    public void printCost() {
        System.out.println(getName()+ ", " + calcCost());
    }

    public abstract void printInfo();

    public abstract void printDescription();


}