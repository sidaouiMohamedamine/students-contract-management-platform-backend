package com.sidaoui.projetSpring.Service;


import com.sidaoui.projetSpring.Entity.Departement;
import com.sidaoui.projetSpring.Entity.Universite;
import com.sidaoui.projetSpring.Exception.NotFoundException;
import com.sidaoui.projetSpring.Repository.DepartementRepository;
import com.sidaoui.projetSpring.Repository.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DepartementServiceImp implements IDepartementService {

    @Autowired
    private DepartementRepository departementRepository;
    @Autowired
    private UniversiteRepository universiteRepository;

    @Override
    public Departement saveDepartement(Departement departement) {
        return departementRepository.save(departement);
    }

    @Override
    public List<Departement> getDepartement() {
        return departementRepository.findAll();
    }

    @Override
    public ResponseEntity<Departement> getDepartementById(Long id) {
        Departement departement = departementRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Departement Not Found"));
        return ResponseEntity.ok(departement);
    }

    @Override
    public ResponseEntity<Departement> updateDepartement(Long id, Departement departement) {
        Departement newDepartement = departementRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Departement Not Found!!"));
        newDepartement.setNomDepart(departement.getNomDepart());
        newDepartement.setEtudiant(departement.getEtudiant());
        Departement depart = departementRepository.save(newDepartement);
        return ResponseEntity.ok(depart);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteDepartement(Long id) {
        Departement departement=departementRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Departement Not Found"));
        departementRepository.delete(departement);
        Map<String,Boolean> response=new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @Override
    public List<Departement> retrieveDepartementsByUniversite(long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        return universite.getDepartment();
    }

}