package finalterm.a.library.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BookReader {
    private BufferedReader reader;
    private final String EOF = "!";
    private String title;
    private String author;
    private String genre;
    private double price;

    public BookReader(String fileName) {
        try {
            reader = new BufferedReader(new FileReader(fileName));
        } catch (IOException e) {
            System.out.println("BookReader Error - bad file name: " + fileName);
            throw new RuntimeException(e.toString());
        }
    }

    private String replaceUnderscores(String input) {
        String result = "";
        StringTokenizer t = new StringTokenizer(input, "_");
        int numOfTokens = t.countTokens();
        if (numOfTokens <= 1) {
            return input;
        } else {
            while (t.hasMoreTokens()) {
                String token = t.nextToken();
                if ("".equals(result)) {
                    result = token;
                } else {
                    result += "," + token;
                }
            }
        }
        return result;
    }

    public boolean getNextRecord() {
        boolean result = false;
        try {
            if (reader.ready()) {
                String line = reader.readLine();
                StringTokenizer t = new StringTokenizer(line, ",");
                String s = t.nextToken().trim();
                if (!EOF.equals(s)) {
                    if (t.countTokens() == 3) {
                        title = replaceUnderscores(s);
                        author = t.nextToken().trim();
                        genre = t.nextToken().trim();
                        price = Double.parseDouble(t.nextToken().trim());
                        result = true;
                    } else {
                        throw new RuntimeException(line);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("BookReader Error : " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("BookReader Error - bad record format : " + e.getMessage() + " Skipping");
            result = getNextRecord();
        }
        return result;
    }

    public String titleOf() {
        return title;
    }

    public String authorOf() {
        return author;
    }

    public String genreOf() {
        return genre;
    }

    public double priceOf() {
        return price;
    }

    public void close() {
        try {
            reader.close();
        } catch (IOException e) {
            System.out.println("BookReader Warning - file close failed");
        }
    }
}
