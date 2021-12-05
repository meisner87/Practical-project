package persistence;

import model.Customer;
import model.Employee;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

public class RepositoryDate {

private EntityManager entityManager;

    public RepositoryDate(){
        entityManager = DBUtil.getEntityManager();
        }



    public List<Employee> employeesByDateOfBirth() {
        return entityManager.createQuery("Select f from Employee as f order by f.dob asc ")
                .getResultList();
}

    public List<Employee> employeesBetween(){
        try{
            LocalDate firstDate = LocalDate.of(1977,01,01);
            LocalDate secondDate = LocalDate.of(1986,01,01);

            String sql = "From Employee where dob between :date1 and :date2";
            return entityManager
                    .createQuery(sql, Employee.class)
                    .setParameter("date1",firstDate)
                    .setParameter("date2",secondDate)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }





}