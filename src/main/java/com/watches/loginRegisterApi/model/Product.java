package com.watches.loginRegisterApi.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Product {
	
//	id:number,
//    model:string,
//    price:number,
//    info:string,
//    picture: string,
//    smallInfo: string,
//    cartAdded: boolean
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer productId ;
	double price;
	boolean cartAdded;
	String model;
	String info;
	String smallInfo;
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name = "product_images",
		joinColumns= {
				@JoinColumn(name = "product_id")
		},
		inverseJoinColumns= {
				@JoinColumn(name = "image_id")
		})
	private ImageModel productImages;
	
	
	public ImageModel getProductImages() {
		return productImages;
	}
	public void setProductImages(ImageModel productImages) {
		this.productImages = productImages;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int id, double price, boolean cartAdded, String model, String info,
			String smallInfo) {
		super();
		this.productId = id;
		this.price = price;
		this.cartAdded = cartAdded;
		this.model = model;
		
		this.info = info;
		this.smallInfo = smallInfo;
	}
	public int getId() {
		return productId;
	}
	public void setId(int id) {
		this.productId = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isCartAdded() {
		return cartAdded;
	}
	public void setCartAdded(boolean cartAdded) {
		this.cartAdded = cartAdded;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getSmallInfo() {
		return smallInfo;
	}
	public void setSmallInfo(String smallInfo) {
		this.smallInfo = smallInfo;
	}
}
