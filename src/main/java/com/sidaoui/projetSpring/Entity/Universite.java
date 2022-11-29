package com.sidaoui.projetSpring.Entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Universite")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Universite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUniv;
    private String nomUniv;
    @OneToMany
    private List<Departement> department;

   

}
