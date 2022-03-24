package com.ers.ExpenseManagementSystemSpring.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ers.ExpenseManagementSystemSpring.dao.ImageDao;
import com.ers.ExpenseManagementSystemSpring.entity.ImageEntity;
import com.ers.ExpenseManagementSystemSpring.exception.SystemException;
import com.ers.ExpenseManagementSystemSpring.pojo.ImagePojo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ImageServiceImpl implements ImageService {
	
	
    private final ImageDao imageDao;

    @Autowired
    public ImageServiceImpl(ImageDao imageDao) {
        this.imageDao = imageDao;
    }
    
    @Override
    public ImagePojo save(MultipartFile reimbursementUpload) throws SystemException {
    	ImageEntity imageEntity = null;
    	try {
    		imageEntity = new ImageEntity();
    		imageEntity.setImageName(StringUtils.cleanPath(reimbursementUpload.getOriginalFilename()));
    		imageEntity.setImageType(reimbursementUpload.getContentType());
    		imageEntity.setImageData(reimbursementUpload.getBytes());
    		imageEntity.setImageSize(reimbursementUpload.getSize());
    	} catch (IOException e) {
    		throw new SystemException();
    	}
        
        imageDao.saveAndFlush(imageEntity);
        
        String downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/")
                .path(imageEntity.getImageId())
                .toUriString();
        ImagePojo imagePojo = new ImagePojo(imageEntity.getImageId(),imageEntity.getImageName(),imageEntity.getImageType(),imageEntity.getImageSize(),downloadURL,imageEntity.getImageData());
        
        return imagePojo;
    }

	@Override
	public ImagePojo getImage(String imageId) {
		Optional<ImageEntity> optional = imageDao.findById(imageId);
		ImagePojo imagePojo = null;
		if (optional.isPresent()) {
			ImageEntity imageEntity = optional.get();
			String downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/")
                    .path(imageEntity.getImageId())
                    .toUriString();
			imagePojo = new ImagePojo(imageEntity.getImageId(),imageEntity.getImageName(),imageEntity.getImageType(),imageEntity.getImageSize(),downloadURL,imageEntity.getImageData());
		}
		return imagePojo;
	}

	@Override
	public List<ImagePojo> getAllFiles() {
		log.info("Entering getAllFiles() in ImageServiceImpl");
		
		List<ImagePojo> allImagePojo = imageDao.findAll().stream().map(this::mapToImagePojo).collect(Collectors.toList());
		
		log.info("Exiting getAllFiles() in ImageServiceImpl");
		return allImagePojo;
	}
	
	private ImagePojo mapToImagePojo(ImageEntity imageEntity) {
        String downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath()
                                                        .path("/api/")
                                                        .path(imageEntity.getImageId())
                                                        .toUriString();
        ImagePojo imagePojo = new ImagePojo();
        imagePojo.setImageId(imageEntity.getImageId());
        imagePojo.setImageName(imageEntity.getImageName());
        imagePojo.setImageType(imageEntity.getImageType());
        imagePojo.setImageSize(imageEntity.getImageSize());
        imagePojo.setImageUrl(downloadURL);

        return imagePojo;
    }

}