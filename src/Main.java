import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder answer = new StringBuilder();

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] stairs = new int[N + 1];
        int[] dp = new int[N + 1];


        for (int i = 1; i <= N; i++) {
            int cost = Integer.parseInt(br.readLine());
            stairs[i] = cost;
        }

        dp[1] = stairs[1];
        if (N >= 2) {
            dp[2] = stairs[1] + stairs[2];
        }

        for (int i = 3; i <= N; i++) {
            int case1 = dp[i - 2] + stairs[i];
            int case2 = dp[i - 3] + stairs[i] + stairs[i - 1];

            dp[i] = Math.max(case1, case2);
        }

        answer.append(dp[N]);

        bw.write(answer.toString().trim());
        bw.flush();
        bw.close();
    }
}