import java.util.*;
import java.io.*;
public class A_Circle_of_Apple_Trees {
public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> apples=new HashSet<>();
        for (int i = 0; i < n; i++)
            apples.add(Integer.parseInt(st.nextToken()));
        sb.append(apples.size()).append('\n');
    }
    System.out.print(sb.toString());
}
    
}