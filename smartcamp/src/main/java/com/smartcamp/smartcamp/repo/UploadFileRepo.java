package com.smartcamp.smartcamp.repo;

import com.smartcamp.smartcamp.model.UploadFile;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

//Repository for UploadedFile
public interface UploadFileRepo extends JpaRepository<UploadFile, Integer> {
	
	void deleteByTrackingId(String trackingId);
	
	Optional<UploadFile> findByTrackingId(String trackingId);
}
