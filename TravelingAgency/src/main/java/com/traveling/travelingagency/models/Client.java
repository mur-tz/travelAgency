package com.traveling.travelingagency.models;

import java.time.LocalDate;

public class Client extends Base{
    private String Name, LastName1, LastName2, Email, ClientIdentification, Nationality, Gender, ZipCode, Role, Password;
    private int Phone;
    private LocalDate BirthDate;

    public Client(int id, String name, String lastName1, String lastName2, String email, String clientIdentification, String nationality, String gender, String zipCode, String role, String password, int phone, LocalDate birthDate) {
        super(id);
        Name = name;
        LastName1 = lastName1;
        LastName2 = lastName2;
        Email = email;
        ClientIdentification = clientIdentification;
        Nationality = nationality;
        Gender = gender;
        ZipCode = zipCode;
        Role = role;
        Password = password;
        Phone = phone;
        BirthDate = birthDate;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Client(int id) {
        super(id);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName1() {
        return LastName1;
    }

    public void setLastName1(String lastName1) {
        LastName1 = lastName1;
    }

    public String getLastName2() {
        return LastName2;
    }

    public void setLastName2(String lastName2) {
        LastName2 = lastName2;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getClientIdentification() {
        return ClientIdentification;
    }

    public void setClientIdentification(String clientIdentification) {
        ClientIdentification = clientIdentification;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getZipCode() {
        return ZipCode;
    }

    public void setZipCode(String zipCode) {
        ZipCode = zipCode;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int phone) {
        Phone = phone;
    }

    public LocalDate getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        BirthDate = birthDate;
    }
}
