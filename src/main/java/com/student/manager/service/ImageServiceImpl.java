package com.student.manager.service;

import java.util.Base64;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.manager.authentication.PrincipalService;
import com.student.manager.entity.Image;
import com.student.manager.repository.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	PrincipalService principalService;

	@Autowired
	ImageRepository imageRepository;

	public Image saveImage(byte[] bytes) {

		int idStudent = principalService.getCurrentUser().getIdStudent();
		Optional<Image> imageOptional = imageRepository.findById(idStudent);

		if (!imageOptional.isPresent()) {
			Image image = new Image();
			image.setMSV(idStudent);
			image.setBytes(bytes);
			return imageRepository.save(image);

		} else {
			Image img = imageOptional.get();
			img.setBytes(bytes);
			return imageRepository.save(img);

		}

	}

	public String loadById() {
		int idImage = principalService.getCurrentUser().getIdStudent();
		Optional<Image> image = imageRepository.findById(idImage);
		if (image.isPresent()) {
			return Base64.getEncoder().encodeToString(image.get().getBytes());

		}

		return "";
	}

}
