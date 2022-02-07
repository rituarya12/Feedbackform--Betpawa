package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.FeedbackDAO;
import com.luv2code.springboot.cruddemo.entity.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class FeedbackServiceImpl implements FeedbackService {
    private FeedbackDAO feedbackDAO;

    @Autowired
    public FeedbackServiceImpl(FeedbackDAO feedbackDAO) {
        this.feedbackDAO = feedbackDAO;
    }

    @Override
    @Transactional
    public List<Feedback> findAll() {
        return feedbackDAO.findAll();
    }

    @Override
    @Transactional
    public Feedback findById(int theId) {
        return feedbackDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(Feedback feedbacks) {
        feedbackDAO.save(feedbacks);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        feedbackDAO.deleteById(theId);
    }
}
