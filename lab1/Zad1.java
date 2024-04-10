package lab1;

import java.util.Scanner;

class Zad1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Program wyliczający wartość wyrażenia silnia z n");
        boolean temp = true;
        while (temp) {
            System.out.print("Podaj liczbę: ");
            int num = scanner.nextInt();
            int result = factioral(num);
            System.out.println("Silnia z " + num + " wynosi " + result);
            System.out.print("Chcesz kontynuować? (t/n): ");
            scanner.nextLine();
            String answer = scanner.nextLine();
            if (answer.equals("n")) {
                temp = false;
            }
        }
        scanner.close();
    }

    static int factioral(int n){
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}