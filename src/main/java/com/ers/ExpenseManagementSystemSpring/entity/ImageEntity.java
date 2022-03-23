package com.ers.ExpenseManagementSystemSpring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	
	@OneToOne
	@JoinColumn(name = "reimbursement_id")
	private ReimbursementEntity reimbursementEntity;
	
	@Column(name = "image_name")
	private String imageName;
	
	@Column(name = "image_type")
	private String imageType;
	
	@Lob
	private byte[] imageData;
	
	// Constructor for new images
		public ImageEntity(int imageName2, int imageType2, byte[] imageData2) {
		
	}

	public ImageEntity(int reimbursementId, String imageName, String imageType,
			byte[] imageData) {
		this.reimbursementEntity = new ReimbursementEntity(reimbursementId);
		this.imageName = imageName;
		this.imageType = imageType;
		this.imageData = imageData;
	}
	
	
	
}
