package com.jayastudent.Hostel_crud.controller;

import com.jayastudent.Hostel_crud.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
@RestController
public class HostelController {
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    @Autowired
    @Lazy
    private RestTemplate restTemplate;
    static final String STUDENT_URL_MS = "http://springboot-mysql-docker:8090/";


    @GetMapping("/find/{roll}")
    public String fetchStudent(@PathVariable int roll) {
Student student = restTemplate.exchange(STUDENT_URL_MS+"all/"+roll, HttpMethod.GET,null, Student.class).getBody();
        System.out.println("Student from Student Report Project:"+student);
        return restTemplate.exchange(STUDENT_URL_MS+"all/"+roll, HttpMethod.GET,null, String.class).getBody();
    }

    @GetMapping("/find")
    public String fetchStudents(){
       return restTemplate.exchange(STUDENT_URL_MS+"all", HttpMethod.GET,null, String.class).getBody();

    }
//http://localhost:8090/all/1
    @PostMapping("/addStudent")
    public String include(@RequestBody Student student){
      return restTemplate.postForObject(STUDENT_URL_MS+"add", student, String.class);
    }
}
