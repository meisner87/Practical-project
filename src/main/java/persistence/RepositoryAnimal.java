package persistence;

import model.AnimalDepartment;
import model.AnimalDescription;
import model.Employee;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class RepositoryAnimal {

    private EntityManager entityManager;

    public RepositoryAnimal() {
        entityManager = DBUtil.getEntityManager();
    }

    public void saveAnAnimal(AnimalDescription animal) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(animal);
            entityManager.getTransaction().commit();
            System.out.println("Animal saved");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public List<AnimalDescription> listAllAnimals() {
        return entityManager.createQuery("from AnimalDescription ")
                .getResultList();
    }


    public List<AnimalDepartment> listAnimalsBySpecieTypeAndZoo() {
        return entityManager.createQuery("SELECT new model.AnimalDepartment(a.species.description, a.name, a.zoo.name, a.animalTypes.name ) " +
                " FROM AnimalDescription a ", AnimalDepartment.class)
                .getResultList();
    }
}
////(String specieName, String animalName, String zooName, String animalType)
//    public List<EmployeeDepartment> listEmployeeByDept() {
//        String sql = "SELECT new model.EmployeeDepartment(e.employeeId, " +
//                "e.firstName, e.department.name) " +
//                "FROM Employee e ";
//        return entityManager
//                .createQuery(sql, EmployeeDepartment.class)
//                .getResultList();
//    }

