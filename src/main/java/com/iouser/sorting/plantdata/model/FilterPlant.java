package com.iouser.sorting.plantdata.model;


import groovyjarjarpicocli.CommandLine;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "filter_plant")
public class FilterPlant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "plant_id", nullable = false)
    private Long plantId;
    @Column(name = "special_level", nullable = false)
    private String specialLevel;
    @Column(name = "damage_level", nullable = false)
    private String damageLevel;
    @Column(name = "username", nullable = false)
    private String userName;
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "user_id", nullable = true)
//    private User user;
    @Transient
    private Plant plant;
    @Transient
    private List<Special> specialList;
    @Transient
    private List<Damage> damageList;


}
