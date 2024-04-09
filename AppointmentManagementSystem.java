package com.appointmentManagementSystem;

import java.util.*;

class User {
	private String username;
	private String password;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}

public class AppointmentManagementSystem {
	private static Scanner scanner = new Scanner(System.in);
	private static Map<String, User> users = new HashMap<>();
	private static List<String> appointments = new ArrayList<>();

	public static void main(String[] args) {
		while (true) {
			System.out.println("1. Register");
			System.out.println("2. Login");
			System.out.println("3. Schedule Appointment");
			System.out.println("4. View Appointments");
			System.out.println("5. Exit");
			System.out.print("Choose an option: ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				register();
				break;
			case 2:
				login();
				break;
			case 3:
				scheduleAppointment();
				break;
			case 4:
				viewAppointments();
				break;
			case 5:
				System.out.println("Exiting...");
				System.exit(0);
			default:
				System.out.println("Invalid option. Please choose again.");
				break;
			}
		}
	}

	private static void register() {
		System.out.println("Enter username:");
		String username = scanner.next();
		System.out.println("Enter password:");
		String password = scanner.next();
		if (!users.containsKey(username)) {
			users.put(username, new User(username, password));
			System.out.println("Registration successful.");
		} else {
			System.out.println("Username already exists. Please choose another username.");
		}
	}

	private static void login() {
		System.out.println("Enter username:");
		String username = scanner.next();
		System.out.println("Enter password:");
		String password = scanner.next();
		User user = users.get(username);
		if (user != null && user.getPassword().equals(password)) {
			System.out.println("Login successful. Welcome, " + username + "!");
		} else {
			System.out.println("Invalid username or password. Please try again.");
		}
	}

	private static void scheduleAppointment() {
		if (users.isEmpty()) {
			System.out.println("No users registered yet. Please register first.");
			return;
		}
		if (appointments.isEmpty()) {
			System.out.println("No appointments scheduled yet.");
		}
		System.out.println("Enter appointment details:");
		System.out.println("Date:");
		String date = scanner.next();
		System.out.println("Time:");
		String time = scanner.next();
		System.out.println("Purpose:");
		String purpose = scanner.next();
		System.out.println("Location:");
		String location = scanner.next();
		appointments.add("Date: " + date + ", Time: " + time + ", Purpose: " + purpose + ", Location: " + location);
		System.out.println("Appointment scheduled successfully.");
	}

	private static void viewAppointments() {
		if (appointments.isEmpty()) {
			System.out.println("No appointments scheduled yet.");
		} else {
			System.out.println("Your Appointments:");
			for (String appointment : appointments) {
				System.out.println(appointment);
			}
		}
	}
}
