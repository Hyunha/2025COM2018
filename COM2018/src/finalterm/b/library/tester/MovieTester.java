package finalterm.b.library.tester;

public class MovieTester {
    /**
     * List of Movies are referenced by following web page.
     * https://github.com/itiievskyi/IMDB-Top-250/blob/master/imdb_top_250.csv
     */

    private static boolean[] solved = MovieTestHelper.getSovled();

    static void main() {
        // 1.1 Movie
        solved[1] = true;
        // 1.2 getter/setter methods for Movie
        solved[2] = true;
        // 2.0 getNumOfMovies
        solved[3] = true;
        // 2.1 findMovieByTitle
        solved[4] = true;
        // 2.2.1 findMoviesByDirector#1
        solved[5] = true;
        // 2.2.2 findMoviesByDirector#2
        solved[6] = true;
        // 2.3.1 findMoviesByYear#1
        solved[7] = true;
        // 2.3.2 findMoviesByYear#2
        solved[8] = true;
        // 2.4 bestScoredMovie
        solved[9] = true;
        // 2.5.1 mostProlificDirector#1
        solved[10] = true;
        // 2.5.2 mostProlificDirector#2
        solved[11] = true;
        // 3.0 MovieReader loading without exception
        solved[12] = true;
        // 3.1.1 sample Movie loading test by MovieReader#1
        solved[13] = true;
        // 3.1.2 sample Movie loading test by MovieReader#2
        solved[14] = true;
        // 3.1.3 sample Movie loading test by MovieReader#3
        solved[15] = true;
        // 3.2 getNumOfMovies on MovieReader
        solved[16] = true;
        // 3.3.1 findMovieByTitle
        solved[17] = true;
        // 3.3.2 findMoviesByDirector
        solved[18] = true;
        // 3.3.3 findMovieByYear
        solved[19] = true;
        // 3.3.4 bestScoredMovie
        solved[20] = true;
        // 3.3.5 mostProlificDirector
        solved[21] = true;

        /* 4 Movies Viewer */
        // If you implement GUI for Movie (MovieViewer)
        // uncomment the below line
        MovieTestHelper.runViewer();

        /* do not touch following code */
        MovieTestHelper.checker();
    }
}
