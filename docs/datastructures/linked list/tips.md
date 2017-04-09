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
<pre><code>
while (fastptr != NULL && fastptr->next != NULL)
        {
            fastptr = fastptr->next->next;
            slowptr = slowptr->next;`
        }
</code></pre>

* **Using additional data structures**
Use additional data structures to keep state of the problem being solved. Some of them are:
  * HashMap or Hash table. It contains key-value pairs
  * Use **Stacks** or **Queues** to solve certain problems
  
