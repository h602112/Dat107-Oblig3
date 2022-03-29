import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.util.SortedMap;

public class BrukerGrenseSnitt {
    public void start() throws ParseException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hva har du lyst å gjøre?");
        System.out.println("1. søke etter ansatt med ansatt-id");
        System.out.println("2. søke etter ansatt med brukernavn");
        System.out.println("3. liste ut alle ansatte");
        System.out.println("4. oppdatere en ansatt sin lønn eller stilling");
        System.out.println("5. legge inn en ny ansatt");
        System.out.println("6. legge inn en ny avdeling");
        System.out.println("7. oppdatere hvilken avdeling en ansatte jobber på");
        System.out.println("8. legge inn et nytt prosjekt");
        System.out.println("9. ingen av delene");
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
                System.out.println("Vennligst oppgi brukernavn til ansatte som du vil finne: ");
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
                String secondUserChoice = scanner.next();
                switch (secondUserChoice) {
                    case "lønn": {
                        System.out.println("Hva er den nye lønnen?");
                        int nyLonn = scanner.nextInt();
                        AnsattDAO ansattDAO = new AnsattDAO();
                        ansattDAO.updateAnsattLonn(id, nyLonn);
                        break;
                    }
                    case "stilling": {
                        System.out.println("Hva er den nye stillingen?: ");
                        String nyStilling = scanner.next();
                        AnsattDAO ansattDAO = new AnsattDAO();
                        ansattDAO.updateAnsattStilling(id, nyStilling);
                        break;
                    }
                }
                break;
            }
            case "5": {
                System.out.println("Vennligst oppgi informasjon angående den ansatte du vil sette inn");
                System.out.print("Brukernavn: ");
                String brukerNavn = scanner.next();
                System.out.print("Fornavn: ");
                String forNavn = scanner.next();
                System.out.print("Etternavn: ");
                String etterNavn = scanner.next();
                System.out.print("Ansettelse-dato: (yyyy-mm-d)");
                String dato = scanner.next();
                LocalDate localDate = LocalDate.parse(dato);
                System.out.println("Stilling: ");
                String stilling = scanner.next();
                System.out.println("Månedslønn: ");
                int maanedslonn = scanner.nextInt();
                System.out.println("Id til avdeling: ");
                int avdelingId = scanner.nextInt();
                AvdelingDAO avdelingDAO = new AvdelingDAO();
                Avdeling avdeling = avdelingDAO.finnAvdelingMedId(avdelingId);


                Ansatt a = new Ansatt(brukerNavn, forNavn, etterNavn, localDate, stilling, maanedslonn, avdeling);
                AnsattDAO ansattDAO = new AnsattDAO();
                ansattDAO.createAnsatt(a);
                break;
            }
            case "6": {
                System.out.println("Vennligst oppgi informasjon angående avdelingen du vil sette inn");
                System.out.println("navn: ");
                String avdelingNavn = scanner.next();
                System.out.println("AnsattId til sjef: ");
                int sjefId = scanner.nextInt();
                AnsattDAO ansattDAO = new AnsattDAO();
                Ansatt sjef =ansattDAO.finnAnsattMedId(sjefId);
                Avdeling a = new Avdeling(avdelingNavn, sjef);
                AvdelingDAO avdelingDAO = new AvdelingDAO();
                avdelingDAO.createAvdeling(a);
                break;
            }

            case "7": {
                System.out.println("Id til ansatt som du vil endre på: ");
                int ansattId = scanner.nextInt();
                System.out.println("Id til avdeling");
                int avdelingId = scanner.nextInt();
                AnsattDAO ansattDAO = new AnsattDAO();
                ansattDAO.updateAnsattAvdeling(ansattId, avdelingId);
                break;
            }
            case "8": {
                System.out.println("Vennligst oppgi informasjon angående prosjektet du skal legge til: ");
                System.out.println("navn: ");
                String prosjektNavn = scanner.next();
                System.out.println("beskrivelse: ");
                String prosjektBeskrivelse = scanner.next();
                Prosjekt p = new Prosjekt(prosjektNavn, prosjektBeskrivelse);
                ProsjektDAO prosjektDAO = new ProsjektDAO();
                prosjektDAO.createProsjekt(p);
            }
            case "9":
                break;
            default:
                System.out.println("Ugyldig");
        }
    }
}

