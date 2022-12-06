package com.sidaoui.projetSpring.Service;


import com.sidaoui.projetSpring.Entity.Universite;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IUniversite {

        public Universite saveUniversite(Universite universite);
        public List<Universite> getAllUniversite();
        public ResponseEntity<Universite>getUniversiteById(Long id);
        public ResponseEntity<Universite>updateUniversite(Long id ,Universite universite);
        public ResponseEntity<Map<String,Boolean>> deleteUniversite(Long id);
        //public void assignUniversiteToDepartement(Long idUniversite, Long idDepartement);
}
