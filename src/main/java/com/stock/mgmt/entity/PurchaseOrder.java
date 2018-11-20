package com.stock.mgmt.entity;

public class PurchaseOrder {
	private int productId;
	private int quantity;
	private int total;
	private int purchasedFrom;
	
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getPurchasedFrom() {
		return purchasedFrom;
	}
	public void setPurchasedFrom(int purchasedFrom) {
		this.purchasedFrom = purchasedFrom;
	}
	
	
	

}
