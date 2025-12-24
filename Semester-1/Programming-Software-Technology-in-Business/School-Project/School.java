import java.util.ArrayList;

public class School {

    private String name;
    private String principal;
    private ArrayList<Teacher> teachers = new ArrayList<>();

    public School(String name, String principal) {
        this.name = name;
        this.principal = principal;
    }

    public void addTeacher(Teacher aTeacher){
        teachers.add(aTeacher);
    }

    public void printTeachers(){
        System.out.println("Καθαρές μηνιαίες αποδοχές:");
        for(Teacher t: teachers) {
            System.out.println(t.getLastName() + " " +  t.totalIncome() + " euros" );

        }
    }

    public String getName() {
        return name;
    }

    public String getPrincipal() {
        return principal;
    }
}
