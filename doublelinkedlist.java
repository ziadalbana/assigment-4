/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.datastructure.linkedList;

/**
 *
 * @author Alex
 */
public class doublelinkedlist {
    Node head;
    Node tail;
    private int size;

    public int getSize() {
        return size;
    }
    static class Node {

        Object data;
        Node prev;
        Node next;

        Node( Object data) {
            this.data = data;
            prev = null;
            next = null;
        }
    }
    public void insert(Object data){
        Node add=new Node(data);
        if(head==null){
            head=add;
            tail=add;
            size++;
        }else{
            Node current=head;
            while(current.next!=null){
                current=current.next;
            }
            current.next=add;
            add.prev=current;
            tail=current.next;
            size++;
        }
    }
    public  void print(doublelinkedlist list){
        Node current=head;
        System.out.println("Linkedlist:");
        while(current!=null){
            System.out.println(current.data);
            current=current.next;
        }
    }
    public  void printtail(doublelinkedlist list){
        Node current=tail;
        System.out.println("Linkedlist:");
        while(current!=null){
            System.out.println(current.data);
            current=current.prev;
        }
    }
    public void add(int index, Object element) {
        Node add = new Node(element);
        if (head == null && index == 0) {
            head = add;
            tail = add;
            size++;
        } else if (index == size) {
            tail.next = add;
            add.prev = tail;
            tail = add;
            size++;
        } else if (index == 0 && index < size) {
            add.next = head;
            head.prev = add;
            head = add;
            size++;
        } else {
            int counter = 0;
            Node current = head;
            if (index > 0 && index < size) {
                while (current.next != null && counter < index) {
                    current = current.next;
                    counter++;
                }
                add.prev = current.prev;
                add.next = current;
                current.prev = add;
                current.prev.prev.next = add;
                size++;
            }
        }
    }
    public void add(Object  element){
       Node add = new Node(element);
        if (head == null) {
            head = add;
            tail = add;
            size++;
        }else{
        tail.next = add;
        add.prev = tail;
        tail = add;
        size++;
    }
   }     
    public Object get(int index) {
        int counter = 0;
        Object val =null;
        Node current = head;
        if (index >= 0 && index < size) {
            while (current.next != null && counter < index) {
                current = current.next;
                counter++;
            }
            val = current.data;
        }
        return val;
    }
    public void set(int index, Object element){
         int counter = 0;
        Node current = head;
        if (index >= 0 && index < size) {
            while (current.next != null && counter < index) {
                current = current.next;
                counter++;
            }
            current.data=element;
        }
    }
    public void clear(){
        head=null;
        tail=null;
        size=0;
    }
    public boolean isEmpty(){
        Boolean status=false;
        if(head==null){
            status=true;
        }
        return status;
    }
    public void remove(int index) {
        if (head == null) {
        } else if (index == 0 && size == 1) {
            clear();
        } else if (index == 0 && index < size) {
            head.next.prev = null;
            head = head.next;
            size--;
        } else if (index == size - 1) {
            tail.prev.next = null;
            tail = tail.prev;
            size--;
        } else {
            int counter = 0;
            Node current = head;
            if (index > 0 && index < size) {
                while (current.next != null && counter < index) {
                    current = current.next;
                    counter++;
                }
                current.prev.next = current.next;
                current.next.prev = current.prev;
                size--;
            }
        }
    }
    public int size(){
        Node current=head;
        int counter=0;
        while(current!=null){
            counter++;
            current=current.next;
        }
        this.size=counter;
        return counter;
    }
    public doublelinkedlist sublist(int fromIndex, int toIndex){
        doublelinkedlist list=new doublelinkedlist();
        if(fromIndex>=0&&fromIndex<toIndex&&toIndex<size){
        int counter=0;
        Node current=head;
        while(current.next!=null&&counter<fromIndex){
            counter++;
            current=current.next;
        }
        Object data;
        while(counter<=toIndex){
            data=current.data;
            list.insert(data);
            current=current.next;
            counter++;
        }
        }
        return list;
    }
    public boolean contains(Object o){
        Boolean status =false;
        Node current=head;
        while(current!=null){
            if(current.data==o){
                status=true;
                break;
            }
        current=current.next;
        }
        return status;
    }
}