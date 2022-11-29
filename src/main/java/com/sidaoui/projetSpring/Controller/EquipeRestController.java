package com.sidaoui.projetSpring.Controller;


import com.sidaoui.projetSpring.Entity.Equipe;
import com.sidaoui.projetSpring.Service.IEquipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/apiEquipe")
public class EquipeRestController {

        @Autowired
        private IEquipe equipeService;

        @PostMapping("/saveEquipe")
        public Equipe saveEquipe(@RequestBody Equipe equipe){
            return  equipeService.saveEquipe(equipe);
        }
        @GetMapping("/getAllEquipe")
        public List<Equipe> getAllquipe(){
            return equipeService.getAllEquipe();
        }
        @GetMapping("/getEquipeById/{id}")
        public ResponseEntity<Equipe>getEquipeById(@PathVariable Long id){
            return equipeService.getEquipeById(id);
        }
        @PutMapping("/updateEquipe/{id}")
        public ResponseEntity<Equipe> updateEquipe(@PathVariable("id")Long id ,@RequestBody Equipe equipe){
            return equipeService.updateEquipe(id,equipe);
        }
        @DeleteMapping("/deleteEquipe/{id}")
        public ResponseEntity<Map<String,Boolean>> deleteEquipe(@PathVariable("id")Long id){
            return equipeService.deleteEquipe(id);
        }



}
