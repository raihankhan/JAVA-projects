/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Prince Vlad
 */
import java.rmi.Remote; 
import java.rmi.RemoteException;
public interface SecInterface extends Remote { 
	// Declaring the method prototype 
	public double Sec(double x) throws RemoteException; 
}
