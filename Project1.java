package gr.aueb.cf.javaProjects;

import java.io.*;
import java.util.*;

public class Project1 {

    public static void main(String[] args) {
        String inputFileName = "αριθμοί.txt";
        String outputFileName = "τελικές_εξάδες.txt";

        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    int number = Integer.parseInt(line);
                    if (number >= 1 && number <= 49) {
                        numbers.add(number);
                    } else {
                        System.out.println("Μη επιτρεπτός αριθμός: " + line);
                        return;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Μη έγκυρος αριθμός: " + line);
                    return;

                }
            }
        } catch (IOException e) {
            System.out.println("Σφάλμα κατά την ανάγνωση του αρχείου: " + e.getMessage());
            return;
        }


        if (numbers.size() < 7 || numbers.size() > 49) {
            System.out.println("Το αρχείο δεν περιέχει έγκυρο αριθμό αριθμών (μεταξύ 7 και 49).");
            return;
        }

        // Ταξινομούμε τους αριθμούς
        Collections.sort(numbers);

        // Παράγουμε όλες τις δυνατές εξάδες
        List<List<Integer>> combinations = new ArrayList<>();
        int n = numbers.size();
        for (int i = 0; i < n - 5; i++) {
            for (int j = i + 1; j < n - 4; j++) {
                for (int k = j + 1; k < n - 3; k++) {
                    for (int l = k + 1; l < n - 2; l++) {
                        for (int m = l + 1; m < n - 1; m++) {
                            for (int o = m + 1; o < n; o++) {
                                combinations.add(Arrays.asList(numbers.get(i), numbers.get(j), numbers.get(k),
                                        numbers.get(l), numbers.get(m), numbers.get(o)));
                            }
                        }
                    }
                }
            }
        }

        // Φιλτράρουμε τις εξάδες με τα κριτήρια
        List<List<Integer>> validCombinations = new ArrayList<>();
        for (List<Integer> combination : combinations) {
            if (isValidCombination(combination)) {
                validCombinations.add(combination);
            }
        }

        // Εξάγουμε τις έγκυρες εξάδες στο αρχείο
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            for (List<Integer> combination : combinations) {
                writer.write(combination.toString().replaceAll("[\\[\\],]", "") + "\n");
            }
        } catch (IOException e) {
            System.out.println("Σφάλμα κατά τη συγγραφή στο αρχείο: " + e.getMessage());
        }

        System.out.println("Η διαδικασία ολοκληρώθηκε και οι τελικές εξάδες αποθηκεύτηκαν στο αρχείο: " + outputFileName);
    }

    // Ελέγχει αν η εξάδα πληροί τα κριτήρια
    public static boolean isValidCombination(List<Integer> combination) {
        int evenCount = 0, oddCount = 0, consecutiveCount = 0;
        Map<Integer, Integer> lastDigits = new HashMap<>();
        Map<Integer, Integer> tensCount = new HashMap<>();

        for (int i = 0; i < combination.size(); i++) {
            int num = combination.get(i);

            // Ελέγχουμε αν ο αριθμός είναι άρτιος ή περιττός
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }

            // Ελέγχουμε για συνεχόμενους αριθμούς
            if (i > 0 && combination.get(i) == combination.get(i - 1) + 1) {
                consecutiveCount++;
            }

            // Ελέγχουμε για τους λήγοντες
            int lastDigit = num % 10;
            lastDigits.put(lastDigit, lastDigits.getOrDefault(lastDigit, 0) + 1);

            // Ελέγχουμε για τη δεκάδα
            int tens = num / 10;
            tensCount.put(tens, tensCount.getOrDefault(tens, 0) + 1);
        }

        // Ελέγχουμε τα κριτήρια
        return evenCount <= 4 &&
                oddCount <= 4 &&
                consecutiveCount <= 2 &&
                lastDigits.values().stream().max(Integer::compare).orElse(0) <= 3 &&
                tensCount.values().stream().max(Integer::compare).orElse(0) <= 3;
    }

}
