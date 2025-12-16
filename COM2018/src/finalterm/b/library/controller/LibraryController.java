package finalterm.b.library.controller;

import finalterm.b.library.model.Movie;
import finalterm.b.library.model.Library;
import finalterm.b.library.view.MovieReader;

public class LibraryController {

    private Library library;

    public LibraryController() {
        library = new Library();
    }

    public void processLibrary(String in) {
        MovieReader reader = new MovieReader(in);
        while (reader.getNextRecord()) {
            Movie movie = new Movie(reader.titleOf(), reader.directorOf(), reader.scoreOf(), reader.yearOf());
            library.addMovie(movie);
        }
        reader.close();
    }

    public Library getLibrary() {
        return library;
    }
}
