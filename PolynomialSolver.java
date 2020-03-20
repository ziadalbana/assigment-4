/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.datastructure.linkedList;
import java.awt.Point;
import java.util.*;
import eg.edu.alexu.csd.datastructure.linkedList.SinglyLinkedList.Node;
/**
 *
 * @author Alex
 */
public class PolynomialSolver{
     SinglyLinkedList A=new SinglyLinkedList();
     SinglyLinkedList B=new SinglyLinkedList();
     SinglyLinkedList C=new SinglyLinkedList();
     SinglyLinkedList R=new SinglyLinkedList();
     Boolean a=false;
     Boolean b=false;
     Boolean c=false;
     Scanner scan = new Scanner(System.in).useDelimiter("[,\\s+]");
    public void swap(int row1,int row2,int[][] arr){
      int temp=0;
      temp=arr[row1][0];
      arr[row1][0]=arr[row2][0];
      arr[row2][0]=temp;
      temp=arr[row1][1];
      arr[row1][1]=arr[row2][1];
      arr[row2][1]=temp;
    }

    public void order(int[][] arr) {
        int max;
        for (int i = 0; i < arr.length; i++) {
            max = arr[i][1];
            for (int j = 1 + i; j < arr.length; j++) {
                if (max < arr[j][1]) {
                    max = arr[i][1];
                    swap(i, j, arr);
                }
            }
        }
    }
    public void setPolynomial(char poly, int[][] terms){
        order(terms);
         switch (poly) {
             case 'A':
                 {
                     Point input = null;
                     for(int i=0;i<terms.length;i++){
                         input=new Point();
                         input.x=terms[i][0];
                         input.y=terms[i][1];
                         A.add(input);
                         input=null;
                     }a=true;        
                     break;
                 }
             case 'B':
                 {
                     Point input = null;
                     for(int i=0;i<terms.length;i++){
                         input=new Point();
                         input.x=terms[i][0];
                         input.y=terms[i][1];
                         B.add(input);
                         input=null;
                     }b=true;       
                     break;
                 }
             case 'C':
                 {
                     Point input = null;
                     for(int i=0;i<terms.length;i++){
                         input=new Point();
                         input.x=terms[i][0];
                         input.y=terms[i][1];
                         C.add(input);
                         input=null;
                     }c=true;       
                     break;
                 }
             case 'R':
                 {
                     Point input = null;
                     for(int i=0;i<terms.length;i++){   
                         input=new Point();
                         input.x=terms[i][0];
                         input.y=terms[i][1];
                         R.add(input);
                         input=null;
                     }      
                     break;
                 }
             default:
                 System.out.println("invaild input");
                 break;
         }
    }
    public  void print(SinglyLinkedList list){
        Node current=list.head;
        System.out.println("Linkedlist:");
        while(current!=null){
            System.out.println(current.value);
            current=current.next;
        }
    }
    public void print(int [][]arr){
        for(int i=0;i<arr.length;i++){
            for(int y=0;y<2;y++){
                System.out.print(arr[i][y]+" ");
            }
            System.out.print("\n");
        }
    }
    void clearPolynomial(char poly){
     if(poly=='A'){
         A.head=null;
         A.tail=null;
         A.size=0;
         a=false;
       }if(poly=='B'){
         B.head=null;
         B.tail=null;
         B.size=0;
         b=false;
       }if(poly=='C'){
         C.head=null;
         C.tail=null;
         C.size=0;
         b=false;
       }
    }
    
    float evaluatePolynomial(char poly, float value) {
        float result = 0;
        if (poly == 'A' && a == true) {
            Node current = A.head;
            while (current != null) {
                result += ((float) ((Point) current.value).x) * Math.pow(value, ((float) ((Point) current.value).y));
                current = current.next;
            }
        } else if (poly == 'B' && b == true) {
            Node current = B.head;
            while (current != null) {
                result += ((float) ((Point) current.value).x) * Math.pow(value, ((float) ((Point) current.value).y));
                current = current.next;
            }
        } else if (poly == 'c' && c == true) {
            Node current = C.head;
            while (current != null) {
                result += ((float) ((Point) current.value).x) * Math.pow(value, ((float) ((Point) current.value).y));
                current = current.next;
            }
        } else {
            System.out.println("Invaild input");

        }
        return result;
    }
     int[][] subtract(SinglyLinkedList l1,SinglyLinkedList l2 ){
        Node current1=l1.head;
        Node current2=l2.head;
        int i=0;
        int result=0;
        int realsize=0;
        int[][] arr=new int[l1.size+l2.size][2];        
        while(current1!=null&&current2!=null){
            result=0;
            if((int)(((Point) current1.value).y)>((int)(((Point) current2.value).y))){
                result=((int)((Point) current1.value).x);
                arr[i][0]=result;
                arr[i][1]=((int)((Point) current1.value).y);
               current1=current1.next;
               i++;
               realsize++;
            }else if((int)(((Point) current1.value).y)<((int)(((Point) current2.value).y))){
                result=((int)((Point) current2.value).x);
                arr[i][0]=-result;
                arr[i][1]=((int)((Point) current2.value).y);
               current2=current2.next;
               i++;
               realsize++;
            }else if((int)(((Point) current1.value).y)==((int)(((Point) current2.value).y))){
                result=((int)((Point) current1.value).x)-((int)((Point) current2.value).x);
                arr[i][0]=result;
                arr[i][1]=((int)((Point) current1.value).y);
               current1=current1.next;
               current2=current2.next;
               i++;
               realsize++;
            }
        }if(current1==null){
            while(current2!=null){
                arr[i][0]=-((int)((Point) current2.value).x);
                 arr[i][1]=((int)((Point) current2.value).y);
                 i++;
                 current2=current2.next;
                 realsize++;
            }
        }
        if(current2==null){
            while(current1!=null){
                arr[i][0]=((int)((Point) current1.value).x);
                 arr[i][1]=((int)((Point) current1.value).y);
                 i++;
                 current1=current1.next;
                 realsize++;
            }
        }
        int[][] finalarr=new int[realsize][2];
        finalarr=removezero(arr,realsize);
        order(finalarr);
        
        return finalarr; 
    }
    
    int[][] add(SinglyLinkedList l1,SinglyLinkedList l2 ){
        Node current1=l1.head;
        Node current2=l2.head;
        int i=0;
        int result=0;
        int realsize=0;
        int[][] arr=new int[l1.size+l2.size][2];        
        while(current1!=null&&current2!=null){
            result=0;
            if((int)(((Point) current1.value).y)>((int)(((Point) current2.value).y))){
                result=((int)((Point) current1.value).x);
                arr[i][0]=result;
                arr[i][1]=((int)((Point) current1.value).y);
               current1=current1.next;
               i++;
               realsize++;
            }else if((int)(((Point) current1.value).y)<((int)(((Point) current2.value).y))){
                result=((int)((Point) current2.value).x);
                arr[i][0]=result;
                arr[i][1]=((int)((Point) current2.value).y);
               current2=current2.next;
               i++;
               realsize++;
            }else if(((int)(((Point) current1.value).y))==((int)(((Point) current2.value).y))){
                result=((int)((Point) current1.value).x)+((int)((Point) current2.value).x);
                arr[i][0]=result;
                arr[i][1]=((int)((Point) current1.value).y);
               current1=current1.next;
               current2=current2.next;
               i++;
               realsize++;
            }
        }if(current1==null){
            while(current2!=null){
                arr[i][0]=((int)((Point) current2.value).x);
                 arr[i][1]=((int)((Point) current2.value).y);
                 i++;
                 current2=current2.next;
                 realsize++;
            }
        }
        if(current2==null){
            while(current1!=null){
                arr[i][0]=((int)((Point) current1.value).x);
                 arr[i][1]=((int)((Point) current1.value).y);
                 i++;
                 current1=current1.next;
                 realsize++;
            }
        }int[][] finalarr=new int[realsize][2];
        finalarr=removezero(arr,realsize);
        order(finalarr);
        
        return finalarr; 
    }
    int[][] multiply(SinglyLinkedList l1,SinglyLinkedList l2){
        Node current1=l1.head;
        Node current2=l2.head;
        int realsize=0;
        int [][]arr=new int[l1.size*l2.size][2];
        int i=0;
        while(current1!=null){
            while(current2!=null){
                arr[i][0]=((int)((Point) current1.value).x)*((int)((Point) current2.value).x);
                arr[i][1]=((int)((Point) current1.value).y)+((int)((Point) current2.value).y);
                i++;
                current2=current2.next;
                realsize++;
            }
            current2=l2.head;
            current1=current1.next;
        }
        
        for(i=0;i<arr.length;i++){
            for(int y=1+i;y<arr.length;y++){
                if(arr[i][1]==arr[y][1]&&arr[i][0]!=0&&arr[y][1]!=0){
                    arr[i][0]=arr[i][0]+arr[y][0];
                    arr[y][0]=0;
                    arr[y][1]=0;
                    realsize--;
                }
            }
        }
        int[][] finalarr=new int[realsize][2];
        finalarr=removezero(arr,realsize);
        order(finalarr);

        return finalarr;
    }
    int[][] add(char poly1, char poly2){
        SinglyLinkedList l1=new SinglyLinkedList();
        SinglyLinkedList l2=new SinglyLinkedList();
        int[][] arr;
        switch (poly1) {
             case 'A':
                 l1=A;
                 break;
             case 'B':
                 l1=B;
                 break;
             case 'C':
                 l1=C;
                 break;
             default:
                 System.out.println("invaild input");
                 break;
         }
         switch (poly2) {
             case 'A':
                 l2=A;
                 break;
             case 'B':
                 l2=B;
                 break;
             case 'C':
                 l2=C;
                 break;
             default:
                 System.out.println("invaild input");
                 break;
         }
        return arr=add(l1,l2);
    }
    int[][] subtract(char poly1, char poly2){
        SinglyLinkedList l1=new SinglyLinkedList();
        SinglyLinkedList l2=new SinglyLinkedList();
        int[][] arr;
         switch (poly1) {
             case 'A':
                 l1=A;
                 break;
             case 'B':
                 l1=B;
                 break;
             case 'C':
                 l1=C;
                 break;
             default:
                 System.out.println("invaild input");
                 break;
         }
         switch (poly2) {
             case 'A':
                 l2=A;
                 break;
             case 'B':
                 l2=B;
                 break;
             case 'C':
                 l2=C;
                 break;
             default:
                 System.out.println("invaild input");
                 break;
         }
        return arr=subtract(l1,l2);
    }
    int[][] multiply(char poly1, char poly2){
        SinglyLinkedList l1=new SinglyLinkedList();
        SinglyLinkedList l2=new SinglyLinkedList();
        int[][] arr;
         switch (poly1) {
             case 'A':
                 l1=A;
                 break;
             case 'B':
                 l1=B;
                 break;
             case 'C':
                 l1=C;
                 break;
             default:
                 System.out.println("invaild input");
                 break;
         }
         switch (poly2) {
             case 'A':
                 l2=A;
                 break;
             case 'B':
                 l2=B;
                 break;
             case 'C':
                 l2=C;
                 break;
             default:
                 System.out.println("invaild input");
                 break;
         }
        return arr=multiply(l1,l2);
    }
    public int[][]removezero(int arr[][],int size){
        int [][]finalarr= new int[size][2];
        int y=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i][0]!=0){
                finalarr[y][0]=arr[i][0];
                finalarr[y][1]=arr[i][1];
                y++;
            }
        }
        return finalarr;
    }
   public String print(char poly){
        if(poly!='A'&&poly!='a'&&poly!='B'&&poly!='b'&&poly!='C'&&poly!='c'&&poly!='R'&&poly!='r'){
            System.out.println("It is empty");
            return null;
        }
        //print();
        String result="";
        Node current=null;
        if(poly=='A'||poly=='a')   current = A.head;
        if(poly=='B'||poly=='b')   current = B.head;
        if(poly=='C'||poly=='c')   current = C.head;
        if(poly=='R'||poly=='r')   current = R.head;
        if (current==null){
            System.out.println("It is empty");
            return null;
        }
        while(current!=null){
            result+=String.valueOf((int)((Point)current.value).x)+"x^"+String.valueOf((int)((Point)current.value).y)+'+';
            current=current.next;
            
        }
        result = result.substring(0, result.length() - 1);
        return result;
    }
}
