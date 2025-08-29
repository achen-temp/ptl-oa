package com.ptl.exercise.redolent;

public class Java_SchoolController {
    
}

/* 

import com.hackerrank.api.model.Student;
import com.hackerrank.api.model.Teacher;
import com.hackerrank.api.repository.StudentRepository;
import com.hackerrank.api.repository.TeacherRepository;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/school")
public class SchoolController {

    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    @Autowired
    public SchoolController(StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    // create teacher
    @PostMapping("/teacher")
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
        teacherRepository.save(teacher);
        return new ResponseEntity<>(teacher, HttpStatus.CREATED);
    }

    // create student
    @PostMapping("/student")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        studentRepository.save(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // add student to a teacher
    @PostMapping("/teacher/{teacherId}/addStudent")
    public ResponseEntity<Teacher> addStudentToTeacher(@PathVariable(value = "teacherId") Long teacherId,
                                                       @RequestBody Student addStudent) {
        //获取到teacher跟student对象，然后把student加入到teacher对象的数组中去
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        Student student = studentRepository.findById(addStudent.getId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        
        teacher.getStudents().add(student); 

      
        teacherRepository.save(teacher);
        studentRepository.save(student); 

        return new ResponseEntity<>(teacher, HttpStatus.CREATED);
    }

    // get students of a teacher
    @GetMapping("/teacher/{teacherId}/students")
    public ResponseEntity<Set<Student>> getStudentsOfATeacher(@PathVariable(value = "teacherId") Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        return new ResponseEntity<>(teacher.getStudents(), HttpStatus.OK);
    }

    // get teachers of a student
    @GetMapping("/student/{studentId}/teachers")
    public ResponseEntity<Set<Teacher>> getTeachersOfAStudent(@PathVariable(value = "studentId") Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        return new ResponseEntity<>(student.getTeachers(), HttpStatus.OK);
    }
}

*/