# IQ-Business-Assessment

 ##Project setup 

The runtime environment for the project are
1.	Java 8
2.	Wildfly 10.0
3.	PostgreSQL 11 and PgAdmin IV

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


