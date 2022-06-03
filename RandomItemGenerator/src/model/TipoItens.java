package model;

public enum TipoItens {
    
    //Armas
    ADAG("Adaga"),
    AZAG("Azagaia"),
    BORD("Bordão"),
    LANC("Lança"),
    MACA("Maça"),
    MACHADINHA("Machadinha"),
    MARTLV("Martelo Leve"),
    ALAB("Alabarda"),
    ESPCUR("Espada Curta"),
    ESPGRA("Espada Grande"),
    ESPLON("Espada Longa"),
    GLAIV("Glaive"),
    LANCLONG("Lança Longa"),
    MACEST("Maça Estrela"),
    MACGRA("Machado Grande"),
    MACBAT("Machado de Batalha"),
    MALH("Malho"),
    MARTGUE("Martelo de Guerra"),
    RAPI("Rapieira"),
    VARI("Varinha"),
    CAJA("Cajado"),
    ORBE("Orbe"),
    ARCCUR("Arco Curto"),
    BESLEV("Besta Leve"),
    DARD("Dardo"),
    ARCLONG("Arco Longo"),
    BESMAO("Besta de Mão"),
    BESPES("Besta Pesada"),

    //Armaduras
    ACOLCHOADA("Acolchoada"),
	COURO("Couro"),
	COUROBATIDO("Couro Batido"),
	GIBAODEPELES("Gibão de Peles"),
	CAMISAODEMALHA("Camisão de Malha"),
	BRUNEA("Brunea"),
	PEITORAL("Peitoral"),
	MEIAARMADURA("Meia-Armadura"),
	COTAANEIS("Cota de anéis"),
	COTAMALHA("Cota de malha"),
	COTATALAS("Cota de talas"),
	PLACAS("Placas"),
	ESCUDO("Escudo"),
	ROBE("Robe"),

    //Encantamento das Armas
    AFIADO("Afiado(a)"),
	ANTICRIATURA("Anti-Criatura"),
	ASSASSINA("Assassino(a)"),
	CACADORA("Caçador(a)"), //ENCHANT RANGED
	CURA("da Cura"),
	DANOELEMENTAL("de Dano Elemental"),
	DEFENSORA("Defensor(a)"),
	DRENANTE("Drenante"),
	FORTUNA("da Fortuna"),
	RETORNO("do Retorno"), // ENCHANT MELEE
	ROMPIMENTO("do Rompimento"),
	SANGRAMENTO("do Sangramento"),
	VELOCIDADE("da Velocidade"),

    //Encantamento Armaduras
    ALVO("Alvo"),
	AMPLIARDANO("do Dano Ampliado"), //Armadura
	APANHARFLECHA("de Apanhar Flechas"), //Escudo
	AURACURA("da Aura de Cura"), //Armadura
	AURACORAGEM("da Aura da Coragem"), //Armadura
	AURATERROR("da Aura do Terror"), //Armadura
	CEGANTE("Cegante"),
	CONTROLARMV("do Controle de Mortos-Vivos"), //Armadura
	FORTIFICACAO("da Fortificação"),
	REDUCAODANO("da Redução"),
	REFLEXAO("da Reflexão"),
	RESISTENCIAELEMENTAL("da Resistência Elemental"),
	RESISTENCIAMAGIA("da Resistência à Magia"),
	
	//Robes Mágicos
	APRENDIZ("do Aprendiz"),
	MESTRE("do Mestre"),
	ARQUIMAGO("do Arquimago");

    private String descricao;

	TipoItens(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
