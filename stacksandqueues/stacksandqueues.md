# Stacks and Queues

A library for implementations of stacks and queues.

## Challenge

Build implementations for stack and queue style data structures and well as a node class. Both stacks and queues should use node elements and be able to add, remove, check top value, and check existence of nodes.

## Approach & Efficiency

I started by building the Node class and creating a set of tests that would prove their base functionality. Once the nodes were ready, I created the Stack class.

The Stack class only points at the top node. Through its methods, it can add nodes to the top of the stack and check the values in those nodes. It is also able to pop the top node off the stack and retrieve its value. Each method is tested successively to prove its own functionality and only uses methods proved to work previously if necessary.

The Queue class includes a pointer to the front of the queue as well as a pointer to the back. The pointer to the back allows for efficient addition of values while the pointer to the front allows for efficient retrieval. All interaction with the queue instances is handled through their methods to add, remove, check value, and check emptiness.

Time Efficiency:
  - Stack Methods:
    - push : O(1)
    - isEmpty : O(1)
    - pop : O(1)
    - peek : O(1)
    - toString : O(n)
  - Queue Methods:
    - isEmpty : O(1)
    - enqueue : O(1)
    - dequeue : O(1)
    - peek : O(1)
    - toString : O(1)


Space Efficiency:
  - Stack Methods:
    - push : O(1)
    - isEmpty : O(1)
    - pop : O(1)
    - peek : O(1)
    - toString : O(n)
  - Queue Methods:
    - isEmpty : O(1)
    - enqueue : O(1)
    - dequeue : O(1)
    - peek : O(1)
    - toString : O(1)

## API

Stack Methods:
  - push : Takes in an integer and adds it to the top of the stack.
  - isEmpty : Checks if there are values in the stack. Returns true if there are, false if not.
  - pop : Returns the most recent value added to the stack and removes it from the stack. If the stack is empty, throws a null pointer exception.
  - peek : Returns the most recent value added to the stack. If the stack is empty, throws a null pointer exception.
  - toString : Returns a string representing the stack.

Queue Methods:
  - isEmpty : Checks if thre are values in the queue. Returns true if there are, false if not.
  - enqueue : Takes in an integer and adds it to the back of the queue.
  - dequeue : Returns the value from the front of the queue and removes it from the queue. If the queue is empty, throws a null pointer exception.
  - peek : Returns the value from the front of the queue. If the queue is empty, throws a null pointer exception.
  - toString : Returns a string representing the queue.