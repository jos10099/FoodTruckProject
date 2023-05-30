package com.skilldistillery.foodtruck.entities;

public class FoodTruck {
	private static int currentNumberOfTrucks = 1;

	private String truckType;
	private int id;

	private String foodTruckName;
	private double foodTruckRating;
	private String foodType;

	public FoodTruck() {
		this.id = currentNumberOfTrucks++;

	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public void setFoodTruckRating(double foodTruckRating) {
		this.foodTruckRating = foodTruckRating;
	}

	public double getFoodTruckRating() {
		return foodTruckRating;

	}

	public FoodTruck(String foodTruckName, String foodType, double foodTruckRating) {
		this();
		this.foodTruckName = foodTruckName;
		this.foodTruckRating = foodTruckRating;
		this.foodType = foodType;
	}

	public static int getCurrentNumberOfTrucks() {
		return currentNumberOfTrucks;
	}

	public static void setCurrentNumberOfTrucks(int currentNumberOfTrucks) {
		FoodTruck.currentNumberOfTrucks = currentNumberOfTrucks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFoodTruckName() {
		return foodTruckName;
	}

	public void setFoodTruckName(String foodTruckName) {
		this.foodTruckName = foodTruckName;
	}

	public String getTruckType() {
		return truckType;
	}

	public void setTruckType(String truckType) {
		this.truckType = truckType;
	}

	public String toString() {
		return "Truck ID = " + id + ", Food Truck Name = " + foodTruckName + ", Food Truck Rating = " + foodTruckRating
				+ ", Food Type = " + foodType;
	}

}
