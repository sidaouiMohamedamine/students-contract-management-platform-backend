package com.sidaoui.projetSpring.Repository;

import com.sidaoui.projetSpring.Entity.Etudiant;
import com.sidaoui.projetSpring.Entity.Option;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class EtudiantRepositoryTest {


        @Autowired
        private EtudiantRepository etudiantRepository;


    @Test
   public  void findEtudiantByNomE() {

        // Given
        String nomE = "Sidaoui";
        Etudiant etudiant = new Etudiant(1L,nomE,"Mohamed Amine", Option.SE,null,null,null);
        Etudiant  savedStudent= etudiantRepository.save(etudiant);
        // Then
        Etudiant expectedStudent = etudiantRepository.findEtudiantByNomE(nomE);

        //When

        Assertions.assertThat(expectedStudent).isNotNull();


       // assertThat(expectedStudent).isNotNull();
        //assertThat(expectedStudent.getNomE()).isEqualTo(nomE);
        /**
         assertThat(expectedStudent.get(0).getNomE()).isEqualTo(etudiant.getNomE());
         assertThat(expectedStudent.get(0).getNomE()).isEqualTo(nomE); ;
         assertNotNull(expectedStudent);
         **/

    }

        @Test
        @Disabled
        public void findEtudiantByNomEAndPrenomE() {
        }

        @Test
        public void findAllStudent(){

            String nomE = "Sidaoui";

            // Given
            Etudiant etudiant1 = new Etudiant(1L,nomE,"Mohamed Amine", Option.SE,null,null,null);
            Etudiant etudiant2 = new Etudiant(1L,nomE,"Mohamed Amine", Option.SE,null,null,null);
                etudiantRepository.save(etudiant2);
                etudiantRepository.save(etudiant1);
                // When
            List<Etudiant> listEtudiant = etudiantRepository.findAll();
                // Then
            Assertions.assertThat(listEtudiant).isNotNull();

        }
}