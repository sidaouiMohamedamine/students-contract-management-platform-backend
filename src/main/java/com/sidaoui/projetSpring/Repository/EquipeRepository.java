package com.sidaoui.projetSpring.Repository;

import com.sidaoui.projetSpring.Entity.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe,Long> {

}
