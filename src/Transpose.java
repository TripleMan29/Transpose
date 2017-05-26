import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.*;


class Transpose {
    private int width;
    private boolean cut;
    private boolean align;

    Transpose(int width, boolean align, boolean cut) {
        this.width = width;
        this.align = align;
        this.cut = cut;
    }

    void transpose(Scanner scan, PrintWriter out) throws IOException {
        int maxSize = 0;
        List<List<String>> listOfStrings = new ArrayList<>();
        while (scan.hasNextLine()) {
            List<String> line = new ArrayList<>();
            String[] words = scan.nextLine().split("[ ]+");
            Collections.addAll(line, words);
            if (line.size() > maxSize) {
                maxSize = line.size();
            }
                listOfStrings.add(line);

        }
        String alignn;
        String widthToString;
        if ((this.align) || (width == 0)) alignn = "";
        else alignn = "-";
        if (width == 0) widthToString = "";
        else widthToString = Integer.toString(width);
        for (int i = 0; i < maxSize; i++) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < maxSize; j++) {
                try {
                    int len;
                    String word = String.format("%" + alignn + widthToString + "s", listOfStrings.get(j).get(i));
                    if (cut)
                        word = word.substring(0, width);
                    str.append(word);
                    if (width != 0) len = Math.max(width - word.length(), 0) + 1;
                    else len = 1;
                    if (j != maxSize - 1) for (int n = 0; n < len; n++) {
                        str.append(" ");
                    }
                } catch (IndexOutOfBoundsException ignored) {
                    int len;
                    if (width != 0) len = width;
                    else len = 1;
                    if (j != maxSize - 1) for (int n = 0; n < len; n++) {
                        str.append(" ");
                    }
                }
            }
            out.println(str);
        }
        out.close();
    }
}
