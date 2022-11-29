package com.sidaoui.projetSpring.Service;


import com.sidaoui.projetSpring.Entity.Departement;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IDepartementService {
    public Departement saveDepartement(Departement departement);
    public List<Departement> getDepartement();
    public ResponseEntity<Departement> getDepartementById(Long id);
    public ResponseEntity<Departement> updateDepartement(Long id, Departement departement);
    public ResponseEntity<Map<String,Boolean>> deleteDepartement(Long id);
}
