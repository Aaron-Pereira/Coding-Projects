public class SimpleLinkedList {
    


    private Node head; // Points to the first node in the list
    
    /**
     * Constructor: Initializes an empty linked list.
     */
    public SimpleLinkedList() {
        head = null;
    }
    
    /**
     * Adds a new node with the given data at the end of the list.
     */
    public void add(String data) {
  
        Node b = new Node(data);
        Node temp = new Node(null, head);
        if (this.isEmpty()== true){
            head = b;
        }
        
        while(temp.getNext() != null){
            temp = temp.getNext();
        }

        temp.setNext(b);

    }
    
    /**
     * Inserts a new node at the specified position.
     */
    public void add(int position, String data) {

        Node dataContainer = new Node(data, null);
        Node temp = new Node(null, head);
        if(position > this.size()){
            return;
        }
        if(position < 0){
            return;
        }
        if (position == 0){
            head = dataContainer;
        }
      
        int i = 1;
    
        while(i <= position){
            
            temp = temp.getNext();
            i++;
        }
        dataContainer.setNext(temp.getNext());
        temp.setNext(dataContainer);
                
    }
    
    /**
     * Retrieves data from the node at the specified position.
     */
    public String get(int position) {
  
              if(position == 0){
            return head.getData();
			
        }

	    if(position >= this.size() || position <= 0){
            return null;
            //System.out.println("out of range works");
			
			
			
        } else {
       
        Node temp = new Node("", head);

        int i = 0;
        
        while(i <= position){
            temp = temp.getNext();
            i++;
        }
    
        return temp.getData();
        
		}
    }
    
    /**
     * Removes and returns data from the node at the specified position.
     */
    public String remove(int position) {

        
        Node tempNode;
        if(position >= this.size() || position < 0){
            //System.out.println("remove out of position works");
            return null;
        }
        
        if(position == 0){
            
            head = head.getNext();
            
        }
        String dataTemp;
        Node temp = new Node(null, head);

        int i = 0;
        
        while(i <= position-1){
            temp = temp.getNext();
            i++;
        }
        dataTemp = temp.getNext().getData();
        temp.setNext(temp.getNext().getNext());
        return dataTemp;
        

    }


    /**
     * Updates the data of the node at the specified position.
     */
    public String set(int position, String data) {
        Node temp = new Node(null, head);
        String dataTemp;
        if(this.size() <= position || position <= 0){
            
            return null;
        }
        
        
        if(position == 0){
            head.setData(data);
        }
        
        int i = 0;
        
        while(i <= position){
            temp = temp.getNext();
            i++;
        }
        dataTemp = temp.getData();
        temp.setData(data);
        return dataTemp;
        
    }
    
    /**
     * Returns the size (number of nodes) of the linked list.
     */
    public int size() {
        if(head == null){
            return 0;
        }

        int i = 0;
        Node temp = new Node(null, head);
        while(temp.getNext() != null){
            temp.setNext(temp.getNext().getNext());
            i = i + 1;
        }
        return i;    
    }
    
    /**
     * Checks if the linked list is empty.
     */
    public boolean isEmpty() {
        if(head != null){
            return false;
        }
        return true;

     
    }


     public static void main(String[] args){
         
       

		 	SimpleLinkedList list = new SimpleLinkedList();
             list.add("A");
             list.add("B");
             list.add("C");
             System.out.println("The size of the linked list is: " + list.size());
             

     

        
     }
}


