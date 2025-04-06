# JUnit 5 Homework 

This repository contains the solution for the JUnit 5 homework assignment, which demonstrates unit testing features using JUnit 5.

---

## 📁 Project Structure

- `src/main/najah/code/` – Core classes (`Calculator`, `Product`, `UserService`, `RecipeBook`, etc.)
- `src/main/najah/test/` – Unit tests for each class
- `AllTestsSuite.java` – Test suite to run all tests together

---

## ✅ Completed Requirements

- ✔️ Wrote test classes for `Calculator`, `Product`, `UserService`, `RecipeBook`
- ✔️ Tested valid and invalid inputs
- ✔️ Used `@DisplayName`, `@ParameterizedTest`, `@Timeout`, `assertAll`
- ✔️ Created a test suite with `@Suite` and `@SelectClasses`
- ✔️ Used lifecycle hooks: `@BeforeAll`, `@AfterAll`, `@BeforeEach`, `@AfterEach`
- ✔️ Included one intentionally failing test (disabled with `@Disabled`)
- ✔️ Used `@Execution(ExecutionMode.CONCURRENT)` for parallel test execution

---

## 📊 Step 7 – Test Coverage

**Test coverage was measured using IntelliJ's built-in tool.**

To run with coverage:
1. Right-click any test class (e.g., `ProductTest`)
2. Select **"Run 'ProductTest' with Coverage"**
3. IntelliJ will display line and method coverage automatically

> No need for EclEmma – IntelliJ integrates coverage for JUnit 5 out of the box.

---


