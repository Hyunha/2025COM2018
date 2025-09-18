package chapters.ch03;

public class TextSearch {
    public static void main(String[] args) {
        TextSearch text_search = new TextSearch();
        String s = "Hanyang";
        char c = 'a';
        boolean found = false;
        int index = 0;
        while (!found && index < s.length()) {
            // loop invariant:
            // (1) found == false : s[0], .., s[index-1]은 모두 c가 아님
            // (2) found == true : s.charAt(index) == c
            if (s.charAt(index) == c)
                found = true;
            else
                index = index + 1;
        }
        if (!found)
            index = -1;
        System.out.println(index);
    }
}
