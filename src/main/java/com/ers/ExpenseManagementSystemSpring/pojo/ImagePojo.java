package com.ers.ExpenseManagementSystemSpring.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImagePojo {
	
	private String imageId;
	private String imageName;
	private String imageType;
	private Long imageSize;
	private String imageUrl;
	private byte[] imageData;
}
