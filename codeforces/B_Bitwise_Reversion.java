import java.util.*;
public class B_Bitwise_Reversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int x = sc.nextInt(), y = sc.nextInt(), z = sc.nextInt();
            boolean ok = true;
            for (int i = 0; i < 31; i++) {
                int xi = (x >> i) & 1;
                int yi = (y >> i) & 1;
                int zi = (z >> i) & 1;

                if (!(
                    (xi == 0 && yi == 0 && zi == 0) ||
                    (xi == 0 && yi == 1 && zi == 0) ||
                    (xi == 0 && yi == 0 && zi == 1) ||
                    (xi == 1 && yi == 0 && zi == 0) ||
                    (xi == 1 && yi == 1 && zi == 1)
                )) {
                    ok = false;
                    break;
                }
            }
            System.out.println(ok ? "YES" : "NO");
        }
    }
}
