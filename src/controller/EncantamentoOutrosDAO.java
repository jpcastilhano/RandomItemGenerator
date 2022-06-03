package controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import model.Anel;
import model.Maravilhoso;
import model.Pocao;
import model.TipoOutros;

public class EncantamentoOutrosDAO {

	private TipoOutros[] TIPO_ENCANTAMENTO_ANEL = {TipoOutros.ACAOLIVRE, TipoOutros.ANDARAGUA,
			TipoOutros.ARIETE, TipoOutros.ARMAZENARMAGIA, TipoOutros.COMANDARELEMENTAIS,
			TipoOutros.INVISIBILIDADE, TipoOutros.INVOCADOR, TipoOutros.NATACAO,
			TipoOutros.PERICIA, TipoOutros.POTENCIAF, TipoOutros.POTENCIAM,
			TipoOutros.PROTECAO, TipoOutros.QUEDASUAVE, TipoOutros.RESISTENCIA, TipoOutros.RESISTENCIAF};
	
	private TipoOutros[] TIPO_ENCANTAMENTO_MARAVILHOSO = {TipoOutros.BASTAO,TipoOutros.BOLA,TipoOutros.COLA,TipoOutros.CORDA,
			TipoOutros.CUBO,TipoOutros.DISPOSITIVO,TipoOutros.FORTALEZA,TipoOutros.GEMAE,TipoOutros.GEMAL,TipoOutros.GEMAV,
			TipoOutros.LANTERNA,TipoOutros.MOCHILA,TipoOutros.PEDRA,TipoOutros.PEDRAI,TipoOutros.PEDRAM,TipoOutros.SOLVENTE,
			TipoOutros.TAPETE};
	
	private TipoOutros[] TIPO_ENCANTAMENTO_POCAO = {TipoOutros.AMIZADE, TipoOutros.AUMENTAR, TipoOutros.CLARIVIDENCIA,
			TipoOutros.CURA, TipoOutros.CURAC, TipoOutros.ENCOLHER, TipoOutros.VENENO, TipoOutros.ESCALAR, TipoOutros.FORMAG,
			TipoOutros.FORÇA, TipoOutros.HEROISMO, TipoOutros.INVIS, TipoOutros.INVUL, TipoOutros.LERM, TipoOutros.RESIST,
			TipoOutros.RESPIRAR, TipoOutros.SOPRO, TipoOutros.VEL, TipoOutros.VIT, TipoOutros.VOO};
	
	private TipoOutros[] TIPO_PERICIA = {TipoOutros._ACR, TipoOutros._ADR, TipoOutros._ARC, TipoOutros._ATL, TipoOutros._ATU, TipoOutros._ENG,
			TipoOutros._FUR, TipoOutros._HIS, TipoOutros._INT, TipoOutros._INTU, TipoOutros._INV, TipoOutros._MED, TipoOutros._NAT,
			TipoOutros._PER, TipoOutros._PERS, TipoOutros._PRE, TipoOutros._REL, TipoOutros._SOB};
	
	private TipoOutros[] TIPO_RESISTENCIA = {TipoOutros._ACI, TipoOutros._FRI, TipoOutros._FOG, TipoOutros._ENE, TipoOutros._ELE,
			TipoOutros._NEC, TipoOutros._VEN, TipoOutros._PSI, TipoOutros._TRO, TipoOutros._RAD};
	
	private TipoOutros[] PEDRA_IONICA = {TipoOutros.PABS, TipoOutros.PAGI, TipoOutros.PPRO, TipoOutros.PFOR, TipoOutros.PGAB, TipoOutros.PINT,
			TipoOutros.PINTE, TipoOutros.PLID, TipoOutros.PMAE, TipoOutros.PPROT, TipoOutros.PREG, TipoOutros.PARM, TipoOutros.PFORC, TipoOutros.PSUS};
			
	private HashMap<TipoOutros, Integer[]> sumario = new HashMap<TipoOutros, Integer[]>();
	private Integer[] v123 = {1, 2, 3};
	private Integer[] v23 = {2, 3};
	private Integer[] v12 = {1, 2};
	private Integer[] v1 = {1};
	private Integer[] v2 = {2};
	private Integer[] v3 = {3};
	
	public TipoOutros criarEncantamentoAnel(Anel anel) {
		//Sum�rio de encantamentos
		sumario.put(TipoOutros.ACAOLIVRE, v1);
		sumario.put(TipoOutros.ANDARAGUA, v1);
		sumario.put(TipoOutros.ARIETE, v12);
		sumario.put(TipoOutros.ARMAZENARMAGIA, v12);
		sumario.put(TipoOutros.COMANDARELEMENTAIS, v3);
		sumario.put(TipoOutros.INVISIBILIDADE, v23);
		sumario.put(TipoOutros.INVOCADOR, v123);
		sumario.put(TipoOutros.NATACAO, v1);
		sumario.put(TipoOutros.PERICIA, v1);
		sumario.put(TipoOutros.POTENCIAF, v2);
		sumario.put(TipoOutros.POTENCIAM, v2);
		sumario.put(TipoOutros.PROTECAO, v12);
		sumario.put(TipoOutros.QUEDASUAVE, v1);
		sumario.put(TipoOutros.RESISTENCIA, v1);
		sumario.put(TipoOutros.RESISTENCIAF, v2);
		
		//L�gica da escolha do encantamento
		Integer _r;
		_r = anel.getRaridade(); //Get da raridade da arma		
		TipoOutros temp; //Vari�vel que ser� passada v�rias vezes pra obter um enchant
		boolean key; //Key para parar o do while
		key = true;
		
		do {
			temp = TIPO_ENCANTAMENTO_ANEL[new Random().nextInt(TIPO_ENCANTAMENTO_ANEL.length)]; //Pega um valor do array
			List<Integer> list = Arrays.asList(sumario.get(temp)); //Transforma em lista
			if (list.contains(_r)) { //Garante que a raridade est� nas listas
				key = false;
			}
		} while (key == true);
				
		return temp;
	}

	public TipoOutros variavelAnel(TipoOutros temp) {
		TipoOutros sent;
		sent = null;
		
		if (temp == TipoOutros.PERICIA) {
			sent = TIPO_PERICIA[new Random().nextInt(TIPO_PERICIA.length)];
		}
		
		if (temp == TipoOutros.RESISTENCIA) {
			sent = TIPO_RESISTENCIA[new Random().nextInt(TIPO_RESISTENCIA.length)];
		}
		
		return sent;
	}
	
	public TipoOutros criarEncantamentoMaravilhoso(Maravilhoso mar) {
		//Sum�rio de encantamentos
		sumario.put(TipoOutros.BASTAO, v1);
		sumario.put(TipoOutros.BOLA, v2);
		sumario.put(TipoOutros.JARROALQ, v1);
		sumario.put(TipoOutros.COLA, v3);
		sumario.put(TipoOutros.CORDA, v1);
		sumario.put(TipoOutros.CUBO, v3);
		sumario.put(TipoOutros.DISPOSITIVO, v3);
		sumario.put(TipoOutros.FORTALEZA, v2);
		sumario.put(TipoOutros.GEMAL, v1);
		sumario.put(TipoOutros.GEMAV, v2);
		sumario.put(TipoOutros.GEMAE, v1);
		sumario.put(TipoOutros.LANTERNA, v1);
		sumario.put(TipoOutros.MOCHILA, v1);
		sumario.put(TipoOutros.PEDRA, v1);
		sumario.put(TipoOutros.PEDRAI, v123);
		sumario.put(TipoOutros.PEDRAM, v1);
		sumario.put(TipoOutros.SOLVENTE, v3);
		sumario.put(TipoOutros.TAPETE, v1);
		
		//L�gica da escolha do encantamento
		Integer _r;
		_r = mar.getRaridade(); //Get da raridade da arma		
		TipoOutros temp; //Vari�vel que ser� passada v�rias vezes pra obter um enchant
		boolean key; //Key para parar o do while
		key = true;
		
		do {
			temp = TIPO_ENCANTAMENTO_MARAVILHOSO[new Random().nextInt(TIPO_ENCANTAMENTO_MARAVILHOSO.length)]; //Pega um valor do array
			List<Integer> list = Arrays.asList(sumario.get(temp)); //Transforma em lista
			if (list.contains(_r)) { //Garante que a raridade est� nas listas
				key = false;
			}
		} while (key == true);
		
		return temp;
	}

	public TipoOutros pedraIonica(Maravilhoso mar) {
		//Sum�rio de pedras
		sumario.put(TipoOutros.PABS, v2);
		sumario.put(TipoOutros.PAGI, v2);
		sumario.put(TipoOutros.PPRO, v1);
		sumario.put(TipoOutros.PFOR, v2);
		sumario.put(TipoOutros.PGAB, v3);
		sumario.put(TipoOutros.PINT, v2);
		sumario.put(TipoOutros.PINTE, v2);
		sumario.put(TipoOutros.PLID, v2);
		sumario.put(TipoOutros.PMAE, v3);
		sumario.put(TipoOutros.PPROT, v2);
		sumario.put(TipoOutros.PREG, v3);
		sumario.put(TipoOutros.PARM, v1);
		sumario.put(TipoOutros.PFORC, v2);
		sumario.put(TipoOutros.PSUS, v1);
		
		//L�gica da escolha do encantamento
		Integer _r;
		_r = mar.getRaridade(); //Get da raridade da arma		
		TipoOutros temp; //Vari�vel que ser� passada v�rias vezes pra obter um enchant
		boolean key; //Key para parar o do while
		key = true;
		
		do {
			temp = PEDRA_IONICA[new Random().nextInt(PEDRA_IONICA.length)]; //Pega um valor do array
			List<Integer> list = Arrays.asList(sumario.get(temp)); //Transforma em lista
			if (list.contains(_r)) { //Garante que a raridade est� nas listas
				key = false;
			}
		} while (key == true);
				
		return temp;
	}
	
	public TipoOutros criarEncantamentoPocao(Pocao pocao) {
		//Sum�rio de encantamentos
		sumario.put(TipoOutros.AMIZADE, v1);
		sumario.put(TipoOutros.AUMENTAR, v1);
		sumario.put(TipoOutros.CLARIVIDENCIA, v2);
		sumario.put(TipoOutros.CURA, v12);
		sumario.put(TipoOutros.CURAC, v3);
		sumario.put(TipoOutros.ENCOLHER, v2);
		sumario.put(TipoOutros.VENENO, v1);
		sumario.put(TipoOutros.ESCALAR, v1);
		sumario.put(TipoOutros.FORMAG, v2);
		sumario.put(TipoOutros.FORÇA, v123);
		sumario.put(TipoOutros.HEROISMO, v1);
		sumario.put(TipoOutros.INVIS, v2);
		sumario.put(TipoOutros.INVUL, v2);
		sumario.put(TipoOutros.LERM, v2);
		sumario.put(TipoOutros.RESIST, v1);
		sumario.put(TipoOutros.RESPIRAR, v1);
		sumario.put(TipoOutros.SOPRO, v1);
		sumario.put(TipoOutros.VEL, v2);
		sumario.put(TipoOutros.VIT, v2);
		sumario.put(TipoOutros.VOO, v3);
		
		//L�gica da escolha do encantamento
		Integer _r;
		_r = pocao.getRaridade(); //Get da raridade da arma		
		TipoOutros temp; //Vari�vel que ser� passada v�rias vezes pra obter um enchant
		boolean key; //Key para parar o do while
		key = true;
		
		do {
			temp = TIPO_ENCANTAMENTO_POCAO[new Random().nextInt(TIPO_ENCANTAMENTO_POCAO.length)]; //Pega um valor do array
			List<Integer> list = Arrays.asList(sumario.get(temp)); //Transforma em lista
			if (list.contains(_r)) { //Garante que a raridade est� nas listas
				key = false;
			}
		} while (key == true);
		
		return temp;
	}

	public TipoOutros pocaoResistencia() {
		return TIPO_RESISTENCIA[new Random().nextInt(TIPO_RESISTENCIA.length)];
	}
}
