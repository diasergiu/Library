package Entityes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "carteNavigator"})
public class Editura {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_editura")
    private int idEditura;
    @Column(name = "denumire_editura", unique = true)
    @JsonProperty
    private String denumireEditura;
    @JsonProperty

    @OneToMany(mappedBy="edituraNavigator",
            fetch = FetchType.LAZY,
            orphanRemoval = false)
    private Set<Carte> carteNavigator;

    public int getIdEditura() {
        return idEditura;
    }

    public void setIdEditura(int idEditura) {
        this.idEditura = idEditura;
    }

    public String getDenumireEditura() {
        return denumireEditura;
    }

    public void setDenumireEditura(String denumireEditura) {
        this.denumireEditura = denumireEditura;
    }
}
