package com.example.demo.Student.Services.FileServiceImpl;

import com.example.demo.Student.Services.FileServices;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
@Service

public class Impl implements FileServices {
    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {

        // file name
        String name = file.getOriginalFilename();
        // file path
        String filepath = path + File.separator + name;

        // create folder
        File f = new File(path);
        if(!f.exists()){
            f.mkdir();
        }
        // copy file
        Files.copy(file.getInputStream(), Paths.get(filepath));
        return name;
    }
}
