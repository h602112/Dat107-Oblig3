import javax.persistence.*;

@Entity
@Table(schema = "oblig3")
public class Avdeling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int avdeling;
    private String navn;

    @ManyToOne
    @JoinColumn(name = "sjef", referencedColumnName = "ansattID")
    private Ansatt ansatt;

}
