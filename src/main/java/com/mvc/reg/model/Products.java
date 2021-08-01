package com.mvc.reg.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="products")
public class Products implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	private String name ;
	private double price ;
	private String added_on ;
	private long category_id ;
	private String description ;
	private double rating ;
	private String image ;
	private int qty ; 
	
	
	
	public Products() {
		super();
	}
	
	public Products( String name, double price, String added_on, long category_id, String description,
			double rating, String image, int qty) {
		super();
		
		this.name = name;
		this.price = price;
		this.added_on = added_on;
		this.category_id = category_id;
		this.description = description;
		this.rating = rating;
		this.image = image;
		this.qty = qty;
	}

	public Products( String name, double price, String added_on, long category_id) {
		super();

		this.name = name;
		this.price = price;
		this.added_on = added_on;
		this.category_id = category_id;
		
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAdded_on() {
		return added_on;
	}
	public void setAdded_on(String added_on) {
		this.added_on = added_on;
	}
	public long getCategory_id() {
		return category_id;
	}
	public void setCategory_id(long category_id) {
		this.category_id = category_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", price=" + price + ", added_on=" + added_on
				+ ", category_id=" + category_id + ", description=" + description + ", rating=" + rating + ", image="
				+ image + ", qty=" + qty + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
