# CloudComputing

URL: http://cloud.ib9g3mmngc.us-west-2.elasticbeanstalk.com

## Sample API



## **Add Professor**

  Returns json data about the professor.

- **URL**

  /webapi/professors

- **Method:**

  `POST`

- **Data Params**

  None

- **Success Response:**

  - **Code:** 200
  
    **Content:** 
    
    `{
    "id": "1761448090",
    "firstName": "Bruce",
    "lastName": "Jane",
    "department": "Computer",
    "professorId": "BruceJane",
    "joiningDate": "20181111"
    }`

## **Get All Professors**

  Returns json data of all the professors.

- **URL**

  /webapi/professors/all

- **Method:**

  `GET`

- **Data Params**

  None

- **Success Response:**

  - **Code:** 200
  
    **Content:** 
    
    `{
    "id": "1761448090",
    "firstName": "Bruce",
    "lastName": "Jane",
    "department": "Computer",
    "professorId": "BruceJane",
    "joiningDate": "20181111"
    }`
