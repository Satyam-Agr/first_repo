package first_repo.leetcode;

import java.util.Scanner;
import java.util.StringTokenizer;

class Solution {
    static void swap(int a[],int i,int j)
    {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    public void sortColors(int[] nums) {
        int mid=0,low=0,high=nums.length;
        while (mid<=high) {
            if(nums[mid]==1)
                mid++;
            else if(nums[mid]==0)
            {
                swap(nums, low, mid);
                low++;
                mid++;
            }
            else
            {
                swap(nums, mid, high);
                high--;
            }
        }
    }
}
class sort_colors {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Solution run=new Solution();
        StringTokenizer in=new StringTokenizer(sc.nextLine());
        int a[]=new int[in.countTokens()];
        for (int i = 0; i < a.length; i++) 
        {
            a[i]=Integer.parseInt(in.nextToken());
        }
        run.sortColors(a);
        sc.close();
    }
    
}
