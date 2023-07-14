package com.example.demo.Student;
import com.example.demo.Student.Services.FileServices;
import org.apache.tomcat.util.file.ConfigurationSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentServices studentServices;
    private FileServices fileServices;
    @Autowired
    public StudentController(StudentServices studentServices, FileServices fileServices) {
        this.studentServices = studentServices;
        this.fileServices = fileServices;
    }

    @GetMapping("/view")
    public List<StudentInfo> getStudentInfo(){
        return studentServices.getStudentInfo();
    }
    @PostMapping("/add")
    public void registerNewStudent(@RequestBody StudentInfo studentInfo){
        studentServices.addNewStudent(studentInfo);
    }
    @DeleteMapping(path = "/delete/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentServices.deleteStudent(studentId);
    }
    @PutMapping(path = "update")
    public StudentInfo updateStudent(@RequestBody StudentInfo studentInfo){
        return studentServices.updateStudent(studentInfo);
    }
    @Value("${project.image}")
    String path;
    @PostMapping("/upload")
    public ResponseEntity<FileResponse> uploadImage(@RequestParam("image") MultipartFile image) {
        String filename = null;
        try{
            filename  = this.fileServices.uploadImage(path, image);
        }
        catch (IOException e){
            return new ResponseEntity<FileResponse>(new FileResponse(null,"File not uploaded"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<FileResponse>(new FileResponse(filename,"File uploaded successfully"), HttpStatus.OK);
    }

//    @PostMapping("/upload")
//    public  String uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
//        String path = "/home/vishal-gtcsys/IdeaProjects/demo/src/main/resources/static/image";
//        Files.copy(file.getInputStream(), Paths.get(path+ File.separator + file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
//        return "Uploaded Successfully";
//    }

}
