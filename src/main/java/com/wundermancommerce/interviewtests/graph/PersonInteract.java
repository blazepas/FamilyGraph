package com.wundermancommerce.interviewtests.graph;

import java.util.ArrayList;
import java.util.List;

public class PersonInteract {
    private String surname;
    private String email;
    private List familia = new ArrayList();

    public PersonInteract(String surname, String email){
        this.surname=surname;
        this.email=email;
    }

    public List<PersonInteract> getFamilia() {
        return familia;
    }

    public String getFamilyMember(){
        String memberSur="";
        int interPerson = getFamilia().size();
        for(int i=0; i<interPerson;i++){
            System.out.println(getFamilia().get(i).surname);
            memberSur = getFamilia().get(i).surname;
        }
        return memberSur;
    }


    public void addFamilyMember(int weight, PersonInteract personInteract) {
        familia.add(weight,personInteract);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}