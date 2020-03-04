# Serialization and De-serialization 

## Bullet points
* Store objects
* Store from runtime into a byte stream
* Restore from byte stream into runtime
* Save object to file system
* Save object to database. RDBMS store them in blob columns. OODBMS store directly
* Pass objects across memory addresses
* Pass objects over network
* Store object means, serialization stores entire object graph. Means it stores all objects that storing object points to
* De-serialization takes byte stream and rebuilds object graph
* Serialization
	* Serializing
	* De-serializing

## How
* Uses reflection
* Operates only on instance members
* If we want to apply for static, we can customize to do that

## Serialization Types
* 