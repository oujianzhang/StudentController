/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.kaindorf.beans;

import java.time.LocalDate;

/**
 *
 * @author oujia
 */
public class Student {
    private String nachname;
    private String vorname;
    private int katalognummer;
    private String klasse;
    private char gender;
    private LocalDate birthdate;

    public Student(String nachname, String vorname, int katalognummer, String klasse, char gender, LocalDate birthdate) {
        this.nachname = nachname;
        this.vorname = vorname;
        this.katalognummer = katalognummer;
        this.klasse = klasse;
        this.gender = gender;
        this.birthdate = birthdate;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public int getKatalognummer() {
        return katalognummer;
    }

    public void setKatalognummer(int katalognummer) {
        this.katalognummer = katalognummer;
    }

    public String getKlasse() {
        return klasse;
    }

    public void setKlasse(String klasse) {
        this.klasse = klasse;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
    
    
}
