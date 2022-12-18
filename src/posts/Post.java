package posts;

public class Post {
        private String data;
        private String hora;
        private String mensagem;

    public Post(String data, String hora, String mensagem) {
        this.data = data;
        this.hora = hora;
        this.mensagem = mensagem;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public String getMensagem() {
        return mensagem;
    }
}
