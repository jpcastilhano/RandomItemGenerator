package controller;

import java.util.Random;

import model.Anel;
import model.Pocao;
import model.TipoOutros;
import model.Maravilhoso;

public class OutrosDAO {

	private EncantamentoOutrosDAO encantamentoOutrosDAO;
	private MetodosDAO metodosDAO;
	public OutrosDAO() {
		encantamentoOutrosDAO = new EncantamentoOutrosDAO();
		metodosDAO = new MetodosDAO();
	}
	
	public Maravilhoso criarMaravilhoso(Integer id) {
		Maravilhoso mar = new Maravilhoso();
		
		mar.setId(id);
		mar.setRaridade(new Random().nextInt(3)+1);
		mar.setItem(encantamentoOutrosDAO.criarEncantamentoMaravilhoso(mar));
		
		if (mar.getItem() == TipoOutros.PEDRAI) {
			mar.setAuxiliar(encantamentoOutrosDAO.pedraIonica(mar));
		}
		
		return mar;
	}
	
	public Anel criarAnel(Integer id, Integer raridade) {
		Anel anel = new Anel();
		
		anel.setId(id);
		anel.setRaridade(metodosDAO.raridadeNaoNula(raridade));
		anel.setTipo(TipoOutros.ANEL.getDescricao());
		anel.setEncantamento(encantamentoOutrosDAO.criarEncantamentoAnel(anel));
				
		if (anel.getEncantamento() == TipoOutros.PERICIA || anel.getEncantamento() == TipoOutros.RESISTENCIA) {
			anel.setAuxiliar(encantamentoOutrosDAO.variavelAnel(anel.getEncantamento()));
		}
		
		return anel;
	}
	
	public Pocao criarPocao(Integer id, Integer raridade) {
		Pocao pocao = new Pocao();
		
		pocao.setId(id);
		pocao.setRaridade(metodosDAO.raridadeNaoNula(raridade));
		pocao.setTipo(TipoOutros.POCAO);
		pocao.setPocao(encantamentoOutrosDAO.criarEncantamentoPocao(pocao));
		
		if (pocao.getPocao() == TipoOutros.RESIST) {
			pocao.setAuxiliar(encantamentoOutrosDAO.pocaoResistencia());
		}
		
		return pocao;
	}
}
