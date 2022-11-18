# java-bdd-automation-practice

## List of tests

- Authentication
- Add a product to cart
- Finish checkout process
- Add product to wishlist
- Verify last purchase in My Orders


## Project Structure

### Short explanation of each folder/package

#### src/main/resources
Contains the property files that are used in the framework. Currently, only browser parameter. This file will be moved.

#### src/test/java
Contains the next folders:
- driver: Classes to manage the driver, includes Singleton and Strategy pattern classes.
- helper: Contains classes with code that is utilized in the framework, i.e. Constants. 
- pageobjs: Classes that follows the page factory pattern
- steps: Classes with the logic behind each BDD step
- utils: Methods to use in all the rest of classes

#### src/test/resources
Contains the next folders:
- features: Contains the BDD feature files.
- testdata: Contains file for parametrized tests.

## How to run BDD tests

For now execute the file "RunTests" located in **src/test/java** <br>
This will execute all the feature files.