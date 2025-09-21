package first_repo.practice_codes;
import java.util.*;

public class SubTree {//must have BinartTree class in the same package
    static boolean isIdentical(Node mainRoot,Node subRoot)
    {
        if(mainRoot==null && subRoot ==null)
            return true;
        if (mainRoot==null || subRoot ==null) 
            return false;
        if(mainRoot.data==subRoot.data)
            return isIdentical(mainRoot.left, subRoot.left) && isIdentical(mainRoot.right, subRoot.right);
        return false;
    }
    static boolean isSubTree(Node mainRoot,Node subRoot)
    {
        if(subRoot==null)
            return true;
        if(mainRoot==null)
            return false;
        if(mainRoot.data==subRoot.data)
        {
            if(isIdentical(mainRoot, subRoot))
                return true;
        }
        return isSubTree(mainRoot.left, subRoot) || isSubTree(mainRoot.right, subRoot);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        int subNodes[]={2,4,-1,-1,5,-1,-1};
        Node mainroot=BinaryTree.creatBinaryTree(nodes);
        Node subroot=BinaryTree.creatBinaryTree(subNodes);
        if(isSubTree(mainroot, subroot))
            System.out.println("true");
        else
            System.out.println("false");
        sc.close();
    }
}
