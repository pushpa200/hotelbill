package com.Tyss.hotelbilling;

import java.util.Scanner;

public class HotelEx extends App{

	public static void main(String[] args) {
		HotelEx he = new HotelEx();
		App ap = new App();
		Hotel_Billing hb = new Hotel_Billing();

		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 to show all food");
		System.out.println("Press 2 to order");
		System.out.println("Press 3 to operations");
		System.out.println("Press 4 to total bill");

		int ip = sc.nextInt();

		if (ip >= 1 && ip <= 4) {

			switch (ip) {
			case 1:
				ap.showAllFood();
				break;
			case 2:
				ap.orderFood();
				break;
			case 3:
				ap.operations();
				break;
			case 4:
				ap.totalBill();
				break;
			default:
				System.out.println("invalid");
			}
		}



	}

}
