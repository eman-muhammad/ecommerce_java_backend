package com.project.services;

import com.project.database.Repository.ImageRepository;
import com.project.database.Entities.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageDao;

    public Image insert (Image image){
        return imageDao.save(image);
    }
}
