package com.sidaoui.projetSpring.Service;


import com.sidaoui.projetSpring.Entity.Contrat;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IContratService {

    public Contrat saveContrat(Contrat contrat);
    public List<Contrat> getAllContrat();
    public ResponseEntity<Contrat> getContratById(Long id);
    public ResponseEntity<Map<String,Boolean>> deleteContrat(long id);
    public ResponseEntity<Contrat> updateContrat(long id,Contrat contrat);
    public Contrat affectContratToEtudiant(Contrat contrat, String nomE,String prenomE);


    }
