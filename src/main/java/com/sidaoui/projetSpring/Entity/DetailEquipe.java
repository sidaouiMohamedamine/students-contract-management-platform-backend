package com.sidaoui.projetSpring.Entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DetailEquipe")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DetailEquipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String thematique;
    @OneToOne
    private Equipe equipe;



}
