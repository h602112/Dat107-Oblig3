import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class BrukerGrenseSnitt {
    public void start() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        int num = -1;

        label:
        while (true) {
            System.out.println("Hva har du lyst å gjøre?");
            System.out.println("1. søke etter ansatt med ansatt-id");
            System.out.println("2. søke etter ansatt med brukernavn");
            System.out.println("3. liste ut alle ansatte");
            System.out.println("4. oppdatere en ansatt sin lønn eller stilling");
            System.out.println("5. legge inn en ny ansatt");
            System.out.println("6. ingen av delene");
            String userChoice = scanner.nextLine();
            switch (userChoice) {
                case "1": {
                    System.out.println("Vennligst oppgi id til ansatte som du vil finne: ");
                    int ansattId = scanner.nextInt();
                    AnsattDAO ansattDAO = new AnsattDAO();
                    System.out.println(ansattDAO.finnAnsattMedId(ansattId));
                    break;
                }
                case "2": {
                    System.out.println("Vennligst oppgi bruker til ansatte som du vil finne: ");
                    String brukerNavn = scanner.nextLine();
                    AnsattDAO ansattDAO = new AnsattDAO();
                    System.out.println(ansattDAO.finnAnsattMedBrukerNavn(brukerNavn));
                    break;
                }
                case "3": {
                    AnsattDAO ansattDAO = new AnsattDAO();
                    System.out.println(ansattDAO.hentAlleAnsatte());
                    break;
                }
                case "4": {
                    System.out.println("Oppgi id til ansatte som du vil endre informasjon på: ");
                    int id = scanner.nextInt();
                    System.out.println("Vil du oppdatere lønn eller stilling?");
                    String valg = scanner.nextLine();
                    switch (valg) {
                        case "lønn": {
                            System.out.println("Hva er den nye lønnen?");
                            int nyLonn = scanner.nextInt();
                            AnsattDAO ansattDAO = new AnsattDAO();
                            ansattDAO.updateAnsattLonn(id, nyLonn);
                        }
                        case "stilling": {
                            System.out.println("Oppgi id til ansatte som du vil endre informasjon på: ");
                            System.out.println("Hva er den nye stillingen?: ");
                            String nyStilling = scanner.nextLine();
                            AnsattDAO ansattDAO = new AnsattDAO();
                            ansattDAO.updateAnsattStilling(id, nyStilling);

                        }
                    }
                }
                case "5": {
                    System.out.println("Vennligst oppgi informasjon angående den ansatte du vil sette inn");
                    System.out.print("Brukernavn: ");
                    String brukerNavn = scanner.next();
                    System.out.print("Fornavn: ");
                    String forNavn = scanner.next();
                    System.out.print("Etternavn: ");
                    String etterNavn = scanner.next();
                    System.out.print("Ansettelse-dato: ");
                    String dato = scanner.next();
                    System.out.println("Stilling: ");
                    String stilling = scanner.next();
                    System.out.println("Månedslønn: ");
                    int maanedslonn = scanner.nextInt();
                    Ansatt a = new Ansatt(brukerNavn, forNavn, etterNavn, dato, stilling, maanedslonn);
                    AnsattDAO ansattDAO = new AnsattDAO();
                    ansattDAO.createAnsatt(a);
                    break;
                }
                case "6":
                    break label;
            }
        }
    }
}
