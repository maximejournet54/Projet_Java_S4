package controleur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import modele.InterfaceMorpion;

//import java.util.ArrayList;

public class ImplementationMorpion extends UnicastRemoteObject implements InterfaceMorpion {
    
	private static final long serialVersionUID = 1L;

	char [] grille = new char [9];
	
	public ImplementationMorpion() throws RemoteException {
		super();
    }
	
	public void initGrille() throws RemoteException{
		for(int i=0 ; i<9 ; i++) {
			this.grille[i] = 'E';
		}
	}
	
	public void PlacerX(int c) throws RemoteException{
		this.grille[c] = 'X';
	}
	
	public void PlacerO(int c) throws RemoteException{
		this.grille[c] = 'O';
	}
	
	public void AfficheGrille()throws RemoteException{
		for(int i=0 ; i<9 ; i++) {
			System.out.println(grille[i]);
		}
	}
	
	public int testRanc(int a, int b, int c) throws RemoteException{
		if((grille[a] != 'E') && (grille[b] != 'E') && (grille[c] != 'E')) {
			if((grille[a] == grille[b]) && (grille[b]==grille[c])) {
				if(grille[a]=='X'){
					return 1;
				}else {
					return 0;
				}
			}
			return -1;
		}
		return -1;
	}
	
	public int testGagnant() throws RemoteException{
		int gagnant = -1;
		//test du premier horizontal
		gagnant = testRanc(0,1,2);

	    //second horizontal
	    if(gagnant < 0){
	       gagnant = testRanc(3,4,5);
	        }
	    //troisième horizontal
	    if(gagnant < 0){
		       gagnant = testRanc(6,7,8);
		        }
	    //Premier vertical
	    if(gagnant < 0){
		       gagnant = testRanc(0,3,6);
		        }
	    //Deuxième vertical
	    if(gagnant < 0){
		       gagnant = testRanc(1,4,7);
		        }
	    //troisième vertical
	    if(gagnant < 0){
		       gagnant = testRanc(2,5,8);
        }
	    //Première diagonale
	    if(gagnant < 0){
		       gagnant = testRanc(0,4,8);
        }
	    //Deuxième diagonale
	    if(gagnant < 0){
		       gagnant = testRanc(2,4,6);
	    }
		
		return gagnant;
	}
	
}
