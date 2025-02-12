# 🖥️ Simple Linked List in Java  

This project implements a **singly linked list** in Java, demonstrating how nodes are dynamically linked to form a flexible data structure.  

---

## 📌 Node Class  

The `Node` class represents a **single unit** in the linked list. Each node contains:  
- **`data`** → Stores the string value.  
- **`next`** → A reference to the next node in the list.  

### 🔹 Key Methods  
- **`Node(String data, Node next)`** → Initializes the node with data and a reference to the next node.  
- **`getNext()` / `setNext(Node newNext)`** → Gets or updates the next node reference.  
- **`getData()` / `setData(String data)`** → Gets or updates the node’s data.  

🔗 **Purpose:** Forms the **building block** of the linked list by storing data and linking nodes together.  

---

## 📌 SimpleLinkedList Class  

The `SimpleLinkedList` class **manages a collection of nodes dynamically**, allowing for efficient insertion, retrieval, and traversal.  

### 🔹 Key Methods  
- **`add(String data)`** → Adds a new node to the end of the list.  
- **`get(int position)`** → Retrieves data from a node at a specific position.  
- **`size()`** → Returns the number of nodes in the list.  
- **`isEmpty()`** → Checks if the list is empty.  

🔗 **Purpose:** Implements **fundamental linked list operations**, enabling dynamic memory management and efficient data handling.  

---

## 🎯 High-Level Overview  

| Class | Purpose | Key Features |
|-------|---------|--------------|
| `Node` | Represents a single element in the linked list. | Stores data, links to the next node. |
| `SimpleLinkedList` | Manages the linked list dynamically. | Supports adding, retrieving, and checking size. |

🚀 **Together, these classes create a functional singly linked list in Java!**  

---

## 🛠️ Future Enhancements  

🔹 Implement **node deletion**.  
🔹 Add **search and reverse methods**.  
🔹 Optimize **memory management** for better performance.  

---

## 📬 Let's Connect!  
[![LinkedIn](https://img.shields.io/badge/LinkedIn-Connect-blue?style=flat&logo=linkedin)](https://linkedin.com/in/aaronpereira22)  

🚀 **Always learning, coding, and improving!**
