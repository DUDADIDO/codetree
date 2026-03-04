
import java.util.Scanner;

public class Main {
	static int[][] grid;
	static boolean[][] visited;
	static int n, m;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxHeight = Integer.MIN_VALUE;
        int maxCnt = Integer.MIN_VALUE;
        int maxIdx = 0;
        
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];

        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < m; j++) {
        		grid[i][j] = sc.nextInt();
        		maxHeight = Math.max(grid[i][j], maxHeight);
        	}
        }
        for(int k=1; k<maxHeight; k++) {
        	int cnt = 0;
            visited = new boolean[n][m];
        	for(int r=0; r<n; r++) {
        		for(int c=0; c<m; c++) {
        			if(grid[r][c] > k && !visited[r][c]) {
        				cnt++;
        				dfs(r, c, k);
        			}
        		}
        	}
        	if(cnt > maxCnt) {
        		maxCnt = cnt;
        		maxIdx = k;
        	}
        	maxCnt = Math.max(cnt, maxCnt);
        }
        
        System.out.println(maxIdx + " " + maxCnt);
        
        sc.close();
    }
    static void dfs(int r, int c, int k) {
    	visited[r][c] = true;
    	
    	for(int d=0; d<4; d++) {
    		int nr = r + dr[d];
    		int nc = c + dc[d];
    		if(nr<0 || nr>=n || nc<0 || nc>=m) continue;
    		if(visited[nr][nc] || grid[nr][nc] <= k) continue;
    		dfs(nr, nc, k);
    	}
    }
}