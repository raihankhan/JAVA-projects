/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Prince Vlad
 */
import java.rmi.*; 
import java.util.*; 
public class Client { 
	public static void main(String[] args) throws Exception 
	{ 
		Scanner sc = new Scanner(System.in); 
		while (true) { 
			// User Menu 
			System.out.println( 
				"Enter which trigonometric value do you want to calculate"
                                        + "\n"
                                        + "\n1.Sin\n2.Cos\n3.Tan\n4.Cosec\n5.Sec\n6.Cot\n7.Exit"); 
			System.out.println("Enter the option:"); 
			int opt = sc.nextInt(); 
			if (opt == 7) { 
				break; 
			} 
			System.out.println( 
				"Enter the value in Degree\n"); 
			double a = sc.nextDouble(); 
			double n; 
			switch (opt) { 
			case 1: 
				// lookup method to find reference of remote 
				// object 
				SinInterface obj1 
					= (SinInterface)Naming.lookup("ADD"); 
				n = obj1.Sin(a); 
				System.out.println("sin(" + a + ") = " + n);  
				break; 
			case 2: 
				CosInterface obj2
					= (CosInterface)Naming.lookup("ADD"); 
				n = obj2.Cos(a); 
				System.out.println("cos(" + a + ") = " + n);
				break; 
			case 3: 
				TanInterface obj3 
					= (TanInterface)Naming.lookup("ADD"); 
				n = obj3.Tan(a); 
				System.out.println("tan(" + a + ") = " + n);
				break; 
			case 4: 
				CosecInterface obj4 
					= (CosecInterface)Naming.lookup("ADD"); 
				n = obj4.Cosec(a); 
				System.out.println("cosec(" + a + ") = " + n);
				break; 
                        case 5: 
				SecInterface obj5 
					= (SecInterface)Naming.lookup("ADD"); 
				n = obj5.Sec(a); 
				System.out.println("sec(" + a + ") = " + n);
				break;
                        case 6: 
				CotInterface obj6 
					= (CotInterface)Naming.lookup("ADD"); 
				n = obj6.Cot(a); 
				System.out.println("cot(" + a + ") = " + n); 
				break; 
                                
			} 
		} 
	} 
}