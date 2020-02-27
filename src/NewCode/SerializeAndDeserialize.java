package NewCode;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树

 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。
 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，
 序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。

 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 */
public class SerializeAndDeserialize {

    void Serialize1(TreeNode root, StringBuilder sb) {
        if (root == null){
            sb .append("#!");
            return;
        }
        sb.append(root.val+"!");
        Serialize1(root.left,sb);
        Serialize1(root.right,sb);
    }
    String Serialize(TreeNode root){
        if (root==null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Serialize1(root,sb);
        return sb.toString();
    }

    int index = -1;
    TreeNode Deserialize(String str) {
        if (str.length()==0){
            return null;
        }
        String[] strs = str.split("!");
        return Deserialize1(strs);
    }
    TreeNode Deserialize1(String[] strs) {
        index++;
        if(!strs[index].equals("#")) {
            TreeNode root = new TreeNode(0);
            root.val = Integer.parseInt(strs[index]);
            root.left = Deserialize1(strs);
            root.right = Deserialize1(strs);
            return root;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;

        SerializeAndDeserialize serializeAndDeserialize = new SerializeAndDeserialize();
        System.out.println(serializeAndDeserialize.Serialize(node1));

        String s = serializeAndDeserialize.Serialize(node1);
        System.out.println(serializeAndDeserialize.Deserialize(s).val);
    }
}
