package mg.working.fournisseur_identite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.working.fournisseur_identite.model.jeton.JetonInscription;
import mg.working.fournisseur_identite.repository.JetonInscriptionRepository;

@Service
public class JetonInscriptionService {
    @Autowired
    JetonInscriptionRepository jetonInscriptionRepository;

    public void insertJetonInscription(JetonInscription jetonInscription) {
        this.jetonInscriptionRepository.save(jetonInscription);
    }

     // Méthode pour rechercher un jeton d'inscription par son token
     public JetonInscription findByToken(String token) {
        return jetonInscriptionRepository.findByToken(token);
    }

    // Méthode pour supprimer un jeton d'inscription par son ID
    public void deleteById(int id) {
        jetonInscriptionRepository.deleteByIdIfExists(id);
    }
    
}
