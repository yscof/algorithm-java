import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == 'c' && i < text.length() - 1) {
                if (text.charAt(i + 1) == '=' || text.charAt(i + 1) == '-') {
                    count++;
                    i += 1;
                    continue;
                }
            } else if (text.charAt(i) == 'd' && i < text.length() - 1) {
                if (text.charAt(i + 1) == 'z' && i < text.length() - 2) {
                    if (text.charAt(i + 2) == '=') {
                        count++;
                        i += 2;
                        continue;
                    }
                } else if (text.charAt(i + 1) == '-') {
                    count++;
                    i += 1;
                    continue;
                }
            } else if (text.charAt(i) == 'l' && i < text.length() - 1) {
                if (text.charAt(i + 1) == 'j') {
                    count++;
                    i += 1;
                    continue;
                }
            } else if (text.charAt(i) == 'n' && i < text.length() - 1) {
                if (text.charAt(i + 1) == 'j') {
                    count++;
                    i += 1;
                    continue;
                }
            } else if (text.charAt(i) == 's' && i < text.length() - 1) {
                if (text.charAt(i + 1) == '=') {
                    count++;
                    i += 1;
                    continue;
                }
            } else if (text.charAt(i) == 'z' && i < text.length() - 1) {
                if (text.charAt(i + 1) == '=') {
                    count++;
                    i += 1;
                    continue;
                }
            }

            count++;
        }

        System.out.println(count);

        scanner.close();
    }
}