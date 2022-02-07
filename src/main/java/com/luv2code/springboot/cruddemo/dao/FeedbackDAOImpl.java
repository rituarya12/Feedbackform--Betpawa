package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Feedback;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class FeedbackDAOImpl implements FeedbackDAO{
    // define field for entitymanager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public FeedbackDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


    @Override
    public List<Feedback> findAll() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<Feedback> theQuery =
                currentSession.createQuery("from Feedback", Feedback.class);

        // execute query and get result list
        List<Feedback> feedbacks = theQuery.getResultList();

        // return the results
        return feedbacks;
    }


    @Override
    public Feedback findById(int theId) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // get the employee
        Feedback feedback =
                currentSession.get(Feedback.class, theId);

        // return the employee
        return feedback;
    }


    @Override
    public void save(Feedback feedback) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // save employee
        currentSession.saveOrUpdate(feedback);
    }


    @Override
    public void deleteById(int theId) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery(
                        "delete from Feedback where id=:theId");
        theQuery.setParameter("feedbackId", theId);

        theQuery.executeUpdate();
    }
}
