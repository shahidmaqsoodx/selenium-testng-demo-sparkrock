# QA Automation Assessment – The Internet (Herokuapp)

## Overview
This repository contains the deliverables for the **Senior QA Engineer – Real Work Challenge** assessment.  

The application under test is **[The Internet (Herokuapp)](https://the-internet.herokuapp.com)**, chosen because it provides diverse UI elements (login, dropdowns, checkboxes, file uploads, alerts) while remaining simple enough for focused test design and automation.  

Key highlights:
- Well-structured **Test Design** and **Test Cases** (separate markdown docs).
- Selenium + TestNG framework using **Page Object Model (POM)**.
- Local execution supported via **Eclipse** and **Maven CLI**.
- Automatic **screenshots on failure**.
- **HTML reports** generated for test results.

---

## Project Structure
```plaintext
.
├── screenshots/                  # Captured screenshots for failing tests (auto-created at runtime)
├── test-output/                  # TestNG HTML reports (auto-created at runtime)
├── src/
│   └── test/java/
│       ├── utils/                     # Utilities
│       │   └── ScreenshotUtil.java    # Captures screenshots on test failure
│       ├── pages/                     # Page Object Model classes (one per feature/page)
│       │   └── LoginPage.java         # Login form interactions
│       │   └── SecureAreaPage.java    # Post-login secure area
│       │   └── DropdownPage.java      # Dropdown interaction methods
│       │   └── CheckboxPage.java      # Checkbox selection methods
│       │   └── FileUploadPage.java    # File upload actions
│       │   └── AlertsPage.java        # JavaScript alerts handling
│       └── tests/                     # Test classes (one per feature/module)
│           └── BaseTest.java          # WebDriver setup, teardown, screenshots
│           └── LoginTest.java         # Login-related tests (valid, invalid, blank)
│           └── DropdownTest.java      # Dropdown selection test
│           └── CheckboxTest.java      # Checkbox toggle test
│           └── FileUploadTest.java    # File upload tests (valid, empty, multiple)
│           └── AlertsTest.java        # JavaScript alerts tests (accept, dismiss)
├── src/test/resources/           # Test resources (supporting files for upload tests)
│       └── testfile.txt
│       └── file1.txt
│       └── file2.txt
├── Test_Design.md                # Test design document (assessment deliverable)
├── Test_Cases.md                 # Test cases document (assessment deliverable)
├── pom.xml                       # Maven dependencies (Selenium, TestNG, etc.)
└── README.md                     # Project overview and instructions

```
---

## Technology Stack
- **Language:** Java  
- **Automation:** Selenium WebDriver 4.35  
- **Test Runner:** TestNG 7.11  
- **Build Tool:** Maven  
- **IDE:** Eclipse  

---

## How to Run Tests

### 1. From Eclipse
- Import project as **Maven Project**.  
- Right-click any test class (e.g., `LoginTest.java`).  
- Select **Run As → TestNG Test**.  
- Results will appear in Eclipse console and under `test-output/`.  

### 2. From CLI
```bash
mvn clean test
```
### This will:
- Clean previous reports and builds.  
- Compile code.  
- Run all TestNG tests in `src/test/java`.  

---

### Reports:
- HTML report → `test-output/`  
- Screenshots on failure → `screenshots/`  

---


## Future Improvements
- Add environment-based configuration (e.g., `config.properties`)  
- Integrate with GitHub Actions for CI/CD  
- Extend test coverage to more Herokuapp features  



---
---

 **Author:** Shahid Maqsood  
 **Date:** 27th September, 2025  
