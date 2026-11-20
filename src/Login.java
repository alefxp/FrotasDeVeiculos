public class Login {


    private int ID;
    private String nome;
    private String email;
    private String senha;
    private Setor setor;

    public Login(int ID, String nome, String email, String senha, Setor setor) {
        this.ID = ID;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.setor = setor;
    }

    public Setor getSetor() {
        return setor;
    }

    public int getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public boolean validarSenha (String senhaDigitada) {
        return this.senha.equals(senhaDigitada);
    }

}