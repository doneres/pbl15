import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static Scanner sc = new Scanner(System.in);
    private static final String FILE_NAME = "usuarios.txt";

    public static void main(String[] args) {
        while (true) {
            System.out.printf("""
                    Escolha uma opção:

                    1 - Consultar usuários cadastrados (Read);
                    2 - Consultar um determinado usuário (Read);
                    3 - Portal administrativo;
                    4 - Sair;

                    """);
            int escolhaMenu = sc.nextInt();
            sc.nextLine();

            switch (escolhaMenu) {
                case 1:
                    GerarTitulo("Consultar usuários cadastrados (Read)");
                    ConsultarUsuarios();
                    break;

                case 2:
                    GerarTitulo("Consultar um determinado usuário (Read)");
                    ConsultarUsuario();
                    break;

                case 3:
                    GerarTitulo("Portal administrativo");
                    validarAcesso();
                    break;

                case 4:
                    System.out.println("Obrigado por usar o programa!");
                    return;

                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    continue;
            }
        }
    }

    public static void GerarTitulo(String titulo) {
        System.out.println("\n==================== " + titulo + " ====================\n");
    }

    public static void CadastrarUsuario() {
        System.out.print("Nome Completo: ");
        String nome = sc.nextLine();

        System.out.print("Telefone (11 1 1111-1111): ");
        String numero = sc.nextLine();

        System.out.print("Senha: ");
        String senha = sc.nextLine();

        String registro = nome + "," + numero + "," + senha;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(registro);
            writer.newLine();
            System.out.println("Usuário cadastrado com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar o usuário: " + e.getMessage());
        }
    }

    public static void ConsultarUsuarios() {
        List<String> usuarios = carregarUsuarios();

        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário foi cadastrado ainda.");
        } else {
            for (int i = 0; i < usuarios.size(); i++) {
                String[] dados = usuarios.get(i).split(",");
                System.out.println("Usuário #" + (i + 1));
                System.out.println("Nome: " + dados[0]);
                System.out.println("Telefone: " + dados[1]);
                System.out.println("-----------------------");
            }
        }
    }

    public static void ConsultarUsuario() {
        List<String> usuarios = carregarUsuarios();

        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário foi cadastrado ainda.");
            return;
        }

        System.out.println("\nLista de usuários cadastrados:\n");
        for (int i = 0; i < usuarios.size(); i++) {
            String[] dados = usuarios.get(i).split(",");
            System.out.println("Usuário #" + (i + 1) + ": " + dados[0]);
        }

        System.out.print("Digite o índice correspondente a um usuário: ");
        int index = sc.nextInt();
        sc.nextLine();

        if (index < 1 || index > usuarios.size()) {
            System.out.println("Índice inválido.");
            return;
        }

        String[] dados = usuarios.get(index - 1).split(",");
        System.out.println("Nome: " + dados[0]);
        System.out.println("Telefone: " + dados[1]);
    }

    public static void AtualizarUsuario() {
        List<String> usuarios = carregarUsuarios();

        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário foi cadastrado ainda.");
            return;
        }

        System.out.println("\nLista de usuários cadastrados:\n");
        for (int i = 0; i < usuarios.size(); i++) {
            String[] dados = usuarios.get(i).split(",");
            System.out.println("Usuário #" + (i + 1) + ": " + dados[0]);
        }

        System.out.print("Digite o índice correspondente a um usuário: ");
        int index = sc.nextInt();
        sc.nextLine();

        if (index < 1 || index > usuarios.size()) {
            System.out.println("Índice inválido.");
            return;
        }

        String[] dados = usuarios.get(index - 1).split(",");
        System.out.println("Nome atual: " + dados[0]);
        System.out.println("Telefone atual: " + dados[1]);

        System.out.print("Novo nome: ");
        String novoNome = sc.nextLine();
        System.out.print("Novo telefone: ");
        String novoTelefone = sc.nextLine();
        System.out.print("Nova senha: ");
        String novaSenha = sc.nextLine();

        usuarios.set(index - 1, novoNome + "," + novoTelefone + "," + novaSenha);
        salvarUsuarios(usuarios);
        System.out.println("Usuário atualizado com sucesso!");
    }

    public static void deletarUsuario() {
        List<String> usuarios = carregarUsuarios();

        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário foi cadastrado ainda.");
            return;
        }

        System.out.println("\nLista de usuários cadastrados:\n");
        for (int i = 0; i < usuarios.size(); i++) {
            String[] dados = usuarios.get(i).split(",");
            System.out.println("Usuário #" + (i + 1) + ": " + dados[0]);
        }

        System.out.print("Digite o índice correspondente a um usuário: ");
        int index = sc.nextInt();
        sc.nextLine();

        if (index < 1 || index > usuarios.size()) {
            System.out.println("Índice inválido.");
            return;
        }

        usuarios.remove(index - 1);
        salvarUsuarios(usuarios);
        System.out.println("Usuário deletado com sucesso!");
    }

    public static void validarAcesso() {
        System.out.print("Usuário: ");
        String user = sc.nextLine();

        System.out.print("Senha: ");
        String pass = sc.nextLine();

        if ("admin".equals(user) && "admin".equals(pass)) {
            System.out.println("Bem-vindo, administrador!");
            int escolha;
            do {
                escolha = login();
            } while (escolha != 0);
        } else {
            System.out.println("Usuário ou senha inválidos.");
        }
    }

    public static int login() {
        System.out.printf("""
                Escolha uma opção:

                1 - Cadastrar um usuário (Create);
                2 - Consultar usuários cadastrados (Read);
                3 - Consultar um determinado usuário (Read);
                4 - Atualizar um registro de usuário (Update);
                5 - Deletar um registro de usuário (Delete);
                6 - Sair;
                """);

        int escolha = sc.nextInt();
        sc.nextLine();
        switch (escolha) {
            case 1 -> CadastrarUsuario();
            case 2 -> ConsultarUsuarios();
            case 3 -> ConsultarUsuario();
            case 4 -> AtualizarUsuario();
            case 5 -> deletarUsuario();
            case 6 -> {
                return 0;
            }
            default -> System.out.println("Opção inválida. Tente novamente.");
        }
        return 1;
    }

    private static List<String> carregarUsuarios() {
        List<String> usuarios = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                usuarios.add(linha);
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar usuários: " + e.getMessage());
        }
        return usuarios;
    }

    private static void salvarUsuarios(List<String> usuarios) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String usuario : usuarios) {
                writer.write(usuario);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar usuários: " + e.getMessage());
        }
    }
}
