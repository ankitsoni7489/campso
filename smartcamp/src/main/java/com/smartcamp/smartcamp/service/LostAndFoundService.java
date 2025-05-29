package com.smartcamp.smartcamp.service;



import com.smartcamp.smartcamp.model.LostFound;
import com.smartcamp.smartcamp.repo.LostAndFoundRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LostAndFoundService {

    @Autowired
    private LostAndFoundRepo lostFoundRepo;

    public void saveItem(LostFound item) {
    	lostFoundRepo.save(item);
    }

    public List<LostFound> getAllItems() {
        return lostFoundRepo.findAll();
    }
}
