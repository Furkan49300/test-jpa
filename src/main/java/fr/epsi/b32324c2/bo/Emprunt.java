package fr.epsi.b32324c2.bo;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="emprunt")
public class Emprunt {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="date_debut")
    private Date date_debut;
    @Column(name="date_fin")
    private Date date_fin;
    @Column(name="delai")
    private int delai;
    @Column(name="id_client")
    private int id_client;

    public Emprunt() {
    }

    public int getId() {
        return id;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public int getDelai() {
        return delai;
    }

    public int getId_client() {
        return id_client;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Emprunt{");
        sb.append("id=").append(id);
        sb.append(", date_debut=").append(date_debut);
        sb.append(", date_fin=").append(date_fin);
        sb.append(", delai=").append(delai);
        sb.append(", id_client=").append(id_client);
        sb.append('}');
        return sb.toString();
    }
}
