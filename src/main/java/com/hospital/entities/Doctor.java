package com.hospital.entities;

public class Doctor {

   private int id;
   private String firstName;
   private String lastName;
   private String specialization;
   private String email;

   public void setId(int id) {
      this.id = id;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public void setSpecialization(String specialization) {
      this.specialization = specialization;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public void setHostpialId(int hostpialId) {
      this.hostpialId = hostpialId;
   }

   public int getId() {
      return id;
   }

   public String getFirstName() {
      return firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public String getSpecialization() {
      return specialization;
   }

   public String getEmail() {
      return email;
   }

   public int getHostpialId() {
      return hostpialId;
   }

   private int hostpialId;







}
