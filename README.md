# anzcodingchallenge
ANZ Wholesale Engineering Sample Project – Backend Development
The sample application being requested by the candidate to build the backend service
needed to support a web application to that allows a user to view transactions on any of the
accounts they hold.
Required functionality:
- View account list
- View account transactions
Technology Guidelines:
UI
Not applicable and outside of the scope of this project.
Backend Server
Utilise standard java and spring boot and other spring projects as a base. Add any other
framework as necessary.
# Prerequisites to run application
- Java 8
- Maven
- Access to maven central to download required jars
- Port 8080 should be available for use.

Steps to run 

1. Import this maven project in eclipse and run main class AccountApplication.java
This will bring up apring boot application and hapy flow can be tested by hitting following URLs

User Accounts - with Data  
http://localhost:8080/anz/user/1/accounts  
http://localhost:8080/anz/user/2/accounts

User Accounts - No Data  
http://localhost:8080/anz/user/3/accounts

User Accounts - Exception  
http://localhost:8080/anz/user/4/accounts

Account Transactions - with Data  
http://localhost:8080/anz/account/1000/transactions  
http://localhost:8080/anz/account/4000/transactions

Account Transactions - No Data  
http://localhost:8080/anz/account/2000/transactions  

Account Transactions - Exception  
http://localhost:8080/anz/account/8000/transactions  

# Frameworks Used
- Spring
- Hibernate
- Jackson Databind

# Assumptions

- Assumed association between User and Account in DB design. May not be always the case.
- Used separate mapping table for accounts and transactions
- Testing done with mockito to verify interactions. Integration tests not present but can be added using frameworks like DBUnit etc
- Exception handling is very generic to avoid whitelabel page but that can definitely be improved further.