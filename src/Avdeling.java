import javax.persistence.*;

@Entity
@Table(schema = "oblig3")
public class Avdeling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int avdeling;
    private String navn;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sjef", referencedColumnName = "ansattId")
    private Ansatt sjef;

    public Avdeling(String navn, Ansatt sjef) {

        this.navn = navn;
        this.sjef = sjef;
    }

    public Avdeling() {

    }

    @Override
    public String toString() {
        return "Avdeling{" +
                "avdeling=" + avdeling +
                ", navn='" + navn + '\'' +
                ", sjef=" + sjef +
                '}';
    }
}
