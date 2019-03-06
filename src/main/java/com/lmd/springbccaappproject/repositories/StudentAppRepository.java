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
        return jdbc.query("SELECT * FROM student_applications ORDER BY name", this::mapRowToStudentAppInfo);
    }

    public StudentAppInfo findById(Integer id) {
        Object[] args = { id };
        return jdbc.queryForObject("SELECT * FROM student_applications where id = ?", this::mapRowToStudentAppInfo,
                args);
    }

    public List<StudentAppInfo> findBySchool(String highSchool) {
        Object[] args = { highSchool };
        return jdbc.query("SELECT * FROM student_applications WHERE high_school = ? ORDER BY name",
                this::mapRowToStudentAppInfo, args);
    }

    public List<StudentAppInfo> findByEligibility(Boolean eligibility) {
        Object[] args = { eligibility };
        return jdbc.query("SELECT * FROM student_applications WHERE eligibility = ? ORDER BY name",
                this::mapRowToStudentAppInfo, args);
    }

    public StudentAppInfo mapRowToStudentAppInfo(ResultSet rs, int rowNum) throws SQLException {
        return new StudentAppInfo(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("phone_number"),
                rs.getString("email"), rs.getString("high_school"), rs.getString("graduation_date"),
                rs.getBoolean("eligibility"), rs.getString("prior_knowledge"), rs.getString("current_plan"),
                rs.getString("aptitude"), rs.getString("passion"), rs.getString("dedication"));
    }
}