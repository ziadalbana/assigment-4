
package eg.edu.alexu.csd.datastructure.linkedList;

import java.lang.*;

/**
 *
 * @author ZIAD ELABD
 * @author ZIAD ALLBANA
 */
public class SinglyLinkedList  {
    Node head;
    Node tail;
    int size;
     class Node {
      Object value;
      Node next;
      Node(Object data){
          this.value=data;
          next=null;
      }
     }
    
   
    public void add(int index,Object  element){
      int counter=0;
      Node add=new Node(element);
      if(head==null){
        head=add;
        tail=add;
        size++;
        }
      else if(index==0){
          add.next=head;
          head=add;
          size++;
      }
      else if(index==size){
        tail.next=add;
        tail=add;
        size++;
      }
      else{
      if(index>0&&index<size){  
      Node current=head;
      Node pre=null;
      while(current.next!=null&&counter<index){
        pre=current;
        current=current.next;
        counter++;
      }
      pre.next=add;
      add.next=current;
      size++;
      }
      }  
    }

    
    public void add(Object element) {
        Node input=new Node(element);
        if(head==null) {
          head=tail=input;
          size++;
        }else{
            tail.next=input;
            tail=input;
            tail.next=null;
            size++;
        }
    }

    
    public Object get(int index){
        int counter=0;
        Object val=null;
        if(head==null){
            return null;
        }
        else{
            if(index>=0&&index<size){
                Node current=head;
                while(current.next!=null&&counter<index){
                      counter++;
                      current=current.next;
                }
                  val= current.value;
            }else{  
                System.out.println("index out of border"); 
            }  
            return val;  
        }
    
    
    }

    
    public void set(int index, Object data) {
        int counter = 0;
        if (head == null && index == 0) {
            head = new Node(data);
        } else {
            if (index >= 0 && index < size) {
                Node current = head;
                while (current.next != null && counter < index) {
                    current = current.next;
                    counter++;
                }
                current.value = data;
            }
        }
    }

   
    public void clear() {
        head=null;
        tail=null;
        size=0;

    }

  
    public boolean isEmpty() {
        int counter=0;
        return head==null;
        
    }

    
    public void remove(int index) {
        if (head == null) { 
        }
        else if (index == 0 && size == 1) {
            clear();
        } else if (index == 0 && index < size) {
            //head.next.prev = null;
            head = head.next;
            size--;
        } else if (index == size - 1) {
            Node current=head;
            Node temp=null;
            while (current.next!=null){
                temp=current;
                current=current.next;
            }
            temp.next=null;
            tail=temp;
            size--;
        } else {
            int counter = 0;
            Node current = head;
            Node temp=null;
            if (index > 0 && index < size) {
                while (current.next != null && counter < index) {
                    temp=current;
                    current = current.next;
                    counter++;
                }
                temp.next=current.next;
                size--;
            }
        }
    }


    

    
    public int size() {
        
        int counter=0;
      Node current=head;
      while (current!=null){
            counter++;
            current=current.next;        
          }
          this.size=counter;
       return counter;
        

    }

    
    public SinglyLinkedList sublist(int fromIndex, int toIndex) {
        if(fromIndex < 0 || fromIndex > this.size()-1 || toIndex < 0 || toIndex > this.size()-1){
            return null;
        }
        SinglyLinkedList sub = new SinglyLinkedList();
        Node current=this.head;
        for(int i=0;i<fromIndex && i<size;i++){
            current=current.next;
        }
        //Node temp=sub.head;
        sub.add(current.value);
        System.out.println(current.value+"55");
        for(int i=fromIndex;i<toIndex && i<size ;i++){
            current=current.next;
            System.out.println(current.value+"55");
            sub.add(current.value);
        }
       return sub;
    }

   
    public boolean contains(Object o) {
        boolean found=false;
        Node current=head;
        while(current!=null){
            if(current.value ==o) {
                found=true;
                break;
            }
            current=current.next;
        }
        return found;
    }
    public  void print(SinglyLinkedList list){
        Node current=list.head;
        System.out.println("Linkedlist:");
        while(current!=null){
            System.out.println(current.value);
            current=current.next;
        }
    }
    
    
}