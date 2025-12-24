import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Create schools
        School school1 = new School("1st Highschool Polygyros", "Papadopoulos");
        School school2 = new School("17th Highschool Thessaloniki", "Nikolaou");
        School school3 = new School("3rd Highschool Patras", "Iosifidou");

        // Generated teachers με AI για το school 1
        school1.addTeacher(new Associate(25.50, 120, "Dimitriou", "10001"));
        school1.addTeacher(new Associate(28.75, 150, "Papacharalambous", "10002"));
        school1.addTeacher(new Associate(22.00, 100, "Georgiadis", "10003"));
        school1.addTeacher(new Tenured(2500.00, 0.15, 2, "Papadopoulos", "20001"));


        // Generated teachers με AI για το school 2
        school2.addTeacher(new Associate(23.50, 110, "Anagnostou", "10006"));
        school2.addTeacher(new Tenured(2600.00, 0.16, 2, "Alexandrou", "20004"));
        school2.addTeacher(new Tenured(2900.00, 0.19, 1, "Michalopoulos", "20005"));
        school2.addTeacher(new Tenured(3100.00, 0.21, 2, "Theodoros", "20006"));

        // Generated teachers με AI για το school 3
        school3.addTeacher(new Associate(24.75, 125, "Petrou", "10007"));
        school3.addTeacher(new Associate(27.25, 145, "Kontogiannis", "10008"));
        school3.addTeacher(new Associate(21.50, 95, "Demetriou", "10009"));
        school3.addTeacher(new Tenured(2550.00, 0.17, 2, "Giannakopoulos", "20007"));
        school3.addTeacher(new Tenured(2750.00, 0.18, 1, "Komnenos", "20008"));
        school3.addTeacher(new Tenured(3050.00, 0.22, 3, "Marinos", "20009"));

        ArrayList<School> schools = new ArrayList<School>();

        schools.add(school1);
        schools.add(school2);
        schools.add(school3);

        InputFrame form = new InputFrame(schools);

//        school1.printTeachers();

    }

}
