package com.sidaoui.projetSpring.Repository;

import com.sidaoui.projetSpring.Controller.EtudiantRestController;
import com.sidaoui.projetSpring.Entity.Etudiant;
import com.sidaoui.projetSpring.Entity.Option;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)

public class EtudiantRepositoryTest {


        @Autowired
        private EtudiantRepository etudiantRepository;


    @Test
    @Disabled
   public  void findEtudiantByNomE() {

        // Given
        String nomE = "Sidaoui";
        Etudiant etudiant = new Etudiant(1L,nomE,"Mohamed Amine");
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
            //Etudiant etudiant1 = new Etudiant(1L,nomE,"Mohamed Amine");
            //Etudiant etudiant2 = new Etudiant(1L,nomE,"Mohamed Amine");

            Etudiant etudiant3 = Etudiant
                    .builder()
                    .idEtudiant(1L)
                    .nomE("Sidaoui")
                    .prenomE("MohamedAmine")
                    .build();
            Etudiant etudiant4 = Etudiant
                    .builder()
                    .idEtudiant(1L)
                    .nomE("Sidaoui")
                    .prenomE("Said")
                    .build();
                etudiantRepository.save(etudiant3);
                etudiantRepository.save(etudiant4);
                // When
            List<Etudiant> listEtudiant = etudiantRepository.findAll();
                // Then
            Assertions.assertThat(listEtudiant).isNotNull();

        }


}