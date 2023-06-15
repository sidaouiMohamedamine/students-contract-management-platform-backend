package com.sidaoui.projetSpring.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sidaoui.projetSpring.Entity.Etudiant;
import com.sidaoui.projetSpring.Service.EtudiantServiceImp;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = EtudiantRestController.class)
@ExtendWith(MockitoExtension.class)
class EtudiantRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EtudiantServiceImp etudiantService;

    @Autowired
    private ObjectMapper objectMapper;

    private Etudiant etudiant;


    @BeforeEach
    void setUp() {

      //  mockMvc = MockMvcBuilders.standaloneSetup(EtudiantRestController.class).build();
        etudiant = Etudiant
                .builder()
                .idEtudiant(1L)
                .nomE("Sidaoui")
                .prenomE("Mohamed Amine")
                .build();
    }

    @Test
    void saveEtudiant() throws Exception {



        given(etudiantService.saveEtudiant(ArgumentMatchers.any())).willAnswer((invocation -> invocation.getArgument(0)));

        ResultActions response = mockMvc.perform(post("/apiEtudiant/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(etudiant)));

        response.andExpect(MockMvcResultMatchers.status().isOk());


    }
    @Test
    public void getEtudiant() throws Exception {
        Etudiant etudiant1 = Etudiant
                .builder()
                .idEtudiant(1L)
                .nomE("Sidaoui")
                .prenomE("Mohamed Amine")
                .build();
        Etudiant etudiant2 = Etudiant
                .builder()
                .idEtudiant(1L)
                .nomE("Sidaoui")
                .prenomE("Mohamed Amine")
                .build();
        List<Etudiant> etudiants=new ArrayList<>();
        etudiants.add(etudiant1);
        etudiants.add(etudiant2);

        when(etudiantService.getEtudiant()).thenReturn(etudiants);


        ResultActions response = mockMvc.perform(get("/apiEtudiant/getEtudiant")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(etudiant)));


        response.andExpect(MockMvcResultMatchers.status().isOk());

    }


    @Test
    public void getEtudiantById() throws Exception {

        Long idE =1L;


        when(etudiantService.getEtudiantById(idE)).thenReturn( ResponseEntity.ok(etudiant));


        ResultActions response = mockMvc.perform(get("/apiEtudiant/getEtudiantById/{idE}",idE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(etudiant)));


        response.andExpect(MockMvcResultMatchers.status().isOk());


    }
    @Test
    public void updateEtudiant() throws  Exception {
        Long idE =1L;


        when(etudiantService.updateEtudiant(idE,etudiant)).thenReturn(ResponseEntity.ok(etudiant));

        ResultActions response = mockMvc.perform(put("/apiEtudiant/updateEtudiant/{idE}",idE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(etudiant)));

    }

    @Test
    public void deleteEtudiant() throws Exception{
        Long idE =1L;


       Map<String, Boolean> responseMap = new HashMap<>();
        responseMap.put("deleted", true);
       when(etudiantService.deleteEtudiant(idE)).thenReturn(ResponseEntity.ok(responseMap));
        ResultActions response = mockMvc.perform(delete("/apiEtudiant/deleteEtudiant/{idE}",idE)
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(MockMvcResultMatchers.status().isOk());

    }





}