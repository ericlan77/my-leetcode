import com.sun.source.tree.Tree;
import utils.*;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Stack;

public class Test {
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
            if(i == list.length-1)
                treeArray.add(Integer.parseInt(list[i].substring(0,1)));
            if(list[i].equals("null"))
                treeArray.add(null);
            else
                treeArray.add(Integer.parseInt(list[i]));
        }
        TreeNode root = new TreeNode(treeArray.get(0));
        Stack<TreeNode> stack = new Stack<>();
        for(int i = 1; i < treeArray.size(); i++){

        }
    }
}
