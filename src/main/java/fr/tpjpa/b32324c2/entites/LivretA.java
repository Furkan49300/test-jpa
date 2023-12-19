package fr.tpjpa.b32324c2.entites;

import javax.persistence.Entity;

@Entity
public class LivretA extends Compte {

    private double taux;

    public LivretA() {
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LivretA{");
        sb.append("taux=").append(taux);
        sb.append('}');
        return sb.toString();
    }
}