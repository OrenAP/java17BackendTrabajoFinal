package com.orenap.backendenrollmentrecord.controller;

import com.orenap.backendenrollmentrecord.dto.CourseDTO;
import com.orenap.backendenrollmentrecord.dto.GenericResponse;
import com.orenap.backendenrollmentrecord.model.Course;
import com.orenap.backendenrollmentrecord.service.impl.CourseServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {
  private final CourseServiceImpl service;
  @Qualifier("courseMapper")
  private final ModelMapper modelMapper;

  @GetMapping
  public ResponseEntity<List<CourseDTO>> readAll() throws Exception{
    List<CourseDTO> list = service.readAll().stream().map(this::convertToDto).toList();
    return ResponseEntity.ok(list);
  }

  @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<CourseDTO>> radById(@PathVariable("id") Integer id) throws Exception{
        Course obj = service.readById(id);
        return ResponseEntity.ok(new GenericResponse<>(200, "success", Arrays.asList(convertToDto(obj))));
    }

    @PostMapping
    public ResponseEntity<CourseDTO> save(@Valid @RequestBody CourseDTO dto) throws Exception{
        Course obj = service.save(convertToEntity(dto));
        return new ResponseEntity <>(convertToDto(obj), HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<CourseDTO> update(@Valid @RequestBody CourseDTO dto, @PathVariable("id") Integer id) throws Exception{
        Course obj = service.update(convertToEntity(dto), id);
        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private CourseDTO convertToDto(Course entity){
        return modelMapper.map(entity, CourseDTO.class);
    }

    private Course convertToEntity(CourseDTO dto){
        return modelMapper.map(dto, Course.class);
    }

}
