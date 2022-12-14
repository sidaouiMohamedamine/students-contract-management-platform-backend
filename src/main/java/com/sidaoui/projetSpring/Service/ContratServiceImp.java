package com.sidaoui.projetSpring.Service;


import com.sidaoui.projetSpring.Entity.Contrat;
import com.sidaoui.projetSpring.Entity.Etudiant;
import com.sidaoui.projetSpring.Repository.EtudiantRepository;
import com.sidaoui.projetSpring.Exception.NotFoundException;
import com.sidaoui.projetSpring.Repository.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ContratServiceImp implements IContratService{
    @Autowired
    private ContratRepository contratRepository;
    @Autowired
    private EtudiantRepository etudiantRepository;

    /****************************Method to save new contrat*****************/
    @Override
    public Contrat saveContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }
    /**************************Method to get all contract********************/
    //the scheduler service allows to display the list of contracts every 15th second
    @Scheduled(cron="*/15 * * * * * ")
    @Override
    public List<Contrat> getAllContrat() {
        return contratRepository.findAll();
    }
    /*************************Method to get contract by id******************/
    @Override
    public ResponseEntity<Contrat> getContratById(Long id) {
        Contrat contrat=contratRepository.findById(id)
                .orElseThrow(()->new NotFoundException("We did not found the user"));
        return ResponseEntity.ok(contrat);
    }
    /*************Method to delete contract********************/
    @Override
    public ResponseEntity<Map<String, Boolean>> deleteContrat(long id) {
        Contrat contrat=contratRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Contract Not Found"));
        contratRepository.delete(contrat);
        Map<String,Boolean> response=new HashMap<>();
        response.put("Contract deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
    /*************Method to update contract********************/

    @Override
    public ResponseEntity<Contrat> updateContrat(long id, Contrat contrat) {
        Contrat newContrat=contratRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Not Found"));
        newContrat.setDateDebutContrat(contrat.getDateDebutContrat());
        newContrat.setDateFinContrat(contrat.getDateFinContrat());
        newContrat.setSpecialite(contrat.getSpecialite());
        newContrat.setArchive(contrat.getArchive());
        newContrat.setEtudiant(contrat.getEtudiant());
        Contrat updatedContrat =contratRepository.save(newContrat);
        return ResponseEntity.ok(updatedContrat);
    }
    /***********************Affecter Contrat to Etudiant*****************************/
    @Override
    public Contrat affectContratToEtudiant(Contrat contrat, String nomE,String prenomE){
        Contrat newContrat = contratRepository.findById(2L).orElseThrow(()->new NotFoundException("Not Found"));
        Etudiant etudiant = etudiantRepository.findEtudiantByNomEAndPrenomE(nomE,prenomE);
        boolean b = etudiant.getContrat().size() <= 5;
        {
            contrat.setEtudiant(etudiant);
            contratRepository.save(contrat);
        }
        return contrat;
    }


}
