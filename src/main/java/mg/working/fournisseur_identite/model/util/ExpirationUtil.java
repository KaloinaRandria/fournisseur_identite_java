package mg.working.fournisseur_identite.model.util;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ExpirationUtil {
     @Column(name = "date_insertion", nullable = false)
    private LocalDateTime dateInsertion;

    @Column(name = "date_expiration", nullable = false)
    private LocalDateTime dateExpiration;

    @Column(name = "duree", nullable = false)
    private float duree; // Durée en heures

    public ExpirationUtil(float duree) {
        this.duree = duree;
        this.dateInsertion = LocalDateTime.now(); // Date et heure actuelles
        this.dateExpiration = calculerDateExpiration(); // Calculer la date d'expiration
    }

    private LocalDateTime calculerDateExpiration() {
        if (this.dateInsertion == null) {
            this.dateInsertion = LocalDateTime.now(); // Date actuelle si non définie
        }

        // Ajouter la durée en heures à la date d'insertion
        return this.dateInsertion.plusSeconds((long) (this.duree * 3600));
    }

    public void updateDateExpiration() {
        this.dateExpiration = calculerDateExpiration();
    }

}
