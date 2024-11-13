import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<String> nomes = new ArrayList<String>();
    private static ArrayList<String> telefone = new ArrayList<String>();
    private static ArrayList<String> senha = new ArrayList<String>();
    private static ArrayList<String> user = new ArrayList<String>();

    public static void main(String[] args) {
        while (true) {
            System.out.printf("""

                    Escolha uma opção:

                    1 - Consultar usuários cadastrados (Reade);
                    2 - Consultar um determinado usuário (Reade);
                    3 - Portal administrativo;
                    4 - Sair;

                    """);
            int escolhaMenu = sc.nextInt();
            sc.nextLine();

            switch (escolhaMenu) {
                case 1:
                    GerarTitulo("Consultar usuários cadastrados (Reade)");

                    break;

                case 2:
                    GerarTitulo("Consultar um determinado usuário (Reade)");

                    break;
                case 3:
                    GerarTitulo("Portal administrativo");

                    logar();
                case 4:
                    System.out.println("Obrigado por usar o programa!");
                    sc.close();
                    return;

                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    return;
            }
        }
    }

    public static void GerarTitulo(String titulo) {
        System.out.println("\n==================== " + titulo + " ====================\n");
    }

    public static void CadastrarUsuario() {
        System.out.print("Nome Completo: ");
        String nome = sc.nextLine();
        nomes.add(nome);

        System.out.print("Telefone (11 1 1111-1111): ");
        String numero = sc.nextLine();
        telefone.add(numero);

        System.out.print("Senha: ");
        String password = sc.nextLine();
        senha.add(password);
    }

    public static void ConsultarUsuarios() {
        System.out.println("Lista de usuarios cadastrados:\n");

        if (nomes.isEmpty()) {
            System.out.println("Nenhum usuário foi cadastrado ainda.");
        } else {
            for (int i = 0; i < nomes.size(); i++) {
                System.out.println("Usuário #" + (i + 1));
                System.out.println("Nome: " + nomes.get(i));
                System.out.println("Telefone: " + telefone.get(i));
                System.out.println("-----------------------");
            }
            System.out.println(" ");
        }
    }

    public static void ConsultarUsuario() {
        System.out.println("\nLista de usuarios cadastrados:\n");
        for (int i = 0; i < nomes.size(); i++) {
            System.out.println("Usuário #" + (i + 1));
            System.out.println("Nome: " + nomes.get(i));
        }

        System.out.print("Digite o index correspondente a um usuário: ");
        int index = sc.nextInt();
        sc.nextLine();
        index--;

        System.out.println(" ");
        System.out.println("Nome: " + nomes.get(index));
        System.out.println("Telefone: " + telefone.get(index));

    }

    public static void AtualizarUsuario() {
        System.out.println("\nLista de usuários cadastrados:\n");
        for (int i = 0; i < nomes.size(); i++) {
            System.out.println("Usuário #" + (i + 1));
            System.out.println("Nome: " + nomes.get(i));
        }

        System.out.print("Digite o índice correspondente a um usuário: ");
        int usuarioSelecionado = sc.nextInt();
        sc.nextLine();
        usuarioSelecionado--;

        if (usuarioSelecionado < 0 || usuarioSelecionado >= nomes.size()) {
            System.out.println("Índice inválido.");
            return;
        }

        System.out.printf("""

                    1 - Nome
                    2 - Telefone
                    3 - Senha

                """);
        System.out.print("Escolha uma opção: ");
        int escolhaAtualizacao = sc.nextInt();
        sc.nextLine();

        switch (escolhaAtualizacao) {
            case 1:
                System.out.print("Digite o novo nome: ");
                String novoNome = sc.nextLine();
                nomes.set(usuarioSelecionado, novoNome);
                System.out.println("Nome atualizado com sucesso!");
                break;

            case 2:
                System.out.print("Digite o novo telefone: ");
                String novoTelefone = sc.nextLine();
                telefone.set(usuarioSelecionado, novoTelefone);
                System.out.println("Telefone atualizado com sucesso!");
                break;

            case 3:
                System.out.print("Digite a nova senha: ");
                String novaSenha = sc.nextLine();
                senha.set(usuarioSelecionado, novaSenha);
                System.out.println("Senha atualizada com sucesso!");
                break;

            default:
                System.out.println("Opção inválida. Nenhuma atualização foi feita.");
                break;
        }
    }

    public static void deletarUsuario() {
        System.out.println("\nLista de usuários cadastrados:\n");
        for (int i = 0; i < nomes.size(); i++) {
            System.out.println("Usuário #" + (i + 1));
            System.out.println("Nome: " + nomes.get(i));
        }

        System.out.print("Digite o índice correspondente a um usuário: ");
        int usuarioSelecionado = sc.nextInt();
        sc.nextLine();
        usuarioSelecionado--;

        if (usuarioSelecionado < 0 || usuarioSelecionado >= nomes.size()) {
            System.out.println("Índice inválido.");
            return;
        }

        nomes.remove(usuarioSelecionado);
        telefone.remove(usuarioSelecionado);
        senha.remove(usuarioSelecionado);

        System.out.println("Usuário deletado com sucesso!");
    }

    public static int logar() {

        //Finalizar lógica de login

        user.add("admin");
        senha.add("admin");

        System.out.print("Usuário: ");
        String user = sc.nextLine();

        System.out.print("Senha: ");
        String pass = sc.nextLine();

        if (user.get(0).equals(user) && senha.get(0).equals(pass)) {

            login();

        } else {
            int cont = 1;
            while (cont < 3) {

                System.out.println("Usuário ou senha inválidos. Tente novamente.\n");

                System.out.println("Deseja resgatar sua senha? (S/N)");
                String resgatar = sc.nextLine();

                if (resgatar.equalsIgnoreCase("s")) {
                    resgatarSenha();
                }
            }

            cont++;
        }
        return 1;
    }

    public static int login() {

        System.out.printf("%nBem vindo, %s, este é o portal administrativo!%n%n", user);

        System.out.printf("""
                Escolha uma opção:

                1 - Cadastrar um usuário (Create);
                2 - Consultar usuários cadastrados (Reade);
                3 - Consultar um determinado usuário (Reade);
                4 - Atualizar um registro de usuário (Update);
                5 - Deletar um registro de usuário (Delete);
                6 - Sair;
                """);

        int escolha = sc.nextInt();
        sc.nextLine();
        switch (escolha) {
            case 1:
                CadastrarUsuario();
                break;
            case 2:
                ConsultarUsuarios();
                break;
            case 3:
                ConsultarUsuario();
                break;
            case 4:
                AtualizarUsuario();
                break;
            case 5:
                deletarUsuario();
                break;
            case 6:
                sc.close();
                return 0;
            default:
                System.out.println("Opção inválida. Por favor, escolha uma opção válida. \n");
                return 1;
        }

        return 1;
    }

    public static void resgatarSenha() {
        System.out.println("Digite o seu nome de usuário: ");
        String user = sc.nextLine();

        if (user.equals("admin")) {
            System.out.println("Sua senha é: admin");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

}