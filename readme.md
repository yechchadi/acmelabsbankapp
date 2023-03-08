# Current Account API

This is a RESTful API that allows existing customers to open a new current account with an initial credit. The API exposes two endpoints: one for opening a new account and another for retrieving user information including their account balance and transaction history.

### Technologies Used

Java 17
Spring Boot
Maven
JUnit
Mockito

### Setup Instructions

Clone the repository:

`git clone https://github.com/yechchadi/acmelabsbankapp.git`

Navigate to the project directory:

`cd acmelabsbankapp`

Build the project:

`mvn clean install`

Run the application:

`java -jar target/acmelabsbankapp-1.0.0.jar`

The API can be accessed at http://localhost:8080.

### API Endpoints

The following are the API endpoints for the Account service:

**POST** _/account/create_

Request body: {"customerID": "4A55BT", "initialCredit": 2000.00}
Response body: {
    "accountID": "oB3QWADy",
    "customerID_ext": "4A55BT",
    "initialCredit": 2000,
    "balance": 2000,
    "transactions": []
    }

**GET** _/customer?customerID=4A55BT_

Response body:
{
    "customerID": "4A55BT",
    "name": "Alan",
    "surname": "Turing",
    "accounts": [
        {
        "accountID": "Fed2NEVr",
        "customerID_ext": "4A55BT",
        "initialCredit": 4500,
        "balance": 4500,
        "transactions": [
            {
            "transactionID": "RibKS-JK2hrPIrY",
            "amount": 4500,
            "date": "2023-03-07T23:56:55.527+00:00",
            "accountID_ext": "Fed2NEVr"
            }
            ]
        },
        {
        "accountID": "wlTia2xw",
        "customerID_ext": "4A55BT",
        "initialCredit": 6000,
        "balance": 6000,
        "transactions": [
            {
            "transactionID": "RibKS-JK2hrPIrY",
            "amount": 6000,
            "date": "2023-03-07T23:56:55.527+00:00",
            "accountID_ext": "wlTia2xw"
            }
            ]
        },
        {
        "accountID": "e7Ts1y8C",
        "customerID_ext": "4A55BT",
        "initialCredit": 0,
        "balance": 0,
        "transactions": []
        }
        ]
}

### Data Model

The following is the proposed data model for the solution:

#### Customer

customerID (String)
Name (String)
Surname (String)
Accounts (List)


#### Account

accountID (String)
customerID_ext (String)
initialCredit (Integer)
balance (Integer)
Transactions (List)

#### Transaction

transactionID (String)
accountID_ext (String)
amount (Integer)
date (Date)

### Testing

Unit tests will be created for each microservice using JUnit and Mockito. Integration tests will also be created to test the communication between the microservices.

### Continuous Integration and Continuous Deployment

Continuous Integration and Continuous Deployment (CI/CD) will be implemented using GitHub Actions. The CI/CD pipeline will automate the build, test, and deployment process of the microservices.