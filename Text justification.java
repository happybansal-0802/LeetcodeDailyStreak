Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left-justified, and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.
  Solution:
  import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();

        int i = 0;
        int width = 0;
        List<String> curLine = new ArrayList<>();

        while (i < words.length) {
            String curWord = words[i];

            if (width + curWord.length() <= maxWidth) {
                curLine.add(curWord);
                width += curWord.length() + 1;
                i++;
            } else {
                int spaces = maxWidth - width + curLine.size();

                int added = 0;
                int j = 0;

                while (added < spaces) {
                    if (j >= curLine.size() - 1) {
                        j = 0;
                    }

                    curLine.set(j, curLine.get(j) + " ");
                    added++;
                    j++;
                }

                res.add(String.join("", curLine));

                curLine.clear();
                width = 0;
            }
        }

        for (int word = 0; word < curLine.size() - 1; word++) {
            curLine.set(word, curLine.get(word) + " ");
        }
        curLine.set(curLine.size() - 1, curLine.get(curLine.size() - 1) + " ".repeat(maxWidth - width + 1));

        res.add(String.join("", curLine));

        return res;
    }
}
