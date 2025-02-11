# 🖥️ Linked List Implementation in C++

This project demonstrates the **basic implementation of a singly linked list in C++**, covering **node creation, linked list initialization, and dynamic memory management**.

## 📌 How It Works

1. **Initializing the Linked List**  
   - A new **linked list object** is created, triggering its **constructor**.
   - The constructor initializes:
     - `length = 0` (indicating an empty list).
     - `head = nullptr` (since no nodes exist yet).

2. **Creating a New Node**  
   - A new **node `n`** is created.
   - The **data** value of `n` is set to `1`.
   - The **next pointer** of `n` is set to `nullptr`, meaning it's not linked to any other nodes yet.
   - The node’s data is printed to confirm its creation.

3. **Adding the Node to the Linked List**  
   - The **length of the list** is incremented by `1`.
   - The `head` pointer is updated to point to the **new node `n`**, making it the first node in the list.
