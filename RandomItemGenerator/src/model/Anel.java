package model;

public class Anel extends Objeto {

	private String tipo;
	private TipoOutros encantamento;
	private TipoOutros auxiliar;
	
	public TipoOutros getAuxiliar() {
		return auxiliar;
	}

	public void setAuxiliar(TipoOutros auxiliar) {
		this.auxiliar = auxiliar;
	}

	public TipoOutros getEncantamento() {
		return encantamento;
	}

	public void setEncantamento(TipoOutros encantamento) {
		this.encantamento = encantamento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
    	StringBuilder builder = new StringBuilder();
				
		builder.append(getId() + ": ").
				append(getTipo() + " ").
				append(getEncantamento().getDescricao() + " ");
		if(getAuxiliar() != null) {
			builder.append(getAuxiliar().getDescricao() + " ");
		}
		switch(getRaridade()) {
			case 1: builder.append("(Incomum)"); break;
			case 2: builder.append("(Raro)"); break;
			case 3: builder.append("(Épico)"); break;
			default: builder.append("nada men"); break;
		}
				
		return builder.toString();
    }
}
