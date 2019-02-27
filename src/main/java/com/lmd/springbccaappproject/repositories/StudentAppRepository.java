package com.lmd.springbccaappproject.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

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
                "INSERT into student_applications (name, age, phone_number, email, high_school, graduation_date, prior_knowledge, current_plan, aptitude, passion, dedication) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                application.name, application.age, application.phoneNumber, application.email, application.highSchool,
                gradDate, application.priorKnowledge, application.currentPlan, application.aptitude,
                application.passion, application.dedication);
    }

    private StudentAppInfo mapModelToStudentAppInfo(ResultSet rs, int rowNum) throws SQLException {
        return new StudentAppInfo(rs.getString("name"), rs.getInt("age"), rs.getString("phone_number"),
                rs.getString("email"), rs.getString("high_school"), rs.getDate("graduation_date"),
                rs.getString("prior_knowledge"), rs.getString("current_plan"), rs.getString("aptitude"),
                rs.getString("passion"), rs.getString("dedication"));
    }
}