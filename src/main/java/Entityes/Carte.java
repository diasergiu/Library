package Entityes;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
@Entity
@javax.persistence.SequenceGenerator(
        name="CARTE_SEQ",
        sequenceName="CARTE_SEQ",
        allocationSize = 1
)
public class Carte {

    @Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CARTE_SEQ")
    @Column(name = "id_carte")
    private int idCarte;
    @Column(name = "titlu")
    @JsonProperty
    private String titlu;
    @Column(name = "ISBN")
    @JsonProperty
    private String ISBN;
    @Column(name = "an_publicatie")
    @JsonProperty
    private Date anPublicatie;
    @JsonProperty
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
            CascadeType.MERGE,
            CascadeType.MERGE
    })
    private Set<Autor> autori;

    @JsonProperty
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_editura")
    private Editura editura;

    public int getIdCarte() {
        return idCarte;
    }

    public void setIdCarte(int idCarte) {
        this.idCarte = idCarte;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Date getAnPublicatie() {
        return anPublicatie;
    }

    public void setAnPublicatie(Date     anPublicatie) {
        this.anPublicatie = anPublicatie;
    }

    public Set<Autor> getAutori() {
        return autori;
    }

    public void setAutori(Set<Autor> autori) {
        this.autori = autori;
    }

    public Editura getEditura() {
        return editura;
    }

    public void setEditura(Editura editura) {
        this.editura = editura;
    }
}
