package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {
	private FoodTruck[] fleet;

	
	private Scanner sc;

	public static void main(String[] args) {

		FoodTruckApp app = new FoodTruckApp();

		app.run();
	}

	public FoodTruckApp() {

		fleet = new FoodTruck[5];

		sc = new Scanner(System.in);

	}

	public void run() {

		System.out.println("Please enter the  name, food type, and rating for up to five food trucks.");
		int truckCount = 0;

		for (int indexOfArrays = 0; indexOfArrays < 5; indexOfArrays++) {
			System.out.println("Please enter the food truck name: ");
			String foodTruckName = sc.next();

			if (foodTruckName.equalsIgnoreCase("quit")) {
				break;
			}

			System.out.println("Please enter the food type:");
			String foodType = sc.next();

			System.out.println("Please enter the rating: ");
			double foodTruckRating = sc.nextDouble();

			FoodTruck foodTruck = new FoodTruck(foodTruckName, foodType, foodTruckRating);
			fleet[indexOfArrays] = foodTruck;
			truckCount++;
		}

		theMenu();
		sc.close();

	}

	public void theMenu() {
		boolean exit = false;

		while (!exit) {

			System.out.println("|~~~~~~~~~~~~~~~~~~~Menu~~~~~~~~~~~~~~~~~~~|");
			System.out.println("|1.) List of Exisiting food trucks         |");
			System.out.println("|2.) See the Average rating of food trucks |");
			System.out.println("|3.) Display the highest-rated food truck  |");
			System.out.println("|4.) Quit                                  |");
			System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");

			System.out.println("Please make a selection: ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				listfoodTrucks();
				break;
			case 2:
				showAverageRating();
				break;
			case 3:
				showHighestRatedFoodTruck();
				break;
			case 4:
				exit = true;
				break;
			default:
				System.out.println("This is not a valid choice, please try again.");

			}
		}

	}

	public void listfoodTrucks() {
		System.out.println("~~~~List of Existing Food Trucks~~~~");
		for (FoodTruck foodTruck : fleet) {

			if (foodTruck != null) {
				System.out.println(foodTruck);
			}

		}
	}

	public void showAverageRating() {
		double sumOfRating = 0;
		int truckCount = 0;

		for (FoodTruck foodTruck : fleet) {

			if (foodTruck != null) {
				sumOfRating += foodTruck.getFoodTruckRating();
				truckCount++;
			}

		}
		if (truckCount > 0) {
			double averageRate = sumOfRating / truckCount;
			System.out.println("~~~~Average Rating of Food Trucks~~~~ " + averageRate);
		} else {
			System.out.println("No food truck ratings have been found.");
		}

	}

	public void showHighestRatedFoodTruck() {
		FoodTruck highestRatedFoodTruck = null;
		for (FoodTruck foodTruck : fleet) {

			if (foodTruck != null) {
				if (highestRatedFoodTruck == null
						|| foodTruck.getFoodTruckRating() > highestRatedFoodTruck.getFoodTruckRating()) {
					highestRatedFoodTruck = foodTruck;
				}

			}

		}
		if (highestRatedFoodTruck != null) {
			System.out.println("~~~~ Highest Rated Food Truck ~~~~");
			System.out.println(highestRatedFoodTruck);
		} else {
			System.out.println("No highest food truck ratings has been found.");
		}

	}
}
