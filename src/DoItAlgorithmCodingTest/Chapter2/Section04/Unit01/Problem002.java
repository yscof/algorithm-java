package DoItAlgorithmCodingTest.Chapter2.Section04.Unit01;

import java.util.Scanner;

public class Problem002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] grades = new int[N];
        for (int i = 0; i < N; i++) {
            grades[i] = sc.nextInt();
        }

        int sum = 0;
        int max = 0;

        for (int i = 0; i < N; i++) {
            sum += grades[i];
            if (grades[i] > max) {
                max = grades[i];
            }
        }

        double average = (double) sum / max * 100 / N;
        System.out.println(average);
    }
}
