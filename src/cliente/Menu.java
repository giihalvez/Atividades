package cliente;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

public class Menu {
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    CadCliente cadastroCliente = new CadCliente();
    boolean running = true;

                while (running) {
        System.out.println("\n* Menu de Clientes *");
        System.out.println("1. Listar clientes");
        System.out.println("2. Buscar cliente por ID");
        System.out.println("3. Cadastrar novo cliente");
        System.out.println("4. Deletar");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");

        int opcao;
        try {
            opcao = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Por favor, insira um número válido!");
            continue;
        }

        switch (opcao) {
            case 1:
                List<Cliente> clientes = cadastroCliente.listarClientes();
                if (clientes.isEmpty()) {
                    System.out.println("Nenhum cliente cadastrado.");
                } else {
                    for (Cliente cliente : clientes) {
                        System.out.println(cliente.toString());
                    }
                }
                break;

            case 2:
                System.out.print("Digite o ID do cliente: ");
                long id;
                try {
                    id = Long.parseLong(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("ID inválido!");
                    break;
                }
                Cliente cliente = cadastroCliente.buscarId(id);
                if (cliente != null) {
                    System.out.println(cliente.toString());
                } else {
                    System.out.println("Cliente com ID " + id + " não encontrado.");
                }
                break;

            case 3:
                System.out.print("Digite o nome: ");
                String nome = scanner.nextLine();

                System.out.print("Digite o email: ");
                String email = scanner.nextLine();

                System.out.print("Digite o telefone : ");
                String telefone = scanner.nextLine();

                cadastroCliente.cadastroClientes(nome, email, telefone);
                System.out.println("Cliente cadastrado !");
                break;
            case 4:
                System.out.print("Digite o ID do cliente que deseja deletar: ");
                long idToDelete;
                try {
                    idToDelete = Long.parseLong(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("ID inválido insira um Id válido.");
                    break;
                }

                Cliente clienteParaRemover = cadastroCliente.buscarId(idToDelete);
                if (clienteParaRemover != null) {
                    cadastroCliente.listarClientes().remove(clienteParaRemover);
                    System.out.println("Cliente com ID " + idToDelete + " removido!");
                } else {
                    System.out.println("ID não encontrado!");
                }
                break;


            case 5:
                System.out.println("Saindo...");
                running = false;
                break;

            default:
                System.out.println("Opção inválida! Escolha entre 1 e 4.");
                break;
        }
    }

                scanner.close();
}
}