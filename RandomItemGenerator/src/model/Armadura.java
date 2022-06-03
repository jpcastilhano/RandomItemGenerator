package model;

public class Armadura extends Objeto {
	
	private TipoItens tipo;
    private boolean magico;
    private EncantamentoArmadura encantamento;

    public TipoItens getTipo() {
        return tipo;
    }

    public void setTipo(TipoItens tipo) {
        this.tipo = tipo;
    }

    public EncantamentoArmadura getEncantamento() {
        return encantamento;
    }

    public void setEncantamento(EncantamentoArmadura encantamento) {
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
		}
		
		return builder.toString();
    }
}
