package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        
        System.out.println("Digite seu nome: ");
        String dono = in.nextLine();
        
        System.out.println("Digite o tipo de conta que deseja abrir.");
        System.out.println("1 para poupança ou 2 para corrente:");
        int tipo =  in.nextInt();
        
        System.out.println("Digite o valor do depósito inicial: ");
        double deposito = in.nextInt();

        if(tipo > 2 && tipo < 1) {
            System.out.println("Conta invalida");
        }

        Conta conta = Conta.abrirConta(tipo, dono, deposito);

        String tipoDeConta = conta.getTipo() == 1 ? "Poupança" : "Corrente";

        System.out.println("\n O dono da conta " + tipoDeConta  + " é: " + conta.getDono() +" Possui: " + conta.getSaldo() + " de saldo\n");

        int loop = 1;

        while(loop > 0) {
            System.out.println("\n Digite a operação que deseja realizar: ");
            System.out.println("1)Sacar");
            System.out.println("2)Depositar");
            System.out.println("3)Fechar Conta");
            System.out.println("4)Pagar mensalidade");
            System.out.println("5)Sair");
            int option = in.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Digite o valor do saque: ");
                    int saque = in.nextInt();
                    double saldoAtual = conta.sacar(saque);
                    System.out.println("Seu saldo é: " + saldoAtual);
                    break;
                case 2: 
                    System.out.println("Digite o valor do depósito: ");
                    int valor = in.nextInt();
                    double saldo = conta.depositar(valor);
                    System.out.println("Seu saldo é: " + saldo);
                    break;
                case 3: 
                    conta.fecharConta(conta);
                    break;
                case 4: 
                    conta.pagarMesal();
                    break;
                default:
                    loop--;
                    break;
            }
        }

        in.close();
    }
}