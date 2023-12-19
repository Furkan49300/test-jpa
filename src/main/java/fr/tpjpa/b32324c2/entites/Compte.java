package fr.tpjpa.b32324c2.entites;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="compte")
@Inheritance(strategy = InheritanceType.JOINED)
public class Compte {
    @Id
    @Column(name="id")
    @GeneratedValue
    private int id;
    @Column(name="numero")
    private String numero;
    @Column(name="solde")
    private double solde;

    public Compte() {
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }
    @ManyToMany
    @JoinTable(name="CLI_CPT",
            joinColumns= @JoinColumn(name="ID_CPT", referencedColumnName="ID"),
            inverseJoinColumns= @JoinColumn(name="ID_CLI", referencedColumnName="ID")
    )
    private Set<Client> clients = new HashSet<>();
    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    @OneToMany(mappedBy = "compte")
    private List<Operation> operations = new ArrayList<>();

    // Assurez-vous d'ajouter les méthodes getter et setter pour la liste operations
    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Compte{");
        sb.append("numero='").append(numero).append('\'');
        sb.append(", solde=").append(solde);
        sb.append('}');
        return sb.toString();
    }



}

