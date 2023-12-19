package fr.tpjpa.b32324c2;

import fr.tpjpa.b32324c2.entites.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        // Création d'un compte
        Compte cp = new Compte();
        cp.setNumero("1");
        cp.setSolde(25);

        // Création d'adresses pour les clients
        Adresse adresseC1 = new Adresse();
        adresseC1.setNumero(123);
        adresseC1.setRue("Rue de la Paix");
        adresseC1.setCodePostal(75001);
        adresseC1.setVille("Paris");

        Adresse adresseC2 = new Adresse();
        adresseC2.setNumero(456);
        adresseC2.setRue("Avenue des Champs-Élysées");
        adresseC2.setCodePostal(75002);
        adresseC2.setVille("Paris");

        // Création de clients
        Client c1 = new Client();
        c1.setNom("jeremy");
        c1.setPrenom("thomas");
        c1.setDateNaissance(LocalDate.parse("2017-12-03"));
        c1.setAdresse(adresseC1);

        Client c2 = new Client();
        c2.setNom("clara");
        c2.setPrenom("zidane");
        c2.setDateNaissance(LocalDate.parse("2017-12-03"));
        c2.setAdresse(adresseC2);

        // Création d'une assurance vie
        AssuranceVie assuranceVie = new AssuranceVie();
        assuranceVie.setDateFin(LocalDate.parse("2030-12-31"));
        assuranceVie.setTaux(0.03);

        // Création d'un compte livret A
        LivretA livretA = new LivretA();
        livretA.setTaux(0.02);

        // Création d'une opération
        Operation operation = new Operation();
        operation.setDate(LocalDateTime.parse("2025-05-15T00:00:00"));
        operation.setMontant(640);
        operation.setMotif("cadeau");
        operation.setCompte(cp);

        // Création d'un virement
        Virement virement = new Virement();
        virement.setDate(LocalDateTime.parse("2025-05-15T00:00:00"));
        virement.setMontant(640);
        virement.setMotif("cadeau");
        virement.setBeneficiaire("maxime");
        virement.setCompte(cp);

        // Persistez les entités dans l'ordre approprié
        em.persist(c1);
        em.persist(c2);
        em.persist(cp);
        em.persist(assuranceVie);
        em.persist(livretA);
        em.persist(operation);
        em.persist(virement);

        // Associez les entités
        c1.getComptes().add(assuranceVie);
        c1.getComptes().add(livretA);

        cp.getClients().add(c1);
        cp.getClients().add(c2);

        c1.getComptes().add(cp);
        c2.getComptes().add(cp);

        cp.getOperations().add(operation);
        cp.getOperations().add(virement);

        transaction.commit();

        em.close();
        emf.close();
    }
}
