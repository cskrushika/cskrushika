#### Advantages of Linked lists
* **The size of the arrays is fixed:** So we must know the upper limit on the number of elements in advance. Also, generally, the allocated memory is equal to the upper limit irrespective of the usage, and in practical uses, upper limit is rarely reached.
* **Inserting a new element in an array of elements is expensive**, because room has to be created for the new elements and to create room existing elements have to shifted.

For example, suppose we maintain a sorted list of IDs in an array id[].

id[] = [1000, 1010, 1050, 2000, 2040, …..].

And if we want to insert a new ID 1005, then to maintain the sorted order, we have to move all the elements after 1000 (excluding 1000).

Deletion is also expensive with arrays until unless some special techniques are used. For example, to delete 1010 in id[], everything after 1010 has to be moved.

So Linked list provides following two advantages over arrays: 
  1. Dynamic size
  2. Ease of insertion/deletion
  
#### Linked lists have following drawbacks:
  1. Random access is not allowed. We have to access elements sequentially starting from the first node. So we cannot do binary search with linked lists. Access is O(1) for arrays where it is O(n) for linked lists as the whole list may have to be traversed to search for an element.
  2. Extra memory space for a pointer is required with each element of the list. LL follow non-contiguous memory allocations.
  3. Arrays have better cache locality that can make a pretty big difference in performance.
  
##### The important take-aways can be summed as follows:
  1. Array means contiguous memory. It can exist in any memory section be it Data or Stack or Heap.
  2. Linked List means non-contiguous linked memory. It can exist in any memory section be it Heap or Data or Stack.
  3. As a programmer, looking at a data structure from memory perspective could provide us better insight in choosing a particular data structure or even designing a new data structure. For example, we might create an array of linked lists etc.