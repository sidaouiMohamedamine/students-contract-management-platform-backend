package com.sidaoui.projetSpring.Controller;


import com.sidaoui.projetSpring.Entity.Contrat;
import com.sidaoui.projetSpring.Service.IContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/apiContrat")
public class ContratRestController {
    @Autowired
    private IContratService contratService;

    /****************************Method to save new contrat*****************/
    @PostMapping("/saveContrat")
    public Contrat saveContrat(@RequestBody Contrat contrat){
        return contratService.saveContrat(contrat);
    }
    /**************************Method to get all contract********************/
    @GetMapping("/getAllContrat")
    public List<Contrat> getAllContrat(){
        return contratService.getAllContrat();
    }
    /*************************Method to get contract by id******************/
    @GetMapping("/getContrat/{id}")
    public ResponseEntity<Contrat> getContratById(@PathVariable("id") Long id){
       return  contratService.getContratById(id);
    }
    /*************************************Method to Update contrat********************/
    @PutMapping("/updateContrat/{id}")
    public ResponseEntity<Contrat>updateContrat(@PathVariable("id")Long id ,@RequestBody Contrat contrat){
        return contratService.updateContrat(id,contrat);
    }
    /*************Method to delete contract********************/
    @DeleteMapping("/deleteContrat/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteContrat(@PathVariable("id") Long id){
        return contratService.deleteContrat(id);
    }
    /**********************AffecteContratToEtudiant**********************************************/
    @PutMapping("/affectContratToEtudiant/{nomE}/{prenomE}")
    public Contrat affectContratToEtudiant(@RequestBody Contrat contrat,@PathVariable("nomE") String nomE,@PathVariable("prenomE") String prenomE){
        return  contratService.affectContratToEtudiant(contrat,nomE,prenomE);
    }



}
