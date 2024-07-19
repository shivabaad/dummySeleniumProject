<a id="readme-top"></a>

## About The Project

This project demonstrates automation testing of an E-commerce website using Java, Selenium and TestNG. Page object model has been used to create the page and test classes. The pages classes does not have test methods. The test classes do not have any implementation logic. This helps to seperate the concerns of implementing the logic and running the tests.

The initiation of browser is done using Singleton design pattern. This helps to get a single instance of the WebDriver. Thread Local is used to get the driver instance. This helps to parallel tests and avoid race conditions across tests.



### Folder Structure

<p>- drivers</p>
<p>------chrome driver</p>
<p>------gecko driver</p>
<p>------edge driver</p>
<p></p>
<p>- logs</p>
<p></p>
<p>- reports</p>
<p>--- screenshots</p>
<p></p>
<p>- src</p>
<p>--- main</p>
<p>------ java</p>
<p>--------- base</p>
<p>------------ BasePage			Super class of all the page classes. This class has some Utlity methods used to interact with pages.</p>
<p>--------- page classes</p>
<p>------------ Home			Home page has fields and methods encapsulated to interact with the home page.</p>
<p>------------ SearchBar			SearchBar is common throughout all the pages.</p>
<p>------------ SearchItems		Page returned after search items in search bar</p>
<p>------ resources</p>
<p>--------- conf.properties		Has some configuration properties for waits.</p>
<p>--------- Log4j2.xml			Used for Logging</p>
<p>--- test</p>
<p>------ java</p>
<p>--------- base</p>
<p>------------ BaseTest.java		Super class of all the test classes</p>
<p>------------ ExtentManager.java		Used for reporting</p>
<p>------------ Retry.java			Used for retrying failed tests</p>
<p>------------ RetryTransform.java</p>
<p>------------ TestListener.java		Used for listening to tests outcome. The test outcome can be success, failed, skipped etc</p>
<p>------------ Utils.java			Has some common utilities</p>
<p>------------ WebDriverFactory.java	Used to instantiate the WebDriver which is thread local</p>
<p>--------- tests</p>
<p>------------ HomePageTests.java</p>
<p>------------ SearchTests.java</p>
<p></p>
<p>- pom.xml</p>
<p></p>
<p>- testng.xml</p>
<p></p>


### Prerequisites

1. Java 11 or more
2. Maven 3.9.1
3. Clone this repository
4. Make sure that the browsers are updated.




### Running the tests

* On Chrome browser
  ```sh
  mvn clean test -Dbrowser=chrome
  ```

* On Edge browser
  ```sh
  mvn clean test -Dbrowser=edge
  ```

* On Firefox browser
  ```sh
  mvn clean test -Dbrowser=firefox
  ```
