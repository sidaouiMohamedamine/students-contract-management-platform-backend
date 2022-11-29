package com.sidaoui.projetSpring.Repository;


import com.sidaoui.projetSpring.Entity.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversiteRepository extends JpaRepository<Universite,Long> {
}
