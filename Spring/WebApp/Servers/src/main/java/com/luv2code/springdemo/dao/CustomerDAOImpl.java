package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO
{

    @Autowired
    private SessionFactory sessionFactory;

//    private SessionFactory sessionFactory;
//    public CustomerDAOImpl(Sessionfactory se)
//{
//    sessionFactory=se;
//}

    @Override
    public List<Customer> getCustomers()
    {
//        get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

//        create a query
       Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName",Customer.class);

//        execute query and get result list
        List<Customer> customers = theQuery.getResultList();

//        return the results
        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        Session currentSession = sessionFactory.getCurrentSession();


        Query<Customer> theQuery =
                currentSession.createQuery("select c from Customer c "
                                + "where c.firstName =:theCustomerFirstName and c.lastName =:theCustomerLastName and c.email=:email",
                        Customer.class);

        // set parameter on query
        theQuery.setParameter("theCustomerFirstName", theCustomer.getFirstName());
        theQuery.setParameter("theCustomerLastName", theCustomer.getLastName());
        theQuery.setParameter("email", theCustomer.getEmail());

        // execute query and get instructor
        try {
            Customer temp = theQuery.getSingleResult();

            System.out.println(temp);

        }
        catch (Exception exc)
        {
            System.out.println("handled");
            currentSession.saveOrUpdate(theCustomer);
        }
    }

    @Override
    public Customer getCustomer(int theId)
    {
        Session currentSession = sessionFactory.getCurrentSession();

        Customer theCustomer= currentSession.get(Customer.class,theId);

        return  theCustomer;
    }

    @Override
    public void delete(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
        theQuery.setParameter("customerId",theId);

        theQuery.executeUpdate();
    }
}
