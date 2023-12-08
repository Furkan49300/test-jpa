package fr.epsi.b32324c2;

import fr.epsi.b32324c2.bo.Livre;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-essai");
        System.out.println(emf);

        EntityManager em = emf.createEntityManager();
        Livre liv = em.find(Livre.class, 5L);

        if (liv != null) {
            System.out.println(liv);
        }
        em.close();

    }
}
