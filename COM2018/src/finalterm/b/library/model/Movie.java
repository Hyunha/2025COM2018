package finalterm.b.library.model;

public class Movie {
    private String title;
    private String director;
    private double score;
    private int year;

    public Movie(String title, String director, double score, int year) {
        this.setTitle(title);
        this.setDirector(director);
        this.setScore(score);
        this.setYear(year);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString() {
        return title + ", " + director + ", " + score + ", " + year;
    }
}
