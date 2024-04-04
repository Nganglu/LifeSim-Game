package com.bqtn.utils;
import com.bqtn.characters.Character;

import java.io.*;
import java.time.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CharacterEditor {

    static List<Character> characterList;
    static final String testPath = "src/main/java/com/bqtn/utils/test.character";

    public CharacterEditor(){
        characterList = new ArrayList<>();
    }

    public static void loadFromFile(String path){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineArray = line.split(";");
                String lastName = lineArray[0];
                String firstName = lineArray[1];
                String gender = lineArray[2];
                String[] dob = lineArray[3].split("-");
                int physicalAge = Integer.parseInt(lineArray[4]);
                int percentile = Integer.parseInt(lineArray[5]);
                int strength = Integer.parseInt(lineArray[6]);
                int dexterity = Integer.parseInt(lineArray[7]);
                int intelligence = Integer.parseInt(lineArray[8]);
                int constitution = Integer.parseInt(lineArray[9]);
    
                characterList.add(new Character(firstName, lastName, gender, LocalDate.of(Integer.parseInt(dob[0]), Integer.parseInt(dob[1]), Integer.parseInt(dob[2])), physicalAge, percentile, strength, dexterity, intelligence, constitution));
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e+": File not found at ");
        }
    }

    public static void writeToFile(String path){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path,false));
            for (Character character : characterList) {
                String characterLine = character.getLastName()+
                                    ";"+character.getFirstName()+
                                    ";"+character.getGender()+
                                    ";"+character.getDateOfBirth()+
                                    ";"+character.getPhysicalAge()+
                                    ";"+character.getPercentile()+
                                    ";"+character.getStrength()+
                                    ";"+character.getDexterity()
                                    +";"+character.getIntelligence()
                                    +";"+character.getConstitution()+";\n";
                writer.write(characterLine);
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e+": Unable to write to "+path);
        }
    }

    public static void displayCharacterList(){
        for (Character character : characterList) {
            System.out.println(character.getFullName());
        }
    }

    public static void addCharacter(Character character){
        characterList.add(character);
    }
    
    public static void main(String[] args) {
        new CharacterEditor();
        JFrame frame = new JFrame("Character Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(12, 2, 5, 5)); // Rows, Columns, Horizontal Gap, Vertical Gap

        String[] labels = {"Last Name:", "First Name:", "Gender:", "Date of Birth (YYYY-MM-DD):", "Physical Age:", "Percentile:", "Strength:", "Dexterity:", "Intelligence:", "Constitution:"};
        JTextField[] fields = new JTextField[labels.length];

        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i]);
            panel.add(label);
            JTextField field = new JTextField();
            fields[i] = field;
            panel.add(field);
        }

        JButton addButton = new JButton("Add Character");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get data from text fields and create a new character
                String lastName = fields[0].getText();
                String firstName = fields[1].getText();
                String gender = fields[2].getText();
                LocalDate dob = LocalDate.parse(fields[3].getText());
                int physicalAge = Integer.parseInt(fields[4].getText());
                int percentile = Integer.parseInt(fields[5].getText());
                int strength = Integer.parseInt(fields[6].getText());
                int dexterity = Integer.parseInt(fields[7].getText());
                int intelligence = Integer.parseInt(fields[8].getText());
                int constitution = Integer.parseInt(fields[9].getText());

                Character newCharacter = new Character(firstName, lastName, gender, dob, physicalAge, percentile, strength, dexterity, intelligence, constitution);
                addCharacter(newCharacter);
                writeToFile(testPath);
                JOptionPane.showMessageDialog(frame, "Character added successfully!");
                for (JTextField field : fields) {
                    field.setText("");
                }
            }
        });

        panel.add(addButton);

        frame.add(panel);
        frame.setVisible(true);
    }
}
