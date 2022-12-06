package com.sidaoui.projetSpring.Service;


import com.sidaoui.projetSpring.Entity.Universite;
import com.sidaoui.projetSpring.Repository.DepartementRepository;
import com.sidaoui.projetSpring.Repository.Exception.NotFoundException;
import com.sidaoui.projetSpring.Repository.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UniversiteServiceImp implements IUniversite{

    @Autowired
    private UniversiteRepository universiteRepository;
    @Autowired
    private DepartementRepository departementRepository;
    @Override
    public Universite saveUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public List<Universite> getAllUniversite() {
        return universiteRepository.findAll();
    }

    @Override
    public ResponseEntity<Universite> getUniversiteById(Long id) {
        Universite universite=universiteRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Universite Not Found"));
        return ResponseEntity.ok(universite);
    }

    @Override
    public ResponseEntity<Universite> updateUniversite(Long id, Universite universite) {
        Universite newUniversite=universiteRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Universite Not Found"));
        newUniversite.setNomUniv(universite.getNomUniv());
        newUniversite.setDepartment(universite.getDepartment());
        Universite uni=universiteRepository.save(newUniversite);
        return ResponseEntity.ok(uni);

    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteUniversite(Long id) {
        Universite universite=universiteRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Universite Not Found"));
        universiteRepository.delete(universite);
        Map<String,Boolean> response=new HashMap<>();
        response.put("Deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    /*
    public void assignUniversiteToDepartement(Long idUniversite,Long idDepartement){
        Universite universite=universiteRepository.findById(idUniversite)
                .orElseThrow(()->new NotFoundException("Not Found university"));
        Departement departement=departementRepository.findById(idDepartement)
                .orElseThrow(()->new NotFoundException("Not Found"));
        universite.setDepartment((List<Departement>) departement);
        universiteRepository.save(departement);

    } */


      }

