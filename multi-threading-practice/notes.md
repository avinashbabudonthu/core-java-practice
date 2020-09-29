# Multi Threading Notes
* multi tasking
	* process of executing multiple functionalities simultaneously
* Why multi tasking
	* to avoid cpu ideal state
* multi tasking types
	* Process based multi tasking
	* Thread based multi tasking
* Process based multi tasking
	* process of executing multiple applications of different technologies simulatenously
* Thread based multi tasking
	* process of executing multiple functionalities of same application simulatenously
* Thread
	* Functionality which can execute simultaneously with other parts of the program.
	* Part of the program under execution. Part of process. Light weight process
* Process
	* program under execution
	* Definition from concurrent programming in java: A process is an operating-system abstraction that allows one computer system to support many units of execution. Each process typically represents a separate running program; for example, an executing JVM. Like the notion of a "computesystem", a "process" is a logical abstraction, not a physical one. So, for example, bindings from processes to CPUs may vary dynamically.
* Scheduling
	* Process of deciding which functionality should execute. 
	* How much time this functionality has to execute. 
	* What functionalty has to execute next. 
	* Scheduling will be done by jvm with the help of local OS. 
	* Definition from concurrent programming in Java: Computations and underlying policies that select which eligible thread to run. These may further interact with other system chores such as processing asynchronous events and garbage collection etc.
* IPC - Inter Process Communication
	* To facilitate the communication between processes operating system support IPC, such as pipes and sockets
	* IPC also supports communication between processes running in different systems.
	* Processes running in same computer system communicates using pipes. 
	* Processes running in different computer systems communicate using sockets. "
* Thread.start()
	* To hand over run() method of java.lang.Runnable interface to jvm to run as an independent task
* multi threading
	* process of defining multiple functionalities as threads and executing multiple threads simultaneously
* suspending thread
	* based on time - `Thread.sleep(100);`
	* based on execution of another thread - `t1.join();`
	* suspend unconditionally to release the lock the current thread acquired - `wait(),notify(), notifyAll()`
	* sleep(), join(), wait() - throws InterruptedException
* Thread safe
	* process of avoiding multiple threads enter common functionality of common object simultaneously. We achive thread safe using synchronized key word
* wait()
	* To release the lock that current thread holding and thread goes to wait state
	* wait() can be called from synchronized block or synchronized method only because intrinsic lock can be acquired while entering into synchronized method or synchronized block and released on exit of synchronized method or synchronized block
* notify()
	* To place a request to jvm to reschedule the thread which has gone to wait state by calling wait() method
* volatile
	* preventing threads caching variable that is changing(from the same thread or by other thread)
