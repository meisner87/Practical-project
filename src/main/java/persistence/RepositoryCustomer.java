package persistence;

import java.util.List;
import javax.persistence.EntityManager;

import lombok.Data;
import model.Customer;
import util.DBUtil;
@Data

public class RepositoryCustomer {

    private EntityManager em;

    public RepositoryCustomer() {
        em = DBUtil.getEntityManager();
    }

    @SuppressWarnings("unchecked")
    public List<Customer> listAllCustomers() {
        return em.createQuery("Select f from Customer as f order by f.firstName asc")
                .getResultList();
    }


    }



