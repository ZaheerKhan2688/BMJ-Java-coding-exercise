----------------------------------------------
EndPoint 1:  "/courseSearch/{searchTerm}"
----------------------------------------------

Ex: http://localhost:8080/courseSearch/{searchTerm}

Method: GET
Response: 
[{"id":2,"title":"3.5,Introduction to coronavirus disease 2019 (COVID-19)"},{"id":3,"title":"2.00,Clinical pointers: COVID-19 in primary care"},{"id":7,"title":"7.50,Introduction to testing for COVID-19"}]

----------------------------------------------
EndPoint 2:  "/courseSearchHours/{searchTerm}"
----------------------------------------------
				
EX: http://localhost:8080/courseSearchTime/{serachTerm}

Method: GET
Response: 
{"sumOfHours":3.5,"courses":[{"id":2,"title":"3.5,Introduction to coronavirus disease 2019 (COVID-19)"}]}

**************************
SpringBoot: 2.7.4
Java: 11
Database: H2 in memory ( once application is started, the data added to database will be visible.
http://localhost:8080/h2-console)
**************************
