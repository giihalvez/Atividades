package automoveis;

public class Moto extends Veiculo{
    private boolean temSidecar;

    public Moto(boolean temSidecar){
        this.temSidecar = temSidecar;

    }

    public Moto(String marca, String modelo, int ano,boolean temSidecar ){
        super(marca,modelo,ano);
        this.temSidecar = temSidecar;
    }

    public boolean isTemSidecar() {
        return temSidecar;
    }

    public void setTemSidecar(boolean temSidecar) {
        this.temSidecar = temSidecar;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println(" Moto: ");
        System.out.println(" Marca: " +getMarca()+ " Modelo: " +getModelo()+ " Ano: " +getAno()+ " SideCar: " +isTemSidecar());
    }
}

