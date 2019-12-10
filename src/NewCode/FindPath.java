package NewCode;

import java.util.ArrayList;
import java.util.Stack;

public class FindPath {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root==null) return arrayLists;
        FindPath(root,target,arrayLists,arrayList,0);
        return arrayLists;
    }
    private void FindPath(TreeNode root, int target, ArrayList<ArrayList<Integer>> arrayLists,ArrayList<Integer> arrayList, int sum){

        sum+=root.val;
        arrayList.add(root.val);

        boolean isLeaf = root.left==null&&root.right==null;
        if (isLeaf&&sum==target){
            //这步很重要，需要new一个新的ArrayList
            arrayLists.add(new ArrayList<>(arrayList));
        }
        if (root.left!=null){
            FindPath(root.left,target,arrayLists,arrayList,sum);
        }
        if (root.right!=null){
            FindPath(root.right,target,arrayLists,arrayList,sum);
        }
        arrayList.remove(arrayList.size()-1);
        sum-=root.val;
    }

    public static void main(String[] args) {
        TreeNode node10= new TreeNode(10);
        TreeNode node5= new TreeNode(5);
        TreeNode node12= new TreeNode(12);
        TreeNode node4= new TreeNode(4);
        TreeNode node7= new TreeNode(7);

        node10.left=node5;
        node10.right=node12;
        node5.left=node4;
        node5.right=node7;

        FindPath findPath = new FindPath();
        ArrayList<ArrayList<Integer>> arrayList =  findPath.FindPath(node10,22);
        System.out.println(arrayList);

    }
}
