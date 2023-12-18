package fr.tpjpa.b32324c2.entites;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="client")
public class Client {
    @Id
    @Column(name="id")
    private int id;
    @Column(name="nom")
    private String nom;
    @Column(name="prenom")
    private String prenom;
    @Column(name="dateNaissance")
    private LocalDate dateNaissance;

    @Embedded
    private Adresse adresse;

    public Client() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Client{");
        sb.append("nom='").append(nom).append('\'');
        sb.append(", prenom='").append(prenom).append('\'');
        sb.append(", dateNaissance=").append(dateNaissance);
        sb.append('}');
        return sb.toString();
    }

    @ManyToMany
    @JoinTable(name="CLI_CPT",
            joinColumns= @JoinColumn(name="ID_CLI", referencedColumnName="ID"),
            inverseJoinColumns= @JoinColumn(name="ID_CPT", referencedColumnName="ID")
    )
    private Set<Compte> comptes;

    @ManyToOne
    @JoinColumn(name="BANK_ID")
    private Banque banque;

}
