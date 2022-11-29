package com.sidaoui.projetSpring.Repository;


import com.sidaoui.projetSpring.Entity.DetailEquipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailEquipeRepository extends JpaRepository<DetailEquipe,Long> {
}
