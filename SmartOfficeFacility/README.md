Smart Office Facility 🏢
Overview

Welcome to the Smart Office Facility project! This Java-based application simulates a smart office environment where meeting rooms can be configured, booked, and managed. Each room is equipped with smart sensors (lights and air conditioning) that respond automatically to occupancy. The project demonstrates the use of Object-Oriented Programming (OOP) concepts and design patterns for clean, modular, and maintainable software.

Features

Room Configuration: Create and manage multiple rooms with unique IDs and capacities.

Booking System: Book and cancel room reservations with ease.

Smart Sensors: Automatically turn on/off lights and air conditioning based on occupancy.

Usage Statistics: Track total bookings and occupancy for each room.

User Authentication: Restrict access to booking and configuration features via login.

Design Patterns: Demonstrates Singleton, Command, and Observer patterns.

Key Components
Main

Entry point of the application. Provides a console-based menu to interact with the system.

Authentication

Handles user login with predefined username and password.

OfficeConfiguration

Singleton class managing all room instances. Allows configuration, retrieval, and printing of room details.

Room

Represents a meeting room. Stores booking status, occupancy, and attached sensors.

Sensors

Implements the Observer pattern. Includes:

LightControl → Turns lights on/off.

AirConditionControl → Turns AC on/off.

Commands

Implements the Command pattern for booking and cancellation:

BookRoomCommand

CancelRoomCommand

User

Represents a system user with username and password fields.

Design Patterns

Singleton Pattern: OfficeConfiguration ensures only one instance manages rooms.

Observer Pattern: Room notifies attached sensors of occupancy changes.

Command Pattern: Encapsulates booking and cancellation actions as command objects.

OOP Principles: Encapsulation, inheritance, and polymorphism applied throughout.

How to Run

Compile the project

cd SmartOfficeFacility/src
javac *.java


Run the application

java Main


Login credentials (default)

Username: admin
Password: password

Example
Console Input / Output
=== Smart Office Facility ===
Username: admin
Password: password
Login successful!

1. Configure Rooms
2. Book Room
3. Cancel Booking
4. Add Occupants
5. View Room Statistics
6. Exit


Positive Case

> Configure 3 rooms
Office configured with 3 meeting rooms: Room 1, Room 2, Room 3.

> Add occupant (Room 1, 2)
Room 1 is now occupied by 2 persons. AC and lights turned on.

> Book Room 1
Room 1 booked successfully.

> Cancel Room 1
Booking for Room 1 cancelled successfully.


Negative Case

> Book Room 1 (already booked)
Room 1 is already booked during this time. Cannot book.

> Cancel Room 2 (not booked)
Room 2 is not booked. Cannot cancel booking.

> Add occupant (Room 2, 1)
Room 2 occupancy insufficient to mark as occupied.

Code Structure
SmartOfficeFacility/
│
├── src/
│   ├── Main.java
│   ├── OfficeConfiguration.java
│   ├── Room.java
│   ├── Sensor.java
│   ├── LightControl.java
│   ├── AirConditionControl.java
│   ├── Command.java
│   ├── BookRoomCommand.java
│   ├── CancelRoomCommand.java
│   ├── User.java
│   └── Authentication.java
└── README.md

Contact

For queries or improvements, please reach out to Venmathi R.
