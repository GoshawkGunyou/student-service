package com.example.studentservice.service.impl;

import com.example.studentservice.assembler.StudentAssembler;
import com.example.studentservice.domain.grade.Grade;
import com.example.studentservice.domain.schoolclasses.ClassInfo;
import com.example.studentservice.domain.student.Student;
import com.example.studentservice.dto.StudentDTO;
import com.example.studentservice.mapper.GradeMapper;
import com.example.studentservice.mapper.StudentMapper;
import com.example.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    GradeMapper gradeMapper;

    @Override
    public List<Student> findInClass(Integer classId) {
        return studentMapper.findAllByClassId(classId);
    }

    @Override
    public List<Student> findInClass(String className) {
        return null;
    }



    @Override
    public Integer insert(Student student) {
        // find last insereted student and find serial based on that + 1
        student.setSerial(parseSerial(studentMapper.findLast()));
        return studentMapper.add(student);
    }

    /**
     *
     * @param serial studentSerial to parse into int
     * @return int representation of serial
     */
    private Integer parseSerial(String serial) {
        return Integer.parseInt(serial.substring(serial.length() - 5));
    }


    @Override
    public Student findById(Integer id) {
        return null;
    }

    @Override
    public StudentDTO getInfo(String serial, String name) {
        if (serial == null && name == null) {
            return null;
        }
        StudentDTO studentDTO = null;
        Student student = new Student();
        student.setName("".equals(name) ? null : name);
        student.setSerial("".equals(serial) ? null : serial);
        student = studentMapper.findByStudent(student);
        if (student == null)
            return null;
        ClassInfo classInfo = student.getClassInfo();
//        Grade grade = gradeMapper.findByStudentSerialAndName(student);
        List<Grade> grades = gradeMapper.findByStudentId(student.getId());
        if (grades != null) {
            studentDTO = StudentAssembler.create(grades, student, classInfo);
        }
        return studentDTO;
    }
}
