package com.sidaoui.projetSpring.Repository;


import com.sidaoui.projetSpring.Entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {

    @Query("SELECT e FROM Etudiant e WHERE e.nomE=?1 and e.prenomE=?2")
    Etudiant findEtudiantByNomEAndPrenomE(String nomE,String prenomE);
}
