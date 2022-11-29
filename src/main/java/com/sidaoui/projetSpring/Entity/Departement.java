package com.sidaoui.projetSpring.Entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Departement")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Departement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDepart ;
    private String nomDepart;
    @OneToMany(mappedBy = "departement",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Etudiant> etudiant;

}
