# IQ-Business-Assessment

 ## Project setup 

## Technology stack

1.	Hibernate 5.0.7 Final
2.	Postgres 10
3.	JSF 2.2.18
4.	Bootfaces 1.3.0
5.	Primefsaces 6.2
6.	Bootstrap 3.3.7
7.	Wildfly 10.0.0. Final
8.	Maven 3.5.4
9.	Junit 4.12
10.	Spring framework 5.0.8


## Installation
1.	Install maven 
2.	Clone the repository from https://github.com/gershom12/IQ-Business-Assessment
3.	Go to project repository via cmd and type “mvn clean install” to build the project and download all the required dependencies.
## Database setup
1.	Download and install postgresl and PgAdmin IV
2.	Create a postgres database named “empdb” on PgAdmin 
3.	Make sure that the username and password on DataSourceUtilty.java matches the the credentials you used on the postgreSQL server created on PgAdmin 

## How to run

1.	Install wildfly 10.0

2.	Drop PosgreSQL driver into wildfly  

C:\Program Files\wildfly-10.0.0.Final\modules\system\layers\base\org\postgresql

3.	Compile using mvn clean install on the command line

4.	Run unit tests using mvn test

5.	Copy the war file from target folder and drop it on deployment folder folder 
C:\Program Files\wildfly-10.0.0.Final\standalone\deployments

6.	Start ./standalone.sh to start the server 

7.	Open your browser and go to  http://localhost:8080/crudwebapp/", you should see a welcome page explaining what the application does and links on the menu section to navigate to the employee management section.



