package com.wundermancommerce.interviewtests.graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SolutionTwo {
    public static void main(String[] args) {
        String line;
        BufferedReader quickBufferedReader;
        BufferedReader bufferedReaderLine;
        int counter = 0;
        int counterList = 0;
        int familySizeTwo = 1;
        ArrayList<PersonInteract> peopleList = new ArrayList<PersonInteract>();
        ArrayList<ArrayList> lists = new ArrayList<ArrayList>();

        //Automates Lists
        try {
            //count how many nodes is needed
            quickBufferedReader = new BufferedReader(new FileReader("src/test/resources/relationships.csv"));
            while (quickBufferedReader.ready()) {
                String checkNext = quickBufferedReader.readLine().trim();
                if (checkNext.isEmpty()) {
                    counterList++;
                }
            }
            //create family list
            for (int j = 0; j < counterList; j++) {
                lists.add(new ArrayList());
            }
        } catch (FileNotFoundException fn) {
            fn.printStackTrace();
        } catch (IOException io) {
            io.printStackTrace();
        }

        //CREATE NODES !!
        try {
            //count how many nodes is needed
            quickBufferedReader = new BufferedReader(new FileReader("src/test/resources/people.csv"));
            while (quickBufferedReader.readLine() != null) counter++;

            //read line
            bufferedReaderLine = new BufferedReader(new FileReader("src/test/resources/people.csv"));
            for (int j = 0; j < counter; j++) {
                if ((line = bufferedReaderLine.readLine()) != null) {
                    String[] valueOne = line.split(",");
                    PersonInteract personInteract = new PersonInteract(valueOne[1], valueOne[2]);
                    peopleList.add(personInteract);
                }
            }
            //Read all Nodes in memory
            System.out.println("Show all people: ");
            for (PersonInteract personInteract : peopleList) {
                System.out.println(personInteract.getSurname());
            }

            //Fill member list for each person
            for (int i = 0; i < peopleList.size(); i++) {
                peopleList.get(i).addFamilyMember(0, peopleList.get(1));
                peopleList.get(i).addFamilyMember(1, peopleList.get(2));
            }

            ////// compare with member if member is not there increment counter
            for (int i = 0; i < peopleList.size(); i++) {
                System.out.println("\nFAMILIA FOR " + peopleList.get(i).getSurname() + " is : ");
                familySizeTwo = familySizeTwo + peopleList.get(i).getFamilia().size();
                System.out.println("=======================================");
                for (int j = 0; j < peopleList.get(i).getFamilia().size(); j++) {
                    if (peopleList.get(i).getEmail() == peopleList.get(i).getFamilia().get(j).getEmail()) {
                        familySizeTwo = familySizeTwo - 1;
                    }
                }
                    peopleList.get(i).getFamilia();
                    peopleList.get(i).getFamilyMember();
                    System.out.println("THIS FAMILY IN TOTAL HAS " + familySizeTwo + " members");
                    familySizeTwo = 1;
                }
        } catch (FileNotFoundException fn) {
            fn.printStackTrace();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}