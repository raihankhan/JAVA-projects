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

public interface Service extends Remote{

	String currentBoard() throws RemoteException;
	
	boolean play(int row, int column, int player) throws RemoteException;
	
	int checkWinner() throws RemoteException;
}