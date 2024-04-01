package com.orenap.backendenrollmentrecord.service.impl;

import com.orenap.backendenrollmentrecord.model.Registration;
import com.orenap.backendenrollmentrecord.repo.IGenericRepo;
import com.orenap.backendenrollmentrecord.repo.IRegistrationRepo;
import com.orenap.backendenrollmentrecord.service.IRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl extends CRUDImpl<Registration, Integer> implements IRegistrationService {
    private final IRegistrationRepo repo;
    @Override
    protected IGenericRepo<Registration, Integer> getRepo() {
        return repo;
    }
}
