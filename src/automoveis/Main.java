package automoveis;
public class Main {
    public static void main(String[] args) {

        Carro c1 = new Carro("BMW |","M4 |", 2023, 2);
        Moto m1 = new Moto("Honda |", "Bross |", 2020, true);

        c1.exibirDetalhes();
        m1.exibirDetalhes();
    }
}