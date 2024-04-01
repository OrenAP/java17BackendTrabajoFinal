package com.orenap.backendenrollmentrecord.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegistrationDetailDTO {
    @JsonManagedReference
    private RegistrationDTO registration;
    @NotNull
    private CourseDTO course;
    @NotNull
    @Size(min=3, max=100)
    private String classroom;
}
