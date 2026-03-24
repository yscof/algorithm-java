package DoItAlgorithmCodingTest.Chapter2.Section04.Unit03;

import java.io.IOException;
import java.util.Scanner;

// 백준 2018번
public class Problem006_book {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 1;
        int start_index = 1;
        int end_index = 1;
        int sum = 1;

        while (end_index != N) {
            if (sum == N) {
                count++;
                end_index++;
                sum += end_index;
            } else if (sum > N) {
                sum -= start_index;
                start_index++;
            } else {
                end_index++;
                sum += end_index;
            }
        }

        System.out.println(count);
    }
}
