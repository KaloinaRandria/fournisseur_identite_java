package mg.working.fournisseur_identite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.working.fournisseur_identite.model.jeton.Jeton;
import mg.working.fournisseur_identite.repository.JetonRepository;

@Service
public class JetonService {
    @Autowired
    JetonRepository jetonRepository;

    public void insertJeton(Jeton jeton) {
        this.jetonRepository.save(jeton);
    }

    public Jeton getJetonById(int id) {
        return this.jetonRepository.findById(id).orElse(null);
    }

    public void deleteJeton(Jeton jeton) {
        this.jetonRepository.delete(jeton);
    }
}
