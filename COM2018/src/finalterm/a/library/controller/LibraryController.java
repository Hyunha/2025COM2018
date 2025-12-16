package finalterm.a.library.controller;

import finalterm.a.library.model.Book;
import finalterm.a.library.model.Library;
import finalterm.a.library.view.BookReader;

public class LibraryController {

    private Library library;

    public LibraryController() {
        library = new Library();
    }

    public void processLibrary(String in) {
        BookReader reader = new BookReader(in);
        while (reader.getNextRecord()) {
            Book book = new Book(reader.titleOf(), reader.authorOf(), reader.priceOf(), reader.genreOf());
            library.addBook(book);
        }
        reader.close();
    }

    public Library getLibrary() {
        return library;
    }
}
