#### Tips and cues on Linked lists
* While deleting the linked list in Java setting the head node as null breaks the references to subsequent nodes and as java has GC, the used space by other nodes are cleared during next GC run. In case of C++, it is a better idea to clear the memory for each node.

* While performing any operations on LL, consider the following boundary conditions:
  * The head is null
  * Or the head node contains the key being searched for
  * If there is only one node present currently in the LL
  * If dealing with exact position of node, consider for first and last positions
  
* While traversing through the linked list always copy the reference of the head node into another object, temp node and then traverse over the temp node. In this way the original head node is untouched.

    `// Store head node`
    `Node temp = head;`

#### Usable strategies for LL Problems
* **Fast and slow pointers** 
`while (fast_ptr != NULL && fast_ptr->next != NULL)`
  `      {`
        `    fast_ptr = fast_ptr->next->next;`
          `  slow_ptr = slow_ptr->next;`
   `     }`