package model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class AnimalDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animalDescription")
    private int animalDescriptionId;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "zooId")
    private Zoo zoo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "speciesId")
    private Species species;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "animalTypeId")
    private AnimalTypes animalTypes;


}
