package Insurance_Project;

public class HouseInsurance extends Insurance {

    private int cubicHouse;

    public HouseInsurance(int code, String name, int months, int cubicHouse) {
        super(code, name, months);
        this.cubicHouse = cubicHouse;
    }

    public void printInfo(){
        System.out.println("Insurance description: House");
        System.out.println("Κωδικός αριθμός ασφάλειας: " + getCode());
        System.out.println("Επώνυμο ασφαλιζόμενου: " + getName());
        System.out.println("Διάρκεια ασφάλισης: " + getMonths()+ " Months");
        System.out.println("Διάρκεια ασφάλισης: " + calcCost()+ " Euro");
    }

    public double calcCost(){
        totalCost = (cubicHouse * insuranceMonths) / 10.0;
        return totalCost;
    }

    public void printDescription(){
        System.out.println("Home Insurance description:");
        System.out.println(getCode());
        System.out.println(getName());
        System.out.println(getMonths() + " months");
        System.out.println(calcCost()+ " Euro");
    }

}
