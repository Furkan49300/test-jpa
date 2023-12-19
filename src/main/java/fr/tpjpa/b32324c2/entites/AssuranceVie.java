package fr.tpjpa.b32324c2.entites;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class AssuranceVie extends Compte {

    private LocalDate dateFin;
    private Double taux;

    public AssuranceVie() {
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AssuranceVie{");
        sb.append("dateFin=").append(dateFin);
        sb.append(", taux=").append(taux);
        sb.append('}');
        return sb.toString();
    }
}
