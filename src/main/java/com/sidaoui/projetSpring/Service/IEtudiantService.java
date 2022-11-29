package com.sidaoui.projetSpring.Service;

import com.sidaoui.projetSpring.Entity.Etudiant;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IEtudiantService {

    public Etudiant saveEtudiant(Etudiant e);
    public List<Etudiant> getEtudiant();
    public ResponseEntity<Etudiant> getEtudiantById(Long id);
    public ResponseEntity<Etudiant> updateEtudiant(Long id, Etudiant etudiant);
    public ResponseEntity<Map<String,Boolean>> deleteEtudiant(Long id);
}
