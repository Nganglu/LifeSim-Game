package com.bqtn.world;
import java.time.*;
import java.util.*;

import com.bqtn.characters.Character;


public class World {

    private String worldName;
    private String worldDescription;

    private LocalDate initialDate;
    private LocalDateTime currentTime;
    
    private Map<String,Character> charactersMap;

    // Map<String,Location> locationMap;
    // Economy economy;
    // Bank bank;

    private static Period period;

    public World(String name,String description,int currentYear,int currentMonth,int currentDay){
        this.worldName = name;
        this.worldDescription = description;
        this.initialDate = LocalDate.of(currentYear,currentMonth,currentDay);
        this.currentTime = LocalDateTime.of(currentYear,currentMonth,currentDay,0,0,0);

        this.charactersMap = new HashMap<>();
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
        this.advanceTime(0, 0, 0, 0, 0, seconds);
    }

    private void advanceMinutes(int minutes){
        this.advanceTime(0, 0, 0, 0, minutes, 0);
    }

    private void advanceHours(int hours){
        this.advanceTime(0, 0, 0, hours, 0, 0);
    }

    private void advanceDays(int days){
        this.advanceTime(0, 0, days, 0, 0, 0);
    }
    
    public void addCharacter(Character character){
        if (character.getPhysicalAge() == 0){
            try {
                character.growInDays(this.getCharacterAge(character));
            } catch (Exception e) {
                System.out.println(e+" character body has not been initialized.");
            }
        }
        this.charactersMap.put(character.getFirstName()+" "+character.getLastName(), character);
    }
    
    public void removeCharacter(Character character){
        this.charactersMap.remove(character.getFirstName()+" "+character.getLastName());

    }

    public Character getCharacterByName(String firstName,String lastName){
        return charactersMap.get(firstName+" "+lastName);
    }
    
    public int getCharacterAge(Character character){
        int age = 0;
        period = Period.between(character.getDateOfBirth(), this.getCurrentDate());
        age += period.getYears()*365 + period.getMonths()*30 + period.getDays();
        return age;
    }

    public LocalDateTime getCurrentTime() {
        return this.currentTime;
    }
    
    public LocalDate getCurrentDate(){
        return this.currentTime.toLocalDate();
    }
}
