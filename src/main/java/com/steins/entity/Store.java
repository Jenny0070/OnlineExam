package com.steins.entity;

import java.util.List;

/**
 * @author Sunny
 */
public class Store {
	private Integer storeId;
	private String storeName;
	private String storePic;
	private String storeDesc;
	private Integer storeScore;
	private Integer storeRanking;
	private String storeTel;
	private List<Food> foodList;
	
	@Override
	public String toString() {
		return "Store{" +
				"storeId=" + storeId +
				", storeName='" + storeName + '\'' +
				", storePic='" + storePic + '\'' +
				", storeDesc='" + storeDesc + '\'' +
				", storeScore='" + storeScore + '\'' +
				", storeRanking='" + storeRanking + '\'' +
				", storeTel='" + storeTel + '\'' +
				", foodList=" + foodList +
				'}';
	}
	
	public Integer getStoreId() {
		return storeId;
	}
	
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	
	public String getStoreName() {
		return storeName;
	}
	
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	public String getStorePic() {
		return storePic;
	}
	
	public void setStorePic(String storePic) {
		this.storePic = storePic;
	}
	
	public String getStoreDesc() {
		return storeDesc;
	}
	
	public void setStoreDesc(String storeDesc) {
		this.storeDesc = storeDesc;
	}
	
	public Integer getStoreScore() {
		return storeScore;
	}
	
	public void setStoreScore(Integer storeScore) {
		this.storeScore = storeScore;
	}
	
	public Integer getStoreRanking() {
		return storeRanking;
	}
	
	public void setStoreRanking(Integer storeRanking) {
		this.storeRanking = storeRanking;
	}
	
	public String getStoreTel() {
		return storeTel;
	}
	
	public void setStoreTel(String storeTel) {
		this.storeTel = storeTel;
	}
	
	public List<Food> getFoodList() {
		return foodList;
	}
	
	public void setFoodList(List<Food> foodList) {
		this.foodList = foodList;
	}
}
