package com.sidaoui.projetSpring.Controller;


import com.sidaoui.projetSpring.Entity.Etudiant;
import com.sidaoui.projetSpring.Service.IEtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/apiEtudiant")
public class EtudiantRestController {

    @Autowired
    private IEtudiantService etudiantService;

    /***************************************Method To Save New Student****************/
    @PostMapping("/save")
    public Etudiant saveEtudiant(@RequestBody Etudiant e){

        return this.etudiantService.saveEtudiant(e);
    }
    /**************************************Method To Get All Student********************/
    @GetMapping("/getEtudiant")
    public List<Etudiant> getEtudiant(){
        return this.etudiantService.getEtudiant();
    }
    /**************************************Method To Get Student By Id********************/
    @GetMapping("/getEtudiantById/{id}")
    public ResponseEntity<Etudiant>getEtudiantById(@PathVariable("id")Long id){
      return etudiantService.getEtudiantById(id);
    }
    /**************************************Method To Update Student********************/
    @PutMapping("/updateEtudiant/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable("id")Long id,@RequestBody Etudiant etudiant){
        return etudiantService.updateEtudiant(id,etudiant);
    }
    /**************************************Method To Delete Student********************/
    @DeleteMapping("/deleteEtudiant/{id}")
    public ResponseEntity<Map<String,Boolean>>deleteEtudiant(@PathVariable("id")Long id){
        return etudiantService.deleteEtudiant(id);
    }
    @PutMapping("/assignEtudiantToDepartment/{idEtudiant}/{idDepartment}")
    public void assignEtudiantToDepartment(@PathVariable("idEtudiant")long idEtudiant,@PathVariable("idDepartement") long idDepartment){
        assignEtudiantToDepartment(idEtudiant,idDepartment);
    }
    @PutMapping("/addAndAssignEtudiantToEquipeAndContract/{idContrat}/{idEquipe}")
    public Etudiant addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant e,@PathVariable("idContrat") long idContract,@PathVariable("idEquipe") long idEquipe) {
        return etudiantService.addAndAssignEtudiantToEquipeAndContract(e,idContract,idEquipe);
    }


    }
