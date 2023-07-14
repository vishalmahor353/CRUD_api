//package com.example.demo.Student;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.List;
//
//@Configuration
//public class StudentConfig {
//    @Bean
//    CommandLineRunner commandLineRunner(StudentRepository repository){
//        return args -> {
//           StudentInfo raj = new StudentInfo(
//                101L,
//                "Raj Bhatiya",
//                "rj@gamil.com",
//                LocalDate.of(2003, Month.MARCH, 15)
//            );
//            StudentInfo vyom = new StudentInfo(
//                    102L,
//                    "Vyom Makwana",
//                    "vm3@gamil.com",
//                    LocalDate.of(2008, Month.FEBRUARY, 28)
//            );
////            repository.saveAll(List.of(raj,vyom));
//
//        };
//
//    }
//}
