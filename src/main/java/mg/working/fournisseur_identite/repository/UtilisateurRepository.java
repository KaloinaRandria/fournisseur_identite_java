package mg.working.fournisseur_identite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mg.working.fournisseur_identite.model.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur , Integer>{
    
}
