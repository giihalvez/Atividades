package cliente;
import java.util.ArrayList;
import java.util.List;

public class CadCliente {
    private final List<Cliente> clientes;
    private static int proximoId = 1;

    public CadCliente() {
        super();
        clientes = new ArrayList<>();
        clientes.add(new Cliente(proximoId++, "Gisele", "giselealvez@20", "779999999999"));
        clientes.add(new Cliente(proximoId++, "Bruno", "bubu@123", "77988888888"));
        clientes.add(new Cliente(proximoId++, "Sofia", "sofi@23", "77977777777"));
    }

    public List<Cliente> listarClientes() {
        return this.clientes;
    }

    public Cliente buscarId(long id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    public void cadastroClientes(String nome, String email, String telefone) {
        Cliente novoCadastro = new Cliente(proximoId++, nome, email, telefone);
        clientes.add(novoCadastro);
    }

    public boolean atualizarCliente(int id, String nome, String email, String telefone) {
        Cliente cliente = this.buscarId(id);
        if (cliente != null) {
            cliente.setNome(nome);
            cliente.setEmail(email);
            return true;
        }
        return false;
    }

    public boolean deletarCliente(int id) {
        Cliente cliente = this.buscarId(id);
        if (cliente != null) {
            clientes.remove(cliente);
            return true;
        }
        return false;
    }



}
