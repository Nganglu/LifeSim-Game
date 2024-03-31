package com.bqtn;
import java.time.*;

import com.bqtn.Characters.Character;

public class SimulationManager {
    public static void main(String[] args) {
        World world = new World(2024, 1, 1);
        world.addNewCharacter("Benjamin","Nguyen","male",LocalDate.of(1996,01,31));

        Character alter = world.getCharacterByName("Benjamin", "Nguyen");

        System.out.println(alter);
        System.out.println(alter.bodyToString());
    }
}
