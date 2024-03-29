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
    private int growthEndAge;
    private int lifeExpectancy;
    
    private Body body;
    private double height;
    private double weight;

    private int energy;
    private int health;

    private World world;

    private CharacterState state;

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Character(LocalDate dateOfBirth,String firstName,String lastName,String gender,double height,double weight){
        this(dateOfBirth, firstName, lastName, gender);
        this.height = height;
        this.weight = weight;
        //this.body = body!!!!
        //this.height = this.body.setHeight(height);
    }

    public Character(LocalDate dateOfBirth,String firstName,String lastName,String gender){
        this.dateOfBirth = dateOfBirth;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.growthEndAge = ( this.gender.toUpperCase().equals("FEMALE")) ? 16 : 18;
    }

    public String toString(){
        return this.firstName + " " + this.lastName + " (" + this.gender + ")\n" +
                "Date of Birth: " + this.dateOfBirth + " (" + this.age + " years old)\n" +
                "Height: " + df.format(this.height) + "cm / Weight: " + df.format(this.weight) + "kg";
    }

    
    public void generateHeight(int parentsHeight){
        int targetGrowth = (this.age > this.growthEndAge)? this.growthEndAge : this.age;
        if (this.age == 0){
            this.height = 50;
        }
        if (this.age == 1){
            this.height = 75;
        }
        if (this.age == 2){
            this.height = 87;
        }
        if (this.age >= 3) {
            
            switch (this.gender.toLowerCase()) {
                case "male":
                this.height = 84.88+(4.65*targetGrowth)+(parentsHeight-152.4)/2;
                break;
                case "female":
                this.height = 69.97+(4.89*targetGrowth)+(parentsHeight-152.4)/2;
                break;
                default:
                this.height = 77+(4.77*targetGrowth)+(parentsHeight-152.4)/2;
                break;
            }
        }
        
        this.body.setHeight(this.height);
    }
    
    public void generateHeight(){
        this.generateHeight(170);
    }
    
    public void generateWeight(){
        int targetGrowth = (this.age > this.growthEndAge)? this.growthEndAge : this.age;
        
        switch (this.gender.toLowerCase()) {
            case "male":
            this.weight = 0.09 * Math.pow(targetGrowth, 2) + 0.8 * targetGrowth + 40;
            break;
            case "female":
            this.weight = 0.06 * Math.pow(targetGrowth, 2) + 0.5 * targetGrowth + 35;
            break;
            default:
            this.weight = 0.07 * Math.pow(targetGrowth,2) + 0.75 * targetGrowth + 37.5;
            break;
        }

        this.body.setWeight(this.weight);
    }

    public LocalDate getDateOfBirth(){
        return this.dateOfBirth;
    }
    
    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return this.body.getWeight();
    }

    public void setWeight(double weight) {
        this.body.setWeight(weight);
        this.weight = weight;
    }

    public double getHeight() {
        return this.body.getHeight();
    }

    public void setHeight(double height) {
        this.body.setWeight(height);
        this.height = height;
    }
    
}
