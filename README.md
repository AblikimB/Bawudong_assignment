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
Run tests in headless mode with maven comm:

change the browser to headless-chrome in configuration.properties and run

mvn test -Dheadless=true

#### Cross Browser
Run tests in different browsers:

change the browser accordingly in configuration.properties  and run the following commands respectively

mvn test -Dbrowser=chrome
mvn test -Dbrowser=firefox

### CI/CD Integration
I have established a pipeline on Jenkins for the smoke test suite, scheduled to execute daily at 8:00 AM EDT. This automated process is also set to send email notifications upon completion. Furthermore, any new push to the remote repository triggers the Jenkins pipeline, ensuring consistent and efficient test execution.

### Reporting
Cucumber generates detailed test reports, which can be accessed in the target/cucumber-reports directory. Additionally, Jenkins also generates comprehensive Cucumber reports as part of its integration, providing a centralized location for reviewing test results and trends.

### Taking Screenshots for Failed Tests
In the event of a test failure, screenshots are automatically captured and saved in the target/screenshots directory. You can review these screenshots to gain insights into the cause of failures.

# Approach to Test Scenarios
## Scenario Abstraction
In designing my test scenarios, I've taken a pragmatic approach by abstracting certain interactions to focus on the broader functionality being tested. This allows me to keep the scenarios concise and maintainable while still effectively covering the intended testing areas.

For instance, in scenarios like "Verify new orders are added to My Orders" and "Verify new review added to My Product Reviews," I've abstracted the step-by-step interactions of placing orders and writing reviews. Instead, I've used placeholders like <order> and <product> to signify the specific items without getting bogged down in detailed user interactions.

### Abstracted Steps for Brevity
My scenarios focus on testing the core functionalities without overly emphasizing every step of user interaction. This approach helps me cover a wider range of scenarios efficiently and keeps the scenarios concise, which is especially useful when the step-by-step interactions are less critical to the testing objectives.

### Utilizing Different Cucumber Approaches
I've also showcased the versatility of Cucumber by employing various approaches, such as using data tables to handle diverse test data inputs effectively and crafting utility methods to encapsulate common interactions, thereby enhancing the scenarios' maintainability and readability. Additionally, I adapt my use of Given steps based on the scenario's context, sometimes placing them in the background for one feature and directly under each scenario for another, ensuring flexibility and alignment with scenario-specific requirements.

### WebDriver Management and Parallel Execution
To ensure efficient WebDriver management and enable parallel execution, I've implemented the Singleton design pattern for my Driver instance. Moreover, I've utilized ThreadLocal to encapsulate the WebDriver object on a per-thread basis. This approach creates a separate copy of the driver for each thread, allowing me to run scenarios in parallel without interference and ensuring a smooth and independent testing environment.

### Applying the Page Object Model (POM)
In line with best practices, I've embraced the Page Object Model (POM) to enhance the test project's structure and maintainability. By encapsulating web page elements and their interactions in dedicated Page classes, I've achieved cleaner and more modular test scenarios. This design decision has contributed to improved readability and ease of maintenance across the test suite. Additionally, I've expanded the usage of Page classes to cover a wider range of pages, further promoting organization and scalability.

### Summary
Overall, my approach to test scenario design encompasses abstraction, background utilization, brevity, versatility in Cucumber approaches, WebDriver management, parallel execution handling, cross browser  and adherence to the Page Object Model. These combined strategies empower me to conduct effective, streamlined, and comprehensible testing while upholding the project's scalability and maintainability.
