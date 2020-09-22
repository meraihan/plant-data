package com.iouser.sorting.plantdata.model;


import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "general")
public class General {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Id
    @JoinColumn(name = "plants")
    private String plants;
    @JoinColumn(name = "family")
    private String family;
    @JoinColumn(name = "usage")
    private String usage;
    @JoinColumn(name = "activation_range")
    private String activationRange;
    @JoinColumn(name = "attack_direction")
    private String attackDirection;
    @JoinColumn(name = "shot_style")
    private String shotStyle;
    @JoinColumn(name = "acquisition")
    private String acquisition;

    public General() {
    }

    public General(String plants) {
        this.plants = plants;
    }
}
