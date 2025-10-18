import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int[] arr=new int[4];
                for (int j = 0; j < arr.length; j++)
                    arr[i] = Integer.parseInt(st.nextToken());
                if(arr[2]>arr[3])
                {
                    
                }
            }
            sb.append().append('\n');
        }
        System.out.print(sb.toString());
    }
}