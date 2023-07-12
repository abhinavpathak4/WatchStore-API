package com.watches.loginRegisterApi.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.watches.loginRegisterApi.model.ImageModel;
import com.watches.loginRegisterApi.model.Product;
import com.watches.loginRegisterApi.repository.ProductRepository;
import com.watches.loginRegisterApi.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	
	public Product addNewProduct(Product product) {
		return productRepository.save(product);
	}
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	public void deleteProductDetails(Integer productId) {
		productRepository.deleteById(productId);
	}
	
	

	public Product addNewProduct( Product product, MultipartFile file) {
		
		try {
			ImageModel images = uploadImage(file);
			product.setProductImages(images);
			return addNewProduct(product);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public ImageModel uploadImage(MultipartFile multipartFiles) throws IOException{
		
			ImageModel imageModel = new ImageModel(
					multipartFiles.getOriginalFilename(),
					multipartFiles.getContentType(),
					multipartFiles.getBytes()
					);
		return imageModel;
	}
}
