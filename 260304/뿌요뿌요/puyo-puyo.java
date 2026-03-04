import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0 ,0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int boomCnt = 0;
		int maxCnt = 0;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				if(!visited[r][c]) {
					cnt = 0;
					dfs(r, c);
					maxCnt = Math.max(maxCnt, cnt);
					if(cnt >= 4) {
						boomCnt++;
					}
				}
			}
		}
		System.out.println(boomCnt + " " + maxCnt);
		
	}
	
	static void dfs(int r, int c) {
		cnt++;
		visited[r][c] = true;
		
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr<0 || nr>=n || nc<0 || nc>=n) continue;
			if(visited[nr][nc] || map[nr][nc] != map[r][c]) continue;
			
			dfs(nr, nc);
		}
	}
}