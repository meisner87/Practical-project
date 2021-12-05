package model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Zoo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "zooId")
    private int zooId;

    @Column(name = "name")
    private String name;


}
