package Film_Project;

public class Film {

    // Q1
    private String title;
    private String director;
    private int playingTime;
    private boolean candidacy;
    private String showDate;

    // Q2
    public Film(String title, String director, int playingTime, String showDate) {
        this.title = title;
        this.director = director;
        this.playingTime = playingTime;
        this.showDate = showDate;
        candidacy = false;
    }

    // Q3
    public Film(String title) {
        this.title = title;
        director = "";
        playingTime = 0;
        candidacy = false;
        showDate = "00/00/0000";
    }
    // Q4
    public void setTitle(String aTitle) {
        title = aTitle;
    }

    public void setDirector(String aDirector) {
        director = aDirector;
    }

    public void setPlayingTime(int time) {
        playingTime = time;
    }

    public void setDate (String aDate) {
        showDate = aDate;
    }

    public void setCandidacyStatus(boolean newStatus) {
        candidacy = newStatus;
    }

    // Q5
    public String getTitle(){
        return title;
    }

    public String getDirector(){
        return director;
    }

    public int getShowTime(){
        return playingTime;
    }

    public boolean getCandidacyStatus(){
        return candidacy;
    }

    public String getDate(){
        return showDate;
    }

    // Q6
    public void printInfo(){
        System.out.println(title + ", Director " + director);
        System.out.println("\t" + playingTime + " minutes");
        System.out.println("\t" + showDate);
        if(candidacy) {
            System.out.println("\tCandidate for Oscar!");
        }
    }




}

