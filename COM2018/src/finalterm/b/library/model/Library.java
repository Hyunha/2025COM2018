package finalterm.b.library.model;

public class Library {
    private Movie[] movies;
    public final int MAX_MOVIES = 200;
    private int numOfMovies;

    public Library() {
        movies = new Movie[MAX_MOVIES];
        numOfMovies = 0;
    }

    public boolean addMovie(Movie movie) {
        if (movie == null || movie.getTitle() == null || movie.getDirector() == null || !(movie.getYear() >= 1900) || movie.getScore() < 0) {
            return false;
        }
        if (numOfMovies < MAX_MOVIES) {
            movies[numOfMovies] = movie;
            numOfMovies++;
            return true;
        } else {
            return false;
        }
    }

    public int getNumOfMovies() {
        return numOfMovies;
    }

    public Movie getMovie(int index) {
        if (index < 0 || index >= numOfMovies) {
            return null;
        }
        return movies[index];
    }

    public Movie findMovieByTitle(String title) {
        Movie result = null;
        for (int i = 0; i < numOfMovies; i++) {
            if (movies[i].getTitle().equals(title)) {
                result = movies[i];
            }
        }
        return result;
    }

    public Movie[] findMoviesByDirector(String director) {
        Movie[] results = new Movie[numOfMovies];
        int idx = 0;
        for (int i = 0; i < numOfMovies; i++) {
            if (movies[i].getDirector().equals(director)) {
                results[idx] = movies[i];
                idx++;
            }
        }
        return results;
    }

    public Movie[] findMoviesByYear(int year) {
        Movie[] results = new Movie[numOfMovies];
        int idx = 0;
        for (int i = 0; i < numOfMovies; i++) {
            if (movies[i].getYear() == year) {
                results[idx] = movies[i];
                idx++;
            }
        }
        return results;
    }

    public Movie bestScoredMovie() {
        Movie result = null;
        double max = 0.0;
        for (int i = 0; i < numOfMovies; i++) {
            if (movies[i].getScore() > max) {
                result = movies[i];
                max = movies[i].getScore();
            }
        }
        return result;
    }

    private int findMovieIndex(String[] directors, String director) {
        for (int i = 0; i < directors.length; i++) {
            if (directors[i] != null && directors[i].equals(director)) {
                return i;
            }
        }
        return -1;
    }

    public String mostProlificDirector() {
        String prolificDirector = "empty";
        String[] directors = new String[numOfMovies];
        int[] movieCounts = new int[numOfMovies];
        int numOfDirectors = 0;
        for (int i = 0; i < numOfMovies; i++) {
            Movie ithMovie = movies[i];
            int ithMovieIdx = findMovieIndex(directors, ithMovie.getDirector());
            if (ithMovieIdx == -1) {
                directors[numOfDirectors] = ithMovie.getDirector();
                movieCounts[numOfDirectors] = 1;
                numOfDirectors++;
            } else {
                movieCounts[ithMovieIdx]++;
            }
        }
        int movieCountMax = 0;
        for (int i = 0; i < numOfDirectors; i++) {
            if (movieCounts[i] > movieCountMax) {
                movieCountMax = movieCounts[i];
                prolificDirector = directors[i];
            }
        }
        return prolificDirector;
    }
}
