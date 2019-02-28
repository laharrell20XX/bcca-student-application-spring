package com.lmd.springbccaappproject.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import java.util.List;

import com.lmd.springbccaappproject.models.StudentAppInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentAppRepository {
    public JdbcTemplate jdbc;

    @Autowired
    public StudentAppRepository(JdbcTemplate jdbcTemplate) {
        jdbc = jdbcTemplate;
    }

    public void save(StudentAppInfo application) {
        Date gradDate = application.toDate();
        jdbc.update(
                "INSERT into student_applications (name, age, phone_number, email, high_school, graduation_date, eligibility, prior_knowledge, current_plan, aptitude, passion, dedication) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                application.name, application.age, application.phoneNumber, application.email, application.highSchool,
                gradDate, application.eligibility, application.priorKnowledge, application.currentPlan,
                application.aptitude, application.passion, application.dedication);
    }

    public List<StudentAppInfo> findAll() {
        return jdbc.query(
                "SELECT id, name, age, phone_number, email, high_school, graduation_date, eligibility, prior_knowledge, current_plan, aptitude, passion, dedication FROM student_applications",
                this::mapModelToStudentAppInfo);
    }

    private StudentAppInfo mapModelToStudentAppInfo(ResultSet rs, int rowNum) throws SQLException {
        return new StudentAppInfo(rs.getString("name"), rs.getInt("age"), rs.getString("phone_number"),
                rs.getString("email"), rs.getString("high_school"), rs.getString("graduation_date"),
                rs.getBoolean("eligibility"), rs.getString("prior_knowledge"), rs.getString("current_plan"),
                rs.getString("aptitude"), rs.getString("passion"), rs.getString("dedication"));
    }
}