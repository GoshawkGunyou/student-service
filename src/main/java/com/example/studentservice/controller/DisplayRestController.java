package com.example.studentservice.controller;

import com.example.studentservice.domain.student.Student;
import com.example.studentservice.dto.ClassInfoDTO;
import com.example.studentservice.dto.StudentDTO;
import com.example.studentservice.dto.StudentGradeDTO;
import com.example.studentservice.form.ClassQuery;
import com.example.studentservice.form.ScoreQuery;
import com.example.studentservice.form.StudentQuery;
import com.example.studentservice.response.DataResponse;
import com.example.studentservice.service.ClassInfoService;
import com.example.studentservice.service.GradeService;
import com.example.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/display")
public class DisplayRestController {
    @Autowired
    GradeService gradeService;

    @Autowired
    StudentService studentService;

    @Autowired
    ClassInfoService classInfoService;

    @RequestMapping("/grade")
    @CrossOrigin
    public DataResponse<StudentGradeDTO> toGrade(@RequestBody ScoreQuery q) {
        if (q == null || q.isNull()) return new DataResponse<>(null, "Empty query");
        return gradeService.getGradeOf(q);
    }

    @RequestMapping("/loadStudents")
    @CrossOrigin
    public DataResponse<List<Student>> students(@RequestBody Integer classId) {
        if (classId == null) return new DataResponse<>(null, "Invalid query");
        return studentService.findInClass(classId);
    }

    @RequestMapping("/student")
    @CrossOrigin
    public DataResponse<StudentDTO> findStudent(@RequestBody StudentQuery studentQuery) {
        if (studentQuery == null || studentQuery.isNull()) return null;
        return studentService.getInfo(studentQuery.getStudentSerial(), studentQuery.getStudentName());
    }

    @RequestMapping("/classInfo")
    @CrossOrigin
    public DataResponse<ClassInfoDTO> findClassInfo(@RequestBody ClassQuery classQuery) {
        if (classQuery == null || classQuery.isNull()) return new DataResponse<>(null, "Invalid Query");
        DataResponse<ClassInfoDTO> dataResponse = new DataResponse<>();
        dataResponse.setData(classInfoService.getClassInfo(classQuery.getClassName(), classQuery.getClassSerial()));
        return dataResponse;
    }

}
