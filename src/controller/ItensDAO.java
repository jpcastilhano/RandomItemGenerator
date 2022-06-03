package controller;

import java.util.Random;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import model.Arma;
import model.Armadura;
import model.EncantamentoArma;
import model.EncantamentoArmadura;
import model.TipoItens;
import model.TipoOutros;


public class ItensDAO {
    
    private TipoItens[] TIPO_ARMA = {TipoItens.ADAG, TipoItens.AZAG, TipoItens.BORD, TipoItens.LANC, TipoItens.MACA, TipoItens.MACHADINHA,
            TipoItens.MARTLV, TipoItens.ALAB, TipoItens.ESPCUR, TipoItens.ESPGRA, TipoItens.ESPLON, TipoItens.GLAIV, TipoItens.LANCLONG,
            TipoItens.MACEST, TipoItens.MACGRA, TipoItens.MACBAT, TipoItens.MALH, TipoItens.MARTGUE, TipoItens.RAPI};
    
    private TipoItens[] TIPO_ARMA_MAGICA = {TipoItens.VARI, TipoItens.CAJA, TipoItens.ORBE};

    private TipoItens[] TIPO_ARMA_RANGED = {TipoItens.ARCCUR, TipoItens.BESLEV, TipoItens.DARD, TipoItens.ARCLONG, TipoItens.BESMAO, TipoItens.BESPES};

    private static TipoItens[] TIPO_ENCANTAMENTO = {TipoItens.AFIADO, TipoItens.ANTICRIATURA, TipoItens.ASSASSINA,
            TipoItens.CURA, TipoItens.DANOELEMENTAL, TipoItens.DEFENSORA, TipoItens.DRENANTE,
            TipoItens.FORTUNA, TipoItens.RETORNO, TipoItens.ROMPIMENTO, TipoItens.SANGRAMENTO,
            TipoItens.VELOCIDADE};

    private static TipoItens[] TIPO_ENCANTAMENTO_RANGED = {TipoItens.AFIADO, TipoItens.ANTICRIATURA, TipoItens.ASSASSINA,
            TipoItens.CURA, TipoItens.DANOELEMENTAL, TipoItens.DEFENSORA, TipoItens.DRENANTE,
            TipoItens.FORTUNA, TipoItens.CACADORA, TipoItens.ROMPIMENTO, TipoItens.SANGRAMENTO,
            TipoItens.VELOCIDADE};

    private static TipoOutros[] DANO_ELEMENTAL = {TipoOutros._ACI, TipoOutros._FRI, TipoOutros._FOG, TipoOutros._ELE, TipoOutros._NEC, TipoOutros._RAD};

    private TipoItens[] TIPO_ARMADURA = {TipoItens.ACOLCHOADA, TipoItens.BRUNEA, TipoItens.CAMISAODEMALHA,
            TipoItens.COTAANEIS, TipoItens.COTAMALHA, TipoItens.COTATALAS, TipoItens.COURO, TipoItens.COUROBATIDO,
            TipoItens.GIBAODEPELES, TipoItens.MEIAARMADURA, TipoItens.PEITORAL, TipoItens.PLACAS};

    private TipoItens[] TIPO_ARMADURA_LEVE = {TipoItens.ACOLCHOADA, TipoItens.COURO, TipoItens.COUROBATIDO,
            TipoItens.GIBAODEPELES, TipoItens.CAMISAODEMALHA, TipoItens.BRUNEA, TipoItens.PEITORAL, TipoItens.MEIAARMADURA};

    private static TipoItens[] TIPO_ENCANTAMENTO_ARMADURA = {TipoItens.ALVO, TipoItens.AMPLIARDANO,
			TipoItens.AURACORAGEM, TipoItens.AURACURA, TipoItens.AURATERROR,
			TipoItens.CEGANTE, TipoItens.CONTROLARMV, TipoItens.FORTIFICACAO,
			TipoItens.REDUCAODANO, TipoItens.REFLEXAO, TipoItens.RESISTENCIAELEMENTAL,
			TipoItens.RESISTENCIAMAGIA};
	
	private static TipoItens[] TIPO_ENCANTAMENTO_ESCUDO = {TipoItens.ALVO, TipoItens.APANHARFLECHA,
			TipoItens.CEGANTE, TipoItens.FORTIFICACAO, TipoItens.REDUCAODANO,
			TipoItens.REFLEXAO, TipoItens.RESISTENCIAELEMENTAL, TipoItens.RESISTENCIAMAGIA};
	
	private static TipoItens[] TIPO_ENCANTAMENTO_MAGICO = {TipoItens.APRENDIZ, TipoItens.MESTRE,
			TipoItens.ARQUIMAGO};

    private static HashMap<TipoItens, Integer[]> sumario = new HashMap<TipoItens, Integer[]>();
    private static Integer[] v123 = {1, 2, 3};
    private static Integer[] v23 = {2, 3};
    private static Integer[] v12 = {1, 2};
    private static Integer[] v1 = {1};
    private static Integer[] v2 = {2};
	private static Integer[] v3 = {3};

    /*private MetodosDAO metodosDAO;
    public ItensDAO() {
        metodosDAO = new MetodosDAO();
    }*/

    //###############################################################################
    //###############################################################################
    // ====================== CRIAR ARMAS =============================
    //###############################################################################
    //###############################################################################
    public Arma criarArma(Integer id, Integer raridade, boolean magico) {
		Arma arma = new Arma();
		
		arma.setId(id);
		arma.setRaridade(raridade);
		arma.setTipo(TIPO_ARMA[new Random().nextInt(TIPO_ARMA.length)]);
		arma.setMagico(magico);
		
		if (arma.isMagico() == true && arma.getRaridade() != 0) {
			arma.setEncantamento(ItensDAO.criarEncantamentoArma(arma));
			
			if (arma.getEncantamento().getTipoEncantamento() == TipoItens.DANOELEMENTAL) {
				arma.setAuxiliar(ItensDAO.danoElemental());
			}
		}
		return arma;
	}
	
	public Arma criarArmaMagica(Integer id, Integer raridade) {
		Arma arma = new Arma();
		
		arma.setId(id);
		arma.setTipo(TIPO_ARMA_MAGICA[new Random().nextInt(TIPO_ARMA_MAGICA.length)]);
		arma.setRaridade(raridade);
		
		return arma;
	}
	
	public Arma criarArmaRanged(Integer id, Integer raridade, boolean magico) {
		Arma arma = new Arma();
		
		arma.setId(id);
		arma.setRaridade(raridade);
		arma.setTipo(TIPO_ARMA_RANGED[new Random().nextInt(TIPO_ARMA_RANGED.length)]);
		arma.setMagico(magico);
		
		if (arma.isMagico() == true && arma.getRaridade() != 0) {
			arma.setEncantamento(ItensDAO.criarEncantamentoArmaRanged(arma));
			
			if (arma.getEncantamento().getTipoEncantamento() == TipoItens.DANOELEMENTAL) {
				arma.setAuxiliar(ItensDAO.danoElemental());
			}
		}
		return arma;
	}

    //###############################################################################
    //###############################################################################
    //======================== ENCANTAMENTOS DE ARMAS ===============================
    //###############################################################################
    //###############################################################################
	
    public static EncantamentoArma criarEncantamentoArma(Arma arma) {
		EncantamentoArma enchant = new EncantamentoArma();
		//Criação do sumário de encantamentos
		sumario.put(TipoItens.AFIADO, v2);
		sumario.put(TipoItens.ANTICRIATURA, v1);
		sumario.put(TipoItens.ASSASSINA, v123);
		sumario.put(TipoItens.CURA, v23);
		sumario.put(TipoItens.DANOELEMENTAL, v123);
		sumario.put(TipoItens.DEFENSORA, v123);
		sumario.put(TipoItens.DRENANTE, v123);
		sumario.put(TipoItens.FORTUNA, v12);
		sumario.put(TipoItens.RETORNO, v1);
		sumario.put(TipoItens.ROMPIMENTO, v23);
		sumario.put(TipoItens.SANGRAMENTO, v123);
		sumario.put(TipoItens.VELOCIDADE, v2);
		
		//Lógica da escolha do encantamento
		Integer _r;
		_r = arma.getRaridade(); //Get da raridade da arma		
		TipoItens temp; //Variável que será passada várias vezes pra obter um enchant
		boolean key; //Key para parar o do while
		key = true;
		
		do {
			temp = TIPO_ENCANTAMENTO[new Random().nextInt(TIPO_ENCANTAMENTO.length)]; //Pega um valor do array
			List<Integer> list = Arrays.asList(sumario.get(temp)); //Transforma em lista
			if (list.contains(_r) || list.contains(_r-1) || list.contains(_r-2)) { //Garante que a raridade está nas listas
				key = false;
			}
		} while (key == true);
		
		//Lógica da escolha da melhoria
		Integer tempM;
		key = true;
		do {
			tempM = sumario.get(temp)[new Random().nextInt(sumario.get(temp).length)];
			if (tempM <= _r) {
				key = false;
			}
		} while (key == true);
		
		enchant.setTipoEncantamento(temp);
		enchant.setMelhoriaEncantamento(tempM);
		return enchant;
	}

	public static EncantamentoArma criarEncantamentoArmaRanged(Arma arma) {
		EncantamentoArma enchant = new EncantamentoArma();
		//Criação do sumário de encantamentos
		sumario.put(TipoItens.AFIADO, v2);
		sumario.put(TipoItens.ANTICRIATURA, v1);
		sumario.put(TipoItens.ASSASSINA, v123);
		sumario.put(TipoItens.CURA, v23);
		sumario.put(TipoItens.DANOELEMENTAL, v123);
		sumario.put(TipoItens.DEFENSORA, v123);
		sumario.put(TipoItens.DRENANTE, v123);
		sumario.put(TipoItens.FORTUNA, v12);
		sumario.put(TipoItens.CACADORA, v1);
		sumario.put(TipoItens.ROMPIMENTO, v23);
		sumario.put(TipoItens.SANGRAMENTO, v123);
		sumario.put(TipoItens.VELOCIDADE, v2);
		
		//Lógica da escolha do encantamento
		Integer _r;
		_r = arma.getRaridade(); //Get da raridade da arma
		
		TipoItens temp; //Variável que será passada várias vezes pra obter um enchant
		boolean key; //Key para parar o do while
		key = true;
		do {
			temp = TIPO_ENCANTAMENTO_RANGED[new Random().nextInt(TIPO_ENCANTAMENTO_RANGED.length)]; //Pega um valor do array
			List<Integer> list = Arrays.asList(sumario.get(temp)); //Transforma em lista
			if (list.contains(_r) || list.contains(_r-1) || list.contains(_r-2)) { //Garante que a raridade está nas listas
				key = false;
			}
		} while (key == true);
		
		//Lógica da escolha da melhoria
		Integer tempM;
		key = true;
		do {
			tempM = sumario.get(temp)[new Random().nextInt(sumario.get(temp).length)];
			if (tempM <= _r) {
				key = false;
			}
		} while (key == true);
		
		enchant.setTipoEncantamento(temp);
		enchant.setMelhoriaEncantamento(tempM);
		return enchant;
	}

	public static TipoOutros danoElemental() {
		return DANO_ELEMENTAL[new Random().nextInt(DANO_ELEMENTAL.length)];
	}

    //###############################################################################
    //###############################################################################
    //======================== CRIAR ARMADURAS ===============================
    //###############################################################################
    //###############################################################################

    public Armadura criarArmadura(Integer id, Integer raridade, boolean magico) {
		Armadura armadura = new Armadura();
		
		armadura.setId(id);
		armadura.setRaridade(raridade);
		armadura.setTipo(TIPO_ARMADURA[new Random().nextInt(TIPO_ARMADURA.length)]);
		armadura.setMagico(magico);
		
		if (armadura.isMagico() == true && armadura.getRaridade() != 0) {
			armadura.setEncantamento(ItensDAO.criarEncantamentoArmadura(armadura));
		}
		return armadura;
	}
	
	public Armadura criarArmaduraLeve(Integer id, Integer raridade, boolean magico) {
		Armadura armadura = new Armadura();
		
		armadura.setId(id);
		armadura.setRaridade(raridade);
		armadura.setTipo(TIPO_ARMADURA_LEVE[new Random().nextInt(TIPO_ARMADURA_LEVE.length)]);
		armadura.setMagico(magico);
		
		if (armadura.isMagico() == true && armadura.getRaridade() != 0) {
			armadura.setEncantamento(ItensDAO.criarEncantamentoArmadura(armadura));
		}
		return armadura;
	}
	
	public Armadura criarEscudo(Integer id, Integer raridade, boolean magico) {
		Armadura armadura = new Armadura();
		
		armadura.setId(id);
		armadura.setRaridade(raridade);
		armadura.setTipo(TipoItens.ESCUDO);
		armadura.setMagico(magico);
		
		if (armadura.isMagico() == true && armadura.getRaridade() != 0) {
			armadura.setEncantamento(ItensDAO.criarEncantamentoEscudo(armadura));
		}
		return armadura;
	}
	
	public Armadura criarRobe(Integer id, Integer raridade, boolean magico) {
		Armadura armadura = new Armadura();
		
		armadura.setId(id);
		armadura.setRaridade(raridade);
		armadura.setTipo(TipoItens.ROBE);
		armadura.setMagico(magico);
		
		if (armadura.isMagico() == true && armadura.getRaridade() != 0) {
			armadura.setEncantamento(ItensDAO.criarEncantamentoRobe(armadura));
		}
		return armadura;
	}

    //###############################################################################
    //###############################################################################
    //======================== ENCANTAMENTO DE ARMADURAS ===============================
    //###############################################################################
    //###############################################################################

    public static EncantamentoArmadura criarEncantamentoArmadura(Armadura armadura) {
		EncantamentoArmadura enchant = new EncantamentoArmadura();
		//Criação do sumário de encantamentos
		sumario.put(TipoItens.ALVO, v1);
		sumario.put(TipoItens.AMPLIARDANO, v123);
		sumario.put(TipoItens.AURACORAGEM, v123);
		sumario.put(TipoItens.AURACURA, v123);
		sumario.put(TipoItens.AURATERROR, v123);
		sumario.put(TipoItens.CEGANTE, v1);
		sumario.put(TipoItens.CONTROLARMV, v2);
		sumario.put(TipoItens.FORTIFICACAO, v123);
		sumario.put(TipoItens.REDUCAODANO, v123);
		sumario.put(TipoItens.REFLEXAO, v123);
		sumario.put(TipoItens.RESISTENCIAELEMENTAL, v123);
		sumario.put(TipoItens.RESISTENCIAMAGIA, v2);
		
		//Lógica da escolha do encantamento
		Integer _r;
		_r = armadura.getRaridade(); //Get da raridade da arma
		
		TipoItens temp; //Variável que será passada várias vezes pra obter um enchant
		boolean key; //Key para parar o do while
		key = true;
		do {
			temp = TIPO_ENCANTAMENTO_ARMADURA[new Random().nextInt(TIPO_ENCANTAMENTO_ARMADURA.length)]; //Pega um valor do array
			List<Integer> list = Arrays.asList(sumario.get(temp)); //Transforma em lista
			if (list.contains(_r) || list.contains(_r-1) || list.contains(_r-2)) { //Garante que a raridade está nas listas
				key = false;
			}
		} while (key == true);
		
		//Lógica da escolha da melhoria
		Integer tempM;
		key = true;
		do {
			tempM = sumario.get(temp)[new Random().nextInt(sumario.get(temp).length)];
			if (tempM <= _r) {
				key = false;
			}
		} while (key == true);
		
		enchant.setTipoEncantamento(temp);
		enchant.setMelhoriaEncantamento(tempM);
		return enchant;
	}

	public static EncantamentoArmadura criarEncantamentoEscudo(Armadura armadura) {
		EncantamentoArmadura enchant = new EncantamentoArmadura();
		//Criação do sumário de encantamentos
		sumario.put(TipoItens.ALVO, v1);
		sumario.put(TipoItens.APANHARFLECHA, v1);
		sumario.put(TipoItens.CEGANTE, v1);
		sumario.put(TipoItens.FORTIFICACAO, v123);
		sumario.put(TipoItens.REDUCAODANO, v123);
		sumario.put(TipoItens.REFLEXAO, v123);
		sumario.put(TipoItens.RESISTENCIAELEMENTAL, v123);
		sumario.put(TipoItens.RESISTENCIAMAGIA, v2);
		
		//Lógica da escolha do encantamento
		Integer _r;
		_r = armadura.getRaridade(); //Get da raridade da arma
		
		TipoItens temp; //Variável que será passada várias vezes pra obter um enchant
		boolean key; //Key para parar o do while
		key = true;
		do {
			temp = TIPO_ENCANTAMENTO_ESCUDO[new Random().nextInt(TIPO_ENCANTAMENTO_ESCUDO.length)]; //Pega um valor do array
			List<Integer> list = Arrays.asList(sumario.get(temp)); //Transforma em lista
			if (list.contains(_r) || list.contains(_r-1) || list.contains(_r-2)) { //Garante que a raridade est� nas listas
				key = false;
			}
		} while (key == true);
		
		//Lógica da escolha da melhoria
		Integer tempM;
		key = true;
		do {
			tempM = sumario.get(temp)[new Random().nextInt(sumario.get(temp).length)];
			if (tempM <= _r) {
				key = false;
			}
		} while (key == true);
		
		enchant.setTipoEncantamento(temp);
		enchant.setMelhoriaEncantamento(tempM);
		return enchant;
	}
	
	public static EncantamentoArmadura criarEncantamentoRobe(Armadura armadura) {
		EncantamentoArmadura enchant = new EncantamentoArmadura();
		//Criação do sumário de encantamentos
		sumario.put(TipoItens.APRENDIZ, v1);
		sumario.put(TipoItens.MESTRE, v2);
		sumario.put(TipoItens.ARQUIMAGO, v3);
		
		//Lógica da escolha do encantamento
		Integer _r;
		_r = armadura.getRaridade(); //Get da raridade da arma
		
		TipoItens temp; //Variável que será passada várias vezes pra obter um enchant
		boolean key; //Key para parar o do while
		key = true;
		do {
			temp = TIPO_ENCANTAMENTO_MAGICO[new Random().nextInt(TIPO_ENCANTAMENTO_MAGICO.length)]; //Pega um valor do array
			List<Integer> list = Arrays.asList(sumario.get(temp)); //Transforma em lista
			if (list.contains(_r)) { //Garante que a raridade está nas listas
				key = false;
			}
		} while (key == true);
		
		//Lógica da escolha da melhoria
		Integer tempM;
		key = true;
		do {
			tempM = sumario.get(temp)[new Random().nextInt(sumario.get(temp).length)];
			if (tempM <= _r) {
				key = false;
			}
		} while (key == true);
		
		enchant.setTipoEncantamento(temp);
		enchant.setMelhoriaEncantamento(tempM);
		return enchant;
	}
}