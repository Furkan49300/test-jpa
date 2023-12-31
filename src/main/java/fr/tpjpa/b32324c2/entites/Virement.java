package fr.tpjpa.b32324c2.entites;

import javax.persistence.Entity;

@Entity
public class Virement extends Operation {

    private String beneficiaire;

    public Virement() {
    }

    public String getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Virement{");
        sb.append("beneficiaire='").append(beneficiaire).append('\'');
        sb.append('}');
        return sb.toString();
    }
}