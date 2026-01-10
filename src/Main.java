import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder answer = new StringBuilder();
    static final int INF = 9900001;
    static int[][] dist;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        dist = new int[V + 1][V + 1];

        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                dist[i][j] = INF;
            }
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dist[a][b] = Math.min(dist[a][b], c);
        }

        floydWarshall(V);

        int result = INF;

        for (int i = 1; i <= V; i++) {
            result = Math.min(result, dist[i][i]);
        }

        if (result == INF) {
            answer.append("-1");
        } else {
            answer.append(result);
        }

        bw.write(answer.toString().trim());
        bw.flush();
        bw.close();
    }

    public static void floydWarshall (int n) {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }
}