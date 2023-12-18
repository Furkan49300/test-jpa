package fr.tpjpa.b32324c2.entites;

import fr.tpjpa.b32324c2.entites.Compte;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="operation")
public class Operation {

    @Id
    @Column(name="id")
    private int id;
    @Column(name="date")
    private LocalDateTime date;
    @Column(name="montant")
    private double montant;
    @Column(name="motif")
    private String motif;

    public Operation() {
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Operation{");
        sb.append("date=").append(date);
        sb.append(", montant=").append(montant);
        sb.append(", motif='").append(motif).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @ManyToOne
    @JoinColumn(name="CPT_ID")
    private Compte compte;
}
