package org.example;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Map<String, ContaCorrente> contas = new HashMap<>();
        Map<String, ContaCorrente> pix = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        int opcao = 0;

        do {
            System.out.println("------ Sistema Bancario ------");
            System.out.println("1. Criar nova conta");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Transferir");
            System.out.println("5. Transferencia via pix");
            System.out.println("6. conferir saldo");
            System.out.println("7. Sair");
            System.out.print("Opcao: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o numero da sua nova conta: ");
                    String numero = scanner.next();
                    System.out.print("Digite o numero do seu pix: ");
                    String pix1 = scanner.next();
                    System.out.print("Faca um deposito inicial: ");
                    BigDecimal saldo = scanner.nextBigDecimal();
                    ContaCorrente conta = new ContaCorrente(numero, pix1 , saldo);
                    contas.put(numero, conta);
                    pix.put(pix1, conta);
                    System.out.println("Conta criada com sucesso!");
                    break;
                case 2:
                    System.out.print("Digite o numero da sua conta: ");
                    numero = scanner.next();
                    conta = contas.get(numero);
                    if (conta == null) {
                        System.out.println("Conta nao encontrada!");
                    } else {
                        System.out.print("Digite o valor do depósito: ");
                        BigDecimal valor = scanner.nextBigDecimal();
                        conta.depositar(valor);
                        System.out.println("Deposito realizado com sucesso!");
                    }
                    break;
                case 3:
                    System.out.print("Digite o numero da sua conta: ");
                    numero = scanner.next();
                    conta = contas.get(numero);
                    if (conta == null) {
                        System.out.println("Conta nao encontrada!");
                    } else {
                        System.out.print("Digite o valor que deseja sacar: ");
                        BigDecimal valor = scanner.nextBigDecimal();
                        if (conta.sacar(valor)) {
                            System.out.println("Saque realizado com sucesso!");
                        } else {
                            System.out.println("Saldo insuficiente!");
                        }
                    }
                    break;
                case 4:
                    System.out.print("Digite o numero da sua conta: ");
                    String numeroOrigem = scanner.next();
                    ContaCorrente contaOrigem = contas.get(numeroOrigem);
                    if (contaOrigem == null) {
                        System.out.println("Conta nao encontrada!");
                    } else {
                        System.out.print("Digite o numero da conta que ira receber a transferencia: ");
                        String numeroDestino = scanner.next();
                        ContaCorrente contaDestino = contas.get(numeroDestino);
                        if (contaDestino == null) {
                            System.out.println("Conta nao encontrada!");
                        } else {
                            System.out.print("Digite o valor da transferencia: ");
                            BigDecimal valor = scanner.nextBigDecimal();
                            if (contaOrigem.transferir(contaDestino, valor)) {
                                System.out.println("Transferência realizada com sucesso!");
                            } else {
                                System.out.println("Saldo insuficiente!");
                            }
                        }
                    }
                    break;
                case 5:
                    System.out.print("Digite o numero da sua conta: ");
                    String numeroOrigem1 = scanner.next();
                    ContaCorrente contaOrigem1 = contas.get(numeroOrigem1);
                    if (contaOrigem1 == null) {
                        System.out.println("Conta nao encontrada!");
                    } else {
                        System.out.print("Digite o pix da conta que ira receber a transferencia: ");
                        String pix1Destino = scanner.next();
                        ContaCorrente pixDestino = pix.get(pix1Destino);
                        if (pix1Destino == null) {
                            System.out.println("Pix nao encontrado");
                        } else{
                            System.out.print("Digite o valor da transferencia: ");
                            BigDecimal valor = scanner.nextBigDecimal();
                            if (contaOrigem1.transferirPix(pixDestino, valor)) {
                                System.out.println("Pix realizado com sucesso!");
                            } else {
                                System.out.println("Saldo insuficiente!");
                            }
                        }
                    }
                    break;
                case 6:
                    System.out.print("Digite o numero da conta: ");
                    numero = scanner.next();
                    conta = contas.get(numero);
                    if (conta == null) {
                        System.out.println("Conta nao encontrada!");
                    }else{
                        System.out.println("O saldo da conta " + conta.getNumero() + " e: " + conta.getSaldo() + "\n");
                    }
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opcao invalida!");
                    break;
            }


        } while (opcao != 7);

        scanner.close();

    }

}

