package datastruct;

import java.util.Arrays;
import java.util.LinkedList;

public class BinaryTree {
    /**
     * 创建一颗二叉树
     * @param inputList
     * @return
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList){
        TreeNode headNode=null;
        if (null==inputList || inputList.size()==0){
            return null;
        }
        Integer data=inputList.remove(0);
        if (null!=data){
            headNode=new TreeNode();
            headNode.data=data;
            headNode.leftChild=createBinaryTree(inputList);
            headNode.rightChild=createBinaryTree(inputList);
        }
        return headNode;
    }

    /**
     * 先序遍历
     * @param headNode
     */
    public static void preOrderTraveral(TreeNode headNode){
        if (null==headNode){
            return ;
        }
        System.out.println(headNode.data);
        preOrderTraveral(headNode.leftChild);
        preOrderTraveral(headNode.rightChild);
    }

    /**
     * 中序遍历
     * @param headNode
     */
    public static void inOrderTraveral(TreeNode headNode){
        if (null==headNode){
            return ;
        }
        inOrderTraveral(headNode.leftChild);
        System.out.println(headNode.data);
        inOrderTraveral(headNode.rightChild);
    }

    /**
     * 后序遍历
     * @param headNode
     */
    public static void postOrderTraveral(TreeNode headNode){
        if (null==headNode){
            return ;
        }
        postOrderTraveral(headNode.leftChild);
        postOrderTraveral(headNode.rightChild);
        System.out.println(headNode.data);
    }

    private static class TreeNode{
        int data;
        TreeNode leftChild;
        TreeNode rightChild;
    }

    public static void main(String []args){
        LinkedList<Integer> inputlist=new LinkedList<>(
                Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,4})
        );
        TreeNode treeNode=createBinaryTree(inputlist);
        System.out.println("前序遍历");
        preOrderTraveral(treeNode);
        System.out.println("中序遍历");
        inOrderTraveral(treeNode);
        System.out.println("后序遍历");
        postOrderTraveral(treeNode);

        System.out.println();
    }
}
