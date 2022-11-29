package com.sidaoui.projetSpring.Controller;


import com.sidaoui.projetSpring.Entity.DetailEquipe;
import com.sidaoui.projetSpring.Service.IDetailEquipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/apiDetailEquipe")
public class DetailEquipeRestController {

    @Autowired
    private IDetailEquipe detailEquipeService;

    @PostMapping("/saveDetailEquipe")
    public DetailEquipe saveDetailEquipe(@RequestBody DetailEquipe detailEquipe){
        return detailEquipeService.saveDetailEquipe(detailEquipe);
    }
    @GetMapping("/getAllDetailEquipe")
    public List<DetailEquipe> getAllDetailEquipe(){
        return detailEquipeService.getAllDetailEquipe();
    }
    @GetMapping("/getDetailEquipeById/{id}")
    public ResponseEntity<DetailEquipe>getDetailEquipeById(@PathVariable("id")Long id){
        return detailEquipeService.getDetailEquipeById(id);
    }
    @PutMapping("/updateDetailEquipe/{id}")
    public ResponseEntity<DetailEquipe>updateDetailEquipe(@PathVariable("id")Long id,@RequestBody DetailEquipe detailEquipe){
        return detailEquipeService.updateDetailEquipe(id,detailEquipe);
    }
    @DeleteMapping("/deleteDetailEquipe/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteDetailEquipe(@PathVariable("id")Long id){
        return detailEquipeService.deleteDetailEquipe(id);
    }




}
