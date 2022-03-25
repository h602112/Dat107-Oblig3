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

    @Override
    public String toString() {
        return "Avdeling{" +
                "avdeling=" + avdeling +
                ", navn='" + navn + '\'' +
                ", sjef=" + sjef +
                '}';
    }
}
