package gr.aueb.cf.javaProjects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Project3 {
    public static void main(String[] args) {
        String inputFileName = "project3.txt";
        ArrayList<Frequency> frequencies = new ArrayList<>();

        StringBuilder builder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
               builder.append(line);
            }
            String str = builder.toString();
            char[] strArray = str.toCharArray();

            for (int i = 0; i < 128; i++) {
                if(!Character.isWhitespace(strArray[i])) {
                    boolean found = false;
                    for (Frequency f:frequencies){
                        if (f.character == strArray[i]) {
                            f.count ++;
                            found = true;
                        }
                    }
                    if (!found) {
                        frequencies.add(new Frequency(strArray[i], 1 ));
                    }
                }
            }


        } catch (IOException e) {
            System.out.println("Σφάλμα κατά την ανάγνωση του αρχείου: " + e.getMessage());
            return;
        }

        Collections.sort(frequencies, (p1, p2) -> Integer.compare(p2.count, p1.count));

        System.out.println("Ταξινόμηση ανά συχνότητα εμφάνισης");
        for (Frequency f:frequencies){
            System.out.println("Ο χαρακτήρας " + f.character + " εμφανίζεται " + f.count + " φορές");
        }

        Collections.sort(frequencies, (p1, p2) -> Character.compare(p2.character, p1.character));
        System.out.println("Ταξινόμηση ανά χαρακτήρα");
        for (Frequency f:frequencies){
            System.out.println("Ο χαρακτήρας " + f.character + " εμφανίζεται " + f.count + " φορές");
        }


    }
}
class Frequency {
    char character;
    int count;

    public Frequency(char character, int count) {
        this.character = character;
        this.count = count;
    }
}



