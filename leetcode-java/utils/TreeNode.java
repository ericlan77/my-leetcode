package utils;

import com.sun.source.tree.Tree;

/**
 * @ClassName: TreeNode
 * @Description: TODO
 * @Author: Eric Lan
 * @Date: 2020/8/17 22:32
 * @Version: TODO
 **/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    public TreeNode(int x) {
        val = x;
    }
    public TreeNode(int x,TreeNode parent){
        val = x;
        this.parent = parent;
    }
}
