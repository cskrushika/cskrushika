##### Difference between Array and ArrayList in detail?
* Arrays are fixed sized; set during initialization. ArrayList is variable sized. It is created with a default size.
* But as ArrayList is backed by an array, a resize operation slows down the performance as it involves creation of new array and copy of content from old to new array.
* Primitives cannot be stored in ArrayList. Only Objects can be stored in ArrayList. Arrays can store both primitives and Objects
* JVM through Autoboxing(converting primitives to equivalent objects internally) ensures that only objects are added to the arraylist object.
  <pre><code>
  ArrayList  arraylistobject = new ArrayList();`
  arraylistobject.add(23);  // try to add 23 (primitive)
  </code></pre>
  
* **Generics cannot be used with array.**<br>
ArrayStoreException is thrown when an attempt to store a different type in an array is made. ArrayList allows you to use Generics to ensure type-safety.
* Performance of arrays is higher compared to ArrayList
* Arrays are multi-dimensional
* Syntax related:
Size of array: `array.length;`
Size of ArrayList: `arrayList.size();`
  <pre><code>
  Array: array[i] = object;
  ArrayList: arrayList.add(object);
  </code></pre>
  
##### Instantiate Queue using Java Collections
A *Queue* is an *interface*, which means you cannot construct a Queue directly except via an anonymous inner class.

The best option is to construct off a class that already implements the Queue interface, like one of the following: *ArrayDeque, LinkedList, AbstractQueue, ArrayBlockingQueue, ConcurrentLinkedQueue, DelayQueue, LinkedBlockingQueue, PriorityBlockingQueue, PriorityQueue, or SynchronousQueue*. For example:
<pre><code>
Queue<Integer> q = new LinkedList<Integer>();
	or
Queue<Integer> q = new ArrayDeque<Integer>();
</code></pre>

Typically you pick a collection implementation by the performance and concurrency characteristics you're interested in.



