package mg.working.fournisseur_identite.model.jeton;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jeton_inscription")
@SequenceGenerator(
    name = "s_jeton_inscription",
    sequenceName = "s_jeton_inscription",
    allocationSize = 1
)
public class JetonInscription {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_jeton_inscription") @Column(name = "id_jeton_inscription")
    int id;
    String mail;
    String mdp;
    String nom;
    LocalDate dateNaissance;
    @ManyToOne @JoinColumn(name = "id_jeton" , referencedColumnName = "id_jeton")
    @Column(unique = true)
    Jeton jeton;

     // Constructeur personnalisé
    public JetonInscription(String mail, String mdp, String nom, LocalDate dateNaissance, Jeton jeton) {
        this.mail = mail;
        this.mdp = mdp;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.jeton = jeton;
    }

    // Méthode pour vérifier si le jeton est expiré
    public boolean isExpired() {
        return jeton.getExpirationUtil().getDateExpiration().isBefore(LocalDateTime.now());
    }

}
