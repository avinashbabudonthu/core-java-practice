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
* Serialization means both
	* Serializing
	* De-serializing

## How
* Uses reflection
* Operates only on instance members
* If we want to apply for static, we can customize to do that

## Serialization Types
* Serializable interface
	* Implemented by any type that need to be serializable
	* This indicates that type supports serialization
	* Has no methods. This is marker interface
* ObjectOutputStream
	* class used to serialize
	* Take object graph and write it to stream
* ObjectInputStream
	* Take byte stream as input and create object graph

## Requirement for Serilization
* Implement Serilizable interface
* All members should be serializable
	* Primitive types are serializable by default
	* Other members other than primitives must implement Serializable interface

## Examples
* Serialize object - [Serialize.java](src/test/java/com.serialization/Serialize.java) - **saveEmployeeObject()**