package com.sidaoui.projetSpring.Controller;


import com.sidaoui.projetSpring.Entity.Universite;
import com.sidaoui.projetSpring.Service.IUniversite;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/apiUniversite")
@Api(tags = "University Management")
public class UniversiteRestController {

    @Autowired
    private IUniversite universiteService;

    @PostMapping("/saveUniversite")
    public Universite saveUniversite(@RequestBody Universite universite){
        return universiteService.saveUniversite(universite);
    }
    @GetMapping("/getAllUniversite")
    public List<Universite> getAllUniversite(){
        return universiteService.getAllUniversite();
    }
    @GetMapping("/getUniversiteById/{id}")
    public ResponseEntity<Universite> getUniversiteById(@PathVariable("id")Long id){
        return universiteService.getUniversiteById(id);
    }
    @PutMapping("/updateUniversite/{id}")
    public ResponseEntity<Universite> updateUniversite(@PathVariable("id")Long id,@RequestBody Universite universite){
        return universiteService.updateUniversite(id,universite);
    }
    @DeleteMapping("/deleteUniversite/{id}")
    public ResponseEntity<Map<String,Boolean>>deleteUniversite(@PathVariable("id")Long id){
        return universiteService.deleteUniversite(id);
    }








}
