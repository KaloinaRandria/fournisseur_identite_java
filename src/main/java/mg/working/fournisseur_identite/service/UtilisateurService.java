package mg.working.fournisseur_identite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.working.fournisseur_identite.model.Utilisateur;
import mg.working.fournisseur_identite.repository.UtilisateurRepository;

@Service
public class UtilisateurService {
    @Autowired
    UtilisateurRepository utilisateurRepository;

    public void insertUtilisateur(Utilisateur utilisateur) {
        this.utilisateurRepository.save(utilisateur);
    }
}
