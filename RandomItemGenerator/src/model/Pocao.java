package model;

public class Pocao extends Objeto {

	private TipoOutros tipo;
	private TipoOutros pocao;
	private TipoOutros auxiliar;

	
	public TipoOutros getAuxiliar() {
		return auxiliar;
	}

	public void setAuxiliar(TipoOutros auxiliar) {
		this.auxiliar = auxiliar;
	}

	public TipoOutros getTipo() {
		return tipo;
	}

	public void setTipo(TipoOutros tipo) {
		this.tipo = tipo;
	}

	public TipoOutros getPocao() {
		return pocao;
	}

	public void setPocao(TipoOutros pocao) {
		this.pocao = pocao;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append(getId() + ": ").
				append(getTipo().getDescricao() + " ").
				append(getPocao().getDescricao() + " ");
		if(getAuxiliar() != null) {
			builder.append(getAuxiliar().getDescricao() + " ");
		}
		switch(getRaridade()) {
			case 1: builder.append("[Incomum]"); break;
			case 2: builder.append("[Raro]"); break;
			case 3: builder.append("[Épico]"); break;
			default: builder.append("nada men"); break;
		}
		
		return builder.toString();
	}
}
