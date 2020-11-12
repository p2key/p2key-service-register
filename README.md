# p2key-service-register

Used Libraries
--------------
Embeded Tomcat<br>
Jersey API<br>
MySql Driver

Component Diagram
-----------------

![alt text](https://github.com/p2key/p2key-service-register/blob/main/resources/img/service_register.png)

URLs of Services
----------------
<pre>
HTTP GET	service/all			Get all services<br>
HTTP GET	service/all/actives		Get all active services		<br>
HTTP GET	service/all/deactives		Get all deactive services	<br>
HTTP GET	service/{serviceName}		Get a specific service		<br>
HTTP POST	service/insert			Insert a service		Required JWT token<br>
HTTP POST	service/update/{serviceName}	Update a specific service	Required JWT token<br>
HTTP POST	service/delete/{serviceName}	Delete a specific service	Required JWT token<br>
HTTP POST	service/{serviceName}/promote	Promote a specific service	<br>
</pre>

URLs of Owners
--------------
<pre>
HTTP GET	owner/all				Get all owners of services<br>
HTTP POST	owner/insert				Insert a owner<br>
HTTP POST	owner/update/{ownerName}		Update a specific owner<br>
HTTP POST	owner/delete/{ownerName}		Delete a specific owner<br>
</pre>