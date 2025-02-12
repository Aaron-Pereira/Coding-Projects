# 🖥️ Node Class - Java (Singly Linked List)

This project implements a **Node class** in Java, forming the **building block of a singly linked list**.  
Each node stores **data** (a `String`) and a **reference to the next node** in the list.

---

## 🚀 Features

- **Stores a string value** as node data.  
- **Maintains a pointer** to the next node in the list.  
- Provides **constructors, getter/setter methods, and a `toString()` method** for easy manipulation.  
- Enables **dynamic linking of nodes** to form a **singly linked list**.  

---

## 📜 Code Overview

### **🔹 Node Class**
```java
public class Node {
    private String data;
    private Node next;

    public Node() { this("", null); }
    public Node(String data) { this(data, null); }
    public Node(String data, Node next) { this.data = data; this.next = next; }

    public Node getNext() { return this.next; }
    public void setNext(Node newNext) { this.next = newNext; }

    public String getData() { return this.data; }
    public void setData(String data) { this.data = data; }

    @Override
    public String toString() { return "[Node: " + this.data + "]"; }
}

