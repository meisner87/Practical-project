package model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Species {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "speciesId")
    private int speciesId;

    @Column(name = "description")
    private String description;




}
