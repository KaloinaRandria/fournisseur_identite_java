package mg.working.fournisseur_identite.model.jeton;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import mg.working.fournisseur_identite.model.util.ExpirationUtil;
import mg.working.fournisseur_identite.model.util.TokenGeneratorUtil;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "jeton")
@SequenceGenerator(
    name = "s_jeton",
    sequenceName = "s_jeton",
    allocationSize = 1
)
public class Jeton {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_jeton") @Column(name = "id_jeton")
    int id;
    String jeton;
    @Embedded
    ExpirationUtil expirationUtil;
    @Transient
    int defaultDureeJeton;

    public Jeton() {
        this.expirationUtil = new ExpirationUtil(this.defaultDureeJeton);
        this.jeton = TokenGeneratorUtil.generateToken();
    }

    public boolean isExpired() {
        return this.expirationUtil.getDateExpiration().isBefore(LocalDateTime.now());
    }
}
