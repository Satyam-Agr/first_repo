package first_repo.practice_codes;
import java.util.*;
import java.io.*;
import java.math.*;

class BinarySearch
{
    static int iterativeSearch(int[] arr,int key)
    {
        int low=0,high=arr.length-1;
        while(low<=high)
        {
            int mid = low + (high - low) / 2;
            if(key==arr[mid])
                return mid;
            else if(key>arr[mid])
                low=mid+1;
            else
                high=mid-1;
        }
        return -1;
    }
    static int recursiveSearch(int []arr,int key,int low,int high)
    {
        if(low>high)
            return -1;

        int mid = low + (high - low) / 2;

        if(key==arr[mid])
            return mid;
        else if(key>arr[mid])
            return recursiveSearch(arr, key, mid+1, high);
        else
            return recursiveSearch(arr, key, low, mid-1);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        sc.close();
        int arr[]={0,2,4,5,12,15,34,99,10000};
        // add the call and print staments

    }
}