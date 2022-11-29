package com.sidaoui.projetSpring.Service;


import com.sidaoui.projetSpring.Entity.Etudiant;
import com.sidaoui.projetSpring.Repository.EtudiantRepository;
import com.sidaoui.projetSpring.Repository.Exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EtudiantServiceImp implements IEtudiantService{
    @Autowired
    private EtudiantRepository etudiantRepository;

    @Override
    public Etudiant saveEtudiant(Etudiant e) {
       return this.etudiantRepository.save(e);
    }

    @Override
    public List<Etudiant> getEtudiant() {
        return this.etudiantRepository.findAll();
    }

    @Override
    public ResponseEntity<Etudiant> getEtudiantById(Long id) {
        Etudiant etudiant=etudiantRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Etudiant Not Found"));
        return ResponseEntity.ok(etudiant);
    }

    @Override
    public ResponseEntity<Etudiant> updateEtudiant(Long id, Etudiant etudiant) {
        Etudiant newEtudiant=etudiantRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Etudiant Not Found"));
        newEtudiant.setNomE(etudiant.getNomE());
        newEtudiant.setPrenomE(etudiant.getPrenomE());
        newEtudiant.setOption(etudiant.getOption());
        newEtudiant.setContrat(etudiant.getContrat());
        newEtudiant.setDepartement(etudiant.getDepartement());
        newEtudiant.setEquipe(etudiant.getEquipe());
        Etudiant etu=etudiantRepository.save(newEtudiant);
        return ResponseEntity.ok(etu);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteEtudiant(Long id) {
        Etudiant etudiant=etudiantRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Etudiant Not Found"));
        etudiantRepository.delete(etudiant);
        Map<String,Boolean> response=new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
