package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 28702번
public class no28702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean isNumber = false;
        int num = 0;

        for (int i = 0; i < 3; i++) {
            String str = br.readLine();

            char c = str.charAt(0);
            if (c != 'F' && c != 'B') {
                isNumber = true;
                num = Integer.parseInt(str);
            }

            if (isNumber) {
                num++;
            }
        }
        if (num % 3 == 0) {
            if (num % 5 == 0) {
                System.out.println("FizzBuzz");
            } else {
                System.out.println("Fizz");
            }
        } else {
            if (num % 5 == 0) {
                System.out.println("Buzz");
            }else{
                System.out.println(num);
            }
        }
    }
}
