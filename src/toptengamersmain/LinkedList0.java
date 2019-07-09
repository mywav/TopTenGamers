package toptengamersmain;


/**
 *
 * @author Ryan.Newbold
 */
public class LinkedList0 
{
    private class Node
    {
        HighScorer object;
        private String nickName;
        private int playerScore = 0;        
        Node next;      

        Node(String name, int score, Node n)
        {
            nickName = name;
            playerScore = score;
            next = n;
        } 
   
        Node(String name, int score)
        {
            // Call the other (sister) constructor.
            this(name, score, null);
        }
        
        public void setNext(Node next)
        {
            this.next = next;
        }
                
        public Node getNext()
        {
            return next;
        }
        
        public HighScorer getNodeObject()
        {
            return object;
        }
         
        
        public String getName()
        {
            return nickName;
        }
    
        public int getScore()
        {
            return playerScore;
        }      


        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public void setPlayerScore(int playerScore) {
            this.playerScore = playerScore;
        }
    }	
	 
    private Node first;   // list head
    private Node last;    // last element in list
    private int nodeCount = 0;
    int counter = 0;
    int maxSize = 10;
	     
    /**
       Constructor.
    */
    
    public LinkedList0()
    {
        first = new Node(null, 0);
        last = new Node(null, 0);
        nodeCount++;
    }
    
    public boolean isEmpty()
    {        
        return first == null;       
    }

    public int size()
    {
       int count = 0;
       Node p = first;     
       while (p != null)
       {
           // There is an element at p
           count++;
           p = p.next;
       }
       return count;
    }
    

    public void add(String name, int score)
    {
      if (isEmpty()) 
      {
          first = new Node(name, score);
          last = first;
      }
      else
      {
          // Add to end of existing list
          last.next = new Node(name, score);
          last = last.next;
      }      
    }
    
   
    public void insert(String name, int score)
    {        
        Node currentNode = first;              
        Node newNode = new Node(name, score);
        Node prevNode = new Node(null, 0);
        
        if (first.playerScore == 0 && first.nickName == null)
        {
            first = newNode;
            last = first;
            counter = 1;
        }
        else if (first.playerScore < newNode.playerScore)
        {
            //Node nextNode = currentNode.getNext();
            newNode.setNext(currentNode);
            first = newNode;
        }
        else
        {            
            while (currentNode != null && newNode.playerScore <= currentNode.playerScore)
            {                                           
                prevNode = currentNode;
                currentNode = currentNode.next;
                
            }       
           
            prevNode.next = newNode;
            newNode.next = currentNode;
            
            
        }
        nodeCount++;
        if (nodeCount > 10)
        {
            removeLast();
            nodeCount--;
        }
    }   

    public int compareTo(HighScorer newHighScorer, HighScorer oldHighScorer)
    {
        int number = newHighScorer.getPlayerScore() - oldHighScorer.getPlayerScore();
        return number;
    }   
    
    @Override
    public String toString()
    {     
      StringBuilder strBuilder = new StringBuilder();
      // Use p to walk down the linked list
      Node p = first;
      while (p != null)
      { 
         strBuilder.append(p.getName() + " " + p.getScore() + "\n");  
         p = p.next;         
      }      
      
      return strBuilder.toString(); 
    }
    
    public void removeLast()
    {
        counter = 1;
        Node currentNode = first;
        while (counter < 10)
        {
            currentNode = currentNode.next;
            counter++;
        }
        last = currentNode;
        last.next = null;
    }
    public boolean remove(String element)
    {
       if (isEmpty()) 
           return false;      
      
       if (element.equals(first.object))
       {
          // Removal of first item in the list
          first = first.next;
          if (first == null)
              last = null;       
          return true;
       }
      
      // Find the predecessor of the element to remove
      Node pred = first;
      while (pred.next != null && 
             !pred.next.object.equals(element))
      {
          pred = pred.next;
      }

      // pred.next == null OR pred.next.object is element
      if (pred.next == null)
          return false;
      
      // pred.next.object  is element
      pred.next = pred.next.next;    
      
      // Check if pred is now last
      if (pred.next == null)
          last = pred;
      
      return true;       
    } 
    
    
}
