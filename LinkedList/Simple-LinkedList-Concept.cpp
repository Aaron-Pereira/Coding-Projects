#include <iostream>
using namespace std;

class Node{
   public:
       int data; // the data stored in this node
       Node* next; // pointer to the next node so that nodes can be linked up
};

class LinkedList{
   public:
       int length; // length of the list
       Node* head; // pointer to the first element (node) of the list

       LinkedList(); // constructor is called when a class object is created
       ~LinkedList(); // constructor is called when a class object is deleted
  
       void prepend(int data); // add a new node (containing the input data) to the front of the list
       void append(int data); // add a new node (containing the input data) to the end of the list
       void display(); // show all the data contained in (all the nodes of) the list   
};

LinkedList::LinkedList(){
   this->length = 0; // initialise list length to zero
   this->head = nullptr; // initially, the list is empty upon creation
}

int main(){

   // declare a pointer (an empty linkedlist)
   LinkedList* list = new LinkedList();

   //create a new object called n of type Node
   Node* n = new Node();

   //access n.data and set it to equal 1
   n->data = 1;

   //access n.next and set equal to nullptr
   n->next = nullptr;

   cout << "\n"<< "n data value: " << n->data;
   cout << "\n"<< "n next address: " << n->next;

   //set the linked list length to = 1
   list->length = list->length+1;

   //print the length out
   cout << "\n"<< "Linked list length: " << list->length;


   //set the head of the linked list to be the
   //first and only node
   list->head = n;

   //prints out the memory address of the head node
   cout<< "\n" << "Memory address of head node: " << list->head;

   //create second node m
   Node* m = new Node();

   m->data = 2;
   cout<< "\n" << "m data value: " << m->data;

   //this is now the last node in the list
   //so it has no pointer to anything after it
   m->next = nullptr;


   //update previous node to contain address to
   //this newly created node
   n->next = m;

   cout << "\n"<< "n next address:" <<n->next << "\n";
  
}

