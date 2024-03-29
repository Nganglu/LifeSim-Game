package com.bqtn;

import java.time.*;
import java.util.ArrayList;

import com.bqtn.Characters.Character;

public class World {

    private LocalDate initialDate;
    private LocalDateTime currentTime;

    private ArrayList<Character> population;

    public World(int year,int month,int day){
        this.initialDate = LocalDate.of(year,month,day);
        this.currentTime = LocalDateTime.of(year,month,day,0,0,0);

        this.population = new ArrayList<Character>();
    }

    
    public LocalDateTime getCurrentTime() {
        return this.currentTime;
    }

    public LocalDate getCurrentDate(){
        return this.currentTime.toLocalDate();
    }
    
    private void advanceTime(int years, int months, int days, int hours, int minutes, int seconds){
        currentTime = currentTime.plusYears(years)
                        .plusMonths(months)
                        .plusDays(days)
                        .plusHours(hours)
                        .plusMinutes(minutes)
                        .plusSeconds(seconds);
    }

    private void advanceSeconds(int seconds){
        currentTime = currentTime.plusSeconds(seconds);
    }

    private void advanceMinutes(int minutes){
        currentTime = currentTime.plusMinutes(minutes);
    }

    private void advanceHours(int hours){
        currentTime = currentTime.plusHours(hours);
    }

    private void advanceDays(int days){
        currentTime = currentTime.plusDays(days);
    }

    public void addCharacter(Character character){
        if(!this.population.contains(character)) {
            character.setAge(calculateCharacterAge(character));
            this.population.add(character);
        };
    }

    public void removeCharacter(Character character){
        if (this.population.contains(character)) this.population.remove(character);
    }

    public int calculateCharacterAge(Character character){
        return Period.between(character.getDateOfBirth(), this.getCurrentDate()).getYears();
    }

    public static void main(String[] args) {
        World world = new World(2014, 1, 31);

        Character alter = new Character(LocalDate.of(1996,01,31),"Benjamin","Nguyen","MALE");
        world.addCharacter(alter);
        alter.setAge(21);
        alter.generateHeight();
        alter.generateWeight();


        System.out.println(alter);
    }
}