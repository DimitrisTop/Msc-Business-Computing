package Insurance_Project;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static void main(String[] args) {

        ArrayList<Insurance> list = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        CarInsurance car1 = new CarInsurance(12345,"Topalidis", 15,1400);
        CarInsurance car2 = new CarInsurance(86420,"Papadopoulou", 30,1800);
        HouseInsurance h1 = new HouseInsurance(54321, "Varmazis", 10, 35);
        HouseInsurance h2 = new HouseInsurance(13579, "Pagwni", 15, 75);

         car1.printInfo();

        list.add(car1);
        list.add(car2);
        list.add(h1);
        list.add(h2);

        // Keno gia readability
        System.out.println("");

        System.out.println("All Insurances");
        for(Insurance c : list) {
            System.out.println( c.getName() + ", " + c.calcCost());
        }

        int searchInsurance = input.nextInt();
        // Adeiasma
        input.nextLine();

        // Keno gia readability
        System.out.println("");

        boolean foundInsurance = false;
        for(Insurance finder: list) {
            if (searchInsurance == finder.getCode()) {
                finder.printDescription();
                foundInsurance = true;
            }
        }
        if(foundInsurance == false)
            System.out.println("There is no insurance "+ searchInsurance);


    }

}





