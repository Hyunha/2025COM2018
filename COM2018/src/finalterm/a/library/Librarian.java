package finalterm.a.library;

import finalterm.a.library.controller.LibraryController;

public class Librarian {
    public static void main(String[] args) {
        String books = "books50.txt";
        LibraryController library = new LibraryController();
        library.processLibrary(books);
    }
}
