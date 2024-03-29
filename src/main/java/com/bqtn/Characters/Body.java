package com.bqtn.Characters;

public class Body {
    // ArrayList<BodyPart> bodyParts;

    private double height;
    private double weight;
    private int bodyAge;
    private int growthLimit;

    private String bioSex;
    //hormonalBalance

    public Body(double height,double weight,int bodyAge,String bioSex){
        this.height = height;
        this.weight = weight;
        this.bodyAge = bodyAge;
        this.bioSex = bioSex;
        this.growthLimit = (this.bioSex.toLowerCase().equals("female"))? 16:18;
    }

    public Body(double height,double weight,int bodyAge){
        this(height,weight,bodyAge,"other");
    }

    public Body(double height,double weight){
        this(height,weight,0,"other");
    }

    public Body(int bodyAge,String bioSex){
        this.bodyAge = bodyAge;
        this.bioSex = bioSex;
        this.growthLimit = (this.bioSex.toLowerCase().equals("female"))? 16:18;
    }

    public void grow(){
    }

    public void generateBody(){
        this.generateHeight();
        this.generateWeight();
    }

    public void generateHeight(int parentsHeight){
        int targetGrowth = (this.bodyAge > this.growthLimit)? this.growthLimit : this.bodyAge;
        if (this.bodyAge == 0){
            this.height = 50;
        }
        if (this.bodyAge == 1){
            this.height = 75;
        }
        if (this.bodyAge == 2){
            this.height = 87;
        }
        if (this.bodyAge >= 3) {
            
            switch (this.bioSex.toLowerCase()) {
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
    }
    
    public void generateHeight(){
        this.generateHeight(170);
    }

    public void generateWeight(){
        int targetGrowth = (this.bodyAge > this.growthLimit)? this.growthLimit : this.bodyAge;
        
        switch (this.bioSex.toLowerCase()) {
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

    public int getBodyAge(){
        return this.bodyAge;
    }

    public void setBodyAge(int bodyAge){
        this.bodyAge = bodyAge;
    }
}
