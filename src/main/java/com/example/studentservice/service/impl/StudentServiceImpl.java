package com.example.studentservice.service.impl;

import com.example.studentservice.assembler.StudentAssembler;
import com.example.studentservice.domain.grade.Grade;
import com.example.studentservice.domain.schoolclasses.ClassInfo;
import com.example.studentservice.domain.student.Student;
import com.example.studentservice.dto.StudentDTO;
import com.example.studentservice.mapper.GradeMapper;
import com.example.studentservice.mapper.StudentMapper;
import com.example.studentservice.response.DataResponse;
import com.example.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    GradeMapper gradeMapper;

    @Override
    public DataResponse<List<Student>> findInClass(Integer classId) {
        DataResponse<List<Student>> dataResponse = new DataResponse<>();
        dataResponse.setDataObject(studentMapper.findAllByClassId(classId));
        if (dataResponse.getDataObject() == null)
            dataResponse.setMessage("Not found");
        else
            dataResponse.setMessage("Success");
        return dataResponse;
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
    public DataResponse<StudentDTO> getInfo(String serial, String name) {
        DataResponse<StudentDTO> dataResponse = new DataResponse<>();
        Student student = new Student();
        student.setName(name);
        student.setSerial(serial);
        student = studentMapper.findByStudent(student);
        if (student == null)
            return new DataResponse<>(null, "Student not found");
        ClassInfo classInfo = student.getClassInfo();
        List<Grade> grades = gradeMapper.findByStudentId(student.getId());
        if (grades != null) {
            dataResponse.setDataObject(StudentAssembler.create(grades, student, classInfo));
            dataResponse.setMessage("success");
        }
        return dataResponse;
    }
}
