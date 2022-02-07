package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Feedback;

import java.util.List;

public interface FeedbackService {

    public List<Feedback> findAll();

    public Feedback findById(int theId);

    public void save(Feedback feedback);

    public void deleteById(int theId);
}
