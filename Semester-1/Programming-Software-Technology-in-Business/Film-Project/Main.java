package Film_Project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        // a
        FilmProgram fm = new FilmProgram();

        // b
        Scanner input = new Scanner(System.in);

        boolean looping = true;
        while (looping) {

            // b i
            System.out.println("Give title? ");
            String title = input.nextLine();

            System.out.println("Give director? ");
            String director = input.nextLine();

            System.out.println("Give playing time? ");
            int playingTime = input.nextInt();

            //adeiasma 1
            input.nextLine();

            System.out.println("The film is candidate for Oscar? (true/false) ");
            boolean candidacy = (input.nextBoolean());

            //adeiasma 2
            input.nextLine();

            System.out.println("Give show date? ");
            String showDate = input.nextLine();



            // b ii
            Film f1 = new Film(title, director, playingTime, showDate);

            // b iii
            if(candidacy) {
                f1.setCandidacyStatus(true);
            }

            // b iv
            fm.storeFilm(f1);

            // b v
            System.out.print("Continue? (y/n) ");
            String answer = input.nextLine();

            if(answer.equals("n")) {
                looping = false;

            }

        }

        // c
        System.out.println("***** QUESTION c: show the list of all the films *****");
        fm.showFilms(fm.getList());
        System.out.println("");

        // d
        System.out.println("***** QUESTION d: show the list of films that are candidate for OSCAR *****");
        fm.showFilms(fm.candidateFilms());
        System.out.println("");

        // e
        System.out.println("***** QUESTION e: show the list of films shown on November *****");
        System.out.println("Give the month to see the program of films?");
        int inputMonth = input.nextInt();
        input.nextLine();
        fm.showFilms(fm.monthFilms(inputMonth));
        System.out.println("");

        // f
        System.out.println("***** QUESTION f: mean time of all films *****");
        System.out.println("The mean playing time of all the films in the collection is " + fm.filmsMeanTime());
        System.out.println("");

        // g
        System.out.println("***** QUESTION g: search for films *****");

        // incorrect Film
        System.out.println("Give the title of the film for searching?");
        String incorrectFilm = input.nextLine();
        fm.findFilm(incorrectFilm);

        // valid Film
        System.out.println("Give the title of the film for searching?");
        String validFilm = input.nextLine();
        fm.findFilm(validFilm);





    }
}
