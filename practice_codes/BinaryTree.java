package first_repo.practice_codes;

import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data=data;
        this.left=null;
        this.right=null;
    }
}
public class BinaryTree {

    static int idx=-1;
    static Node creatBinaryTree(int nodes[])
    {
        idx++;
        if(nodes[idx]==-1)
            return null;
        Node current=new Node(nodes[idx]);
        current.left=creatBinaryTree(nodes);
        current.right=creatBinaryTree(nodes);
        return current;

    }
    static void traversPreOrder(Node root)
    {
        if(root ==null)
        {
            System.out.print("-1 ,");//optional
            return;
        }
        System.out.print(root.data+" ,");
        traversPreOrder(root.left);
        traversPreOrder(root.right);
        
    }
    static void traversInOrder(Node root)
    {
        if(root ==null)
        {
            //System.out.println("-1 ,");//optional
            return;
        }
        traversInOrder(root.left);
        System.out.print(root.data+" ,");
        traversInOrder(root.right);
        
    }
    static void traversPostOrder(Node root)
    {
        if(root ==null)
        {
            //System.out.println("-1 ,");//optional
            return;
        }
        traversPostOrder(root.left);
        traversPostOrder(root.right);
        System.out.print(root.data+" ,");
        
    }
    static void traversLevelOrder(Node root)
    {
        if(root==null)
            return;
        Queue<Node> levels=new LinkedList<>();
        levels.add(root);
        levels.add(null);
        while (!levels.isEmpty()) {
            Node current=levels.remove();
            if(current==null)
            {
                System.out.println("");
                if(levels.isEmpty())
                    break;
                levels.add(null);
            }
            else{
                System.out.print(current.data);
                if(current.left != null)
                    levels.add(current.left);
                if(current.right!= null)
                    levels.add(current.right);
            }
        }
    }
    static int countNodes(Node root)
    {
        if(root==null)
            return 0;
        return countNodes(root.left)+countNodes(root.right)+1;
    }
    static int addNodes(Node root)
    {
        if(root==null)
            return 0;
        return addNodes(root.left)+addNodes(root.right)+root.data;
    }
    static int height(Node root)
    {
        if(root == null)
            return 0;
        return Math.max(height(root.left),height(root.right))+1;
    }
    static int diameter(Node root)//O(n^2)
    {
        if(root == null)
            return 0;
        int diam1= diameter(root.left);
        int diam2= diameter(root.right);
        int diam3= height(root.left)+height(root.right)+1;
    
        return Math.max(Math.max(diam1, diam2), diam3);
    }
    static class TreeInfo
    {
        int height;
        int diameter;
        TreeInfo(int height,int diameter)
        {
            this.diameter=diameter;
            this.height=height;
        }
    }
    static TreeInfo diameter2 (Node root)//O(n)
    {
        if(root ==null)
        {
            return new TreeInfo(0, 0);
        }
        TreeInfo left=diameter2(root.left);
        TreeInfo right=diameter2(root.right);

        int myHeight=Math.max(left.height,right.height)+1;
        int myDiameter=Math.max(Math.max(left.diameter, right.diameter),(left.height+right.height+1));
        TreeInfo info=new TreeInfo(myHeight, myDiameter);
        return info;
    }
    static int sumAtLevel(Node root,int level)
    {
        int currLevel=1,sum=-1;
        Queue<Node> nodeQueue=new LinkedList<>();
        nodeQueue.add(root);
        nodeQueue.add(null);
        while(!nodeQueue.isEmpty()&&currLevel<=level)
        {
            Node currNode=nodeQueue.remove();
            if(currNode==null)
            {
                if(nodeQueue.isEmpty())
                    break;
                currLevel++;
                nodeQueue.add(currNode);
            }
            else{
                if(currNode.left != null)
                    nodeQueue.add(currNode.left);
                if(currNode.right!= null)
                    nodeQueue.add(currNode.right);
                if(currLevel==level)
                    sum+=currNode.data;
            }
        }
        if(sum==-1)
            return -1;
        else
            return sum+1;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root=creatBinaryTree(nodes);
        traversPreOrder(root);
        System.out.println("");
        traversInOrder(root);
        System.out.println("");
        traversPostOrder(root);
        System.out.println("");
        traversLevelOrder(root);
        System.out.println("");
        System.out.println(countNodes(root) + "-" + addNodes(root)+ "-" + height(root));
        System.out.println(diameter(root)+ "-" +diameter2(root).diameter);
        System.out.println(sumAtLevel(root,3));
        sc.close();
    }
}
