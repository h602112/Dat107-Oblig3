import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = -1;

        while (true) {
            System.out.println("Vennligst oppgi brukernavnet til ansatte du vil finne(-1 for avbryte): ");
            String brukerNavn = scanner.nextLine();
            if (brukerNavn.equals("-1")) {
                break;
            }
            AnsattDAO ansattDAO = new AnsattDAO();
            System.out.println(ansattDAO.finnAnsattMedPk(brukerNavn));

        }

    }
}
