package model;

public class Arma extends Objeto {
	
	private TipoItens tipo;
    private boolean magico;
    private EncantamentoArma encantamento;
    private TipoOutros auxiliar;

    public TipoOutros getAuxiliar() {
		return auxiliar;
	}

	public void setAuxiliar(TipoOutros auxiliar) {
		this.auxiliar = auxiliar;
	}

	public TipoItens getTipo() {
        return tipo;
    }

    public void setTipo(TipoItens tipo) {
        this.tipo = tipo;
    }

    public EncantamentoArma getEncantamento() {
        return encantamento;
    }

    public void setEncantamento(EncantamentoArma encantamento) {
        this.encantamento = encantamento;
    }

    public boolean isMagico() {
        return magico;
    }

    public void setMagico(boolean magico) {
        this.magico = magico;
    }
    
    @Override
    public String toString() {
    	StringBuilder builder = new StringBuilder();
				
		builder.append(getId() + ": ").
				append(getTipo().getDescricao() + " ").
				append("(+" + getRaridade() + ") ");
		
		if (isMagico() == true && getRaridade() != 0) {
			builder.append(getEncantamento().getTipoEncantamento().getDescricao() + " ");
            switch(getEncantamento().getMelhoriaEncantamento()){
                case 1: builder.append("[Incomum] "); break;
                case 2: builder.append("[Raro] "); break;
                case 3: builder.append("[Épico] "); break;
                default: builder.append("deu ruim"); break;
            }
			if(getAuxiliar() != null) {
				builder.append(getAuxiliar().getDescricao() + " ");
			}
		}
		
		return builder.toString();
    }
}
