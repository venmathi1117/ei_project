# Smart Office Facility 🏢

## Overview
The **Smart Office Facility** project is a Java-based console application to manage a smart office environment. Users can configure meeting rooms, book/cancel reservations, and track occupancy. Each room is equipped with smart sensors (lights and AC) that respond automatically to occupancy changes.

This project demonstrates **OOP principles** and the use of **design patterns**: Singleton, Command, and Observer.

---

## Features
- **Room Configuration:** Add and manage multiple meeting rooms.
- **Booking System:** Book and cancel conference rooms.
- **Smart Sensors:** Lights and AC automatically turn on/off based on occupancy.
- **Auto Release:** Unoccupied rooms automatically release bookings after 5 minutes.
- **Usage Statistics:** Track total bookings and occupancy per room.
- **User Authentication:** Secure login before accessing the system.

---

## Key Components
- **Authentication:** Handles user login.
- **OfficeConfiguration (Singleton):** Manages all rooms.
- **Room:** Represents a meeting room with booking status, occupancy, and sensors.
- **Sensors (Observer):** `LightControl` and `AirConditionControl`.
- **Commands (Command Pattern):** `BookRoomCommand` and `CancelRoomCommand`.

---

## Design Patterns
- **Singleton:** `OfficeConfiguration`.
- **Observer:** Sensors update when room occupancy changes.
- **Command:** Encapsulates booking and cancellation actions.
- **OOP Principles:** Encapsulation, inheritance, and polymorphism.

---

## How to Run
1. **Compile the project**
```bash
cd SmartOfficeFacility/src
javac *.java
Run the application

java Main


Default login

=== Smart Office Facility ===
Username: admin
Password: admin123
Login successful!

Menu:
1. Configure Rooms
2. Set Room Capacity
3. Book Room
4. Cancel Booking
5. Add Occupants
6. View Room Statistics
7. Exit

Choice: 1
Enter number of rooms: 3
Office configured with 3 meeting rooms: Room 1, Room 2, Room 3.

Choice: 2
Enter room ID and capacity: 1 10
Room 1 maximum capacity set to 10

Choice: 5
Enter room ID and number of occupants: 1 2
Room 1 is now occupied by 2 persons.
Lights turned ON.
Air conditioning turned on.

Choice: 3
Enter room ID, start time (HH:MM), and duration (minutes): 1 09:00 60
Room 1 booked from 09:00 for 60 minutes.

Choice: 4
Enter room ID to cancel booking: 1
Booking for Room 1 cancelled successfully.

Choice: 5
Enter room ID and number of occupants: 1 0
Room 1 is now unoccupied. AC and lights turned off.
Lights turned OFF.
Air conditioning turned off.

Choice: 6
=== Room Usage Statistics ===
Room 1: Capacity=10, Total Bookings=1, Total Occupancy=2
Room 2: Capacity=0, Total Bookings=0, Total Occupancy=0
Room 3: Capacity=0, Total Bookings=0, Total Occupancy=0

Choice: 7
Exiting...


Project Structure
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

UML Class Diagram
+---------------------+           +---------------------+
|     Main            |           |   Authentication    |
|---------------------|           |---------------------|
| + main(args): void  | --------> | + login(): boolean  |
+---------------------+           +---------------------+

            |
            v
+-------------------------+
| OfficeConfiguration     |
|-------------------------|
| + configureRooms()      |
| + getRoomById()         |
| + getRooms()            |
+-------------------------+
            |
     1..*   | has
            v
+-------------------------+
| Room                    |
|-------------------------|
| - id, isBooked, sensors |
| + setOccupancy()        |
| + attachSensor()        |
| + book(), cancelBooking()|
+-------------------------+
            |
            v
+------------------+
| <<interface>>    |
| Sensor           |
| + update()       |
+------------------+
   ^             ^
   |             |
+---------------------+   +--------------------------+
| LightControl        |   | AirConditionControl      |
+---------------------+   +--------------------------+

+-------------------------+
| <<interface>> Command   |
| + execute(): void       |
+-------------------------+
   ^                  ^
   |                  |
+--------------------+   +---------------------+
| BookRoomCommand    |   | CancelRoomCommand   |
+--------------------+   +---------------------+
```
## Contact

For any queries or further information, please reach out to [venmathi1117@gmail.com](mailto:venmathi1117.com) .

