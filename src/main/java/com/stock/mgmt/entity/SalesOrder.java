package com.stock.mgmt.entity;
/**
 * This class deals with sales order related to users.
 * @author prem, Milan
 *
 */
public class SalesOrder {
	private int productId;
	private int quantity;
	private int total;
	private int soldTo;
	
	/**
	 * This method returns Product id for sales order 
	 * @return Product ID
	 */
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
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
	public int getSoldTo() {
		return soldTo;
	}

	public void setSoldTo(int soldTo) {
		this.soldTo = soldTo;
	}
	
	

}
