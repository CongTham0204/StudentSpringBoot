package com.student.manager.service;

import com.student.manager.entity.Image;

public interface ImageService {
    Image saveImage(byte[] bytes);
    
    String loadById();
}
