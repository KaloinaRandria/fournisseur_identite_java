package mg.working.fournisseur_identite.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mg.working.fournisseur_identite.model.jeton.JetonInscription;

@Repository
public interface JetonInscriptionRepository extends JpaRepository<JetonInscription , Integer>{
    @Query("SELECT ji FROM JetonInscription ji JOIN ji.jeton j WHERE j.jeton = :token")
    JetonInscription findByToken(@Param("token") String token);

    default void deleteByIdIfExists(Integer id) {
        findById(id).ifPresent(this::delete);
    }
}
