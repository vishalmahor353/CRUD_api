package com.example.demo.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
@Transactional
public interface StudentRepository
        extends JpaRepository<StudentInfo, Long>{

//    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<StudentInfo> findStudentByEmail(String email);

}