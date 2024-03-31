package com.bqtn;
import com.bqtn.Characters.Character;

import java.time.*;
import java.util.*;


public class World {

    private LocalDate initialDate;
    private LocalDateTime currentTime;

    private Map<String,Character> characterMap;

    private static Period period;

    public World(int currentYear,int currentMonth,int currentDay){
        this.initialDate = LocalDate.of(currentYear,currentMonth,currentDay);
        this.currentTime = LocalDateTime.of(currentYear,currentMonth,currentDay,0,0,0);

        this.characterMap = new HashMap<>();
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
        this.characterMap.put(character.getFirstName()+" "+character.getLastName(), character);
    }
    
    public void addNewCharacter(String firstName,String lastName,String gender,LocalDate dateOfBirth){
        if (getCharacterByName(firstName, lastName) == null){
            period = Period.between(dateOfBirth, this.getCurrentDate());
            int age = period.getYears()*365 + period.getMonths()*30 + period.getDays();

            this.characterMap.put(firstName+" "+lastName, new Character(firstName, lastName, gender, dateOfBirth, age));
        } else {
            System.out.println("Name already exists. No character created.\n");
        }
    }
    
    public void removeCharacter(Character character){
        this.characterMap.remove(character.getFirstName()+" "+character.getLastName());

    }

    public Character getCharacterByName(String firstName,String lastName){
        return characterMap.get(firstName+" "+lastName);
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
