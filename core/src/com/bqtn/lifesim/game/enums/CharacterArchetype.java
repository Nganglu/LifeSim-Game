package com.bqtn.lifesim.game.enums;

public enum CharacterArchetype {
    CIVILIAN("Civilian","","Male",35,35,35,35,35,170,6500);


    final String firstName;
    final String lastName;
    final String gender;
    final int averageMental;
    final int averageVitality;
    final int averageCharisma;
    final int averageDexterity;
    final int averageStrength;
    final int height; //! in cm
    final int weight; //! in grams

    CharacterArchetype(String firstName, String lastName, String gender, int averageMental, int averageVitality, int averageCharisma, int averageDexterity, int averageStrength, int height, int weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.averageMental = averageMental;
        this.averageVitality = averageVitality;
        this.averageCharisma = averageCharisma;
        this.averageDexterity = averageDexterity;
        this.averageStrength = averageStrength;
        this.height = height;
        this.weight = weight;
    }

    public String[] getData(){
        return new String[]{this.firstName,
        this.lastName,
        this.gender,
        String.valueOf(this.averageMental),
        String.valueOf(this.averageVitality),
        String.valueOf(this.averageCharisma),
        String.valueOf(this.averageDexterity),
        String.valueOf(this.averageStrength),
        String.valueOf(this.height),
        String.valueOf(this.weight)};
    }
}
