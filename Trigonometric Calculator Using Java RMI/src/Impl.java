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
import java.rmi.server.*; 

public class Impl extends UnicastRemoteObject 
                  implements SinInterface, CosInterface, TanInterface, CosecInterface, SecInterface, CotInterface  { 

	// Default constructor to throw RemoteException 
	// from its parent constructor 
	public Impl() throws Exception { super(); } 

	// Implementation of the AddInterface, 
	// subInterface, MulInterface, and DivInterface 
        @Override
	public double Sin(double x)
        {
        double radians = Math.toRadians(x);  
        return Math.sin(radians);
        } 
        @Override
        public double Cos(double x)
        {
        double radians = Math.toRadians(x);  
        return Math.cos(radians);
        }
        @Override
        public double Tan(double x)
        {
        double radians = Math.toRadians(x);  
        return Math.tan(radians);
        }
        @Override
        public double Cosec(double x)
        {
        double radians = Math.toRadians(x);  
        return 1.0/Math.sin(radians);
        }
        @Override
        public double Sec(double x)
        {
        double radians = Math.toRadians(x);  
        return 1.0/Math.cos(radians);
        }
        @Override
        public double Cot(double x)
        {
        double radians = Math.toRadians(x);  
        return 1.0/Math.tan(radians);
        }
        
}