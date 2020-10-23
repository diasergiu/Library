package Entityes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
@Entity
public class Carte {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
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
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private Set<Autor> autorNavigator;
    @JsonProperty
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_editura")
    private Editura edituraNavigator;

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

    public Set<Autor> getAutorNavigator() {
        return autorNavigator;
    }

    public void setAutorNavigator(Set<Autor> autorNavigator) {
        this.autorNavigator = autorNavigator;
    }

    public Editura getEdituraNavigator() {
        return edituraNavigator;
    }

    public void setEdituraNavigator(Editura edituraNavigator) {
        this.edituraNavigator = edituraNavigator;
    }
}
