package Film_Project;

import java.util.ArrayList;

public class FilmProgram {

    private ArrayList<Film> list;
    // Q7
    public FilmProgram(){
       list = new ArrayList<Film>();
    }

    // Q8
    public void storeFilm(Film aFilm) {
        list.add(aFilm);
    }

    // Q9
    public ArrayList<Film> getList(){
        return list;
    }

    // Q10
    public ArrayList<Film> candidateFilms(){
        ArrayList<Film> oscarList = new ArrayList();
        for(Film f: list) {
            if(f.getCandidacyStatus()) {
                oscarList.add(f);
            }
        }
        return oscarList;
    }

    // Q11
    public ArrayList<Film> monthFilms(int month) {
        ArrayList<Film> monthCheck = new ArrayList();
        for(Film f: list) {
            String date = f.getDate();
            int firstDate = Integer.parseInt(date.substring(3,5));
            if(firstDate == month) {
                monthCheck.add(f);
            }
        }
        return monthCheck;
    }

    // Q12
    public float filmsMeanTime(){
        float avgTime = 0;
        int counter = 0;
        float tempTime = 0;
        for(Film meanList: list){
            tempTime += meanList.getShowTime();
            counter++;
        }
        avgTime = tempTime / counter;
        return avgTime;
    }

    // Q13
    public void findFilm(String aTitle) {
        boolean filmFound = false;
        for (Film findList : list) {
            if (findList.getTitle().equals(aTitle)) {
                findList.printInfo();
                filmFound = true;
            }
        }
        if (filmFound == false) {
            System.out.println("The film " + aTitle + "does not belong to the collection");
        }
    }

    // Q14
    public void showFilms(ArrayList<Film> alist) {
        for(Film a: alist) {
            a.printInfo();
        }
    }



}
