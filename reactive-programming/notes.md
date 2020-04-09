# RXJava

## What is the meaning of Ractive programming?
* Making applications event driven, so that they structured in a way that they works well with concurrency
* Good structure for decoupling modules from each other
* Making application `Scalable`
* Making application `Resilient` in load and failure conditions
* Making application `Responsive`

## Functional Programming Pure Functions
* method1 in below code is pure function because
	* it is thread safe
	* no dependency on state of the object
```
public class AppClass{
	public void method1(int i){
		return i+10;
	}
}
```
* method2 in below code is impure function because
	* it has dependency on instance variable `j`
	* if multiple threads executing method2 then results are unpredicable
```
public class AppClass{
	private int j = 10;
	
	public void method2(int i){
		j = j + 20;
		return i+j;
	}
}
```

## Reactive programming concepts
* [Documentation](https://www.reactivemanifesto.org/)
* Event Driven
* Scalable
* Resilient
* Responsive

## Observer pattern
* We have `Observable` object
* we will have one or more `observer` objects that subscribe themselves to observable
* Now any changes to observable are sent to observers as notifications. These notifications can be synchronous or concurrent

### RXJava use of Observer pattern
* RXJava also have `Observable<T>`, `Observer<T>`
* Notice that they are generic
* notifications from observable to observers are sent concurrently. RXJava handles threading for concurrency

### Reactive programming Resilience
* Graceful error handling
* Manager failure