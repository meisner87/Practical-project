package model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class AnimalTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animalTypeId")
    private int animalTypeId;

    @Column(name = "name" )
    private String name;

    @Column(name = "typeId")
    private String typeId;

    @Column(name = "animalDescription")
    private String animalDescription;








}
