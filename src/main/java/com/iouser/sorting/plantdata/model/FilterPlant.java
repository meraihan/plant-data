package com.iouser.sorting.plantdata.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "filter_plant")
public class FilterPlant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="plant_id", nullable = false)
    private Long plantId;
    @Column(name="special_level", nullable = false)
    private String specialLevel;
    @Column(name="damage_level", nullable = false)
    private String damageLevel;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Transient
    private String[] slevel;
    @Transient
    private String[] dlevel;
//    @Transient
//    private String slevel3;
//    @Transient
//    private String slevel4;
//    @Transient
//    private String slevel5;
//    @Transient
//    private String slevel6;
//    @Transient
//    private String slevel7;
//    @Transient
//    private String slevel8;
//    @Transient
//    private String slevel9;
//    @Transient
//    private String slevel10;
//    @Transient
//    private String slevel11;
//    @Transient
//    private String slevel12;
//    @Transient
//    private String slevel13;
//    @Transient
//    private String slevel14;
//    @Transient
//    private String slevel15;
//    @Transient
//    private String slevel16;
//    @Transient
//    private String slevel17;
//    @Transient
//    private String slevel18;
//    @Transient
//    private String slevel19;
//    @Transient
//    private String slevel20;
//    @Transient
//    private String dlevel1;
//    @Transient
//    private String dlevel2;
//    @Transient
//    private String dlevel3;
//    @Transient
//    private String dlevel4;
//    @Transient
//    private String dlevel5;
//    @Transient
//    private String dlevel6;
//    @Transient
//    private String dlevel7;
//    @Transient
//    private String dlevel8;
//    @Transient
//    private String dlevel9;
//    @Transient
//    private String dlevel10;
//    @Transient
//    private String dlevel11;
//    @Transient
//    private String dlevel12;
//    @Transient
//    private String dlevel13;
//    @Transient
//    private String dlevel14;
//    @Transient
//    private String dlevel15;
//    @Transient
//    private String dlevel16;
//    @Transient
//    private String dlevel17;
//    @Transient
//    private String dlevel18;
//    @Transient
//    private String dlevel19;
//    @Transient
//    private String dlevel20;



}
