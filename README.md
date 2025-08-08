# SauceDemo Test Automation Framework 

![Java](https://img.shields.io/badge/Java-11-blue)
![Playwright](https://img.shields.io/badge/Playwright-1.40.0-green) 
![TestNG](https://img.shields.io/badge/TestNG-7.6.0-red)
![Allure](https://img.shields.io/badge/Allure-2.23.0-blue)
## 📋 Overview
This project provides a robust test automation framework for SauceDemo using Playwright + Java + TestNG with Allure reporting.
| Feature                     | Description                                             |
|----------------------------|---------------------------------------------------------|
| ✅ Playwright              | Reliable browser automation                             |
| ✅ TestNG                  | Priority-based test execution                           |
| ✅ Allure                  | Beautiful, detailed test reporting                      |
| ✅ Page Object Model (POM) | Scalable and maintainable test structure                |

---

## ✅ Test Case Coverage

| Module               | Test Case Description                                 | Status |
|----------------------|-------------------------------------------------------|--------|
| 🔐 Authentication    | Successful login with valid credentials               | ✔️     |
|                      | Error message for locked out user                     | ✔️     |
|                      | Error message for invalid credentials                 | ✔️     |
| 🏷️ Inventory         | Verify product listing displays correctly             | ✔️     |
|                      | Add/remove items from inventory view                  | ✔️     |
|                      | Sort products by name/price                           | ✔️     |
|                      | Validate menu functionality                           | ✔️     |
| 🛒 Cart Operations    | Add items to cart                                    | ✔️     |
|                      | Remove items from cart                                | ✔️     |
|                      | Continue shopping navigation                          | ✔️     |


## 🛠️ Technical Stack
- **Language**: Java 11
- **Build Tool**: Maven
- **Browser Support**: Chromium, Firefox
- **Reporting**: Allure with screenshots

### Prerequisites
- Java JDK 11+
- Maven 3.8+
- Allure commandline tool

### Installation
```bash
git clone https://github.com/yourusername/saucedemo-automation.git
cd saucedemo-automation
mvn clean install
```
### Generating Report
```bash
#One Line code:
allure generate target/allure-results --clean -o target/allure-report
#Open the report:
allure open target/allure-report
#Open the result:
allure serve target/allure-results
```
## 📁 Project Structure
```plaintext
saucedemo-automation/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── saucedemo/
│   │   │           ├── pages/       
│   │   │           └── utils/        
│   │   └── resources/              
│   └── test/
│       └── java/
│           └── com/
│               └── saucedemo/
│                   └── tests/         
├── target/
│   ├── allure-results/                 
│   └── allure-report/                  
│
├── testng.xml                          
└── pom.xml                                   
```
###💡 Additional Tips
Parallel Execution: Add to testng.xml:
```bash
<suite parallel="tests" thread-count="3">
```
## Output Allure Report:
<img width="787" height="406" alt="Behaviors" src="https://github.com/user-attachments/assets/378929f4-9323-4734-a036-4c159b7c638d" />
<img width="787" height="406" alt="Overview" src="https://github.com/user-attachments/assets/beb01b83-e7bf-4787-b302-d3127e185b08" />
<img width="787" height="406" alt="all test" src="https://github.com/user-attachments/assets/da0a65c2-db06-4905-acf7-c47c18359205" />


