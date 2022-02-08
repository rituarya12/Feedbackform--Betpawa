package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Feedback;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface FeedbackDAO extends Repository<Feedback, Integer> {
    public List<Feedback> findAll();

    public Feedback findById(int theId);

    public void save(Feedback feedback);

    public void deleteById(int theId);
}
