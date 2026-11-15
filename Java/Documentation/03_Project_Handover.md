
# Parking Management System
## Project Handover

**Unit:** ICTPRG532 – Apply Advanced Object-Oriented Language Skills

### 1. Project Description

The Parking Management System was developed using Java and C++.

The application demonstrates object-oriented programming, vehicle management, parking space allocation, data structures, algorithms, graphical interfaces, and communication mechanisms.

The system supports three vehicle types:
- Motorcycle
- Car
- Bus

### 2. Software Requirements

The following software is required to compile and run the project:

- Visual Studio Code
- Java Development Kit (JDK)
- G++ Compiler with C++17 support
- Windows PowerShell

### 3. Project Files

The project contains the following components:

**Java**
- Main.java
- ParkingLot.java
- VehicleDataStructures.java
- VehicleHashTable.java
- VehicleAlgorithms.java
- ParkingSharedMemory.java
- ParkingMessagePassing.java
- ParkingServer.java
- ParkingClient.java
- ParkingGUI.java
- ParkingGraphics2D.java

**C++**
- main.cpp
- ParkingSpace.h
- ParkingLot.h

**Documentation**
- 01_Project_Plan.md
- 02_Implementation_Report.md
- 03_Project_Handover.md

**Evidence**
- Seven screenshots showing application testing results.


### 4. How to Run the Application

Open the ParkingManagementSystem project in Visual Studio Code.

**4.1 Run the Java Application**

Open the terminal in the project folder.

Compile the Java files:

```powershell
javac Java\*.java
```

Run the main application:

```powershell
java -cp . Java.Main
```

**4.2 Run the Java Graphical Interface**

Run the graphical user interface:

```powershell
java -cp . Java.ParkingGUI
```

The interface allows users to drag vehicles into available parking spaces.

**4.3 Run the Java 2D Graphics**

```powershell
java -cp . Java.ParkingGraphics2D
```

The application displays a graphical representation of parking spaces.

**4.4 Run the Java Communication Demonstrations**

Shared Memory:

```powershell
java -cp . Java.ParkingSharedMemory
```

Message Passing:

```powershell
java -cp . Java.ParkingMessagePassing
```

**4.5 Run the Java Client-Server Application**

Open two terminals.

In the first terminal, start the server:

```powershell
java -cp . Java.ParkingServer
```

In the second terminal, run the client:

```powershell
java -cp . Java.ParkingClient
```

The server receives a message from the client.

**4.6 Run the C++ Application**

In PowerShell, configure the compiler path if required:

```powershell
$env:Path = "C:\msys64\ucrt64\bin;$env:Path"
```

Compile the C++ application:

```powershell
g++ -std=c++17 "Java\CPP\main.cpp" -o "Java\CPP\parking.exe"
```

Run the application:

```powershell
.\Java\CPP\parking.exe
```

Use the terminal menu to register, search, list, and remove vehicles, or display parking availability.

Select option 6 to exit the program.


### 5. Test Evidence

The project includes seven screenshots demonstrating the execution and testing of the applications.

The screenshots are stored in the following folder:

Java/Evidence/

**Evidence Files**

1. 01_Server_Client_Test.png - Java client-server communication.
2. 02_Parking_GUI_Test.png - Java graphical user interface and drag-and-drop.
3. 03_Parking_Graphics2D_Test.png - Java 2D graphics.
4. 04_Java_DataStructures_Test.png - Java data structures and algorithms.
5. 05_Java_SharedMemory_Test.png - Shared-memory demonstration.
6. 06_Java_MessagePassing_Test.png - Message-passing demonstration.
7. 07_CPP_ParkingSystem_Test.png - C++ parking management application.

### 6. Handover Notes

The project source code, documentation, and testing evidence are organised into separate folders.

The documentation includes:

- Project Plan
- Implementation Report
- Project Handover

The applications can be executed using the instructions provided in this document.

The recorded tests demonstrate the implemented functionality. Final assessment compliance must be verified against the ICTPRG532 assessment requirements before submission.

## 7. Project Documentation

The following documents are included in the project:

- 01_Project_Plan.md – Project planning and requirements.
- 02_Implementation_Report.md – Implementation details and technologies.
- 03_Project_Handover.md – Instructions for running and delivering the application.
- 04_Test_Plan.md – Test cases, expected results and actual results.

All documents are stored in the Java/Documentation folder.

The source code is organised in the Java and Java/CPP folders.

The project includes screenshots of successful application tests in the Java/Evidence folder.