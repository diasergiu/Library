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
public class Autor {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
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
                    CascadeType.PERSIST,
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

    public String getNameAutor() { return nume; }

    public void setNameAutor(String nameAutor) {
        this.nume = nameAutor;
    }

    public String getPrenumeAutor() {
        return prenume;
    }

    public void setPrenumeAutor(String prenumeAutor) {
        this.prenume = prenumeAutor;
    }

    public Set<Carte> getCarteNavigator() {
        return carteNavigator;
    }

    public void setCarteNavigator(Set<Carte> carteNavigator) {
        this.carteNavigator = carteNavigator;
    }

    public void addCarte(Carte carte){ this.carteNavigator.add(carte);}
}