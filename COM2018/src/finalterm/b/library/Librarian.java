package finalterm.b.library;

import finalterm.b.library.controller.LibraryController;

public class Librarian {
    public static void main(String[] args) {
        String movies = "imdb100.csv";
        LibraryController library = new LibraryController();
        library.processLibrary(movies);
    }
}
