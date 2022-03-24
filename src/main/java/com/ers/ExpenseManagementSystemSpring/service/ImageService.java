package com.ers.ExpenseManagementSystemSpring.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ers.ExpenseManagementSystemSpring.exception.SystemException;
import com.ers.ExpenseManagementSystemSpring.pojo.ImagePojo;

public interface ImageService {
	public ImagePojo save(MultipartFile image) throws SystemException ;
	public ImagePojo getImage(String imageId) ;
	public List<ImagePojo> getAllFiles();
}
