package fr.tpjpa.b32324c2.entites;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse {
    private int numero;
    private String rue;
    private int codePostal;
    private String ville;
}
