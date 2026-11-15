
# Parking Management System
## Implementation Report

**Unit:** ICTPRG532 – Apply Advanced Object-Oriented Language Skills

### 1. Introduction

The Parking Management System was developed using Java and C++ to demonstrate advanced object-oriented programming concepts.

The application manages motorcycles, cars, and buses, including vehicle registration, searching, removal, and parking space allocation.

The project also demonstrates data structures, searching and sorting algorithms, graphical interfaces, and communication mechanisms.

### 2. C++ Implementation

The C++ application was developed using object-oriented programming principles.

The main classes include:

- **Vehicle:** An abstract base class containing common vehicle information.
- **Motorcycle:** A derived class representing motorcycles.
- **Car:** A derived class representing cars.
- **Bus:** A derived class representing buses.
- **ParkingSpace:** Represents an individual parking space, including its location, type, and occupancy status.
- **ParkingLot:** Manages parking spaces, vehicle allocation, and space availability.

The parking lot contains 20 spaces distributed across two levels.

The application follows these parking rules:

- Motorcycles can use any available space.
- Cars can use compact or large spaces.
- Buses require five consecutive large spaces in the same row.

The C++ application was compiled using G++ and tested through the terminal in Visual Studio Code.


### 3. Java Implementation

The Java application was developed to demonstrate advanced object-oriented programming concepts, data structures, algorithms, and graphical interfaces.

**Object-Oriented Programming**

The application includes an abstract Vehicle class and three subclasses:

- Motorcycle
- Car
- Bus

These classes demonstrate inheritance, abstraction, and polymorphism.

**Data Structures**

The Java project includes demonstrations of:

- Doubly Linked List
- Binary Tree
- Hash Table

These structures are used to demonstrate different methods of organising and accessing vehicle information.

**Searching and Sorting Algorithms**

The application demonstrates:

- Linear Search: Used to search for vehicle information.
- Merge Sort: Used to demonstrate the sorting of vehicle data.

**Communication Mechanisms**

The project includes two producer-consumer demonstrations:

- Shared Memory: Communication between Java threads using shared data.
- Message Passing: Communication between Java threads using a BlockingQueue.

The project also includes a client-server demonstration using Java sockets.

**Graphical User Interface**

The graphical interface was developed using Java Swing.

It includes:

- Vehicle selection buttons.
- Drag-and-drop interaction.
- Visual identification of available and occupied spaces.
- A Help button with user instructions.

**2D Graphics**

The application uses Java 2D graphics to display parking spaces.

Green represents available spaces, while red represents occupied spaces.


### 4. Testing and Results

The Parking Management System was tested using Visual Studio Code.

The following tests were performed:

**Test 1 - Java Client-Server Communication**
- The Java server was started on port 5000.
- The client sent a vehicle message to the server.
- Result: The server successfully received the message.
- Evidence: 01_Server_Client_Test.png

**Test 2 - Java Graphical User Interface**
- The parking interface was opened.
- A motorcycle was dragged into an available parking space.
- Result: The parking space changed from green to red.
- Evidence: 02_Parking_GUI_Test.png

**Test 3 - Java 2D Graphics**
- The graphical parking representation was opened.
- Available and occupied spaces were displayed.
- Result: The application displayed the parking spaces using different colours.
- Evidence: 03_Parking_Graphics2D_Test.png

**Test 4 - Java Data Structures**
- The Java application was executed.
- Data structures and algorithms were demonstrated.
- Result: The application displayed the expected console output.
- Evidence: 04_Java_DataStructures_Test.png

**Test 5 - Java Shared Memory**
- The shared-memory demonstration was executed.
- Producer and consumer threads exchanged vehicle information.
- Result: The shared data was successfully accessed.
- Evidence: 05_Java_SharedMemory_Test.png

**Test 6 - Java Message Passing**
- The message-passing demonstration was executed.
- Vehicle messages were exchanged using a BlockingQueue.
- Result: The messages were successfully received.
- Evidence: 06_Java_MessagePassing_Test.png

**Test 7 - C++ Parking Management**
- The C++ application was compiled and executed.
- Vehicle registration, removal, and parking availability were tested.
- Result: The application displayed the expected parking information.
- Evidence: 07_CPP_ParkingSystem_Test.png

### 5. Testing Summary

All seven recorded demonstrations produced the expected results during testing.

The screenshots are stored in the Java/Evidence folder.

These results demonstrate the tested functionality of the Java and C++ applications. Additional verification may be required to confirm compliance with all assessment requirements.

## Algorithm Comparison

### Searching Algorithms

Three searching algorithms were compared:

1. Linear Search:
   Checks each element sequentially.
   Time complexity: O(n).
   It works with unsorted data.

2. Binary Search:
   Divides a sorted collection into halves.
   Time complexity: O(log n).
   It requires sorted data.

3. Hash-Based Search:
   Uses a hash function to locate data.
   Average time complexity: O(1).
   Performance depends on the hash function and collisions.

Selected algorithm: Linear Search.

Linear Search was selected because the parking system
contains a relatively small collection of vehicles,
and searching does not require sorted data.

### Sorting Algorithms

Three sorting algorithms were compared:

1. Bubble Sort:
   Repeatedly compares adjacent elements.
   Average time complexity: O(n²).

2. Quick Sort:
   Uses partitioning to sort elements.
   Average time complexity: O(n log n).
   Worst-case complexity: O(n²).

3. Merge Sort:
   Divides the collection into smaller parts
   and merges them in sorted order.
   Time complexity: O(n log n).

Selected algorithm: Merge Sort.

Merge Sort was selected because it provides predictable
O(n log n) performance and supports custom comparison rules.

The Java implementation uses a Comparator to sort
vehicle types in the following order:

Motorcycle, Car, Bus.

The implementation was successfully tested in Main.java.

## Inter-Process Communication (IPC)

The Parking Management System demonstrates two
inter-process communication mechanisms.

### 1. Shared Memory IPC

The ParkingSharedMemoryIPC.java application uses
MappedByteBuffer to share parking information
between two independent Java processes.

The Producer writes vehicle information to a
memory-mapped file, and the Consumer reads it.

Test result: Passed.

Evidence: 08_Java_SharedMemory_IPC_Test.png

### 2. Message Passing IPC

The ParkingServer.java and ParkingClient.java
applications use Java sockets to communicate
between two independent processes.

The Client sends vehicle information to the Server.
The Server receives and displays the message.

Test result: Passed.

Evidence: 09_Java_MessagePassing_IPC_Test.png

### IPC Testing Summary

Both IPC demonstrations were executed successfully.

The original ParkingSharedMemory.java and
ParkingMessagePassing.java files also demonstrate
Producer-Consumer coordination between Java threads.

The memory-mapped file and socket demonstrations
provide communication between independent processes.


## Architectural Design and Third-Party Library

### Architectural Design

The Parking Management System uses object-oriented programming principles and separates several responsibilities into different classes.

- Model: ParkingLot and vehicle classes manage parking information.
- View: ParkingGUI displays the graphical interface.
- Controller responsibilities: ParkingGUI handles drag-and-drop events and updates the displayed parking spaces.

The project follows some Model-View-Controller (MVC) design principles. However, the graphical interface currently combines view and controller responsibilities, so it is not a complete MVC implementation.

### Third-Party Library: Google Gson

The project uses Google Gson version 2.13.2, an external Java library for JSON serialization.

The ParkingJsonExport.java class demonstrates how Gson converts vehicle information into JSON format.

Gson was selected because it is compatible with Java 21, simple to integrate and useful for exporting structured parking information.

The library is stored in the Java/lib folder.

Test result: Passed.

Evidence: 10_Java_Gson_Library_Test.png
