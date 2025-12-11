package Insurance_Project;

public class CarInsurance extends Insurance {

    private int cubicCar;


    public CarInsurance(int code, String name, int months, int cubicCar) {
        super(code, name, months);
        this.cubicCar = cubicCar;
    }

    public void printInfo(){
        System.out.println("Insurance description: Car" );
        System.out.println("Κωδικός αριθμός ασφάλειας: " + getCode());
        System.out.println("Επώνυμο ασφαλιζόμενου: " + getName());
        System.out.println("Διάρκεια ασφάλισης: " + getMonths() + " Months");
        System.out.println("Κόστος ασφάλειας " + calcCost() + " Euro");
    }

    public double calcCost(){
        totalCost = (cubicCar * insuranceMonths) / 60.0;
        return totalCost;
    }

    public void printDescription(){
        System.out.println("Car Insurance description:");
        System.out.println(getCode());
        System.out.println(getName());
        System.out.println(getMonths() + " months");
        System.out.println(calcCost()+ " Euro");
    }
}
