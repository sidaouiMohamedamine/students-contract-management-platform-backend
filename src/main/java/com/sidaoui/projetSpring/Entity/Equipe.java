package com.sidaoui.projetSpring.Entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Equipe")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Equipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomEquipe;
    private Niveau niveau;
    @ManyToMany(mappedBy = "equipe",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Etudiant>etudiant;
    @OneToOne
    private DetailEquipe detailEquipe;
}
