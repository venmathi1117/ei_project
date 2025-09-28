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
