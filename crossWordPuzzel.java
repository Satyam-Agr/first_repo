package first_repo;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

class Result {

    public static List<String> crosswordPuzzle(List<String> crossword, String words) {
        List<String> word = Arrays.asList(words.split(";"));
        List<List<Integer>> posible = new ArrayList<>();
        for (int i = 0; i < word.size(); i++) {
            posible.add(new ArrayList<>());
            posible.get(i).add(word.get(i).length());
        }
        Hm(crossword, posible);
        Vm(crossword, posible);
        int[] current = new int[word.size()];
        gen.generate(posible, word, current, 0);
        int[] ans = gen.correct;
        for (int i = 0; i < word.size(); i++) {
            for (int j = 0; j < word.get(i).length(); j++) {
                int co = co(ans[i], j);
                int row = co / 10;
                int col = co % 10;
                crossword.set(row, replaceChar(crossword.get(row), col, word.get(i).charAt(j)));
            }
        }
        return crossword;
    }

    public static String replaceChar(String str, int index, char newChar) {
        return str.substring(0, index) + newChar + str.substring(index + 1);
    }

    public static void Hm(List<String> crossword, List<List<Integer>> posible) {
        // Horizontal matches
        for (int row = 0; row < crossword.size(); row++) {
            String temp = crossword.get(row) + "+"; // sentinel at end
            int start = -1;
            for (int i = 0; i < temp.length(); i++) {
                char c = temp.charAt(i);
                if (c == '-') {
                    if (start == -1) start = i;
                } else {
                    if (start != -1) {
                        check(posible, 1, row, start, i);
                        start = -1;
                    }
                }
            }
        }
    }

    public static void Vm(List<String> crossword, List<List<Integer>> posible) {
        // Vertical matches
        int rows = crossword.size();
        int cols = crossword.get(0).length();
        for (int col = 0; col < cols; col++) {
            int start = -1;
            for (int row = 0; row <= rows; row++) {
                char c = (row < rows) ? crossword.get(row).charAt(col) : '+'; // sentinel
                if (c == '-') {
                    if (start == -1) start = row;
                } else {
                    if (start != -1) {
                        check(posible, 2, col, start, row);
                        start = -1;
                    }
                }
            }
        }
    }

    public static void check(List<List<Integer>> posible, int hv, int index, int start, int stop) {
        int length = stop - start;
        for (int i = 0; i < posible.size(); i++) {
            if (length == posible.get(i).get(0)) {
                // Encode: hv(1 digit)*1000 + index*100 + start*10 + (stop-1)
                posible.get(i).add(hv * 1000 + index * 100 + start * 10 + (stop - 1));
            }
        }
    }

    public static boolean compare(List<String> word, List<List<Integer>> posible, int e1, int p1, int e2, int p2) {
        for (int i = 0; i < word.get(e1).length(); i++) {
            for (int j = 0; j < word.get(e2).length(); j++) {
                if (co(p1, i) == co(p2, j)) {
                    if (word.get(e1).charAt(i) != word.get(e2).charAt(j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static int co(int p, int i) {
        if (p / 1000 == 1) {
            // Horizontal: row * 10 + col
            int row = (p / 100) % 10;
            int colStart = (p / 10) % 10;
            return row * 10 + (colStart + i);
        } else {
            // Vertical: row * 10 + col
            int col = (p / 100) % 10;
            int rowStart = (p / 10) % 10;
            return (rowStart + i) * 10 + col;
        }
    }
}

class gen {
    static boolean found = false;
    static int[] correct;

    public static void generate(List<List<Integer>> posible, List<String> word, int[] current, int index) {
        if (found) return;

        if (index == word.size()) {
            boolean check = true;
            outer:
            for (int i = 0; i < word.size(); i++) {
                for (int j = i + 1; j < word.size(); j++) {
                    if (!Result.compare(word, posible, i, current[i], j, current[j])) {
                        check = false;
                        break outer;
                    }
                }
            }
            if (check) {
                found = true;
                correct = Arrays.copyOf(current, current.length);
            }
            return;
        }

        for (int i = 1; i < posible.get(index).size(); i++) {
            current[index] = posible.get(index).get(i);
            generate(posible, word, current, index + 1);
            if (found) return;
        }
    }
}

public class crossWordPuzzel {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        List<String> crossword = IntStream.range(0, 10).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).collect(Collectors.toList());

        String words = bufferedReader.readLine();

        List<String> result = Result.crosswordPuzzle(crossword, words);

        bufferedWriter.write(result.stream().collect(joining("\n")) + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
