package perfis;
import posts.Post;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Perfil {

    private String nome;
    private String login;
    private String senha;
    List<Post> posts = new ArrayList<>();
    public Perfil(){
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public String getNome(){
     return nome;
    }
    public String getLogin(){
     return login;
    }
    public String getSenha(){
     return senha;
    }

    public void menuInicialUsuario() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Selecione uma das opções:");
        System.out.println("1 = Postar / 2 = Time Line / 3 = Sair");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1:
                postar();
                break;
            case 2:
                timeline();
                break;
            case 3:
                sair();
            default:
                System.out.println("Digite uma opção valida");
        }
        menuInicialUsuario();
    }
    public void postar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digita a data: Formato (yy/yy/yyyy): ");
        String data = sc.next();
        System.out.println("Digite a hora: Formato (00:00): ");
        String hora = sc.next();
        System.out.println("Digite a Postagem: ");
        sc.nextLine();
        String mensagem = sc.nextLine();
        if (data.isEmpty() || hora.isEmpty() || mensagem.isEmpty()) {
            System.out.println("Todos os campos devem ser preenchidos");
        }
        posts.add(new Post(data, hora, mensagem));
        System.out.println("Publicação realizada com sucesso");
        timeline();

    }
    public void timeline() {
        System.out.println("Time Line");
        for (Post p : posts) {
            System.out.println(p.getData() + " ás " + p.getHora() + " - " + p.getMensagem());
        }
        menuInicialUsuario();
    }
    public void sair() {
        System.out.println("Obrigado, saindo do seu login!");

    }
}