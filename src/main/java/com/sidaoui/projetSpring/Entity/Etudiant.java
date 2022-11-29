package com.sidaoui.projetSpring.Entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Etudiant")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEtudiant;
    private String nomE;
    private String prenomE;
    @Enumerated(EnumType.STRING)
    private Option option;
    @OneToMany(mappedBy = "etudiant",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Contrat> contrat;
    @ManyToOne
    private Departement departement;
    @ManyToMany
    private List<Equipe>equipe;
}
