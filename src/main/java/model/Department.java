package model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "departmentId")
    private int departmentId;

    @Column(name = "departmentName")
    private String departmentName;

    @ManyToOne
    @JoinColumn(name = "zooId")
    private Zoo zoo;

    @ManyToOne
    @JoinColumn(name = "contactId")
    private Employee employee;



}
