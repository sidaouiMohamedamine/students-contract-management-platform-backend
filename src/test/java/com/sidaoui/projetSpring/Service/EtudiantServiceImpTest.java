package com.sidaoui.projetSpring.Service;

import com.sidaoui.projetSpring.Entity.*;
import com.sidaoui.projetSpring.Exception.NotFoundException;
import com.sidaoui.projetSpring.Repository.ContratRepository;
import com.sidaoui.projetSpring.Repository.EquipeRepository;
import com.sidaoui.projetSpring.Repository.EtudiantRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EtudiantServiceImpTest {

    @InjectMocks
    private EtudiantServiceImp etudiantService;
    @Mock
    private EtudiantRepository etudiantRepository;

    @Mock
    private ContratRepository contratRepository;

    @Mock
    private EquipeRepository equipeRepository;




    @Test
    public void checkIfStudentSaved() {
        Etudiant etudiant = Etudiant
                .builder()
                .idEtudiant(1L)
                .nomE("Sidaoui")
                .prenomE("Mohamed Amine")
                .build();
        when(etudiantRepository.save(Mockito.any(Etudiant.class))).thenReturn(etudiant);
        Etudiant savedStudent = etudiantService.saveEtudiant(etudiant);

        Assertions.assertThat(savedStudent).isNotNull();

    }

    @Test
    void getEtudiant() {
        Etudiant etudiant1 = Etudiant
                .builder()
                .idEtudiant(1L)
                .nomE("Sidaoui")
                .prenomE("Mohamed Amine")
                .build();
        Etudiant etudiant2 = Etudiant
                .builder()
                .idEtudiant(2L)
                .nomE("Sidaoui")
                .prenomE("Mohamed")
                .build();
        List<Etudiant> etudiantList = Arrays.asList(etudiant1, etudiant2);  // Créer une liste avec les objets Etudiant

        when(etudiantRepository.findAll()).thenReturn(etudiantList);

        List<Etudiant> result = etudiantService.getEtudiant();

        Assertions.assertThat(result).isNotNull();

    }

    @Test
    @Disabled
    void getEtudiantById() {
        Long idE= 1L;
        Etudiant etudiant = Etudiant
                .builder()
                .idEtudiant(idE)
                .nomE("Sidaoui")
                .prenomE("Mohamed Amine")
                .build();
        when(etudiantRepository.findById(idE)).thenReturn(Optional.ofNullable(etudiant));

        ResponseEntity<Etudiant> retreivedEtudiant = etudiantService.getEtudiantById(idE);

        Assertions.assertThat(retreivedEtudiant).isNotNull();
        Assertions.assertThat(retreivedEtudiant.getBody().getIdEtudiant()).isEqualTo(idE);
    }

    @Test
    void getEtudiantByNom() {
        String nomE = "Sidaoui";
        Etudiant etudiant = Etudiant
                .builder()
                .idEtudiant(1L)
                .nomE(nomE)
                .prenomE("Mohamed Amine")
                .build();

        when(etudiantRepository.findEtudiantByNomE(nomE)).thenReturn(etudiant);

        Etudiant etudiantList =etudiantService.getEtudiantByNom(nomE);

        Assertions.assertThat(etudiantList).isNotNull();
        Assertions.assertThat(etudiantList.getNomE()).isEqualTo(nomE);



    }
    @Test
    void updateEtudiant() {
        Etudiant etudiant = Etudiant
                .builder()
                .idEtudiant(1L)
                .nomE("Sidaoui")
                .prenomE("Mohamed Amine")
                .build();
        when(etudiantRepository.findById(1L)).thenReturn(Optional.ofNullable(etudiant));
        when(etudiantRepository.save(Mockito.any(Etudiant.class))).thenReturn(etudiant);

        ResponseEntity<Etudiant> savedEtudiant = etudiantService.updateEtudiant(1L,etudiant);

        Assertions.assertThat(savedEtudiant).isNotNull();

    }

    @Test
    void deleteEtudiant() {
        Long id= 1L ;
        Etudiant etudiant = Etudiant
                .builder()
                .idEtudiant(id)
                .nomE("Sidaoui")
                .prenomE("Mohamed Amine")
                .build();

        when(etudiantRepository.findById(id)).thenReturn(Optional.of(etudiant));
        doNothing().when(etudiantRepository).delete(etudiant);

        // Call the service method
        ResponseEntity<Map<String, Boolean>> etudiantDeleted = etudiantService.deleteEtudiant(id);

        // Verify the repository methods were called with the correct arguments
        verify(etudiantRepository).findById(id);
        verify(etudiantRepository).delete(etudiant);

        // Verify the response status code
        assertEquals(HttpStatus.OK, etudiantDeleted.getStatusCode());

        // Verify the response body contains the expected value
        Map<String, Boolean> responseBody = etudiantDeleted.getBody();
        assertTrue(responseBody.get("deleted"));

    }

    @Test
    @Disabled
    void addAndAssignEtudiantToEquipeAndContract() {
        // Créer un objet Etudiant fictif
        Etudiant etudiant = Etudiant.builder()
                .idEtudiant(1L)
                .nomE("Sidaoui")
                .prenomE("Mohamed Amine")
                .build();

        // Créer un objet Contrat fictif
        Contrat contrat = new Contrat();
        contrat.setIdContrat(1L);

        // Créer un objet Equipe fictif
        Equipe equipe = new Equipe();
        equipe.setId(1L);

        // Configurer les comportements des mocks
        Mockito.when(contratRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(contrat));
        Mockito.when(equipeRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(equipe));
        Mockito.when(etudiantRepository.save(Mockito.any(Etudiant.class))).thenReturn(etudiant);

        // Appeler la méthode à tester
        Etudiant result = etudiantService.addAndAssignEtudiantToEquipeAndContract(etudiant, 1L, 1L);

        // Vérifier les interactions avec les mocks
        Mockito.verify(contratRepository, Mockito.times(1)).findById(Mockito.anyLong());
        Mockito.verify(equipeRepository, Mockito.times(1)).findById(Mockito.anyLong());
        Mockito.verify(etudiantRepository, Mockito.times(1)).save(Mockito.any(Etudiant.class));

        // Vérifier le résultat
        Assertions.assertThat(etudiant).isNotNull();
        Assertions.assertThat(etudiant).isEqualTo(result);

    }

    @Test
    @Disabled
    void assignEtudiantToDepartment() {
    }

    @Test
    @Disabled
    void getEtudiantsByDepartement() {
    }
}