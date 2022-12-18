import Exceptions.UsuarioNaoEncontradoException;
import perfis.Perfil;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RedeSocialNova {
    Scanner sc = new Scanner(System.in);
    static List<Perfil> perfis = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Seja muito bem vindo a rede social Nova");
        System.out.println("Só e possivel acessar a rede social com um cadastro, caso não tenha basta se cadastrar!");
        menuPrincipal();
    }

    static void menuPrincipal() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu Principal");
        System.out.println("Digite umas das opções: C = Cadastrar | E = Entrar | F = Fechar");
        String opcao = sc.next().toUpperCase();

        switch(opcao) {
            case ("C"):
                CadastroUsuario();
                break;
            case ("E"):
                login();
                break;
            case ("F"):
                sair();
                break;
            default:
                System.out.println("Digite uma opção valida");
                break;
        }
        menuPrincipal();
    }
     public static void CadastroUsuario() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tela inicial de cadastro:\nPara realizar seu cadastro preencha as informações: ");

        System.out.println("Digite seu nome: ");
        String nome = sc.nextLine();
        System.out.println("Digite seu login: ");
        String login = sc.nextLine();
        System.out.println("Digite sua senha: ");
        String senha = sc.nextLine();

        if (nome.isEmpty() || nome.isBlank() || login.isEmpty() || senha.isEmpty()) {
            System.out.println("O sistema nao aceita campos em branco");
        }

        Perfil perfil = new Perfil();
        perfis.add(perfil);
        System.out.println("Cadastro realizado");
        menuPrincipal();
    }

    private static void login()
        throws UsuarioNaoEncontradoException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Lista de Usuarios do sistema");
        listaDeUsuarios();

        System.out.println("Digite o Login: ");
        String login = sc.next();
        System.out.println("Digite a senha: ");
        String senha = sc.next();
        for (Perfil perfil : perfis) {
            if(login.equals(perfil.getLogin()) && senha.equals(perfil.getSenha())) {
                System.out.println("Bem Vindo a rede social NOVA " + perfil.getNome());
                Perfil m = new Perfil();
                m.menuInicialUsuario();
            } else {
                throw new UsuarioNaoEncontradoException();
            }
        }
    }

    static void listaDeUsuarios() {
        for(Perfil perfil : perfis) {
            System.out.println(perfil.getNome());
            System.out.println(perfil.getLogin());
            System.out.println(perfil.getSenha());

        }
    }
    private static void sair() {
        System.out.println("Saindo do sistema");
        System.exit(0);

    }
}
