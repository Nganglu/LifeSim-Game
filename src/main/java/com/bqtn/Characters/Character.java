package com.bqtn.Characters;

import java.time.*;
import java.util.*;

import java.text.DecimalFormat;

public class Character {

    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate dateOfBirth;
    
    private final Body body;

    private Random random;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Character(String firstName,String lastName,String gender,LocalDate dateOfBirth,int physicalAgeInDays,int percentile){
        setDetails(firstName,lastName,gender,dateOfBirth);
        this.body = new Body(physicalAgeInDays,gender,percentile);
    }

    public Character(String firstName,String lastName,String gender,LocalDate dateOfBirth,int physicalAgeInDays){
        setDetails(firstName,lastName,gender,dateOfBirth);
        random = new Random();
        int percentile = (int) Math.round(random.nextGaussian() * 15 + 50);
        percentile = (percentile > 100 || percentile < 1)?50:percentile;
        this.body = new Body(physicalAgeInDays,gender,percentile);
    }

    public String toString(){
        return this.firstName + " " + this.lastName + " (" + this.gender.toUpperCase() + ")\n" +
                "Date of Birth: " + this.dateOfBirth + "\n" +
                "Height: " + df.format(this.body.getHeight()) + "cm / Weight: " + df.format(this.body.getWeight()) + "kg\n";
    }
    
    private void setDetails(String firstName,String lastName,String gender,LocalDate dateOfBirth){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public void growInDays(int nbOfDays){
        this.body.simulateGrowth(nbOfDays);
    }

    public void growInYears(int nbOfYears){
        this.growInDays(nbOfYears * 365);
    }

    public LocalDate getDateOfBirth(){
        return this.dateOfBirth;
    }

    public Body getBody(){
        return this.body;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String bodyToString(){
        return this.body.toString();
    }
}