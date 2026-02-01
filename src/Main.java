import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder answer = new StringBuilder();

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 동전 종류 N
        int K = Integer.parseInt(st.nextToken());   // 목표 K
        int[] coins = new int[N];

        int coinCount = 0;

        for (int i = 0; i < N; i++) {
            int coin = Integer.parseInt(br.readLine());
            if (coin <= K) {
                coins[i] = coin;
                coinCount++;
            }
        }

        int result = 0;

        for (int i = coinCount - 1; i >= 0; i--) {
            result += K / coins[i];

            K = K % coins[i];
        }

        answer.append(result);

        bw.write(answer.toString().trim());
        bw.flush();
        bw.close();
    }
}