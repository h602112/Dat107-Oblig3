import javax.persistence.*;

@Entity
@Table(schema = "oblig3")
public class Prosjekt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prosjektID;
    private String navn;
    private String beskrivelse;

    @ManyToOne
    @JoinColumn(name = "ansatte", referencedColumnName = "ansattID")
    private Ansatt ansatt;

}
