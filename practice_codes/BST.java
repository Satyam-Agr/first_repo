package first_repo.practice_codes;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BST 
{//Must have Node class in the same package
    static Node createBST(int nodes[])
    {
        Node root=null;
        for(int i=0;i<nodes.length;i++)
        {
            root=addInBST(root, nodes[i]);
        }
        return root;
    }  
    static Node addInBST(Node root, int key)
    {
        if(root==null){
            return new Node(key);
        }
        if(root.data>key){
            root.left=addInBST(root.left, key);
        }
        else{
            root.right=addInBST(root.right, key);
        }
        return root;
    }
    static boolean search(Node root, int key)
    {
        if(root == null)
            return false;

        if(root.data==key)
            return true;
        else if(root.data > key)
            return search(root.left, key);
        else
            return search(root.right, key);
    }
    static Node deletNode(Node root, int key)
    {
        if (root == null)
            return root;
        if(root.data > key)
            root.left = deletNode(root.left, key);
        else if(root.data < key)
            root.right = deletNode(root.right, key);
        else{// root.data == key
            //case 1
            if(root.left == null && root .right == null)
                return null;
                
            //case 2
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            
            //case 3
            Node IS=inOrderSuccessor(root.right);
            root.data= IS.data;
            root.right=deletNode(root.right, IS.data);
        }
        return root;
    }
    static Node inOrderSuccessor(Node root)
    {
        while (root.left!=null)
           root=root.left;
        return root;
    }
    static void printInRange(Node root,int X,int Y)
    {
        if(root == null)
            return;
        
        if(root.data>=X && root.data<=Y)
        {
            printInRange(root.left, X, Y);
            System.out.print(root.data+" ,");
            printInRange(root.right, X, Y);
        }
        else if(root.data> Y)
            printInRange(root.left, X, Y);
        else
            printInRange(root.right, X, Y);
    }
    static Deque <Integer>path= new ArrayDeque<>();
    static void printPaths(Node root)
    {
        if(root == null)
            return;

        path.add(root.data);
        if(root.left== null && root.right == null)
            System.out.println(path);
        else{
        printPaths(root.left);
        printPaths(root.right);
        }
        path.removeLast();
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int nodes[]={20,10,2,3,7,8,30,33,43,12,50};
        Node root1=createBST(nodes);
        BinaryTree.traversInOrder(root1);
        int xy=50;
        if(search(root1, xy))
            System.out.println(xy);
        else 
            System.out.println("");
        deletNode(root1, 50 );
        BinaryTree.traversInOrder(root1);
        System.out.println("");
        printInRange(root1,0,100);
        System.out.println("");
        printPaths(root1);
        printPaths(root1);
        sc.close();
    }
}
