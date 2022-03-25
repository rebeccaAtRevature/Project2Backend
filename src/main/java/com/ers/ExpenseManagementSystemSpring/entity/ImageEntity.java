package com.ers.ExpenseManagementSystemSpring.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "image_details")
public class ImageEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "image_id")
	private int imageId;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "reimbursement_id")
	private ReimbursementEntity reimbursementEntity;
	@Column(name = "image_name")
	private String imageName;
	@Column(name = "image_type")
	private String imageType;
	@Column(name = "image_size")
	private Long imageSize;
	@Lob
	// @Type(type = "org.hibernate.type.BinaryType")
	private byte[] imageData;

	public ImageEntity(String imageName, String imageType, byte[] imageData) {
		this.imageName = imageName;
		this.imageType = imageType;
		this.imageData = imageData;
	}

	// Constructor for persisting new images
	public ImageEntity(ReimbursementEntity reimbursementEntity, String imageName, String imageType, Long imageSize,
			byte[] imageData) {
		this.reimbursementEntity = reimbursementEntity;
		this.imageName = imageName;
		this.imageType = imageType;
		this.imageSize = imageSize;
		this.imageData = imageData;
	}
	
	
	
}
