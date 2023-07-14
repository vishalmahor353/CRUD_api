package com.example.demo.Student;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
public class StudentServices{
    public final StudentRepository studentRepository;
    public StudentServices(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<StudentInfo> getStudentInfo() {
        return studentRepository.findAll();
//        return List.of(new StudentInfo(
//                101L,
//                "Vishal Mahor",
//                "vishal3@gamil.com",
//                LocalDate.of(2003, Month.MARCH, 15),
//                2
//        ));
    }
    public void addNewStudent(StudentInfo studentInfo) {
        Optional<StudentInfo> studentInfoOptional = studentRepository.
                findStudentByEmail(studentInfo.getEmail());
        if (studentInfoOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email taken");
        }
        studentRepository.save(studentInfo);
    }
    public void deleteStudent(long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("Student with id " + studentId + " does not exits");
        }
        studentRepository.deleteById(studentId);
    }
    public StudentInfo updateStudent(StudentInfo dta) {
        StudentInfo studentInfo = studentRepository.findById(dta.getId()).
                orElseThrow(()-> new IllegalStateException((
                        "Student with id" + dta.getId() + " does not exits")));
        if(dta.getName() != null && dta.getName().length()>0 && !Objects.equals(studentInfo.getName(), dta.getName())){
            studentInfo.setName(dta.getName());
        }
        if(dta.getEmail() != null && dta.getEmail() .length()>0 && !Objects.equals(studentInfo.getEmail(), dta.getEmail() )){
            Optional<StudentInfo> studentInfoOptional = studentRepository.findStudentByEmail(dta.getEmail() );
            if(studentInfoOptional.isPresent()){
                throw new IllegalStateException("Email taken");
            }
            studentInfo.setEmail(dta.getEmail() );
        }
        return studentRepository.save(studentInfo);
    }
}