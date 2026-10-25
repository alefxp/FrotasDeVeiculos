import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {

    private int id;
    private LocalDate data;
    private LocalTime horario;
    private String status;
    private String obs;
    private Veiculos veiculo;
    private Setor setor;

    public Reserva(int id, LocalDate data, LocalTime horario, String status, String obs,
                   Veiculos veiculos, Setor setor) {
        this.id = id;
        this.data = data;
        this.horario = horario;
        this.status = status;
        this.obs = obs;
        this.veiculo = veiculos;
        this.setor = setor;
    }

    public void exibirDados() {
        System.out.println("ID da reserva: " + id);
        System.out.println("Veiculo:" + veiculo.getPlaca());
        System.out.println("Setor: " + setor.getNome());
        System.out.println("Data: " + data);
        System.out.println("Horario: " + horario);
        System.out.println("Status: " + status);
        System.out.println("Observação: " + obs);
    }

    public int getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public String getStatus() {
        return status;
    }

    public String getObs() {
        return obs;
    }

    public Veiculos getVeiculo() {
        return veiculo;
    }

    public Setor getSetor() {
        return setor;
    }
}
