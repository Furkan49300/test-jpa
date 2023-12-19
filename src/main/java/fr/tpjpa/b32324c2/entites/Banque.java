package fr.tpjpa.b32324c2.entites;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="banque")
public class Banque {
    @Id
    @Column(name="id")
    @GeneratedValue
    private int id;
    @Column(name="nom")
    private String nom;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Banque{");
        sb.append("id=").append(id);
        sb.append(", nom='").append(nom).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @OneToMany(mappedBy="banque")
    private Set<Client> clients; // référence vers les chambres
    public Banque() {
        clients = new HashSet<Client>();
    }
}
