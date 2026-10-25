import java.util.ArrayList;
import java.util.List;

public class Setor {

    private List<Reserva> reservas;
    private int id;
    private String nome;

    public Setor(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.reservas = new ArrayList<>();
    }

    public void adcReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void removeReserva(Reserva reserva) {
        reservas.remove(reserva);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}