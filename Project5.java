package gr.aueb.cf.javaProjects;

public class Project5 {

   static boolean[][] isSeatBooked = new boolean[30][12];

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 12; j++){
                isSeatBooked[i][j] = false;

            }
        }


    }

    public static void book(char column, int row) {
        int  col = (int)column - 65;  // Μετατροπή χαρακτήρα σε ASCII αριθμό
        if (isSeatBooked[row][col]) {
            System.out.println("Η θέση είναι κλεισμένη");
        } else {
            isSeatBooked[row][col] = true;
            System.out.println("Η κράτηση πραγματοποιήθηκε επιτυχώς");
        }
    }

    public static void cancel(char column, int row) {
        int  col = (int)column - 65;  // Μετατροπή χαρακτήρα σε ASCII αριθμό
        if (!isSeatBooked[row][col]) {
            System.out.println("Η θέση δεν είναι κλεισμένη");
        } else {
            isSeatBooked[row][col] = false;
            System.out.println("Η ακύρωση της κράτησης πραγματοποιήθηκε επιτυχώς");
        }
    }



}
