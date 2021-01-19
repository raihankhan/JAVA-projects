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
import java.rmi.registry.*; 
public class Server { 
	public static void main(String[] args) throws Exception 
	{ 

		// Create an object of the interface 
		// implementation class 
		Impl obj = new Impl(); 

		// Binds the remote object by the name ADD 
		Naming.rebind("gameRegistry", obj); 

		System.out.println("Server Started"); 
	} 
}