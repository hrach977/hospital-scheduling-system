package com.hospital.entities;

import java.util.List;

public class Hospital {

    private int id;
    private String name;
    private String username;
    private String password;
    private List<Doctor> doctors;
    private List<String> services;

    public Hospital(String name, String username, String password, List<Doctor> doctors, List<String> services) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.doctors = doctors;
        this.services = services;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }
}
