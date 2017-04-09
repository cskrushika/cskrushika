#### Problems

######Find Nth node from last in a linked list

  1. Take 2 pointers, say ptrA and ptrB. initialize both pointers pointing at start node.
  2. Move ptrB to Nth node from start keeping ptrA at start node. By doing this the gap between ptrA and ptrB remains as n.
  3.  If Nth position is not available that is, if ptrB encounters NULL before reaching Nth position, then given Nth position is not available and is incorrect, so return -1.</br>
    If Nth position is valid input, then place ptr2 at Nth position.
  4. Now, when both pointers are at N distance from each other, increment ptrA and ptrB one node at a time until ptrB encounters NULL.
  5. When ptrB reaches NULL, it means ptrA reached Nth position from last. So return node at position ptrA.
  ** Time complexity:** O(n) 
  ** Space complexity:** O(1)
  
###### Alternative solution for above problem using recursion:
Use a global variable t otrack the post  recursive call and when it is same as the Nth, return the node.

<pre><code>
public Node nThNodeFromEnd(Node head, int nTh){
    if(head!=null){
        nThNodeFromEnd(head.next,Nth)
        counter++;
        if(counter==n)
            return head;	// returning the node which is nth node from end	
    }
    return null;
}
</code></pre>

