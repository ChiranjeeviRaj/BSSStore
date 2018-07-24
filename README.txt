BSS Store Test

Java 8 simple Shot Cart with JUnit
----------------------------------------------

Tech:
Java 8
Spring
JUnit

Implementation
The Project structured in to three layers

model : All POJO's created on Model which can extendable to any persistence unit. The Pojos created by considering data model.
entity : Persistence unit can be extended by creating Dao's. For the time being created dummy class MockEntityFactory which populates some dummy data
service : service to implement business logic and fetch data from the eitity.


Data Model in Mind :

A product can contain on offer and an offer can be multiple types. If the product has offer then discount applies for the product.
We can also include more similar offers by changing the data with out changing the code.

Set Up Project on Eclipse
IN ECLIPSE:

Import as a maven project and create folowing maven run config ...

 - With goal "mvn clean test" to run unit tests
 - With goal "mvn clean package" to build source packages
 - Runing Main Class : Right click on Run the class and config params /service/src/main/java/Main.java

