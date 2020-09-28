package com.iouser.sorting.plantdata.model;


import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "plant")
public class Plant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="plant_name", nullable = false)
    private String plantName;
    @Column(name="family", nullable = false)
    private String family;
    @Column(name="usage", nullable = false)
    private String usage;
    @Column(name="activationRange", nullable = false)
    private String activationRange;
    @Column(name="attackDirection", nullable = false)
    private String attackDirection;
    @Column(name="shotStyle", nullable = false)
    private String shotStyle;
    @Column(name="acquisition", nullable = false)
    private String acquisition;

    @OneToMany(mappedBy = "plant", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Special> special;
    @OneToMany(mappedBy = "plant", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Damage> damage;

    public Plant() {
    }

    public Plant(String plants) {
        this.plantName = plants;
    }
}
