The task

Develop a web application for paying for tickets. The application should consist of an HTTP API and application logic.

API

The API works in JSON format and consists of two services:

Service for accepting applications for payment. Receive, validate and save the application in the database.
At the entrance accepts:

Route Number

Date and time of departure
The output gives (if successful):

Request ID

Service for checking the status of the application. Gets data about the application from the database.
At the entrance accepts:

Request ID
The output gives:

Application Status
Applications must be stored in the database (optional).

Application logic

The payment process (runs once a minute):

Selects an application suitable for holding from the database

Sends a request to the http-service (the service can be implemented in the same application as a separate endpoint) of the payment gateway, which randomly returns statuses (processed, error, completed)

Updates application status

The statuses “Error” or “Failed” are final, i.e. repeat request not required

