package com.orenap.backendenrollmentrecord.repo;

import com.orenap.backendenrollmentrecord.model.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepo {
    public Student getStudentX(Student student){
        return student;
    }
}
