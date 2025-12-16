package finalterm.b.library.view;

import finalterm.b.library.model.Movie;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovieButton extends JButton implements ActionListener {
    private Movie movie;
    private MovieViewer view;
    boolean clicked = false;

    public MovieButton(Movie movie, MovieViewer view) {
        this.movie = movie;
        this.view = view;
        setText(movie.getTitle());
        addActionListener(this);
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (clicked) {
            String msg = "Already selected!";
            JOptionPane.showMessageDialog(this, msg);
        } else {
            clicked = true;
            String msg = movie.getTitle();
            msg += "\ndirector : " + movie.getDirector() + " at " + movie.getYear();
            msg += "\nscore : " + movie.getScore();
            JOptionPane.showMessageDialog(this, msg);
            view.addToCart(movie);
            view.update();
        }
    }
}
