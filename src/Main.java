import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder answer = new StringBuilder();

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());        // N개의 정수
        int[] array = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        int X = Integer.parseInt(br.readLine());

        int left = 0;
        int right = N - 1;
        int count = 0;
        while (left < right) {
            int sum = array[left] + array[right];

            if (sum == X) {
                count++;
                left++;
                right--;
            } else if (sum < X) {
                left++;
            } else {
                right--;
            }
        }

        answer.append(count);

        bw.write(answer.toString().trim());
        bw.flush();
        bw.close();
    }
}