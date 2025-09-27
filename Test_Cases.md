# Test Cases Document

## Application Under Test
- **Name:** The Internet (Herokuapp)  
- **URL:** https://the-internet.herokuapp.com/  

---

## Introduction
This document details the **10 selected test cases** designed for the chosen scope of the assessment.  

The number of cases is intentionally limited to ensure a **concise yet comprehensive coverage** of the core functionalities (login, checkboxes, dropdown, file upload, and alerts). This avoids the overhead of unnecessary cases while still demonstrating positive, negative, and boundary testing across multiple feature types.  

Each test case also includes **automation notes** to highlight locators, waits, and assertions that will be applied when implementing automation with Selenium + TestNG.  

---

### **TC-001: Login with valid credentials**
- **Objective:** Verify login works with correct username/password.  
- **Preconditions:** Valid credentials (`tomsmith` / `SuperSecretPassword!`).  
- **Steps:**  
  1. Navigate to `/login`.  
  2. Enter valid username.  
  3. Enter valid password.  
  4. Click “Login.”  
- **Expected Result:** Redirected to secure area with success message.  
- **Priority:** High  
- **Type:** Positive  
- **Automation Notes:** Use `id="username"`, `id="password"`, and `cssSelector` for login button. Add assertion on success flash message. Capture screenshot on failure.  

---

### **TC-002: Login with invalid credentials**
- **Objective:** Verify system rejects invalid credentials.  
- **Variants:**  
  - Invalid username + valid password  
  - Valid username + invalid password  
  - Both invalid  
- **Steps (for each variant):**  
  1. Navigate to `/login`.  
  2. Enter credential combination.  
  3. Click “Login.”  
- **Expected Result:** Error message displayed, user remains on login page.  
- **Priority:** High  
- **Type:** Negative  
- **Automation Notes:** Use same locators as TC-001. Assert flash message contains “Your username is invalid!”. Include variants in data-driven testing.  

---

### **TC-003: Login with blank fields**
- **Objective:** Verify login form validation when fields are left blank.  
- **Variants:**  
  - Blank username + valid password  
  - Valid username + blank password  
  - Both blank  
- **Steps (for each variant):**  
  1. Navigate to `/login`.  
  2. Enter credential combination.  
  3. Click “Login.”  
- **Expected Result:** Error message displayed (username required or invalid login).  
- **Priority:** Medium  
- **Type:** Negative / Boundary  
- **Automation Notes:** Use `WebDriverWait` to ensure flash message appears. Group under one data-driven test with different inputs.  

---

### **TC-004: Dropdown selection**
- **Objective:** Verify user can select an option from dropdown.  
- **Steps:**  
  1. Navigate to `/dropdown`.  
  2. Select option “2.”  
- **Expected Result:** Option 2 is selected.  
- **Priority:** Medium  
- **Type:** Functional  
- **Automation Notes:** Use `Select` class on `id="dropdown"`. Assert selected option equals “Option 2”.  

---

### **TC-005: Checkbox interaction**
- **Objective:** Verify user can check and uncheck checkboxes.  
- **Steps:**  
  1. Navigate to `/checkboxes`.  
  2. Toggle Checkbox 1.  
- **Expected Result:** Checkbox 1 state changes accordingly.  
- **Priority:** Medium  
- **Type:** Functional  
- **Automation Notes:** Locate by relative XPath or CSS. Assert state before and after toggle with `.isSelected()`.  

---

### **TC-006: File upload with valid file**
- **Objective:** Verify user can upload a valid file.  
- **Steps:**  
  1. Navigate to `/upload`.  
  2. Choose sample file (`testfile.txt`).  
  3. Click “Upload.”  
- **Expected Result:** Upload successful confirmation displayed.  
- **Priority:** High  
- **Type:** Positive  
- **Automation Notes:** Use `id="file-upload"` to send file path. Use `id="file-submit"` for upload. Assert result contains uploaded filename.  

---

### **TC-007: File upload with empty submission**
- **Objective:** Verify system handles no file upload attempt.  
- **Steps:**  
  1. Navigate to `/upload`.  
  2. Do not select file.  
  3. Click “Upload.”  
- **Expected Result:** Error message displayed or no file uploaded.  
- **Priority:** Medium  
- **Type:** Negative  
- **Automation Notes:** Directly click `id="file-submit"` without file path. Assert system shows error or stays unchanged.  

---

### **TC-008: JavaScript alert acceptance**
- **Objective:** Verify user can accept JavaScript alert.  
- **Steps:**  
  1. Navigate to `/javascript_alerts`.  
  2. Click “Click for JS Alert.”  
  3. Accept alert.  
- **Expected Result:** Result message updated with confirmation.  
- **Priority:** Medium  
- **Type:** Functional  
- **Automation Notes:** Use `switchTo().alert().accept()`. Assert result text contains “You successfully clicked an alert”.  

---

### **TC-009: JavaScript confirm dismissal**
- **Objective:** Verify user can dismiss JavaScript confirm box.  
- **Steps:**  
  1. Navigate to `/javascript_alerts`.  
  2. Click “Click for JS Confirm.”  
  3. Dismiss alert.  
- **Expected Result:** Result message updated with dismissal confirmation.  
- **Priority:** Medium  
- **Type:** Functional  
- **Automation Notes:** Use `switchTo().alert().dismiss()`. Assert result text contains “You clicked: Cancel”.  

---

### **TC-010: File upload with multiple files (boundary test)**
- **Objective:** Verify that the system does not allow multiple files to be uploaded simultaneously.  
- **Preconditions:** Two sample files available on disk (`file1.txt`, `file2.txt`).  
- **Steps:**  
  1. Navigate to `/upload`.  
  2. Attempt to select multiple files (e.g., `file1.txt` and `file2.txt`).  
  3. Click “Upload.”  
- **Expected Result:** Only one file is accepted and uploaded (the last file chosen). System should display only `file2.txt`.  
- **Priority:** Low/Medium  
- **Type:** Negative / Boundary  
- **Automation Notes:** Use `id="file-upload"` and pass multiple file paths separated by newline in `sendKeys()`. Assert only one file name is displayed after upload.  
