import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalTime;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Setor> setores = new ArrayList<>();
        ArrayList<Veiculos> veiculos = new ArrayList<>();
        ArrayList<Reserva> reservas = new ArrayList<>();
        int proxReserva = 1;

        setores.add(new Setor(1, "EXPEDIÇÃO"));
        setores.add(new Setor(2, "COMERCIAL"));
        setores.add(new Setor(3, "MARKETING"));
        setores.add(new Setor(4, "DIRETORIA"));

        veiculos.add(new Veiculos(1, "ABC123", "VOLKSWAGEN", "NIVUS", 2023));
        veiculos.add(new Veiculos(2, "DEF456", "FIAT", "SCUDO", 2025));
        veiculos.add(new Veiculos(3, "GHI789", "FIAT", "STRADA", 2022));
        veiculos.add(new Veiculos(4, "JKL012", "CHEVROLET", "CRUZE", 2022));

        System.out.println("======================================");
        System.out.println("     FROTA VEICULOS EMPRESARIAIS");
        System.out.println("======================================");
        System.out.println();


        Setor setorLogado = null;

        while (setorLogado == null) {
            System.out.println("Entre com o ID do setor ");
            int idSetor = lerId(sc);

            for (Setor setor : setores) {
                if (setor.getId() == idSetor) {
                    setorLogado = setor;
                    break;
                }
            }
            if (setorLogado == null) {
                System.out.println("Setor não encontrado. Tente novamente. \n");
            }
        }

        System.out.println("\n Bem-vindo, " + setorLogado.getNome() + " !");

        System.out.println("\n======= TODOS OS   VEÍCULOS =======");

        for (Veiculos veiculo : veiculos) {
            System.out.println("\nModelo: " + veiculo.getModelo());
            System.out.println("Placa: " + veiculo.getPlaca());

            if (veiculo.estaDisponivel()) {
                System.out.println("Status: DISPONÍVEL");
            } else {
                System.out.println("Status: INDISPONÍVEL");
            }
        }
        System.out.println();
        Veiculos veiculoEscolhido = null;

        while (veiculoEscolhido == null) {
            System.out.println("Entre com ID do veiculo que deseja reservar ");
            int idVeiculo = lerId(sc);

            for (Veiculos veiculo : veiculos) {
                if (veiculo.getId() == idVeiculo) {
                    veiculoEscolhido = veiculo;
                    break;
                }
            }
            if (veiculoEscolhido == null) {
                System.out.println("Veiculo não encontrado. Tente novamente.");
            } else if (!veiculoEscolhido.estaDisponivel()) {
                System.out.println("Este veículo já esta reservado. Escolha outro. ");
                veiculoEscolhido = null;
            }
        }
        System.out.println();

        System.out.println("Veículo selecionado: " + veiculoEscolhido.getModelo());

        System.out.print("Observação da reserva: ");
        String obs = sc.nextLine();

        LocalDate data = LocalDate.now();
        LocalTime horario = LocalTime.now();

        Reserva reserva = new Reserva(
                1,
                data,
                horario,
                "ATIVA",
                obs,
                veiculoEscolhido,
                setorLogado
        );

        reservas.add(reserva);
        setorLogado.adcReserva(reserva);
        veiculoEscolhido.alterarDisponibilidade(false);

        System.out.println("\nReserva realizada com sucesso!");
        reserva.exibirDados();
        sc.close();
    }
    public static int lerId(Scanner sc) {
        while (true) {
            try {
                System.out.print("Digite um ID: ");
                String entrada = sc.nextLine();
                return Integer.parseInt(entrada);

            } catch (NumberFormatException e) {
                System.out.print("Entrada invalida! Digite apenas números: ");
            }
        }
    }
}