package com.example.restful.controller;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;

import com.example.restful.dao.Student;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@SuppressWarnings("rawtypes")
public class StudentsController {

    private ArrayList<Student> studentRepo = new ArrayList<Student>();

    @RequestMapping(value = "/create-student", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createStudent(@RequestBody String input)
            throws JsonMappingException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Student student = mapper.readValue(input, Student.class);
        studentRepo.add(student);

        return new ResponseEntity(HttpStatus.OK);

    }

    @RequestMapping(value = "/get-student", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String getStudent() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        StringWriter out = new StringWriter();
        mapper.writeValue(out, studentRepo);
        System.out.println(out);
        return out.toString();

    }

    @RequestMapping(value = "/student", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String getStudentByEmailId(@RequestParam String emailId)
            throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        StringWriter out = new StringWriter();
        Student studentEmail = null;
        for (Student student : studentRepo) {
            if (student.getEmailId().equals(emailId)) {
                studentEmail = student;
                break;
            }
        }
        mapper.writeValue(out, studentEmail);
        return out.toString();
    }

    @RequestMapping(value = "/delete-student", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody void deleteStudentByEmailId(@RequestParam String emailId)
            throws JsonGenerationException, JsonMappingException, IOException {
        for (Student student : studentRepo) {
            if (student.getEmailId().equals(emailId)) {
                studentRepo.remove(student);
                break;
            }
        }
    }
}