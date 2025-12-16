package finalterm.b.library.view;

import finalterm.b.library.model.Movie;
import finalterm.b.library.model.Library;

import javax.swing.*;
import java.awt.*;

public class MovieViewer extends JFrame {

    private MovieButton[] movieButtons;
    private int selectedMovies = 0;
    private double scores = 0.0;

    JLabel message;
    JButton reset;

    public void addToCart(Movie movie) {
        selectedMovies++;
        scores += movie.getScore();
    }

    public void update() {
        double averageScore = 0.0;
        if (selectedMovies > 0) {
            averageScore = scores / selectedMovies;
        }
        String msg = "number of movies = " + selectedMovies +
                " / average scores = " + averageScore;
        message.setText(msg);
        repaint();
    }

    public MovieViewer(Library library) {
        setTitle("Movies");
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        JPanel lib = new JPanel(new FlowLayout());
        lib.setSize(800, 800);
        lib.setBackground(Color.WHITE);
        int numOfMovies = library.getNumOfMovies();
        movieButtons = new MovieButton[numOfMovies];
        for (int i = 0; i < numOfMovies; i++) {
            Movie movie = library.getMovie(i);
            MovieButton b = new MovieButton(movie, this);
            movieButtons[i] = b;
            lib.add(b);
        }
        JPanel cart = new JPanel(new FlowLayout());
        reset = new JButton("Reset");
        reset.addActionListener((e -> {
            message.setText("number of movies = 0 / average scores = 0.0");
            selectedMovies = 0;
            scores = 0.0;
            for (int i = 0; i < numOfMovies; i++) {
                movieButtons[i].setClicked(false);
            }
            update();
        }));

        message = new JLabel("number of movies = 0 / average scores = 0.0");
        cp.add(lib, BorderLayout.CENTER);
        cp.add(cart, BorderLayout.SOUTH);
        cart.add(message);
        cart.add(reset);
        setSize(800, 850);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
