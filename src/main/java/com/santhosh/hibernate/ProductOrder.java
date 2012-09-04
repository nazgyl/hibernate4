package com.santhosh.hibernate;

// Generated May 17, 2012 5:36:33 PM by Hibernate Tools 3.4.0.CR1

/**
 * ProductOrder generated by hbm2java
 */
public class ProductOrder implements java.io.Serializable {

	private Integer no;
	private Customer customer;
	private Product product;

	public ProductOrder() {
	}

	public ProductOrder(Customer customer, Product product) {
		this.customer = customer;
		this.product = product;
	}

	public Integer getNo() {
		return this.no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}