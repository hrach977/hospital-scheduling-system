package com.hospital.entities;

public class Doctor {

   private int id;
   private String firstName;
   private String lastName;
   private Specialization specialization;
   private String email;
   private Long hospitalId;

   public Doctor(String firstName, String lastName, Specialization specialization, String email, Long hospitalId) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.specialization = specialization;
      this.email = email;
      this.hospitalId = hospitalId;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public void setSpecialization(Specialization specialization) {
      this.specialization = specialization;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public void setHospitalId(Long hospitalId) {
      this.hospitalId = hospitalId;
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

   public Specialization getSpecialization() {
      return specialization;
   }

   public String getEmail() {
      return email;
   }

   public Long getHospitalId() {
      return hospitalId;
   }

}
