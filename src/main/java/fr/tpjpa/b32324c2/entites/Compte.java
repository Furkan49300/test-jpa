package fr.tpjpa.b32324c2.entites;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="compte")
public class Compte {
    @Id
    @Column(name="id")
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Compte{");
        sb.append("numero='").append(numero).append('\'');
        sb.append(", solde=").append(solde);
        sb.append('}');
        return sb.toString();
    }

    @ManyToMany(mappedBy="comptes")
    private Set<Client> clients;
    @OneToMany(mappedBy="compte")
    private Set<Operation> operations;
}

