package utils;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ericlan
 * @date 9/11/2021 12:52 AM
 * @description Tree utils
 */

public class TreeUtil {
    // return a root of built Tree by input String
    public static TreeNode buildTree(String input){
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
        return root;
    }

    public static List<List<String>> levelTraverseWithParent(TreeNode root){
        List<List<String>> allNodeValues = new ArrayList<>();
        ArrayList<String> currLevelNodeValues = new ArrayList<>();
        ArrayList<TreeNode> currLevel = new ArrayList<>();
        ArrayList<TreeNode> nextLevel = new ArrayList<>();
        currLevel.add(root);
        int level = 1;
        while(!currLevel.isEmpty()){
            TreeNode currNode = currLevel.remove(0);
            if(currNode.left != null)
                nextLevel.add(currNode.left);
            if(currNode.right != null)
                nextLevel.add(currNode.right);
            currLevelNodeValues.add(currNode.val+"("+currNode.parent.val+") ");
            if(currLevel.isEmpty()){
                level++;
                allNodeValues.add(currLevelNodeValues);
                currLevelNodeValues = new ArrayList<>();
                currLevel = nextLevel;
                nextLevel = new ArrayList<>();
            }
        }
        return allNodeValues;
    }

    public static List<List<Integer>> levelTraverse(TreeNode root) {
        List<List<Integer>> allNodeValues = new ArrayList<>();
        ArrayList<Integer> currLevelNodeValues = new ArrayList<>();
        ArrayList<TreeNode> currLevel = new ArrayList<>();
        ArrayList<TreeNode> nextLevel = new ArrayList<>();
        currLevel.add(root);
        int level = 1;
        while(!currLevel.isEmpty()){
            TreeNode currNode = currLevel.remove(0);
            if(currNode.left != null)
                nextLevel.add(currNode.left);
            if(currNode.right != null)
                nextLevel.add(currNode.right);
            currLevelNodeValues.add(currNode.val);
            if(currLevel.isEmpty()){
                level++;
                allNodeValues.add(currLevelNodeValues);
                currLevelNodeValues = new ArrayList<>();
                currLevel = nextLevel;
                nextLevel = new ArrayList<>();
            }
        }
        return allNodeValues;
    }

    // print all tree node by level: 7(11)  2(11)  5(4)  1(4)  ->4, the values in brackets imply the parent tree node.
    public static void printTreeLevelWithParent(TreeNode root){
        List<List<String>> tree = levelTraverseWithParent(root);
        int index = 1;
        for(List<String> nodesOnlevel: tree){
            for(String node: nodesOnlevel){
                System.out.print(node+" ");
            }
            System.out.println("->"+index++);
        }
    }

    // print all tree node by level: 7 2 5 1 ->4
    public static void printTreeLevel(TreeNode root){
        List<List<Integer>> tree = levelTraverse(root);
        int index = 1;
        for(List<Integer> nodesOnlevel: tree){
            for(Integer node: nodesOnlevel){
                System.out.print(node+" ");
            }
            System.out.println("->"+index++);
        }
    }

    public static void main(String[] args) {
        String input = "[5,4,8,11,null,13,4,7,2,null,null,5,1]";
        TreeNode root = buildTree(input);
        System.out.println("print tree by level");
        printTreeLevel(root);
        System.out.println("print tree by level with parent");
        printTreeLevelWithParent(root);


    }
}
