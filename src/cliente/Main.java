package cliente;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        CadCliente CadastroCliente = new CadCliente();
        List<Cliente> clientes = CadastroCliente.listarClientes();

        for (Cliente cliente:clientes){
            System.out.println(cliente.toString());
        }
        Cliente c1 = CadastroCliente.buscarId(2);
        if (c1 != null) {
            System.out.println(c1.toString());
        }
        CadastroCliente.cadastroClientes("Elisonaria","elis@25","639999999");

        for (Cliente cliente:clientes){
            System.out.println(cliente.toString());
        }
        System.out.println(CadastroCliente.atualizarCliente(1, "Luara", "lua@2025", "77966666"));
        for (Cliente cliente:clientes){
            System.out.println(cliente.toString());
        }
        System.out.println(CadastroCliente.deletarCliente(3));
        for (Cliente cliente:clientes){
            System.out.println(cliente.toString());
        }


    }



}
