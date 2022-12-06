package com.sidaoui.projetSpring.Controller;


import com.sidaoui.projetSpring.Entity.Departement;
import com.sidaoui.projetSpring.Service.IDepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/apiDepartement")
public class DepartementRestController {

    @Autowired
    private IDepartementService departementService;

    @PostMapping("/saveDepartement")
    public Departement saveDepartement(@RequestBody Departement departement){
        return departementService.saveDepartement(departement);
    }
    @GetMapping("/getAllDeparement")
    public List<Departement> getAll(){
        return departementService.getDepartement();
    }
    @GetMapping("/getDepartementById/{id}")
    public ResponseEntity<Departement> getDepartementById(@PathVariable("id") Long id){
        return departementService.getDepartementById(id);
    }
    @PutMapping ("/updateDepartement/{id}")
    public ResponseEntity<Departement> updateDepartement(@PathVariable("id") Long id,@RequestBody Departement departement){
        return departementService.updateDepartement(id,departement);
    }
    @DeleteMapping("/deleteDepartement/{id}")
    public ResponseEntity<Map<String,Boolean>>deleteDepartement(@PathVariable("id") Long id){
        return departementService.deleteDepartement(id);
    }
    public List<Departement> retrieveDepartementsByUniversite(long idUniversite) {

        return departementService.retrieveDepartementsByUniversite(idUniversite);
    }




    }
