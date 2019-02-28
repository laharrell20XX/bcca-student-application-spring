package com.lmd.springbccaappproject.models;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class StudentAppInfo {

    @NotBlank
    public String name;

    public void setName(String name) {
        this.name = name;
    }

    @NotBlank
    @Size(min = 0)
    public Integer age;

    public void setAge(Integer age) {
        this.age = age;
    }

    @NotBlank
    @Size(min = 10)
    public String phoneNumber;

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @NotBlank
    public String email;

    public void setEmail(String email) {
        this.email = email;
    }

    @NotBlank
    public String highSchool;

    public void setHighSchool(String highSchool) {
        this.highSchool = highSchool;
    }

    @NotBlank
    public String graduationDate;

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    @NotBlank
    public boolean eligibility;

    public void setEligibility(boolean eligibility) {
        this.eligibility = eligibility;
    }

    @NotBlank
    public String priorKnowledge;

    public void setPriorKnowledge(String priorKnowledge) {
        this.priorKnowledge = priorKnowledge;
    }

    @NotBlank
    public String currentPlan;

    public void setCurrentPlan(String currentPlan) {
        this.currentPlan = currentPlan;
    }

    @NotBlank
    public String aptitude;

    public void setAptitude(String aptitude) {
        this.aptitude = aptitude;
    }

    @NotBlank
    public String passion;

    public void setPassion(String passion) {
        this.passion = passion;
    }

    @NotBlank
    public String dedication;

    public void setDedication(String dedication) {
        this.dedication = dedication;
    }

    public Date toDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition position = new ParsePosition(0);
        System.out.println(graduationDate);
        return formatter.parse(graduationDate, position);
    }

    public StudentAppInfo(String name, Integer age, String phoneNumber, String email, String highSchool,
            String graduationDate, boolean eligibility, String priorKnowledge, String currentPlan, String aptitude,
            String passion, String dedication) {

        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.highSchool = highSchool;
        this.graduationDate = graduationDate;
        this.eligibility = eligibility;
        this.priorKnowledge = priorKnowledge;
        this.currentPlan = currentPlan;
        this.aptitude = aptitude;
        this.passion = passion;
        this.dedication = dedication;
    }

    public String toString() {
        return String.format("(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)", name, age, phoneNumber, email,
                highSchool, graduationDate, eligibility, priorKnowledge, currentPlan, aptitude, passion, dedication);
    }
}