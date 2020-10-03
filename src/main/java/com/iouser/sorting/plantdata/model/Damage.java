package com.iouser.sorting.plantdata.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "damage")
public class Damage  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "plant_id", nullable = false)
    private Plant plant;
    private String level;
    private String level1;
    private String level2;
    private String level3;
    private String level4;
    private String level5;
    private String level6;
    private String level7;
    private String level8;
    private String level9;
    private String level10;
    private String level11;
    private String level12;
    private String level13;
    private String level14;
    private String level15;
    private String level16;
    private String level17;
    private String level18;
    private String level19;
    private String level20;
}
