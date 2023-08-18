## README: Execution Instructions
Below are the instructions for setting up and executing the tests using my Cucumber BDD framework built with Java and Maven. I've incorporated options for different browsers, smoke and regression testing, parallel execution, and headless mode. In addition, I have seamlessly integrated my tests into a CI/CD environment using Jenkins.

### Prerequisites
- Java JDK 11 or later
- Maven
Chrome and Firefox browsers
### Setup
- Clone the repository from GitHub: git clone <repository-url>
- Navigate to the project directory: cd <project-directory>
- Install project dependencies: mvn clean install
### Execution
#### Run Smoke Tests
To run smoke tests on the Registered Customers section, execute:

mvn test -Dcucumber.filter.tags="@smoke"

#### Parallel Test
To run tests in parallel, use:

mvn test

#### Headless Mode
Run tests in headless mode:

change the browser to headless-chrome in configuration.properties and run 

mvn test

CI/CD Integration
I created pipeline for smoke test. will show during the meeting

### Reporting
Cucumber generates test reports. Access them in the target/cucumber-reports directory.

# Approach to Test Scenarios
## Scenario Abstraction
In designing my test scenarios, I've taken a pragmatic approach by abstracting certain interactions to focus on the broader functionality being tested. This allows me to keep the scenarios concise and maintainable while still effectively covering the intended testing areas.

For instance, in scenarios like "Verify new orders are added to My Orders" and "Verify new review added to My Product Reviews," I've abstracted the step-by-step interactions of placing orders and writing reviews. Instead, I've used placeholders like <order> and <product> to signify the specific items without getting bogged down in detailed user interactions.

### Background Usage
In some cases, I've utilized the Background section of feature files to set the context for multiple scenarios. For example, in the "Registered Customers" section, the Given User is on My Account Page step is placed in the Background to ensure a consistent starting point. This helps in reducing repetition and promoting a clear flow of scenarios.

### Abstracted Steps for Brevity
My scenarios focus on testing the core functionalities without overly emphasizing every step of user interaction. This approach helps me cover a wider range of scenarios efficiently and keeps the scenarios concise, which is especially useful when the step-by-step interactions are less critical to the testing objectives.

### Utilizing Different Cucumber Approaches
I've also showcased the versatility of Cucumber by employing various approaches. I've used scenario outlines with data tables to handle different test data inputs effectively. Additionally, I've crafted utility methods to encapsulate common interactions, enhancing the maintainability and readability of the scenarios.