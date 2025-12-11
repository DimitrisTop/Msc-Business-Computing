package Employee_Project;

public class Employee {
    // Question 1
    private String name;
    private String education;
    private int postGrad;
    private int years;
    private boolean married;
    private int noChildren;
    private int salary;
    private int bonus;

    public Employee(String newName, String newEducation, int newPostGrad, int newYear, boolean isMarried, int newChildren, int newSalary) {
        name = newName;
        education = newEducation;
        postGrad = newPostGrad;
        years = newYear;
        married = isMarried;
        noChildren = newChildren;
        salary = newSalary;
        bonus = 0;
    }

    public String getName() {
        return name;
    }

    public String getEducation() {
        return education;
    }

    public int getPostGrad() {
        return postGrad;
    }

    private String postGradString() {
        if (postGrad == 0)
            return "Δεν έχει";
        else if (postGrad == 1)
            return "Μεταπτυχιακό δίπλωμα";
        else
            return "Διδακτορικό δίπλωμα";
    }

    public int getYears() {
        return years;
    }

    public boolean isMarried() {
        return married;
    }

    public int getChildren() {
        return noChildren;
    }

    public int getSalary() {
        return salary;
    }

    public int getBonus() {
        return bonus;
    }


    public int getMonthlySalary() {
        return salary + bonus;
    }

    public void setEducation(String newEducation) {
        education = newEducation;
    }

    public void setPostGrad(int newPostGrad) {
        postGrad = newPostGrad;
    }

    public void addYear() {
        years++;
    }

    public void setMarried(boolean statusMarried) {
        married = statusMarried;
    }

    private String marriageStatus() {
        if (married == true)
            return "Έγγαμος";
        else
            return "Άγαμος";
    }

    public void setNoChildren(int changeChildrenNumber) {
        if (noChildren + changeChildrenNumber < 0)
            System.out.println("Λάθος! Δεν επιτρέπεται αρνητικός αριθμός παιδιών");
        else
            noChildren = noChildren + changeChildrenNumber;
    }

    public void totalBonus(int experienceBonus, int childBonus){

        int marriageBonus;
        if (married == true)
            marriageBonus = 50;
        else
            marriageBonus = 0;

        int degreeBonus;
        if(postGrad == 1) {
            degreeBonus= 50;
        }
        else if (postGrad == 2) {
            degreeBonus = 100;
        }
        else {
            degreeBonus = 0;
            // Περιττό το else;
        }

        bonus = (experienceBonus * years) +  marriageBonus + (noChildren * childBonus) + degreeBonus;

    }

    public void details() {
        System.out.println("===============================");
        System.out.println("Ονοματεπώνυμο: " + name);
        System.out.println("Βαθμίδα Εκπαίδευσης: " + education);
        System.out.println("Μεταπτυχιακές σπουδές: " + postGradString());
        System.out.println("Έτη υπηρεσίας: " + years);
        System.out.println("Οικογενειακή κατάσταση: " + marriageStatus());
        System.out.println("Αριθμός ανήλικων παιδιών: " + noChildren);
        System.out.println("Μισθός: " + salary + " euros");
        System.out.println("Μηνιαίο εισόδημα: " + getMonthlySalary() + " euros");
        System.out.println("===============================");
    }

}
