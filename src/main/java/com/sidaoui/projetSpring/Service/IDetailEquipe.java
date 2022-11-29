package com.sidaoui.projetSpring.Service;

import com.sidaoui.projetSpring.Entity.DetailEquipe;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;


public interface IDetailEquipe {

    public DetailEquipe saveDetailEquipe(DetailEquipe detailEquipe);
    public List<DetailEquipe> getAllDetailEquipe();
    public ResponseEntity<DetailEquipe>getDetailEquipeById(Long id);
    public ResponseEntity<DetailEquipe> updateDetailEquipe(Long id,DetailEquipe detailEquipe);
    public ResponseEntity<Map<String,Boolean>> deleteDetailEquipe(Long id);



}
