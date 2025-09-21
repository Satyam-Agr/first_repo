package first_repo.practice_codes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class QuickSort {
    static int partition(List<Integer> arr,int low,int high)
    {
        int i=low-1;
        int pivot=arr.get(high);
        for(int j=low;j<high;j++)
        {
            if(arr.get(j)<pivot)
            {
                i++;
                Collections.swap(arr, i, j);
            }
        }
        Collections.swap(arr, i+1, high);
        return i+1;
    }
    static void  quick (List<Integer> arr,int low,int high)
    {
        if(low<high)
        {
            int pivotIdx=partition(arr, low, high);
            quick(arr, low, pivotIdx-1);
            quick(arr, pivotIdx+1, high);
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
         System.out.print("Enter the size: ");
        int n=sc.nextInt();
        List <Integer> arr=new ArrayList<>();
        for (int i = 0; i < n; i++) 
        {
            arr.add(sc.nextInt());
        }
        quick(arr,0,arr.size()-1);
        System.out.print(arr);
        sc.close();
    }
}
