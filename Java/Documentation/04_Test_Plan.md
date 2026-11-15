
# Parking Management System
## Test Plan

**Unit:** ICTPRG532 – Apply Advanced Object-Oriented Language Skills

### 1. Test Plan Objective

The purpose of this test plan is to verify that the Parking Management System works according to the project requirements.

The tests will cover normal operations, boundary conditions, and invalid inputs.

Each test will record:
- Test ID and input
- Expected result
- Actual result
- Pass or Fail
- Defect, fix, and retest notes

### 2. Test Cases

| ID / Input | Expected Result | Actual Result | Pass/Fail | Fix / Retest Notes |
|---|---|---|---|---|
|
| TC01 - Register a car (CAR123, Toyota Corolla) | The car is registered and a suitable space is allocated. | Vehicle parked at Level 1, Row A, Space 1. Vehicle registered successfully! | Pass | No defect observed |

| 
| TC02 - Register a motorcycle (MOTO123, Honda CB500) | The motorcycle is registered and a suitable space is allocated. | Vehicle parked at Level 1, Row A, Space 2. Vehicle registered successfully! | Pass | No defect observed |

| 
| TC03 - Register a bus (BUS789, Mercedes-Benz Bus) | Five consecutive large spaces are allocated. | Level 2, Row A, Spaces 1-5. Vehicle registered successfully! | Pass | No defect observed |
sim

| 
| TC04 - Search for an existing vehicle (BUS789) | The correct vehicle is found. | Vehicle found! Type: Bus, Plate: BUS789, Model: Mercedes-Benz Bus. | Pass | No defect observed |

| 
| TC05 - Remove a vehicle (BUS789) | The vehicle is removed and its five parking spaces become available. | Vehicle removed successfully. Occupied spaces decreased from 7 to 2, and available spaces increased from 13 to 18. | Pass | No defect observed |

| TC06 - Check empty parking lot | The system displays 20 available spaces. | 20 available spaces displayed | Pass | Previously verified in C++ |

| TC07 - Register when parking is full | The system rejects registration without exceeding capacity. | Registered vehicles: 20. Total spaces: 20. Available spaces: 0. Extra vehicle rejected. | Pass | No defect observed. Tested using test_full_parking.cpp |


| TC08 - Search for a nonexistent vehicle (XYZ999) | The system reports that the vehicle was not found. | Vehicle not found. | Pass | No defect observed |


| TC09 - Enter an invalid menu option (9) | The system handles the invalid option without crashing and displays the menu again. | Invalid option! The main menu was displayed again. | Pass | No defect observed |

| TC10 - Java client-server communication | The server receives the client's message. | Message received by server | Pass | Evidence 01 |
| TC11 - GUI drag-and-drop | An available space changes from green to red. | Space changed to red | Pass | Evidence 02 |

### 3. Test Status

The tests marked "Pass" were previously demonstrated.

The tests marked "Pending" must be executed and their actual results recorded before final submission.

### 4. Defect Management

If a test fails, the issue will be recorded, the code will be reviewed and corrected, and the test will be repeated.

The final test report will include the results of any fixes and retests.
