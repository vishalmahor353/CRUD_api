package com.example.demo.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.cglib.core.Local;
import java.time.LocalDate;
import java.time.Period;
@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student_information")
public class StudentInfo {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName =  "student_sequence",
            allocationSize =  1
    )
    @GeneratedValue(
            strategy = GenerationType.UUID,
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient
    private Integer age;
}
