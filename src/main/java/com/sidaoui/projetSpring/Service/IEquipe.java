package com.sidaoui.projetSpring.Service;


import com.sidaoui.projetSpring.Entity.Equipe;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IEquipe {
    public Equipe saveEquipe(Equipe equipe);
    public List<Equipe> getAllEquipe();
    public ResponseEntity<Equipe>getEquipeById(Long id);
    public ResponseEntity<Equipe>updateEquipe(Long id,Equipe equipe);
    public ResponseEntity<Map<String,Boolean>> deleteEquipe(Long id);

}
