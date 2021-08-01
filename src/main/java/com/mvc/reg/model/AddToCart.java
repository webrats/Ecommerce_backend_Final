package com.mvc.reg.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="add_to_cart")
public class AddToCart implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;

	@Column
	private int qty ;
	@Column
	private double price ;
	@Column
	private Date added_date ;
	@Column
	private long user_id ;
	

	@OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_id")
	private Products product;

	
	public AddToCart() {
		super();
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Date getAdded_date() {
		return added_date;
	}


	public void setAdded_date(Date added_date) {
		this.added_date = added_date;
	}


	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public Products getProduct() {
		return product;
	}
	public void setProduct(Products product) {
		this.product = product;
	}



	@Override
	public String toString() {
		return "AddToCart [id=" + id + ", qty=" + qty + ", price=" + price + ", added_date=" + added_date + ", user_id="
				+ user_id + ", product=" + product + "]";
	}



	
	
	
	
	
	
}
