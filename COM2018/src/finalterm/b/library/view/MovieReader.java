package finalterm.b.library.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class MovieReader {
    private BufferedReader reader;
    private final String EOF = "!";
    private String title;
    private int year;
    private String director;
    private double score;

    public MovieReader(String fileName) {
        try {
            reader = new BufferedReader(new FileReader(fileName));
        } catch (IOException e) {
            System.out.println("MovieReader Error - bad file name: " + fileName);
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
                    if (t.countTokens() == 4) {
                        title = replaceUnderscores(s);
                        year = Integer.parseInt(t.nextToken().trim());
                        director = t.nextToken().trim();
                        score = Double.parseDouble(t.nextToken().trim());
                        String ignore = t.nextToken().trim();
                        result = true;
                    } else {
                        throw new RuntimeException(line);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("MovieReader Error : " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("MovieReader Error - bad record format : " + e.getMessage() + " Skipping");
            result = getNextRecord();
        }
        return result;
    }

    public String titleOf() {
        return title;
    }

    public String directorOf() {
        return director;
    }

    public int yearOf() {
        return year;
    }

    public double scoreOf() {
        return score;
    }

    public void close() {
        try {
            reader.close();
        } catch (IOException e) {
            System.out.println("MovieReader Warning - file close failed");
        }
    }
}
