import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Setor> setores = new ArrayList<>();
        ArrayList<Veiculos> veiculos = new ArrayList<>();

        setores.add(new Setor(1, "EXPEDIÇÃO"));
        setores.add(new Setor(2, "COMERCIAL"));
        setores.add(new Setor(3, "MARKETING"));
        setores.add(new Setor(4, "DIRETORIA"));

        veiculos.add(new Veiculos(1, "ABC123", "VOLKSWAGEN", "NIVUS", 2023, true));
        veiculos.add(new Veiculos(2, "DEF456", "FIAT", "SCUDO", 2025, false));
        veiculos.add(new Veiculos(3, "GHI789", "FIAT", "STRADA", 2022, false));
        veiculos.add(new Veiculos(4, "JKL012", "CHEVROLET", "CRUZE", 2022, true));

        System.out.println("======================================");
        System.out.println("     FROTA VEICULOS EMPRESARIAIS");
        System.out.println("======================================");
        System.out.println();


        Setor setorLogado = null;

        while (setorLogado == null) {
            System.out.print("Digite o ID do setor: ");
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
            System.out.print("Digite o ID do veiculo que deseja reservar: ");
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
        if (veiculoEscolhido == null) {
            System.out.println("Veículo não encontrado");
        } else if (!veiculoEscolhido.estaDisponivel())
            System.out.println("Este veículo já esta reservado");
        else {
            System.out.println("Veículo selecionado: " + veiculoEscolhido.getModelo());
            System.out.println("Pronto para iniciar a reserva");
        }
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