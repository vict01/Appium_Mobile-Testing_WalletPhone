# Appium Automation Testing For Monefy App

## Overview
This is the test automation for Monefy application mobile, which contains a set of automated steps based on Android application, which in turn compound one of the proposed scenarios automated. 

## Explanation of the Automated Scenario 
Record a income, record a expense, then evaluate if income minus expense are equal to balance calculated by application. If so, then, the result is successful, otherwise is failed.  

### How to use the test suite
```
1. Open MonefyMainClass java class
2. Below the main method, there are two commented line, each of them with a String variable initialized with any values,
   which corresponds to the income and expense amount (incomeAmount and expenseAmount, correspondingly) required to start testing.  
3. Change the values of variables incomeAmount and expenseAmount as desired.
4. Run MonefyMainClass java class
5. Once test finish to run,in the IDE console you'll see a printed message indicating if the test succeeded or failed, 
   based on the scenario definition in above section. 
```

### Folder structure
- lib folder (stored in the project root folder): Which contains all libraries used in the project. 
- MonefyBaseClass java class: Which contains all methods used in MonefyMainClass java class.
- MonefyMainClass java class: Which contains the main method, and all steps that make up the test. 
- com.monefy.app.lite_2019-10-27.apk: APK file, based on which run the automated test.

### Note
In general terms the best practice to build the framework structure would be create one java class for each phone screen (with its corresponding attributes and methods) and then instanciate it from main method using Page Object Model as needed; however considering I had time only for automate one scenario using just a few screen and buttons where most element had the same locator, I considered this pattern a risk to finish ontime and probably an unnecessary effort in this specific situation. 

### Used tools/technologies
```
IDE IntelliJ
java 
Appium
Selenium
Node.js
Android Studio
```
