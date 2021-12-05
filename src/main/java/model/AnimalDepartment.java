package model;

import lombok.Data;

@Data
public class AnimalDepartment {
    private String specieName;
    private String animalName;
    private String zooName;
    private String animalType;

    public AnimalDepartment(String specieName, String animalName, String zooName, String animalType) {
        this.specieName = specieName;
        this.animalName = animalName;
        this.zooName = zooName;
        this.animalType = animalType;
    }
}
