package com.sidaoui.projetSpring.Entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Contrat")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Contrat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idContrat;
    private Date dateDebutContrat;
    private Date dateFinContrat;
    private Specialite specialite;
    private Boolean archive;

    @ManyToOne
    private Etudiant etudiant;

}
