package com.bqtn.Characters;

public class Body {
    // ArrayList<BodyPart> bodyParts;

    private double height;
    private double weight;
    private int age;
    private int growthLimit;

    private String bioSex;
    //hormonalBalance

    public Body(double height,double weight,int age,String bioSex){
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.bioSex = bioSex;
        this.growthLimit = (this.bioSex.toLowerCase().equals("female"))? 16:18;
    }

    public void grow(){
    }

    public double getHeight(){
        return this.height;
    }

    public void setHeight(double height){
        this.height = height;
    }

    public double getWeight(){
        return this.weight;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }
}
