package com.orenap.backendenrollmentrecord.config;

import com.orenap.backendenrollmentrecord.dto.CourseDTO;
import com.orenap.backendenrollmentrecord.dto.StudentDTO;
import com.orenap.backendenrollmentrecord.model.Course;
import com.orenap.backendenrollmentrecord.model.Student;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean("studentMapper")
    public ModelMapper studentMapper(){
        ModelMapper mapper = new ModelMapper();
        //Lectura
        TypeMap<Student, StudentDTO> typeMap1 = mapper.createTypeMap(Student.class, StudentDTO.class);
        typeMap1.addMapping(Student::getName,(dest, v)->dest.setNameStudent((String) v));

        //Escritura
        TypeMap<StudentDTO, Student> typeMap2 = mapper.createTypeMap(StudentDTO.class, Student.class);
        typeMap2.addMapping(StudentDTO::getNameStudent,(dest, v)->dest.setName((String) v));
        return mapper;
    }

    @Bean("courseMapper")
    public ModelMapper courseMapper(){
        ModelMapper mapper = new ModelMapper();
        //Lectura
        TypeMap<Course, CourseDTO> typeMap1 = mapper.createTypeMap(Course.class, CourseDTO.class);
        typeMap1.addMapping(Course::getName,(dest, v)->dest.setNameCourse((String) v));

        //Escritura
        TypeMap<CourseDTO, Course> typeMap2 = mapper.createTypeMap(CourseDTO.class, Course.class);
        typeMap2.addMapping(CourseDTO::getNameCourse,(dest, v)->dest.setName((String) v));
        return mapper;
    }
    @Bean("defaultMapper")
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }


}