package persistence;

import model.Employee;
import util.DBUtil;

import javax.persistence.EntityManager;

public class RepositoryEmployee {

    private EntityManager entityManager;

    public RepositoryEmployee(){
            entityManager = DBUtil.getEntityManager();
        }


        public void saveEmployee(Employee employee){
            try{
                entityManager.getTransaction().begin();
                entityManager.persist(employee);
                entityManager.getTransaction().commit();
                System.out.println("Employee saved");
            }catch (Exception e){
                entityManager.getTransaction().rollback();
                e.printStackTrace();
            }
        }

    public void updateEmployeeAddressById(int employeeId,String address){

        try {
            String sql = "UPDATE Employee e SET e.address = :newAddress WHERE e.employeeId = :id";
            entityManager.getTransaction().begin();
            entityManager
                    .createQuery(sql)
                    .setParameter("newAddress",address)
                    .setParameter("id",employeeId)
                    .executeUpdate();
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            System.out.println("Employee address updated");
        }
        }

        public long listTotalEmployees(){
        String sql = "SELECT COUNT(e) from Employee e";
        return (long) entityManager.createQuery(sql).getSingleResult();
        }

}




