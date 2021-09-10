import com.sun.source.tree.Tree;
import utils.*;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Stack;

public class Test {
    public static void levelTraverse(TreeNode root){
        Stack<TreeNode> currLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        currLevel.push(root);
        int level = 1;
        while(!currLevel.isEmpty()){
            TreeNode currNode = currLevel.remove(0);
            if(currNode.left != null)
                nextLevel.add(currNode.left);
            if(currNode.right != null)
                nextLevel.add(currNode.right);
            System.out.print(currNode.val+"("+currNode.parent.val+") ");
            if(currLevel.isEmpty()){
                System.out.print("->"+level);
                System.out.println();
                level++;
                currLevel = nextLevel;
                nextLevel = new Stack<>();
            }
        }
    }
    public static void main(String[] args) {
        String input = "[5,4,8,11,null,13,4,7,2,null,null,5,1]";
        String[] list = input.split(",");
        if(list.length == 1){
            TreeNode root = new TreeNode(Integer.parseInt(list[0].substring(1,2)));
        }
        ArrayList<Integer> treeArray = new ArrayList<>();
        for(int i = 0; i < list.length; i++){
            if(i == 0)
                treeArray.add(Integer.parseInt(list[i].substring(1)));
            else if(i == list.length-1)
                treeArray.add(Integer.parseInt(list[i].substring(0,1)));
            else if(list[i].equals("null"))
                treeArray.add(null);
            else
                treeArray.add(Integer.parseInt(list[i]));
        }
        TreeNode root = new TreeNode(treeArray.get(0));
        root.parent = root;
        Stack<TreeNode> currLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        currLevel.push(root);
        int index = 1;
        while (!currLevel.isEmpty()) {
            TreeNode currNode = currLevel.remove(0);
            // if still num in array, add to the left leaf node, the leaf node add to next level, index++
            if (index < treeArray.size()) {
                if(treeArray.get(index) != null){
                    currNode.left = new TreeNode(treeArray.get(index), currNode);
                    nextLevel.add(currNode.left);
                }
                else
                    currNode.left = null;
                index++;
            } else
                break;
            // if still num in array, add to the right leaf node, the leaf node add to next level,index++
            if (index < treeArray.size()) {
                if(treeArray.get(index) != null){
                    currNode.right = new TreeNode(treeArray.get(index), currNode);
                    nextLevel.add(currNode.right);
                }
                else
                    currNode.right = null;
                index++;
            } else
                break;
            if (currLevel.isEmpty()){
                currLevel = nextLevel;
                nextLevel = new Stack<>();
            }

        }
        levelTraverse(root);
    }

}
