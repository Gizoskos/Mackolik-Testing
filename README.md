# Mackolik-Testing

## Description
Mackolik-Testing is a **Java-based automated testing project** that verifies live football data, match details, and UI behavior on the [Mackolik](https://www.mackolik.com) platform.  
The goal is to ensure data accuracy and interface stability using **Selenium WebDriver** and **JUnit/TestNG**.

## Features
- Automated browser tests for match pages and statistics  
- Validation of team names, scores, and odds  
- Navigation and URL consistency checks  
- Cross-page data accuracy verification  

## Technologies & Tools Used
- **Java** – Core programming language  
- **Selenium WebDriver** – Browser automation  
- **JUnit / TestNG** – Test framework  
- **Maven** – Build and dependency management  
- **Git** – Version control  

## Getting Started

### Prerequisites
- Java JDK 17+  
- Maven  
- ChromeDriver or GeckoDriver in system PATH  

### Installation
```bash
git clone https://github.com/Gizoskos/Mackolik-Testing.git
cd Mackolik-Testing
mvn clean install

Running Tests
Run all tests
mvn test

Run a specific test
mvn -Dtest=MatchPageTest test

Example Test Scenario

Open browser and navigate to Mackolik

Verify page load and match listings

Validate team names, scores, and odds

Log test results and close browser

Example Output
[INFO] Running MatchPageTest
✓ Page loaded successfully
✓ Team names and odds validated
[INFO] BUILD SUCCESS

How I Used Each Tool

Java: Wrote core logic and assertions

Selenium WebDriver: Automated UI interactions

JUnit/TestNG: Structured and ran test cases

Maven: Managed dependencies and builds

Git: Version control for collaboration
