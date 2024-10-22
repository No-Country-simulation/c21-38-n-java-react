package com.encuentratumascota.shelter.service;

import com.encuentratumascota.shelter.model.ImageDebugging;
import com.encuentratumascota.shelter.repository.IImageDebuggingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageDebuggingService implements IImageDebuggingService {


    @Autowired
    private IImageDebuggingRepository iImageDebuggingRepository;

    @Override
    public void saveImageDebugging(ImageDebugging imageDebugging) {
        iImageDebuggingRepository.save(imageDebugging);
    }

}
