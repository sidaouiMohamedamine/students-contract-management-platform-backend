package com.sidaoui.projetSpring.Service;


import com.sidaoui.projetSpring.Entity.Equipe;
import com.sidaoui.projetSpring.Repository.EquipeRepository;
import com.sidaoui.projetSpring.Repository.Exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EquipeServiceImp implements IEquipe {

    @Autowired
    private EquipeRepository equipeRepository;

    @Override
    public Equipe saveEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    @Override
    public List<Equipe> getAllEquipe() {
        return equipeRepository.findAll();
    }

    @Override
    public ResponseEntity<Equipe> getEquipeById(Long id) {
        Equipe equipe=equipeRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Equipe Not Found"));
        return ResponseEntity.ok(equipe);
    }

    @Override
    public ResponseEntity<Equipe> updateEquipe(Long id, Equipe equipe) {
        Equipe newEquipe=equipeRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Equipe Not Found"));
        newEquipe.setNomEquipe(equipe.getNomEquipe());
        newEquipe.setNiveau(equipe.getNiveau());
        newEquipe.setEtudiant(equipe.getEtudiant());
        newEquipe.setDetailEquipe(equipe.getDetailEquipe());
        Equipe eq=equipeRepository.save(newEquipe);
        return ResponseEntity.ok(eq);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteEquipe(Long id) {
        Equipe equipe=equipeRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Equipe Not Found"));
        equipeRepository.delete(equipe);
        Map<String,Boolean> response=new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
