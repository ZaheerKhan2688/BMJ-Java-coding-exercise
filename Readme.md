Endpoint 1:  "/courseSearch/{searchTerm}"

controller -> service -> Repository - > fetch the details from H2 database in memory -> return details matched

Ex: http://localhost:8080/courseSearch/{searchTerm}



Endpoint 2:  "/courseSearchTime/{searchTerm}"

controller ->  service -> Repository - > fetch the details from H2 database in memory
											
-> return details with sum of hours by spliting by "," and suming up all hours and keeping list<courseces> in response.
							
EX: http://localhost:8080/courseSearchTime/{serachTerm}