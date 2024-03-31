import  java.util.Scanner;
import java.util.Random;
public class main{
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        System.out.printf("Menu LOTOFÁCIL");
        int opcao = 1;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("**** Sistema de Cadastro *****");
            System.out.println("1: Apostar de 0 a 100");
            System.out.println("2: Apostaar de A à Z");
            System.out.println("3: Apostar em par ou ímpar");
            System.out.println("0: Sair");

            System.out.println("**********************************)");

            System.out.println("Digite a opção");
            opcao = in.nextInt();
            System.out.println("**********************************)");
            switch (opcao){
                case 1:
                    System.out.println("Opção 1 escolhida.");
                    aposta1();
                    break;
                case 2:
                    System.out.println(" Opção 2 escolhida.");
                    aposta2();
                    break;
                case 3:
                    System.out.println("Opção 3 escolhida.");
                    aposta3();
                    break;
                case 0:
                    System.out.println("Opção 0 escolhida.");
                    break;
                default:
                    System.out.println("O número escolhido é invalido.");
            }
        } while (opcao != 0);
    }
    private static void aposta1(){
        Scanner scn = new Scanner(System.in);
        Random rdm = new Random();

        System.out.println("Digite um número de 0 a 100.");
        int num = scn.nextInt();

        if (num > 100 && num < 0){
            System.out.println("Aposta invalida");
            return;
        }
        int numSorteado = rdm.nextInt(101);
        if (num == numSorteado){
            System.out.println("Você ganhou R$ 1.000,00 reais.");
        } else{
            System.out.println("Que pena! O número sorteado foi: " + numSorteado + ".");
        }
    }
    private static void aposta2(){
        try {
            System.out.println("Digite uma letra de A a Z.");
            int input = System.in.read();
            char letra = (char) input;

            if (!Character.isLetter(letra)){
                System.out.println("Aposta inválida.");
                return;
            }
            letra = Character.toUpperCase(letra);
            char letraPremiada = 'I';
            if (letra == letraPremiada){
                System.out.println("Você ganhou R$ 500,00 reais.");
            }
            else {
                System.out.println("Que pena! A letra sorteadaa foi: "+ letraPremiada + ".");
            }
        }catch (Exception e){
            System.out.println("Erro");
        }

    }
    private static void aposta3(){
        Scanner scn = new Scanner(System.in);
        System.out.println("Digite um número inteiro.");
        int num = scn.nextInt();
        if (num % 2 == 0){
            System.out.println("Você ganhou R$ 100,00 reais.");
        }
        else {
            System.out.println("Que pena! O número digitado é ímpar e a premiação foi para números pares.");
        }
    }
}
