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
1.	After the environment has been setup, compile the application by running mvn clean install on the command line.
2.	Copy the war file from the target folder of the application and drop it into the deployment folder of your wildfly application server.
3.	Once the war file has been pasted on the deployment folder, go to the bin folder of wildfly and start the application server by running the following command ./Standalone.sh
4.	Open your browser and go to "http://localhost:8080/crudwebapp", you should see a welcome page explaining what the application does and links on the menu section to navigate to the employee management section.


