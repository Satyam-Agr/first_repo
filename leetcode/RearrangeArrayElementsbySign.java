package first_repo.leetcode;
import java.util.*;
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int pos=0, neg=1;
        int[] result=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>=0)
            {
                result[pos]=nums[i];
                pos+=2;
            }
            else
            {
                result[neg]=nums[i];
                neg+=2;
            }
        }
        return result;
    }
}
public class RearrangeArrayElementsbySign {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution run = new Solution();
        StringTokenizer in = new StringTokenizer(sc.nextLine());
        int[] a = new int[in.countTokens()];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(in.nextToken());
        }
        run.rearrangeArray(a);
        sc.close();
    }
}
