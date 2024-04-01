package com.orenap.backendenrollmentrecord.service.impl;

import com.orenap.backendenrollmentrecord.model.Student;
import com.orenap.backendenrollmentrecord.repo.IGenericRepo;
import com.orenap.backendenrollmentrecord.repo.IStudentRepo;
import com.orenap.backendenrollmentrecord.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends CRUDImpl<Student, Integer> implements IStudentService {
    private final IStudentRepo repo;
    @Override
    protected IGenericRepo<Student, Integer> getRepo() {
        return repo;
    }
}
