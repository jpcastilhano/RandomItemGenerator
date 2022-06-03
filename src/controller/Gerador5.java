package controller;

import model.Arma;
import model.Armadura;
import model.Anel;
import model.Maravilhoso;
import model.Pocao;

public class Gerador5 {

	public static void main(String[] args) {
		
		ItensDAO itensDAO = new ItensDAO();
		OutrosDAO outrosDAO = new OutrosDAO();
		MetodosDAO metodosDAO = new MetodosDAO();
		
		for (int i=0; i<20; i++) {
			Arma arma = itensDAO.criarArma(i+1, 1, true);
			System.out.println(arma.toString());			
		}		
	}
}