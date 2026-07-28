void main() {

    Scanner scanner = new Scanner(System.in);
    ArrayList<contaBancaria> contas = new ArrayList<>();

    int opcao;

    do {

        IO.println("\n===== SISTEMA BANCÁRIO =====");
        IO.println("1 - Criar Conta");
        IO.println("2 - Depositar");
        IO.println("3 - Sacar");
        IO.println("4 - Consultar Saldo");
        IO.println("5 - Listar Contas");
        IO.println("0 - Sair");
        IO.print("Escolha uma opção: ");

        opcao = scanner.nextInt();

        switch (opcao) {

            case 1: {

                scanner.nextLine();

                IO.print("Nome do titular: ");
                String nome = scanner.nextLine();

                IO.print("Número da conta: ");
                int numero = scanner.nextInt();

                if (buscarConta(contas, numero) == null) {

                    contas.add(new contaBancaria(nome, numero));
                    IO.println("Conta criada com sucesso!");

                } else {

                    IO.println("Já existe uma conta com esse número.");

                }

                break;
            }

            case 2: {

                IO.print("Número da conta: ");
                int numero = scanner.nextInt();

                contaBancaria conta = buscarConta(contas, numero);

                if (conta != null) {

                    IO.print("Valor do depósito: R$ ");
                    double deposito = scanner.nextDouble();

                    conta.depositar(deposito);

                } else {

                    IO.println("Conta não encontrada.");

                }

                break;
            }

            case 3: {

                IO.print("Número da conta: ");
                int numero = scanner.nextInt();

                contaBancaria conta = buscarConta(contas, numero);

                if (conta != null) {

                    IO.print("Valor do saque: R$ ");
                    double saque = scanner.nextDouble();

                    conta.sacar(saque);

                } else {

                    IO.println("Conta não encontrada.");

                }

                break;
            }

            case 4: {

                IO.print("Número da conta: ");
                int numero = scanner.nextInt();

                contaBancaria conta = buscarConta(contas, numero);

                if (conta != null) {

                    conta.consultarSaldo();

                } else {

                    IO.println("Conta não encontrada.");

                }

                break;
            }

            case 5: {

                if (contas.isEmpty()) {

                    IO.println("Nenhuma conta cadastrada.");

                } else {

                    IO.println("\n===== CONTAS CADASTRADAS =====");

                    for (contaBancaria conta : contas) {
                        conta.exibirDados();
                    }

                }

                break;
            }

            case 0: {

                IO.println("Sistema encerrado.");
                break;
            }

            default: {

                IO.println("Opção inválida.");
                break;
            }
        }

    } while (opcao != 0);

    scanner.close();
}

public static contaBancaria buscarConta(ArrayList<contaBancaria> contas, int numeroConta) {

    for (contaBancaria conta : contas) {

        if (conta.getNumeroConta() == numeroConta) {
            return conta;
        }

    }

    return null;
}