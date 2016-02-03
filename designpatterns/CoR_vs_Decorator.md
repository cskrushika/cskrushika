Chain of Responsibility vs Decorator
==

** Differences:**
* In CoR each link can handle the request or pass it up the chain. 
* CoR is like a callback or exception handling. The exception could be swallowed up or passed to caller.
* COR is used when one of many actors might take action on an object. Decorator as "adding" to some thing in different combinations. 
* Think of decorators as a layered unit in which each layer always does pre/post processing. CoR is more like a linked list, and generally 1 actor handles processing.
* CoR is a Behavioral pattern whereas Decorator is a Creational pattern. 

**Similarities:**
* Both use composition instead of inheritance to provide a flexible solution
* Deep inheritance is avoided in both the cases.