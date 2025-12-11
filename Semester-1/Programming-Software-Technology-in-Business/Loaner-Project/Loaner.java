package Loaner_Project;

public class Loaner {

    //Q7
    private String name;
    private Contact homeAddress;
    private Contact workAddress;
    private int amountDue;
    private int reminder;


    // Q8α
    public Loaner(String aName,
                  String haddress, String htown, int hzipCode, String hphoneNumber,
                  String waddress, String wtown,int wzipCode, String wphoneNumber,
                  int amount) {
        this.name = aName;
        this.homeAddress = new Contact(haddress,htown,hzipCode,hphoneNumber);
        this.workAddress = new Contact(waddress,wtown,wzipCode,wphoneNumber);
        this.amountDue = amount;
        this.reminder = 0;
    }

    //Q8b - προϋποθέτει την δημιουργία 2 contacts αντικειμένων
    public Loaner(String theName, Contact thehomeAddress, Contact theWorkAddress, int theAmountDue) {
        this.name = theName;
        this.homeAddress = thehomeAddress;
        this.workAddress = theWorkAddress;
        this.amountDue = theAmountDue;
        this.reminder = 0;

    }

    // Q9
    public void reduceAmount(int amount) {
        amountDue -= amount;
    }

    // Q10
    public void incrementReminder() {
        if (amountDue > 0)
            this.reminder++;
        else
            this.reminder = 0;
    }

    // Q11
    public void receipt(int amount) {
        System.out.println("********** Receipt ******************");
        System.out.println("O/H " + name + " paid " + amount);
        System.out.println(homeAddress.getFullAddress());
        System.out.println("The rest is " + amountDue + " " + "Euro");
        System.out.println("*************************************\n");

    }

    // Q12
    public void payment (int amount) {
        if (amount <= amountDue) {
            reduceAmount(amount);
            receipt(amount);
        }
        else {
            System.out.println("Cannot pay more than amount due.\nKindly try again.\n" );
        }
    }


    // Q13
    public void message (Contact address) {
        System.out.println("********** Remind " + reminder + " *****************");
        System.out.println(name);
        System.out.println(address.getFullAddress());
        System.out.println("Please pay " + amountDue + " " + "Euro by the end of the month");
        System.out.println("*************************************\n");
    }

    // Q14

    public void recordMessage (Contact address) {
        System.out.println("************ Recorded Message **********");
        System.out.println("************ Remind " + reminder + " ************");
        System.out.println("I am calling " + address.getPhoneNumber());
        System.out.println(name);
        System.out.println("Please pay " + amountDue + " " + "Euro by the end of the month");
        System.out.println("*************************************\n");
    }

    // Q15
    public void sentReminder() {
        if (amountDue > 0) {

            switch (reminder) {
                case 0: // 1
                    incrementReminder();
                    message(workAddress);
                    break;
                case 1: // 2
                    incrementReminder();
                    message(homeAddress);
                    break;
                case 2: // 3
                    incrementReminder();
                    recordMessage(workAddress);
                    break;
                case 3: // 4
                    incrementReminder();
                    recordMessage(homeAddress);
                    break;
                default: // 5 Last
                    incrementReminder();
                    recordMessage(homeAddress);
                    System.out.println("********** Last warning!!! **********");
                    System.out.println("The remaining amount of your loan will be subtracted from your salary.");
                    System.out.println("*************************************\n");
                    break;
            }
        }
    }



}