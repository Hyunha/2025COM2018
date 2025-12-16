package finalterm.a.library.view;

import finalterm.a.library.model.Book;
import finalterm.a.library.model.Library;

import javax.swing.*;
import java.awt.*;

public class BookViewer extends JFrame {

    private int selectedBooks = 0;
    private double prices = 0.0;
    private BookButton[] bookButtons;

    JLabel message;
    JButton reset;

    public void addToCart(Book book) {
        selectedBooks++;
        prices += book.getPrice();
    }

    public void update() {
        String msg = "number of books = " + selectedBooks +
                " / total price = $" + prices;
        message.setText(msg);
        repaint();
    }

    public BookViewer(Library library) {
        setTitle("Library");
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        JPanel lib = new JPanel(new FlowLayout());
        lib.setSize(600, 650);
        lib.setBackground(Color.WHITE);
        int numOfBooks = library.getNumOfBooks();
        bookButtons = new BookButton[numOfBooks];
        for (int i = 0; i < numOfBooks; i++) {
            Book book = library.getBook(i);
            BookButton b = new BookButton(book, this);
            lib.add(b);
            bookButtons[i] = b;
        }
        JPanel cart = new JPanel(new FlowLayout());
        reset = new JButton("Reset");
        reset.addActionListener((e -> {
            message.setText("number of books = 0 / total price = $0.0");
            selectedBooks = 0;
            prices = 0.0;
            for (int i = 0; i < numOfBooks; i++) {
                bookButtons[i].setSelected(false);
            }
            update();
        }));

        message = new JLabel("number of books = 0 / total price = $0.0");
        cp.add(lib, BorderLayout.CENTER);
        cp.add(cart, BorderLayout.SOUTH);
        cart.add(message);
        cart.add(reset);
        setSize(600, 730);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
