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
            System.out.print("Entre com o ID do setor: ");
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

        int opcao = 0;

        while (opcao != 3) {
            System.out.println("\n======= MENU DO SETOR =======");
            System.out.println("1 - Realizar reserva");
            System.out.println("2 - Minhas reservas");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = lerId(sc);

            if (opcao == 1) {

                System.out.println("\n======= TODOS OS VEÍCULOS =======");

                for (Veiculos veiculo : veiculos) {
                    System.out.println("\nModelo: " + veiculo.getModelo());
                    System.out.println("Placa: " + veiculo.getPlaca());

                    if (veiculo.estaDisponivel()) {
                        System.out.println("Status: DISPONÍVEL");
                    } else {
                        System.out.println("Status: INDISPONÍVEL");
                    }
                }

                Veiculos veiculoEscolhido = null;

                while (veiculoEscolhido == null) {
                    System.out.print("Entre com ID do veículo: ");
                    int idVeiculo = lerId(sc);

                    for (Veiculos veiculo : veiculos) {
                        if (veiculo.getId() == idVeiculo) {
                            veiculoEscolhido = veiculo;
                            break;
                        }
                    }

                    if (veiculoEscolhido == null) {
                        System.out.println("Veículo não encontrado.");
                    } else if (!veiculoEscolhido.estaDisponivel()) {
                        System.out.println("Veículo indisponível no momento! ");
                        veiculoEscolhido = null;
                    }
                }

                System.out.print("Observação da reserva: ");
                String obs = sc.nextLine();

                LocalDate data = LocalDate.now();
                LocalTime horario = LocalTime.now();

                Reserva reserva = new Reserva(
                        proxReserva,
                        data,
                        horario,
                        "ATIVA",
                        obs,
                        veiculoEscolhido,
                        setorLogado
                );

                proxReserva++;

                reservas.add(reserva);
                setorLogado.adcReserva(reserva);
                veiculoEscolhido.alterarDisponibilidade(false);

                System.out.println("\nReserva realizada com sucesso!");
                reserva.exibirDados();
            } else if (opcao == 2) {

                System.out.println("\n======= MINHAS RESERVAS =======");

                if (setorLogado.getReservas().isEmpty()) {
                    System.out.println("Você ainda não possui reservas.");

                } else {

                    for (Reserva reserva : setorLogado.getReservas()) {
                        reserva.exibirDados();
                        System.out.println("---------------------------");
                    }
                }
            } else if (opcao == 3) {

                System.out.println();

                boolean estaAtiva = false;

                for (Reserva reserva : setorLogado.getReservas()) {
                    if (reserva.getStatus().equals("ATIVA")) {
                        estaAtiva = true;
                        break;
                    }
                }

                if (!estaAtiva) {
                    System.out.println("Você não possui veículos para devolver! ");
                } else {
                    System.out.print("Digite o ID da reserva que deseja devolver: ");
                    int idReserva = lerId(sc);

                    Reserva reservaEncontrada = null;

                    for (Reserva reservaa : setorLogado.getReservas()) {
                        if (reservaa.getStatus().equals("ATIVA")
                                && reservaa.getId() == idReserva) {
                            reservaEncontrada = reservaa;
                            break;
                        }
                    }
                    if (reservaEncontrada == null) {
                        System.out.println("Nenhuma reserva ativa com esse ID no seu setor.");
                    } else {
                        reservaEncontrada.setStatus("FINALIZADA");
                        reservaEncontrada.getVeiculo().alterarDisponibilidade(true);
                        System.out.println("\nVeículo devolvido com sucesso! ");
                    }
                }

            } else if (opcao == 4) {
                System.out.println("Encerrando...");
            } else {
                System.out.println("Opção invalida! ");
            }
        }

    }

    public static int lerId(Scanner sc) {
        while (true) {
            try {
                String entrada = sc.nextLine();
                return Integer.parseInt(entrada);

            } catch (NumberFormatException e) {
                System.out.print("Entrada invalida! Digite apenas números: ");
            }
        }
    }
}