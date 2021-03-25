# BBlogTest
Testing BackBase Blog Site

This is a Gradle project that utilized Cucumber BDD with Selenium Webdriver.  The tests can be ran from Command Line Interface or within the IDE.  Reports are written to: *BBlogTest\target\cucumberReports\html.html*


### Running from CLI
1. Open your command line and cd into the projects workspace.
2. Send the text "*.\gradlew.bat test --tests RunBBlogTests*"

The tests will kick off after gradle loads up for the first time and you'll receive some output such as:
![image](https://user-images.githubusercontent.com/35895736/112500049-08d7db00-8d56-11eb-8be9-dc886524416e.png)


### Running from IDE
 There are three ways to run the tests from the idea.  
   1. Gradle tasks / other / cucumber
   2. From RunBBlogTests
   3. From feature files


### Getting the reports  
The cucumber html report is written to: *BBlogTest\target\cucumberReports\html.html*
