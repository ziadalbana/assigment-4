package eg.edu.alexu.csd.datastructure.linkedList;
/**
 *
 * @author Ziad Albana
 * @author Ziad Alabd 
 */
import java.util.*;
public class practise {

        public static void main(String[] args) 
    {  
        Scanner scan = new Scanner(System.in).useDelimiter("[,\\s+]");
        Scanner num = new Scanner(System.in);
        
        int[] numbers = new int[2];
        int[][] inputs=null;
        int input;
        int size;
        char c;
        char c1;
        int[][] result;
        SinglyLinkedList l1=new SinglyLinkedList();
        PolynomialSolver solve=new PolynomialSolver();
        do{
        do{
        System.out.println("Please choose an action");
        System.out.println("-----------------------");
        System.out.println("1-Set a polynomial variable");
        System.out.println("2-Print the value of a polynomial variable");
        System.out.println("3- Add two polynomials");
        System.out.println("4- Subtract two polynomials");
        System.out.println("5- Multiply two polynomials");
        System.out.println("6- Evaluate a polynomial at some point");
        System.out.println("7- Clear a polynomial variable");
        System.out.println("====================================================================");
        input=scan.nextInt();
      }while(input>7||input<0);
        if(input==1){
            System.out.println("Insert the variable name: A, B or C");
            c=scan.next().charAt(0);
            System.out.println("numbers of terms of the polynomial ");
            size=scan.nextInt();
            inputs=new int[size][2];
            for (int j=0;j<size;j++){
                for(int i = 0; i < 2; i++){
                    numbers[i] = num.nextInt();
                }
                inputs[j][0]=numbers[0];
                inputs[j][1]=numbers[1];
            }
            if(c=='A'){
                solve.setPolynomial(c, inputs);
                System.out.println("A is set");
            }else if(c=='B'){
                solve.setPolynomial(c, inputs);
                System.out.println("B is set");
            }else if(c=='C'){
                solve.setPolynomial(c, inputs);
                System.out.println("C is set");
            }
        }
        else if(input==2){
            System.out.println("Insert the variable name: A, B , C OR R ");
            c = scan.next().charAt(0);
            if (c == 'A' && solve.a == true) {
               System.out.println(solve.print(c));
            } else if (c == 'B' && solve.b == true) {
               System.out.println(solve.print(c));
            } else if (c == 'C' && solve.c == true) {
              System.out.println(solve.print(c));
            }else if(c=='R'){
               System.out.println(solve.print(c));
            }
            else {
                System.out.println("not set");
            }
        }
        else if(input==3){
            System.out.println("Insert the variable name: A, B or C");
            c = scan.next().charAt(0);
            c1=scan.next().charAt(0);
            result=solve.add(c, c1);
            solve.setPolynomial('R', result);
            System.out.println(solve.print('R'));
        }
        else if(input==4){
            System.out.println("Insert the variable name: A, B or C");
            c = scan.next().charAt(0);
            c1=scan.next().charAt(0);
            result=solve.subtract(c, c1);
            solve.setPolynomial('R', result);
            System.out.println(solve.print('R'));
        }
        else if(input==5){
            System.out.println("Insert the variable name: A, B or C");
            c = scan.next().charAt(0);
            c1=scan.next().charAt(0);
            result=solve.multiply(c, c1);
            solve.setPolynomial('R', result);
            System.out.println(solve.print('R'));
        }
        else if(input==6){
            System.out.println("Insert the variable name: A, B or C");
            c = scan.next().charAt(0);
             System.out.println("enter integer u want to evalute");
            int x;
            x=scan.nextInt();
            System.out.println("the result="+solve.evaluatePolynomial(c, x));
        }else if(input==7){
             System.out.println("Insert the variable name: A, B or C");
            c = scan.next().charAt(0);
            solve.clearPolynomial(c);
        }
    }while(input!=0);
        
        
 } 
}

    

