package com.sidaoui.projetSpring.Service;

import com.sidaoui.projetSpring.Entity.*;
import com.sidaoui.projetSpring.Repository.EtudiantRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

public class EtudiantServiceImpTest {
    @InjectMocks
    private EtudiantServiceImp etudiantService;




    @Test
    public void checkIfStudentSaved() {
        // Given

        // When


        //Then

    }

    @Test
    @Disabled
    void getEtudiant() {
    }

    @Test
    @Disabled
    void getEtudiantById() {
    }

    @Test
    @Disabled
    void getEtudiantByNom() {
    }

    @Test
    @Disabled
    void updateEtudiant() {
    }

    @Test
    @Disabled
    void deleteEtudiant() {
    }

    @Test
    @Disabled
    void addAndAssignEtudiantToEquipeAndContract() {
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