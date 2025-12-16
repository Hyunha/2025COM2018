package finalterm.a.library.model;

public class Library {
    private Book[] books;
    public final int MAX_BOOKS = 200;
    private int numOfBooks;

    public Library() {
        books = new Book[MAX_BOOKS];
        numOfBooks = 0;
    }

    public boolean addBook(Book book) {
        if (book == null || book.getTitle() == null || book.getAuthor() == null || book.getGenre() == null || book.getPrice() < 0) {
            return false;
        }
        if (numOfBooks < MAX_BOOKS) {
            books[numOfBooks] = book;
            numOfBooks++;
            return true;
        } else {
            return false;
        }
    }

    public int getNumOfBooks() {
        return numOfBooks;
    }

    public Book getBook(int index) {
        if (index < 0 || index >= numOfBooks) {
            return null;
        }
        return books[index];
    }

    public Book findBookByTitle(String title) {
        Book result = null;
        for (int i = 0; i < numOfBooks; i++) {
            if (books[i].getTitle().equals(title)) {
                result = books[i];
            }
        }
        return result;
    }

    public Book[] findBooksByAuthor(String author) {
        Book[] results = new Book[numOfBooks];
        int idx = 0;
        for (int i = 0; i < numOfBooks; i++) {
            if (books[i].getAuthor().equals(author)) {
                results[idx] = books[i];
                idx++;
            }
        }
        return results;
    }

    public Book[] findBooksByGenre(String genre) {
        Book[] results = new Book[numOfBooks];
        int idx = 0;
        for (int i = 0; i < numOfBooks; i++) {
            if (books[i].getGenre().equals(genre)) {
                results[idx] = books[i];
                idx++;
            }
        }
        return results;
    }

    public Book mostExpensiveBook() {
        Book result = null;
        double max = 0.0;
        for (int i = 0; i < numOfBooks; i++) {
            if (books[i].getPrice() > max) {
                result = books[i];
                max = books[i].getPrice();
            }
        }
        return result;
    }

    private int findBookIndex(String[] authors, String author) {
        for (int i = 0; i < authors.length; i++) {
            if (authors[i] != null && authors[i].equals(author)) {
                return i;
            }
        }
        return -1;
    }

    public String mostProlificAuthor() {
        String prolificAuthor = "none";
        String[] authors = new String[numOfBooks];
        int[] bookCounts = new int[numOfBooks];
        int numOfAuthors = 0;
        for (int i = 0; i < numOfBooks; i++) {
            Book ithBook = books[i];
            int ithAuthorIdx = findBookIndex(authors, ithBook.getAuthor());
            if (ithAuthorIdx == -1) {
                authors[numOfAuthors] = ithBook.getAuthor();
                bookCounts[numOfAuthors] = 1;
                numOfAuthors++;
            } else {
                bookCounts[ithAuthorIdx]++;
            }
        }
        int bookCountMax = 0;
        for (int i = 0; i < numOfAuthors; i++) {
            if (bookCounts[i] > bookCountMax) {
                bookCountMax = bookCounts[i];
                prolificAuthor = authors[i];
            }
        }
        return prolificAuthor;
    }
}
