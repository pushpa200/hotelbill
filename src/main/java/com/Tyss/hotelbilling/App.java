package com.Tyss.hotelbilling;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class App implements HotelBilling {

	public void operations() {
		Scanner sc = new Scanner(System.in);
		System.out.println("press A to insert");
		System.out.println("press B update");
		System.out.println("press C to delete");
		String ip1 = sc.next();
		switch (ip1) {
		case "A":
			insertFood();
			break;
		case "B":
			updateFood();
			break;
		case "C":
			deleteFood();
			break;
		default:
			System.out.println("invalid option");
			break;
		}

	}

	private void deleteFood() {
		EntityTransaction transaction = null;
		EntityManager entityManager = null;
		EntityManagerFactory entityManagerFactory = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			Hotel_Billing hotel = entityManager.find(Hotel_Billing.class, 30);
			entityManager.remove(hotel);
			System.out.println("Object Removed");
			transaction.commit();

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			entityManager.close();
		}

	}

	private void updateFood() {

		EntityTransaction transaction = null;
		EntityManager entityManager = null;
		EntityManagerFactory entityManagerFactory = null;

		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			Hotel_Billing hotel = entityManager.find(Hotel_Billing.class, 20);
			hotel.setFoodName("idly");
			System.out.println("record updated");
			transaction.commit();

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			entityManager.close();
		}

	}

	private void insertFood() {

		EntityTransaction transaction = null;
		EntityManager entityManager = null;
		EntityManagerFactory entityManagerFactory = null;

		Hotel_Billing hotel = new Hotel_Billing();
		hotel.setItemCode(500);
		hotel.setFoodName("dosa");
		hotel.setPrice(25);

		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(hotel);
			System.out.println("saved");
			transaction.commit();

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			entityManager.close();
		}

	}

	public void totalBill() {

		//double total = 0.0;

		EntityTransaction entityTransaction = null;
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;

		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
//			String jpql2 = "select sum(price) from hotel";
//			Query query = entityManager.createQuery(jpql2);
//			int totalSum=query.getFirstResult();
//			System.out.println(totalSum);

			//entityTransaction.commit();

			
		Hotel_Billing hotel1 = entityManager.find(Hotel_Billing.class, 0);
		Hotel_Billing hotel2 = entityManager.find(Hotel_Billing.class, 10);
		Hotel_Billing hotel3 = entityManager.find(Hotel_Billing.class, 20);
		Hotel_Billing hotel4 = entityManager.find(Hotel_Billing.class, 30);
		Hotel_Billing hotel5 = entityManager.find(Hotel_Billing.class, 50);
		Hotel_Billing hotel6 = entityManager.find(Hotel_Billing.class, 90);
		Hotel_Billing hotel7 = entityManager.find(Hotel_Billing.class, 100);

int pr1=hotel1.getPrice();
int pr2=hotel2.getPrice();
int pr3=hotel3.getPrice();
int pr4=hotel4.getPrice();
int pr5=hotel5.getPrice();
int pr6=hotel6.getPrice();
int pr7=hotel7.getPrice();
int total=pr1+pr2+pr3+pr4+pr5+pr6+pr7;
			System.out.println("total bill: " + total);
		
		    entityTransaction.commit();

		} catch (Exception e) {
			entityTransaction.rollback();
			e.printStackTrace();
		}

	}

	public void showAllFood() {

		EntityTransaction entityTransaction = null;
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;

		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();

			Hotel_Billing hotel = entityManager.find(Hotel_Billing.class, 10);
			System.out.println(hotel.getClass());// getting the fully qualified class
			System.out.println("ItemCode : " + hotel.getItemCode());
			System.out.println("FoodName : " + hotel.getFoodName());
			System.out.println("Bill : " + hotel.getPrice());
			// checking if the object is present or not
			System.out.println(entityManager.contains(hotel));
			entityTransaction.commit();

		} catch (Exception e) {
			entityTransaction.rollback();
			e.printStackTrace();
		}

	}

	public void orderFood() {
		int items = 10;
		if (items != 0) {
			insertFood();
		} else if (items == 0) {
			System.out.println("invalid");
		}
		//
		//		EntityTransaction entityTransaction = null;
		//		EntityManagerFactory entityManagerFactory = null;
		//		EntityManager entityManager = null;
		//		
		//		try {
		//			entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
		//			entityManager = entityManagerFactory.createEntityManager();
		//			entityTransaction = entityManager.getTransaction();
		//			entityTransaction.begin();
		//			
		//			Hotel_Billing hotel = entityManager.find(Hotel_Billing.class, 30);
		//			//System.out.println(hotel.getClass());// getting the fully qualified class
		//			System.out.println("ItemCode : " +hotel.getItemCode() );
		//			System.out.println("FoodName : " + hotel.getFoodName());
		//			System.out.println("Bill : " + hotel.getPrice());
		//			// checking if the object is present or not
		//			System.out.println(entityManager.contains(hotel));
		//			entityTransaction.commit();
		//
		//			
		//			
		//		}catch(Exception e) {
		//			entityTransaction.rollback();
		//			e.printStackTrace();	
		//		}

	}

}
