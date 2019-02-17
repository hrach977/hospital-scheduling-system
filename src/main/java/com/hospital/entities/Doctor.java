package com.hospital.entities;

import javax.persistence.*;

@Entity
@Table(name = "doctos")
public class Doctor {
   @Id
   @GeneratedValue(strategy = GenerationType.TABLE)
   private Long id;

   @Column(name = "user_name",nullable = false, unique = true)
   private String username;
   @Column(name = "first_name",nullable = false)
   private String firstName;
   @Column(name = "last_name",nullable = false)
   private String lastName;
   @Column(name = "specialization",nullable = false)
   private Specialization specialization;
   @Column(name = "email",nullable = false, unique = true)
   private String email;
   @Column(name = "phone_number",nullable = false, unique = true)
   private String phoneNumber;
   @Column(name = "hospitaId")
   private Long hospitalId;

   public Doctor(String username, String firstName, String lastName, Specialization specialization, String email, String phoneNumber, Long hospitalId) {
      this.username = username;
      this.firstName = firstName;
      this.lastName = lastName;
      this.specialization = specialization;
      this.email = email;
      this.phoneNumber = phoneNumber;
      this.hospitalId = hospitalId;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }
   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
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

   public Long getId() {
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

   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }

   public String getPhoneNumber() {
      return phoneNumber;
   }

   public Long getHospitalId() {
      return hospitalId;
   }

}
