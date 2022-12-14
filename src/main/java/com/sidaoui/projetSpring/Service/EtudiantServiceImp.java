package com.sidaoui.projetSpring.Service;


import com.sidaoui.projetSpring.Entity.Contrat;
import com.sidaoui.projetSpring.Entity.Departement;
import com.sidaoui.projetSpring.Entity.Equipe;
import com.sidaoui.projetSpring.Entity.Etudiant;
import com.sidaoui.projetSpring.Repository.ContratRepository;
import com.sidaoui.projetSpring.Repository.DepartementRepository;
import com.sidaoui.projetSpring.Repository.EquipeRepository;
import com.sidaoui.projetSpring.Repository.EtudiantRepository;
import com.sidaoui.projetSpring.Exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EtudiantServiceImp implements IEtudiantService{
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private ContratRepository contratRepository;
    @Autowired
    private EquipeRepository equipeRepository;
    @Autowired
    private DepartementRepository departementRepository;

    @Override
    public Etudiant saveEtudiant(Etudiant e) {
       return this.etudiantRepository.save(e);
    }
    //the scheduling service allows to display the list of students every 15th second of a minute
    @Scheduled(cron="15 * * * * * ")
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
    public List<Etudiant> getEtudiantByNom(String nom) {
        List<Etudiant> etudiant=etudiantRepository.findEtudiantByNomE(nom);
        return etudiant;
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
        /************************A vérifier cette méthode **/
    @Override
    @Transactional
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, long idContrat, long idEquipe) {
        Contrat contrat=contratRepository.findById(idContrat)
                .orElseThrow(()->new NotFoundException("Contrat Not Found"));
        Equipe equipe=equipeRepository.findById(idEquipe)
                .orElseThrow(()->new NotFoundException("Equipe Not Found"));
        equipe.getEtudiant().add(e);
        contrat.setEtudiant(e);
        return etudiantRepository.save(e);

    }

    @Override
    public List<Etudiant> getEtudiantsByDepartement(Integer idDepartement) {
        return null;
    }

    /**************************Assign un etudiant to departement***************/
    @Override
    public void assignEtudiantToDepartment(long idEtudiant, long idDepartment) {
        Etudiant etudiant = this.etudiantRepository.findById(idEtudiant).orElse(null);
        Departement departement = this.departementRepository.findById(idDepartment).orElse(null);
        etudiant.setDepartement(departement);
        etudiantRepository.save(etudiant);
    }
    /*******************Get Etudiant By departement*******************/
    @Override
    public List<Etudiant> getEtudiantsByDepartement(long idDepartement) {
        Departement departement = departementRepository.findById(idDepartement).orElse(null);
        List<Etudiant> etudiants = departement.getEtudiant();
        return etudiants;

    }


}
