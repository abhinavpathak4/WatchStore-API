//package com.watches.loginRegisterApi.controller;
//
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestPart;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//import com.watches.loginRegisterApi.model.Product;
//import com.watches.loginRegisterApi.service.ProductService;
//
//@RestController
//@CrossOrigin
//public class ProductController {
//	@Autowired
//	ProductService productService;
//
//	@PostMapping(value = {"/addNewProduct"}, consumes= {MediaType.MULTIPART_FORM_DATA_VALUE})
//	public Product addNewProduct(@RequestPart("product") Product product, @RequestPart("imageFile") MultipartFile file) {
//		return productService.addNewProduct(product,file);
//	}
//
//	@GetMapping("/getAllProducts")
//	public List<Product> getAll(){
//		return productService.getAllProducts();
//	}
//	
//	@DeleteMapping({"deleteProduct/{productId}"})
//	public void deleteProduct(@PathVariable("productId") Integer productId ) {
//		productService.deleteProductDetails(productId);
//	}
//	
//}



package com.watches.loginRegisterApi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.watches.loginRegisterApi.model.Product;
import com.watches.loginRegisterApi.service.ProductService;

@RestController
@CrossOrigin
public class ProductController {
	@Autowired
	ProductService productService;

	@PostMapping(value = {"/addNewProduct"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<Product> addNewProduct(@RequestPart("product") Product product, @RequestPart("imageFile") MultipartFile file) {
		Product addedProduct = productService.addNewProduct(product, file);
		return ResponseEntity.status(HttpStatus.CREATED).body(addedProduct);
	}

	@GetMapping("/getAllProducts")
	public ResponseEntity<List<Product>> getAll() {
		List<Product> products = productService.getAllProducts();
		return ResponseEntity.ok(products);
	}
	 
	@DeleteMapping("/deleteProduct/{productId}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("productId") Integer productId) {
		productService.deleteProductDetails(productId);
		return ResponseEntity.noContent().build();
	}
}

