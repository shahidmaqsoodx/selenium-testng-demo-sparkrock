# Test Design Document

## Application Under Test (AUT)
- **Name:** The Internet (Herokuapp)  
- **URL:** https://the-internet.herokuapp.com  
- **Description:** A demo web application containing multiple simple pages with various UI components. It’s designed for practicing automation skills, covering login, forms, checkboxes, dropdowns, file upload, alerts, and more. It is being picked for this assessment as it allows interaction with various different types of web elements and covers multiple distinct flows under the same application.

---

## Scope
**In-scope:**  
- Authentication flow (`<URL>/login`)  
- Checkbox interactions (`<URL>/checkboxes`)  
- Dropdown selection (`<URL>/dropdown`)  
- File upload (`<URL>/upload`)  
- Alerts (`<URL>/javascript_alerts`)  

**Out-of-scope (for now):**  
- Dynamic UI elements (e.g., infinite scroll, large DOM).  
- API-level or backend validation.  
- Performance or accessibility testing.  

---

## Rationale
The selected application, **The Internet (Herokuapp)**, is intentionally simple yet feature-rich enough to demonstrate a broad range of test design and automation skills within the scope of this assessment.  

- It provides diverse UI elements (login, forms, checkboxes, dropdowns, file upload, alerts) that allow coverage of positive, negative, and edge cases.  
- Its simplicity ensures the focus remains on test strategy, design quality, and automation practices rather than on handling overly complex business logic.  
- The chosen scope enables us to write a concise but comprehensive set of test cases, avoiding the overhead of creating 100+ cases for a larger application.  
- Invalid and blank login scenarios are grouped under two cases but exercised through multiple variants with **data-driven testing**. This keeps the case list concise (10 total) while ensuring robust coverage.  
- A boundary test for file upload was also added to validate that multiple file selection is not supported, further demonstrating boundary value analysis.  

---

## Objectives
- Validate that core user flows (login, form controls, file upload) function as expected.  
- Ensure error handling and negative scenarios are covered.  
- Provide robust, maintainable automated scripts for regression.  

### Automation Goals
- Build a scalable Selenium + TestNG framework (POM-based), with reusable components and reliable selectors, supporting local execution (via IDE or CLI).  
- Ensure clear reporting and failure visibility through logs, HTML reports, and screenshots.  
- Identify future goals such as environment-based configuration and CI/CD execution (e.g., GitHub Actions).

---

## Test Strategy
- **Test Levels:** Functional UI automation.  
- **Test Types:** Positive, negative, boundary, and edge case testing.  
- **Test Data:** Hardcoded test user (valid/invalid credentials), sample files for upload.  
- **Browsers:** Chrome (primary), Firefox (secondary optional).  
- **Execution:** Local (via Eclipse + Maven + TestNG). CI (e.g., GitHub Actions) identified as a future goal.  
- **Automation Pattern:** Page Object Model (POM) for maintainability.  
- **Selectors:** Prefer `id`, `name`, or `data-test` when available. Use `cssSelector` for performance and readability. Apply `relative XPath` when attributes are missing or text-based targeting is needed. Avoid `absolute XPath` due to their flakiness.  
- **Waits:** Prefer explicit waits with `WebDriverWait` over implicit waits where possible. Avoid static waits.  
- **Data-driven testing:** Use TestNG `@DataProvider` for TC-002 (invalid credentials) and TC-003 (blank credentials) to cover multiple variants without duplicating test logic.  

---

## Risk Analysis & Prioritization
| Feature    | Business Risk | Automation Priority |
|------------|---------------|---------------------|
| Login      | High (blocks access to app) | High |
| Dropdown   | Medium (core UI control)    | Medium |
| Checkboxes | Medium (state handling)     | Medium |
| File upload| High (common workflow)      | High |
| Alerts     | Medium (critical for workflows with confirmations) | Medium |

---

## Traceability Matrix
| Requirement / Feature | Test Case IDs            |
|-----------------------|--------------------------|
| Login functionality   | TC-001, TC-002, TC-003   |
| Dropdown selection    | TC-004                   |
| Checkbox interaction  | TC-005                   |
| File upload           | TC-006, TC-007, TC-010   |
| Alert handling        | TC-008, TC-009           |

---

## Deliverables
- **Test_Design.md** (current document).  
- **Test_Cases.md** (detailed cases with clear steps and expected results).  
- Maven project with Selenium + TestNG tests (Java).  
- HTML test report + screenshots.  
- GitHub repo (with proper access) + GitHub Actions CI (future goal).  
- **[Live coding video](https://youtu.be/iaWm1FGdow8)** (implementing 1–2 cases) uploaded (with proper access).  
