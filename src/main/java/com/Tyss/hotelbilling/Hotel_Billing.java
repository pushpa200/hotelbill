package com.Tyss.hotelbilling;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Hotel")
public class Hotel_Billing {
	@Id
	@Column
	private int ItemCode;
	@Column
	private String FoodName;
	@Column
	private int price;


	public int getItemCode() {
		return ItemCode;
	}
	public void setItemCode(int itemCode) {
		ItemCode = itemCode;
	}
	public String getFoodName() {
		return FoodName;
	}
	public void setFoodName(String foodName) {
		FoodName = foodName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
