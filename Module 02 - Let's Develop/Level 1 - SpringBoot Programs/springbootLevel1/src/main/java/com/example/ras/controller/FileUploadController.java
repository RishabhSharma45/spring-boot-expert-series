package com.example.ras.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/file")
public class FileUploadController {

	@Value("${file.upload-dir}")
    private String uploadDir;
	
	
	@PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
		
		if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Arre bhai, file to bhejo 😅");
        }
		
		 try {
	            // folder bana lo agar nahi hai
	            File dir = new File(uploadDir);
	            if (!dir.exists()) {
	                dir.mkdirs();
	            }
	            
	            // file ka poora path
	            File destinationFile = new File(dir, file.getOriginalFilename());

	            // file save
	            file.transferTo(destinationFile);

	            return ResponseEntity.ok(
	                "File safalta se upload ho gayi ✔️ : " + destinationFile.getAbsolutePath()
	            );

	        } catch (IOException e) {
	            return ResponseEntity.internalServerError()
	                    .body("Kuch gadbad ho gayi bhai 😓 File upload nahi hui");
	        }
		
		
	}
	
}
