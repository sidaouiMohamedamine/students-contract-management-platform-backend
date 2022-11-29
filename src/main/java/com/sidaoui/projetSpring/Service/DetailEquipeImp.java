package com.sidaoui.projetSpring.Service;


import com.sidaoui.projetSpring.Entity.DetailEquipe;
import com.sidaoui.projetSpring.Repository.DetailEquipeRepository;
import com.sidaoui.projetSpring.Repository.Exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DetailEquipeImp implements IDetailEquipe{
    @Autowired
    private DetailEquipeRepository detailEquipeRepository;
    @Override
    public DetailEquipe saveDetailEquipe(DetailEquipe detailEquipe) {
        return detailEquipeRepository.save(detailEquipe);
    }

    @Override
    public List<DetailEquipe> getAllDetailEquipe() {
        return detailEquipeRepository.findAll();
    }

    @Override
    public ResponseEntity<DetailEquipe> getDetailEquipeById(Long id) {
        DetailEquipe detailEquipe=detailEquipeRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Detail Equipe Not Found!!"));
        return ResponseEntity.ok(detailEquipe);
    }

    @Override
    public ResponseEntity<DetailEquipe> updateDetailEquipe(Long id, DetailEquipe detailEquipe) {
        DetailEquipe newDetailEquipe=detailEquipeRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Detail Equipe Not Found!!"));
        newDetailEquipe.setThematique(detailEquipe.getThematique());
        newDetailEquipe.setEquipe(detailEquipe.getEquipe());
        DetailEquipe dEquipe=detailEquipeRepository.save(newDetailEquipe);
        return  ResponseEntity.ok(dEquipe);

    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteDetailEquipe(Long id) {
        DetailEquipe detailEquipe=detailEquipeRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Detail Equipe Not Found"));
        detailEquipeRepository.delete(detailEquipe);
        Map<String,Boolean> response=new HashMap<>();
        response.put("Deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
