package com.example.demo.Student.Services;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
@Service
public interface FileServices{
    String uploadImage(String path, MultipartFile file) throws IOException;
}