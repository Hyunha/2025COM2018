package finalterm.a.library.tester;

public class BookTester {
    /**
     * List of Books (titles and authors) are referenced by following web page.
     * https://www.bbc.co.uk/arts/bigread/top200.shtml
     * Genres and prices are randomly generated.
     */

    private static boolean[] solved = BookTestHelper.getSovled();

    static void main() {
        // 1.1 Book
        solved[1] = true;
        // 1.2 getter/setter methods for Book
        solved[2] = true;
        // 2.0 getNumOfBooks
        solved[3] = true;
        // 2.1 findBookByTitle
        solved[4] = true;
        // 2.2.1 findBooksByAuthor#1
        solved[5] = true;
        // 2.2.2 findBooksByAuthor#2
        solved[6] = true;
        // 2.3.1 findBookByGenre#1
        solved[7] = true;
        // 2.3.2 findBookByGenre#2
        solved[8] = true;
        // 2.4 mostExpensiveBook
        solved[9] = true;
        // 2.5.1 mostProlificAuthor#1
        solved[10] = true;
        // 2.5.2 mostProlificAuthor#2
        solved[11] = true;
        // 3.0 BookReader loading without exception
        solved[12] = true;
        // 3.1.1 sample Book loading test by BookReader#1
        solved[13] = true;
        // 3.1.2 sample Book loading test by BookReader#2
        solved[14] = true;
        // 3.1.3 sample Book loading test by BookReader#3
        solved[15] = true;
        // 3.2 getNumOfBooks on BookReader
        solved[16] = true;
        // 3.3.1 findBookByTitle
        solved[17] = true;
        // 3.3.2 findBooksByAuthor
        solved[18] = true;
        // 3.3.3 findBookByGenre
        solved[19] = true;
        // 3.3.4 mostExpensiveBook
        solved[20] = true;
        // 3.3.5 mostProlificAuthor
        solved[21] = true;
        // 4 Book List Viewer
        BookTestHelper.runViewer();
        BookTestHelper.checker();
    }
}
