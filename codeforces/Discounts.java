/*You want to buy n
 products with prices a1,a2,…,an
. You can either:

buy product i
 individually, paying ai
 coins, or
use a discount voucher to buy it as part of a group purchase.
You have k
 discount vouchers with values b1,b2,…,bk
. A voucher of value x
 allows you to select exactly x
 products and pay only for the x−1
 most expensive ones, as such, you can consider that the cheapest product in the group is free. Each product can be included in at most one discount group, even if it is not the free one. Also, any single voucher can be used at most one single time.

What is the minimum total cost required to purchase all n
 products?

Input
Each test contains multiple test cases. The first line contains the number of test cases t
 (1≤t≤104
). The description of the test cases follows.

The first line contains two integers n
 and k
 (1≤n,k≤2⋅105
) —the number of products and the number of available discount vouchers.

The second line contains n
 integers a1,a2,…,an
 (1≤ai≤109
) — the prices of the products.

The third line contains k
 integers b1,b2,…,bk
 (1≤bi≤n
) — the values of the discount vouchers.

It is guaranteed that the sum of n
 across all test cases does not exceed 2⋅105
, and the sum of k
 across all test cases does not exceed 2⋅105
.

Output
Print t
 lines. The i
-th line should contain the answer for the i
-th test case — the minimum total cost required to purchase all products in that test case.*/
package first_repo.codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class Discounts {
    static long minPrice(int prices [],int [] cupons)
    {
        long price=0;
        int idx=prices.length;
        Arrays.sort(cupons);
        Arrays.sort(prices);
        for(int currCupon: cupons)
        {
            idx-=currCupon;
            if(idx<0)
                break;
            prices[idx]=0;
        }
        for(int currPrice: prices)
            price+=currPrice;
        return price;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int []prices=new int[n];
            int []cupons=new int[k];
            for (int j = 0; j < n; j++) {
                prices[j] = sc.nextInt();
            }
            for (int j = 0; j < k; j++) {
                cupons[j] = sc.nextInt();
            }
            long result = minPrice(prices,cupons);
            System.out.println(result);
        }
        sc.close();
    }
}
