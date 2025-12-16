package finalterm.b.library.tester;

import finalterm.b.library.controller.LibraryController;
import finalterm.b.library.model.Movie;
import finalterm.b.library.model.Library;
import finalterm.b.library.view.MovieReader;
import finalterm.b.library.view.MovieViewer;

public class MovieTestHelper {

    private static int total = 21;
    private static int tries = 0;
    private static int correct = 0;

    private static boolean testViewer = false;

    public static void runViewer() { testViewer = true; }

    private static boolean[] solved = {
            true, // dummy
            false, false, false, false, false,
            false, false, false, false, false,
            false, false, false, false, false,
            false, false, false, false, false,
            false, false, false, false, false,
    };

    public static boolean[] getSovled() {
        return solved;
    }
    public static int getTotal() {
        return total;
    }

    private static String[][] answers = {
            {""}, // dummy
            {"The Lord of the Rings: The Return of the King,2003,Peter Jackson,8.9"},
            {"TLtR,2000,P.J,99.99"},
            {"4/truetruetruetrue"},
            {"8.4"},
            {"Sample1,Sample3,Sample4","Sample1,Sample3,Sample4,null"},
            {"null,null,null,null", "null"},
            {"Sample3,Sample4,null,null", "Sample3,Sample4"},
            {"null,null,null,null", "null"},
            {"9.0"},
            {"Director1"},
            {"empty"},
            {"true"},
            {"The Godfather: Part II/1974/Francis Ford Coppola/9.0"},
            {"Schindler's List/1993/Steven Spielberg/8.9"},
            {"Il buono, il brutto, il cattivo/1966/Sergio Leone/8.9"},
            {"10"},
            {"Francis Ford Coppola"},
            {"2"},
            {"3"},
            {"The Shawshank Redemption by Frank Darabont"},
            {"Christopher Nolan"},
            {""},
    };

    public static void checker(int numOfTest, String msg, String solve) {
        int preparedMargin = 20;
        if (solved[numOfTest]) {
            tries++;
            String[] candidates = answers[numOfTest];
            boolean ok = false;
            for (int i = 0; i < candidates.length; i++) {
                if (candidates[i].equals(solve)) {
                    ok = true;
                }
            }
            String prompt = "[" + msg + "]";
            int promptLength = prompt.length();
            System.out.print(prompt);
            if (ok) {
                System.out.println(" ".repeat(preparedMargin - promptLength) + "OK");
                correct++;
            } else {
                if (candidates.length == 1) {
                    System.out.print(" answer is " + " ".repeat(preparedMargin - promptLength - 11) + ": ");
                    System.out.println(candidates[0]);
                } else {
                    for (int i = 0; i < candidates.length; i++) {
                        if (i == 0) {
                            System.out.print(" answers are " + " ".repeat(preparedMargin - promptLength - 13) + ": ");
                        } else {
                            System.out.print(" ".repeat(preparedMargin - 3) + "or   ");
                        }
                        System.out.println(candidates[i]);
                    }
                }
                System.out.print(" ".repeat(promptLength));
                System.out.print(" your solve" + " ".repeat(preparedMargin - promptLength - 11) + ": ");
                System.out.println(solve);
            }
        }
    }

    public static void checker() {

        // settings for 1.x
        Movie movie = new Movie("The Lord of the Rings: The Return of the King", "Peter Jackson", 8.9, 2003);
        String generated = movie.getTitle()+","+ movie.getYear()+","+ movie.getDirector()+","+ movie.getScore();

        // check 1.1 : generate Movie
        checker(1, "1.1", generated);

        // settings for 1.2
        movie.setTitle("TLtR");
        movie.setYear(2000);
        movie.setDirector("P.J");
        movie.setScore(99.99);

        // check 1.2 : getter/setter methods of Movie
        generated = movie.getTitle()+","+ movie.getYear()+","+ movie.getDirector()+","+ movie.getScore();
        checker(2, "1.2", generated);

        // settings for 2.x
        Library library = new Library();

        boolean b1 = library.addMovie(new Movie("Sample1", "Director1", 9.0, 2000));
        boolean b2 = library.addMovie(new Movie("Sample2", "Director2", 8.4, 2001));
        boolean b3 = library.addMovie(new Movie("Sample3", "Director1", 8.6, 2002));
        boolean b4 = library.addMovie(new Movie("Sample4", "Director1", 8.2, 2002));

        // check 2.2 : getNumOfMovies
        generated = "" + library.getNumOfMovies() + "/" + b1 + b2 + b3 + b4;
        checker(3, "2.2", generated);

        // check 2.3 : findMovieByTitle
        try {
            generated = "" + library.findMovieByTitle("Sample2").getScore();
        } catch (Exception e) {
            generated = e.getMessage();
        }
        checker(4, "2.3", generated);

        // check 2.4.1 : findMoviesByDirector#1
        try {
            Movie[] answers = library.findMoviesByDirector("Director1");
            generated = "";
            for (int i = 0; i < answers.length;i++) {
                if (!"".equals(generated)) { generated += ","; }
                if (answers[i] != null) {
                    generated += answers[i].getTitle();
                } else {
                    generated += "null";
                }
            }
        } catch (Exception e) {
            generated = e.getMessage();
        }
        checker(5, "2.4.1", generated);

        // check 2.4.2 : findMoviesByDirector#2
        try {
            Movie[] answers = library.findMoviesByDirector("Director3");
            generated = "";
            if (answers != null) {
                for (int i = 0; i < answers.length;i++) {
                    if (!"".equals(generated)) { generated += ","; }
                    if (answers[i] != null) {
                        generated += answers[i].getTitle();
                    } else {
                        generated += "null";
                    }
                }
            } else {
                generated = "null";
            }
        } catch (Exception e) {
            generated = e.getMessage();
        }
        checker(6, "2.4.2", generated);

        // check 2.5.1 : findMoviesByYear#1
        try {
            Movie[] answers = library.findMoviesByYear(2002);
            generated = "";
            for (int i = 0; i < answers.length;i++) {
                if (!"".equals(generated)) { generated += ","; }
                if (answers[i] != null) {
                    generated += answers[i].getTitle();
                } else {
                    generated += "null";
                }
            }
        } catch (Exception e) {
            generated = e.getMessage();
        }
        checker(7, "2.5.1", generated);

        // check 2.5.2 : findMoviesByYear#2
        try {
            Movie[] answers = library.findMoviesByYear(1999);
            generated = "";
            if (answers != null) {
                for (int i = 0; i < answers.length;i++) {
                    if (!"".equals(generated)) { generated += ","; }
                    if (answers[i] != null) {
                        generated += answers[i].getTitle();
                    } else {
                        generated += "null";
                    }
                }
            } else {
                generated = "null";
            }
        } catch (Exception e) {
            generated = e.getMessage();
        }
        checker(8, "2.5.2", generated);

        // check 2.6 : bestScoredMovie
        try {
            Movie answer = library.bestScoredMovie();
            generated = "" + answer.getScore();
        } catch (Exception e) {
            generated = e.getMessage();
        }
        checker(9, "2.6", generated);

        // check 2.7.1 : mostProlificDirector#1
        try {
            generated = library.mostProlificDirector();
        } catch (Exception e) {
            generated = e.getMessage();
        }
        checker(10, "2.7.1", generated);

        // check 2.7.2 : mostProlificDirector#2
        try {
            generated = new Library().mostProlificDirector();
        } catch (Exception e) {
            generated = e.getMessage();
        }
        checker(11, "2.7.2", generated);

        boolean loadSuccess = false;
        LibraryController libraryController = new LibraryController();
        LibraryController libraryController100 = new LibraryController();
        try {
            libraryController.processLibrary("imdb10.csv");
            libraryController100.processLibrary("imdb100.csv");
            loadSuccess = true;
        } catch (Exception e) {

        }
        generated = "" + loadSuccess;
        checker(12, "3.0", generated);
        if (loadSuccess) {
            MovieReader br = new MovieReader("imdb10.csv");
            int idx = 0;

            try {
                for (int i = 0; br.getNextRecord() && i < 10; i++) {
                    String title = br.titleOf();
                    String author = br.directorOf();
                    double score = br.scoreOf();
                    int year = br.yearOf();
                    if (i % 3 == 2) {
                        generated  = title;
                        generated += "/" + year;
                        generated += "/" + author;
                        generated += "/" + score;
                        checker(13 + idx, "3.1." + (idx + 1), generated);
                        idx++;
                    }
                }

            } catch (Exception e) {

            }

            library = libraryController.getLibrary();

            generated = "" + library.getNumOfMovies();
            checker(16, "3.2", generated);

            generated = null;
            try {
                generated = library.findMovieByTitle("The Godfather").getDirector();
            } catch (Exception e) {}
            checker(17, "3.3.1", generated);

            generated = "";
            try {
                Movie[] movies = library.findMoviesByDirector("Francis Ford Coppola");
                int count = 0;
                for (int i = 0; i < movies.length; i++) {
                    if (movies[i] == null) {
                        break;
                    }
                    count++;
                }
                generated = "" + count;
            } catch (Exception e) {}
            checker(18, "3.3.2", generated);

            library = libraryController100.getLibrary();
            generated = "";
            try {
                Movie[] movies = library.findMoviesByYear(2002);
                int count = 0;
                for (int i = 0; i < movies.length; i++) {
                    if (movies[i] == null) {
                        break;
                    }
                    count++;
                }
                generated = "" + count;
            } catch (Exception e) {}
            checker(19, "3.3.3", generated);

            generated = "";
            try {
                movie = library.bestScoredMovie();
                generated = movie.getTitle() + " by " + movie.getDirector();
            } catch (Exception e) {}
            checker(20, "3.3.4", generated);

            generated = "";
            try {
                generated = library.mostProlificDirector();
            } catch (Exception e) {}
            checker(21, "3.3.5", generated);

            if (testViewer) {
                new MovieViewer(library);
            }
        }

        System.out.println("--------------------------");
        System.out.println("| Results                |");
        System.out.println("--------------------------");
        if (tries == total) {

            if (correct == total) {
                System.out.println("ALL passed");
            } else {
                System.out.println("" + correct + "/" + total + " passed");
            }
        } else {
            System.out.print("" + tries + "/" + total + " tried, ");
            System.out.println("" + correct + "/" + tries + " passed");
            System.out.println("" + (total - tries) + "/" + total + " left");
        }
    }
}
