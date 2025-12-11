package Loaner_Project;

public class Main {
    public static void main(String[] args) {

        // Constructor 2
        Contact cHome = new Contact ("Egnatia 40", "Thessaloniki",44656,"2310897678");
        Contact cWork = new Contact ("Kassandrou 150", "Thessaloniki",54634,"2310234567");
        Loaner loaner1 = new Loaner ("Papadopoulos Periklhs",cHome,cWork,5000);

        // Constructor 1
        Loaner me = new Loaner("Topalidis Dimitris", "Pindou 40" , "Katerini", 60100, "6925752522", "Egnatias 50", "Thessaloniki", 54454, "2310254998", 4000);



        // Remind 1
        loaner1.sentReminder();
        // Remind 2
        loaner1.sentReminder();
        // Remind 3
        loaner1.sentReminder();
        // Remind 4
        loaner1.sentReminder();

        // Payment Topalidis
        me.payment(4000);

        // εκ παραδρομής
        me.sentReminder();

        // Payment 1 Papadopoulos
        loaner1.payment(2000);

        // Remind 5 - Last Warning
        loaner1.sentReminder();

        // Payment 2 Papadopoulos
        loaner1.payment(3000);
        loaner1.sentReminder();

    }
}
