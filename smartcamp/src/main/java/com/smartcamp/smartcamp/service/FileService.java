package com.smartcamp.smartcamp.service;


import com.smartcamp.smartcamp.model.UploadFile;

import com.smartcamp.smartcamp.repo.UploadFileRepo;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;



@Service
public class FileService {

    @Autowired
    private UploadFileRepo fileRepo;
    
    
    public UploadFile convertToEntity(MultipartFile file, String title, String subject, String uploadedBy) throws IOException {
        UploadFile uploadFile = new UploadFile();
        uploadFile.setTitle(title);
        uploadFile.setSubject(subject);
        uploadFile.setUploadedBy(uploadedBy);
        uploadFile.setFileType(file.getContentType());
        uploadFile.setFileData(file.getBytes());
        uploadFile.setFileSize((long) file.getBytes().length); // or file.getSize()
        return fileRepo.save(uploadFile);
    }

	public UploadFile saveFile(MultipartFile file) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<UploadFile> getAllFiles() {
        return fileRepo.findAll();
    }

    public UploadFile getFileById(Integer id) {
        return fileRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("File not found with id: " + id));
    }
    
    @Transactional
	public void deleteFileByTrack(String trackid) {
        fileRepo.deleteByTrackingId(trackid);
    }

    
   
}
