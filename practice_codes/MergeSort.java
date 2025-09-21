package first_repo.practice_codes;
import java.util.*;

public class MergeSort {
    static List<Integer> merge(List<Integer> arr)
    {
        if(arr.size()<=1)
        {
            return arr;
        }
        List<Integer> merged=new ArrayList<>(arr.size());
        List<Integer> part1=merge(new ArrayList<>(arr.subList(0, arr.size()/2)));
        List<Integer> part2=merge(new ArrayList<>(arr.subList(arr.size()/2,arr.size())));
        int i=0,j=0;

        while (i<part1.size()&&j<part2.size())
        {
            if(part1.get(i)<part2.get(j))
            {
            	merged.add(part1.get(i));
                i++;
            }
            else{
            	merged.add(part2.get(j));
                j++;
            }
        }
        while (i<part1.size())
        {
        	merged.add(part1.get(i));
            i++;
        }
        while (j<part2.size())
        {
        	merged.add(part2.get(j));
            j++;
        }
        
        return merged;
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
        arr=merge(new ArrayList<>(arr));
        System.out.print(arr);
        sc.close();
    }
}