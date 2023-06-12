package com.sidaoui.projetSpring.Entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name="Etudiant")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEtudiant;
    private String nomE;
    private String prenomE;
    @Enumerated(EnumType.STRING)
    private Option option;
    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Contrat> contrat;
    @ManyToOne
    private Departement departement;
    @ManyToMany
    private List<Equipe> equipe;

    public Etudiant(Long idEtudiant, String nomE, String prenomE) {
        this.idEtudiant = idEtudiant;
        this.nomE = nomE;
        this.prenomE = prenomE;
    }


}


