package com.bqtn.Characters;

import java.text.DecimalFormat;

public class Body {
    // ArrayList<BodyPart> bodyParts;
    private double height; //in cm
    private double weight; // in kg
    private int physicalAge; // in days

    private String gender;

    private double growthFactor;
    private double BMI;
    private int percentile;
    private double growthSoftcap;

    private int growthSpurtDays;

    private static final DecimalFormat df = new DecimalFormat("0.00");
    private static final double GROWTH_FACTOR_AT_BIRTH = 6.4;
    private static final double HEIGHT_AT_BIRTH = 50;
    private static final double WEIGHT_AT_BIRTH = 3.3;
    private static final double AVERAGE_BMI = 22;

    public Body(int physicalAgeInDays,String gender,int percentile){
        this.gender = gender;
        this.height = HEIGHT_AT_BIRTH;
        this.weight = WEIGHT_AT_BIRTH;
        this.growthFactor = GROWTH_FACTOR_AT_BIRTH;
        this.BMI = AVERAGE_BMI;
        this.percentile = percentile;
        this.setSoftcapFromPercentile();
        this.simulateGrowth(physicalAgeInDays);
    }
    
    public String toString(){
        return df.format(this.height)+"cm  "+df.format(this.weight)+"kg ("+this.percentile+"th perc.)  /  Gender: "+this.gender+"\n"+
        "Age: "+df.format(1.0*this.physicalAge/365)+" y.o.  Growth Factor: "+df.format(1.0*this.growthFactor)+"  Spurt Days: "+this.growthSpurtDays+"\n";
    }
    
    public void simulateGrowth(int nbOfDays){
        for (int i = 0; i < nbOfDays; i++) {
            if (this.growthFactor > this.growthSoftcap || this.physicalAge > 16*365){ // growth factor soft-clamp: 1.2 = 5th pecentile/1.6=50th/1.8=95th
                this.growthFactor -= 2.6/365; // -1 /year
            }
            if (this.growthSpurtDays > 0){
                if (this.physicalAge < 10*365){
                    this.growthFactor += 1.8/365;
                } else {
                    switch (this.gender.toLowerCase()) {
                        case "male":
                            this.growthFactor += 1.4/365;
                            break;
                        case "female":
                        default:
                            this.growthFactor += 0.6/365;
                            break;
                    }
                }
    
                this.growthSpurtDays--;
            }
            if (this.physicalAge <= 12*365){
                if (this.growthFactor > 1){
                    this.growthFactor -= 0.079/365;
                } else {
                    this.growthFactor = 1;
                }
            } else {
                this.growthFactor -= 0.2/365;
                if (this.gender.toLowerCase().equals("female")){
                    this.growthFactor -= 0.2/365;
                }
            }
            if (this.growthFactor < 0.001) this.growthFactor = 0;

            double baseGrowth = 5.0/365;
            this.height += baseGrowth * this.growthFactor;
            this.physicalAge++;

            if (this.physicalAge == 11*365){
                switch (this.gender.toLowerCase()) {
                    case "male":
                        this.growthSpurtDays = 450;
                        break;
                    case "female":
                        this.growthSpurtDays = 365;
                        break;
                    default:
                        this.growthSpurtDays = 400;
                        break;
                }
            }
        }
        this.weight = this.calculateIdealWeight();
    }

    public double calculateIdealWeight(){
        return calculateBMIWeight(this.BMI,this.gender);
    }

    public double calculateBMIWeight(double bodyMassIndex,String gender){
        double targetWeight = bodyMassIndex * Math.pow(this.height/100,2);
        if (this.physicalAge >= 15*365){
            switch (gender.toLowerCase()) {
                case "male":
                    targetWeight += 3;
                    break;
                case "female":
                    targetWeight -= 5;
                break;
                default:
                    break;
            }
        } else {
            targetWeight = Math.pow(this.height,3)/78000;
        }
        return targetWeight;
    }

    public void setSoftcapFromPercentile(){
        //NOTE: Percentile of 5 should return 1.2, 50 should return 1.6, 95 should return 1.8
        // following -> f(x) = ax**2 + bx + c, where x=percentile and y=softcap
        double a = -0.0000493827160494;
        double b = 0.0116049382716;
        double c = 1.14320987654;
        this.growthSoftcap = Double.valueOf(df.format(a*Math.pow(this.percentile,2)+b*this.percentile+c));
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

    public String getGender(){
        return this.gender;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public double getGrowthSoftCap(){
        return this.growthSoftcap;
    }

    public void setPercentile(int percentile){
        if (percentile > 0 && percentile <= 100){
            this.percentile = percentile;
            this.setSoftcapFromPercentile();
        }
    }

    public int getPercentile(){
        return this.percentile;
    }

}
