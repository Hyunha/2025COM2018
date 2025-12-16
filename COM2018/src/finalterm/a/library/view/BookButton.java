package finalterm.a.library.view;

import finalterm.a.library.model.Book;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookButton extends JButton implements ActionListener {
    private Book book;
    private BookViewer view;
    private boolean selected;
    
    public BookButton(Book book, BookViewer view) {
        this.book = book;
        this.view = view;
        setText(book.getTitle());
        addActionListener(this);
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (selected) {
            String msg = "Already selected!";
            JOptionPane.showMessageDialog(this, msg);
        } else {
            String msg = "[" + book.getGenre() + "] " + book.getTitle() + " by " + book.getAuthor();
            msg += "\nprice = $" + book.getPrice();
            JOptionPane.showMessageDialog(this, msg);
            view.addToCart(book);
            view.update();
            selected = true;
        }
    }
}
