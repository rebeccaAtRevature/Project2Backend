package com.ers.ExpenseManagementSystemSpring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ers.ExpenseManagementSystemSpring.entity.ImageEntity;

@Repository
public interface ImageDao extends JpaRepository<ImageEntity, Integer>{

	// Optional<ImageEntity> findByImageId(String imageId);

}
