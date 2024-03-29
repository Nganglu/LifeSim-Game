package com.bqtn.Characters;
import com.bqtn.World;

import java.time.*;

import java.text.DecimalFormat;

public class Character {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;

    private int age;
    private int lifeExpectancy;
    
    private Body body;

    private int energy;
    private int health;

    private World world;

    private CharacterState state;

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Character(LocalDate dateOfBirth,String firstName,String lastName,String gender,double height,double weight){
        this(dateOfBirth,firstName,lastName,gender);
        this.body = new Body(height, weight, this.getBodyAge(), gender);
    }

    public Character(LocalDate dateOfBirth,String firstName,String lastName,String gender){
        this.dateOfBirth = dateOfBirth;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.body = new Body(age, gender);
    }

    public String toString(){
        return this.firstName + " " + this.lastName + " (" + this.gender.toUpperCase() + ")\n" +
                "Date of Birth: " + this.dateOfBirth + " (" + this.age + " years old)\n" +
                "Height: " + df.format(this.body.getHeight()) + "cm / Weight: " + df.format(this.body.getWeight()) + "kg";
    }

    public int calculateCharacterAge(LocalDate currentDate){
        return Period.between(this.dateOfBirth, currentDate).getYears();
    }

    public LocalDate getDateOfBirth(){
        return this.dateOfBirth;
    }
    
    public void setAge(int age) {
        this.age = age;
    }

    public void setBodyAge(int age){
        this.body.setBodyAge(age);
    }

    public int getBodyAge(){
        return this.body.getBodyAge();
    }

    public double getWeight() {
        return this.body.getWeight();
    }

    public void setWeight(double weight) {
        this.body.setWeight(weight);
    }

    public double getHeight() {
        return this.body.getHeight();
    }

    public void setHeight(double height) {
        this.body.setWeight(height);
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public void generateBody(){
        this.calculateCharacterAge(this.dateOfBirth);
        this.body.setBodyAge(this.age);
        this.body.generateBody();
    }
    
}
