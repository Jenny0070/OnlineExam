package com.steins.entity;

public class Food {
	private Integer foodId;
	private String foodName;
	private String foodDesc;
	private String foodPic;
	private Integer storeId;
	
	@Override
	public String toString() {
		return "Food{" +
				"foodId=" + foodId +
				", foodName='" + foodName + '\'' +
				", foodDesc='" + foodDesc + '\'' +
				", foodPic='" + foodPic + '\'' +
				", storeId=" + storeId +
				'}';
	}
	
	public Integer getFoodId() {
		return foodId;
	}
	
	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}
	
	public String getFoodName() {
		return foodName;
	}
	
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	
	public String getFoodDesc() {
		return foodDesc;
	}
	
	public void setFoodDesc(String foodDesc) {
		this.foodDesc = foodDesc;
	}
	
	public String getFoodPic() {
		return foodPic;
	}
	
	public void setFoodPic(String foodPic) {
		this.foodPic = foodPic;
	}
	
	public Integer getStoreId() {
		return storeId;
	}
	
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
}
