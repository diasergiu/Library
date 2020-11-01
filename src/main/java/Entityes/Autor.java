package Entityes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "autor")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "carteNavigator"})
@javax.persistence.SequenceGenerator(
        name="AUTOR_SEQ",
        sequenceName="AUTOR_SEQ",
        allocationSize = 1
)
public class Autor {

    @Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AUTOR_SEQ")
@Column(name = "id_autor")
    private int idAutor;
    @Column(name = "nume")
    @JsonProperty
    private String nume;
    @Column(name = "prenume")
    @JsonProperty
    private String prenume;
    @JsonProperty
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.MERGE
            }
            )
    @JoinTable(name = "carte_autor_mapping",
        joinColumns = @JoinColumn(name = "id_autor",
                        referencedColumnName = "id_autor"),
            inverseJoinColumns = @JoinColumn(name = "id_carte",
                                    referencedColumnName =  "id_carte"))
    private Set<Carte> carteNavigator;


    public Autor() {
        carteNavigator = new HashSet<Carte>();
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNume() { return nume; }

    public void setNume(String nameAutor) {
        this.nume = nameAutor;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public Set<Carte> getCarteNavigator() {
        return carteNavigator;
    }

    public void setCarteNavigator(Set<Carte> carteNavigator) {
        this.carteNavigator = carteNavigator;
    }

    public void addCarte(Carte carte){ this.carteNavigator.add(carte);}
}
