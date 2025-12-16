package finalterm.a.library.tester;

import finalterm.a.library.controller.LibraryController;
import finalterm.a.library.model.Book;
import finalterm.a.library.model.Library;
import finalterm.a.library.view.BookReader;
import finalterm.a.library.view.BookViewer;

public class BookTestHelper {

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
            {"The Lord of the Rings,JRR Tolkien,17.03,Adventure"},
            {"TLtR,JRR.T,99.99,RPG"},
            {"4"},
            {"10.0"},
            {"Sample1,Sample3,Sample4","Sample1,Sample3,Sample4,null"},
            {"null,null,null,null", "null"},
            {"Sample1,Sample2,null,null", "Sample1,Sample2"},
            {"null,null,null,null", "null"},
            {"14.0"},
            {"Author1"},
            {"none"},
            {"true"},
            {"His Dark Materials/Philip Pullman/Fantasy/17.44"},
            {"To Kill a Mockingbird/Harper Lee/Fantasy/19.33"},
            {"The Lion, the Witch and the Wardrobe/CS Lewis/Romance/20.06"},
            {"50"},
            {"Joseph Heller"},
            {"4"},
            {"10"},
            {"A Town Like Alice by Nevil Shute"},
            {"JK Rowling"},
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
        Book book = new Book("The Lord of the Rings", "JRR Tolkien", 17.03, "Adventure");
        String generated = book.getTitle()+","+book.getAuthor()+","+book.getPrice()+","+book.getGenre();

        // check 1.1 : generate Book
        checker(1, "1.1", generated);

        // settings for 1.2
        book.setTitle("TLtR");
        book.setAuthor("JRR.T");
        book.setPrice(99.99);
        book.setGenre("RPG");

        // check 1.2 : getter/setter methods of Book
        generated = book.getTitle()+","+book.getAuthor()+","+book.getPrice()+","+book.getGenre();
        checker(2, "1.2", generated);

        // settings for 2.x
        Library library = new Library();

        library.addBook(new Book("Sample1", "Author1", 10.0, "genre1"));
        library.addBook(new Book("Sample2", "Author2", 12.0, "genre1"));
        library.addBook(new Book("Sample3", "Author1", 13.0, "genre2"));
        library.addBook(new Book("Sample4", "Author1", 14.0, "genre2"));

        // check 2.2 : getNumOfBooks
        generated = "" + library.getNumOfBooks();
        checker(3, "2.2", generated);

        // check 2.3 : findBookByTitle
        try {
            generated = "" + library.findBookByTitle("Sample1").getPrice();
        } catch (Exception e) {
            generated = e.getMessage();
        }
        checker(4, "2.3", generated);

        // check 2.4.1 : findBooksByAuthor#1
        try {
            Book[] answers = library.findBooksByAuthor("Author1");
            generated = "";
            if (answers != null) {
                for (int i = 0; i < answers.length; i++) {
                    if (!"".equals(generated)) {
                        generated += ",";
                    }
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
        checker(5, "2.4.1", generated);

        // check 2.4.2 : findBooksByAuthor#2
        try {
            Book[] answers = library.findBooksByAuthor("Author3");
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

        // check 2.5.1 : findBooksByGenre#1
        try {
            Book[] answers = library.findBooksByGenre("genre1");
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
        checker(7, "2.5.1", generated);

        // check 2.5.2 : findBooksByGenre#2
        try {
            Book[] answers = library.findBooksByGenre("genre0");
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

        // check 2.6 : mostExpensiveBook
        try {
            Book answer = library.mostExpensiveBook();
            generated = "" + answer.getPrice();
        } catch (Exception e) {
            generated = e.getMessage();
        }
        checker(9, "2.6", generated);

        // check 2.7.1 : mostProlificAuthor#1
        try {
            generated = library.mostProlificAuthor();
        } catch (Exception e) {
            generated = e.getMessage();
        }
        checker(10, "2.7.1", generated);

        // check 2.7.2 : mostProlificAuthor#2
        try {
            generated = new Library().mostProlificAuthor();
        } catch (Exception e) {
            generated = e.getMessage();
        }
        checker(11, "2.7.2", generated);

        boolean loadSuccess = false;
        LibraryController libraryController = new LibraryController();
        try {
            libraryController.processLibrary("books50.txt");
            loadSuccess = true;
        } catch (Exception e) {

        }
        generated = "" + loadSuccess;
        checker(12, "3.0", generated);
        if (loadSuccess) {
            BookReader br = new BookReader("books50.txt");
            int idx = 0;

            try {
                for (int i = 0; br.getNextRecord() && i < 10; i++) {
                    String title = br.titleOf();
                    String author = br.authorOf();
                    double price = br.priceOf();
                    String genre = br.genreOf();
                    if (i % 3 == 2) {
                        generated  = title;
                        generated += "/" + author;
                        generated += "/" + genre;
                        generated += "/" + price;
                        checker(13 + idx, "3.1." + (idx + 1), generated);
                        idx++;
                    }
                }

            } catch (Exception e) {

            }

            library = libraryController.getLibrary();

            generated = "" + library.getNumOfBooks();
            checker(16, "3.2", generated);

            generated = null;
            try {
                generated = library.findBookByTitle("Catch-22").getAuthor();
            } catch (Exception e) {}
            checker(17, "3.3.1", generated);

            generated = "";
            try {
                Book[] books = library.findBooksByAuthor("JK Rowling");
                int count = 0;
                for (int i = 0; i < books.length;i++) {
                    if (books[i] == null) {
                        break;
                    }
                    count++;
                }
                generated = "" + count;
            } catch (Exception e) {}
            checker(18, "3.3.2", generated);

            generated = "";
            try {
                Book[] books = library.findBooksByGenre("Historical");
                int count = 0;
                for (int i = 0; i < books.length;i++) {
                    if (books[i] == null) {
                        break;
                    }
                    count++;
                }
                generated = "" + count;
            } catch (Exception e) {}
            checker(19, "3.3.3", generated);

            generated = "";
            try {
                book = library.mostExpensiveBook();
                generated = book.getTitle() + " by " + book.getAuthor();
            } catch (Exception e) {}
            checker(20, "3.3.4", generated);

            generated = "";
            try {
                generated = library.mostProlificAuthor();
            } catch (Exception e) {}
            checker(21, "3.3.5", generated);

            if (testViewer) {
                new BookViewer(library);
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
