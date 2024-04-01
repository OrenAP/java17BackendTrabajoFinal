package com.orenap.backendenrollmentrecord.service.impl;

import com.orenap.backendenrollmentrecord.model.Course;
import com.orenap.backendenrollmentrecord.repo.ICourseRepo;
import com.orenap.backendenrollmentrecord.repo.IGenericRepo;
import com.orenap.backendenrollmentrecord.service.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl extends CRUDImpl<Course, Integer> implements ICourseService {
    private final ICourseRepo repo;
    @Override
    protected IGenericRepo<Course, Integer> getRepo() {
        return repo;
    }
}
