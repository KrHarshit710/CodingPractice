package Tree;

public class HeightOfTree {

    private static int findHeight(TreeNode root){
        if(root == null)
            return 0;
        int lh = findHeight(root.left);
        int rh = findHeight(root.right);

        return Integer.max(lh, rh) + 1;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.right = new TreeNode(3);
        root.left.right.right = new TreeNode(2);
        root.left.right.right.left = new TreeNode(1);

        System.out.println(findHeight(root));
    }
}
