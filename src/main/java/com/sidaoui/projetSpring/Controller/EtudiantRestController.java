package com.sidaoui.projetSpring.Controller;


import com.sidaoui.projetSpring.Entity.Etudiant;
import com.sidaoui.projetSpring.Service.IEtudiantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/apiEtudiant")
@Api(tags = "Student Management", protocols = "http")

public class EtudiantRestController {

    @Autowired
    private IEtudiantService etudiantService;

    /***************************************Method To Save New Student****************/
    @PostMapping("/save")
    @ApiOperation(value = "Save a student")
    public Etudiant saveEtudiant(@RequestBody Etudiant e){

        return this.etudiantService.saveEtudiant(e);
    }
    /**************************************Method To Get All Student********************/
    @GetMapping("/getEtudiant")
    @ApiOperation(value = "retreive all student")
    public List<Etudiant> getEtudiant(){
        return this.etudiantService.getEtudiant();
    }
    /**************************************Method To Get Student By id **********************/
    @GetMapping("/getEtudiantById/{id}")
    @ApiOperation(value = "retreive a student by id")
    public ResponseEntity<Etudiant>getEtudiantById(@PathVariable("id")Long id){
      return etudiantService.getEtudiantById(id);
    }
    /**************************************Method To Update Student********************/
    @PutMapping("/updateEtudiant/{id}")
    @ApiOperation(value = "update a student")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable("id")Long id,@RequestBody Etudiant etudiant){
        return etudiantService.updateEtudiant(id,etudiant);
    }
    /**************************************Method To Delete Student********************/
    @DeleteMapping("/deleteEtudiant/{id}")
    @ApiOperation(value = "delete a student")
    public ResponseEntity<Map<String,Boolean>>deleteEtudiant(@PathVariable("id")Long id){
        return etudiantService.deleteEtudiant(id);
    }
    @PutMapping("/assignEtudiantToDepartment/{idEtudiant}/{idDepartment}")
    @ApiOperation(value = "assignStudentToDepartement")
    public void assignEtudiantToDepartment(@PathVariable("idEtudiant")long idEtudiant,@PathVariable("idDepartement") long idDepartment){
        assignEtudiantToDepartment(idEtudiant,idDepartment);
    }
    @PutMapping("/addAndAssignEtudiantToEquipeAndContract/{idContrat}/{idEquipe}")
    @ApiOperation(value = "addAndAssignEtudiantToEquipeAndContract")
    public Etudiant addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant e,@PathVariable("idContrat") long idContract,@PathVariable("idEquipe") long idEquipe) {
        return etudiantService.addAndAssignEtudiantToEquipeAndContract(e,idContract,idEquipe);
    }
    @GetMapping("/getEtudiantByNom/{nom}")
    @ApiOperation(value = "getStudentByName")
    public Etudiant getEtudiantByNom(@PathVariable("nom") String nom){
        return etudiantService.getEtudiantByNom(nom);
    }


    }
