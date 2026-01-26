import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder answer = new StringBuilder();

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String S = br.readLine();
        int SLength = S.length();
        int q = Integer.parseInt(br.readLine());
        int[][] alphabets = new int[SLength][26];
        alphabets[0][S.charAt(0) - 'a'] = 1;
        for (int i = 1; i < SLength; i++) {
            for (int j = 0; j < 26; j++) {
                alphabets[i][j] = alphabets[i - 1][j];
            }
            alphabets[i][S.charAt(i) - 'a']++;
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            char alphabet = st.nextToken().charAt(0);
            int check = alphabet - 'a';
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if (l == 0) {
                answer.append(alphabets[r][check]).append("\n");
            } else {
                answer.append(alphabets[r][check] - alphabets[l - 1][check]).append("\n");
            }
        }

        bw.write(answer.toString().trim());
        bw.flush();
        bw.close();
    }
}