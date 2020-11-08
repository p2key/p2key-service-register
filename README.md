# p2key-service-register

![alt text](https://github.com/p2key/p2key-service-register/blob/main/resources/img/service_register.png)

URLs of Services
----------------
HTTP GET	service/all						Get all services			OK<br>
HTTP GET	service/all/actives				Get all active services		OK<br>
HTTP GET	service/all/deactives			Get all deactive services	OK<br>
HTTP GET	service/{serviceName}			Get a specific service		OK<br>
HTTP POST	service/insert					Insert a service			OK<br>
HTTP POST	service/update/{serviceName}	Update a specific service	OK<br>
HTTP POST	service/delete/{serviceName}	Delete a specific service	OK<br>
HTTP POST	service/{serviceName}/promote	Promote a specific service<br>


URLs of Owners
--------------
HTTP GET	owner/all						Get all owners of services<br>
HTTP POST	owner/insert					Insert a owner<br>
HTTP POST	owner/update/{ownerName}		Update a specific owner<br>
HTTP POST	owner/delete/{ownerName}		Delete a specific owner<br>