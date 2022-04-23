public class Reserva implements Pagamento{
    
    private Cliente cliente;
    private boolean pagamentoAVista;

    public Reserva(Cliente cliente, boolean pagamentoAVista){
        this.cliente = cliente;
        this.pagamentoAVista = pagamentoAVista;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setPagamentoAVista(boolean pagamentoAVista) {
        this.pagamentoAVista = pagamentoAVista;
    }

    public boolean getPagamentoAVIsta(){
        return pagamentoAVista;
    }

    public double calcularPagamento() {
		
        double valor = 3200;

        if(pagamentoAVista){
            valor = valor * 0.9;
        }
        
        return valor;
	}

    @Override
    public String toString() {
        String forma = "";
        boolean pagamento = getPagamentoAVIsta();
        
        if (pagamento == true){
            forma = "À vista";
        } else {
            forma = "Parcelado";
        }

        return "{Cliente: "+ cliente + ", Forma de pagamento: " +forma+ "}";
    }

}
