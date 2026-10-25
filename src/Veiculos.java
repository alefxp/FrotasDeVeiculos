public class Veiculos {

    private int id;
    private String placa;
    private String marca;
    private String modelo;
    private int ano;
    private boolean disponivel;

    public Veiculos(int id, String placa, String marca, String modelo, int ano, boolean disponivel) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.disponivel = disponivel;
    }

    public int getId() {
        return id;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void exibirDados() {
        System.out.println("ID: " + id);
        System.out.println("Placa: " + placa);
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
        System.out.println("Disponivel: " + disponivel);
    }

    public boolean estaDisponivel() {
        return disponivel;
    }

    public void alterarDisponibilidade(boolean disponivel) {
        this.disponivel = disponivel;
    }
}