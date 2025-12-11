package Employee_Project;

public class Main {
    static void main(String[] args) {



        Employee E1 = new Employee("Ελένη Παπαδοπούλου", "ΠΕ",2,25,true,2,1800);
        E1.details();


        Employee E2 = new Employee("Νίκος Παπαδόπουλος", "ΠΕ",1,4,true,2,1200);
        E2.details();

        System.out.println("\n" + "Αλλαγή του αριθμού ανήλικων παιδιών του/της " + E1.getName());
        E1.setNoChildren(-3);
        System.out.println("Αλλαγή του αριθμού ανήλικων παιδιών του/της " + E1.getName() + "\n");
        E1.setNoChildren(-2);


        E1.totalBonus(10,30);
        System.out.println("Υπολογισμός μηνιαίου εισοδήματος του/της " + E1.getName());
        E1.details();

        E2.totalBonus(10,30);
        System.out.println("Υπολογισμός μηνιαίου εισοδήματος του/της " + E2.getName());
        E2.details();
    }
}