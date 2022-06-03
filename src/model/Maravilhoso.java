package model;

public class Maravilhoso extends Objeto {

	private TipoOutros item;
	private TipoOutros auxiliar;

	public TipoOutros getAuxiliar() {
		return auxiliar;
	}

	public void setAuxiliar(TipoOutros auxiliar) {
		this.auxiliar = auxiliar;
	}

	public TipoOutros getItem() {
		return item;
	}

	public void setItem(TipoOutros item) {
		this.item = item;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append(getId() + ": ").
				append(getItem().getDescricao() + " ");
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
