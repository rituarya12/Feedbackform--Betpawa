package com.luv2code.springboot.cruddemo.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

@Entity
@Table(name="feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="rate")
    @Max(value =10, message="max value can be less than or equal to 10")
    @Min(value=0, message="min value can be greater than or equal to 0")
    private int rate;

    @Column(name="date")
    private Date date;



    // define constructors

    public Feedback() {

    }

    public Feedback(String name, String description, int rate, Date date) {
        this.name = name;
        this.description = description;
        this.rate = rate;
        this.date=date;
    }

    // define getter/setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    // define tostring


    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", rate='" + rate + '\'' +
                ", date=" + date +
                '}';
    }
}
