package controller;

import java.util.Random;

public class MetodosDAO {

	public Integer raridade(Integer nv_loja) {
		Integer t = new Random().nextInt(100)+1;
		switch(nv_loja) {
			case 1:
				if(t < 56) { return 0; }
				else if (t > 55 && t < 91) { return 1; }
				else { return 2; }
				
			case 2:
				if(t < 36) { return 0; }
				else if (t > 35 && t < 76) { return 1; }
				else if (t > 75 && t < 96) { return 2; }
				else { return 3; }
			
			case 3:
				if(t < 16) { return 0; }
				else if (t > 15 && t < 61) { return 1; }
				else if (t > 60 && t < 91) { return 2; }
				else { return 3; }
				
			default: return 0;
		}
	}
	
	public Integer raridadeNaoNula(Integer nv_loja) { //BALANCEAR DEPOIS
		Integer t = new Random().nextInt(100)+1;
		switch(nv_loja) {
			case 1:
				if(t < 56) { return 1; }
				else if (t > 55 && t < 91) { return 2; }
				else { return 3; }
				
			case 2:
				if(t < 36) { return 1; }
				else if (t > 35 && t < 76) { return 2; }
				else { return 3; }
			
			case 3:
				if(t < 16) { return 1; }
				else if (t > 15 && t < 61) { return 2; }
				else { return 3; }
				
			default: return 1;
		}
	}
	
	public boolean magico(Integer nv_loja) {
		Integer t = new Random().nextInt(10)+1;
		switch(nv_loja) {
			case 1:
				if (t < 4) { return true; }
				else { return false; }
			
			case 2:
				if (t < 6) { return true; }
				else { return false; }
			
			case 3:
				if (t < 8 ) { return true; }
				else { return false; }
				
			default: return false;
		}
	}
}
