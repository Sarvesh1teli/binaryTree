package com.BST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class BSTMain {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(40);
		System.out.println("1.Insert operation in BST-1");
		insert_1(root, 20);
		insert_1(root, 30);
		insert_1(root, 10);
		insert_1(root, 60);
		insert_1(root, 50);
		insert_1(root, 70);
		insert_1(root, 55);
		// root.setRight(new TreeNode(30));

		System.out.println("2.Level order traversal is: byLevelOp_2");
		byLevelOp_2(root);
		System.out.println();

		System.out.println("3.Spiral/ZigZag traversal is: zigZagOp_3");
		zigZagOp_3(root);
		System.out.println();

		System.out.println("4.Max depth of tree : maxDepthOfTreeOp_4");
		int depth = heightOfTreeOp_4(root);
		System.out.println(depth);
		System.out.println();

		System.out.println("5.Size of tree  is : sizeOfTreeOp_5");
		int sizeOfTree = sizeOfTreeNumberOfNodesOp_5(root);
		System.out.println(sizeOfTree);
		System.out.println();

		System.out.println("6.Print leaf nodes : printLeafNodeOp_6");
		printLeafNodeOp_6(root);
		System.out.println();

		System.out.println("7.Print All paths of tree : printAllPathOfNodesOp_7");
		int path[] = new int[1000];

		printAllPathOfNodesOp_7(root, path, 0);
		System.out.println();

		System.out.println("8.Both are same tree : isSameTreeOp_8");
		boolean isSametree = isSameTreeOp_8(root, root);
		System.out.println("isSametree:" + isSametree);
		System.out.println();

		System.out.println("9.Print All paths of tree : areMirrorTreeOp_9");
		boolean areMirr = areMirrorTreeOp_9(root, root);
		System.out.println("are Mirror :" + areMirr);
		System.out.println();

		System.out.println("10.Print All paths of tree : isBSTOp_10");
		int min = (int) Math.pow(10, -9);
		int max = (int) Math.pow(10, 9);
		boolean isBst = isBSTOp_10(root, min, max);
		System.out.println("Is it BST  :" + isBst);
		System.out.println();

		System.out.println("11.Print LCM for two nodes : leastCommonAncentorBSTOp_11");
		TreeNode lcm = leastCommonAncentorBSTOp_11(root, 55, 70);
		System.out.println(lcm.getData());
		System.out.println();

		System.out.println("12.Print LCM for two nodes : leastCommonAncentorOp_12");
		TreeNode lcmBT = leastCommonAncentorOp_12(root, 10, 70);
		System.out.println(lcmBT.getData());
		System.out.println();

		System.out.println("13.Left view lements are : leftViewPrintOp_13");
		leftViewPrintOp_13(root, 1);
		System.out.println();

		System.out.println("14.Right view lements are : rightViewPrintOp_14");
		rightViewPrintOp_14(root, 1);
		System.out.println();

		System.out.println("15.Top view lements are : topViewPrintOp_15");
		topViewPrintOp_15(root);
		System.out.println();

		System.out.println("16.Daignol view lements are  (using levelorder concept): daignollyPrintOp_16");
		daignollyPrintOp_16(root);
		System.out.println();

		System.out.println("17.Vertical view lements are  (using levelorder concept): verticalViewPrintOp_17");
		verticalViewPrintOp_17(root);
		System.out.println();

		System.out.println("18.Bottomview lements are  (using levelorder concept): bottomViewPrintOp_18");
		bottomViewPrintOp_18(root);
		System.out.println();

		System.out.println("19.Boundary traveral elements are  : boundaryTraveralPrintOp_19");
		boundaryTraveralPrintOp_19(root);
		System.out.println();

		System.out.println("20.Daimeter of tree is  : daimeterPrintOp_20");
		int daim = daimeterPrintOp_20(root);
		System.out.println("daimeter:"+daim);
		System.out.println();

	}

	private static void insert_1(TreeNode root, int data) {
		if (root.getData() > data) {
			if (root.getLeft() != null) {
				insert_1(root.getLeft(), data);
			} else {

				System.out.println(data + " val is inserted into left side of Root :" + root.getData());

				root.setLeft(new TreeNode(data));
			}
		}
		if (root.getData() < data) {
			if (root.getRight() != null) {
				root = root.getRight();
				insert_1(root, data);
			} else {

				System.out.println(data + " val is inserted into Right side of Root :" + root.getData());

				root.setRight(new TreeNode(data));
			}
		}
	}

	private static void byLevelOp_2(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);

		System.out.println("By-Level order traversal elements are:");

		while (queue.size() > 1) {
			TreeNode temp = queue.poll();

			if (temp == null) {
				if (queue.size() == 0)
					return;
				System.out.println("");
				queue.add(null);

			} else {
				System.out.print(temp.getData() + " ");
				if (temp.getLeft() != null) {
					queue.add(temp.getLeft());
				}
				if (temp.getRight() != null) {
					queue.add(temp.getRight());
				}
			}
		}
	}

	private static void zigZagOp_3(TreeNode root) {
		Stack<TreeNode> st1 = new Stack<>();
		st1.push(root);
		boolean direction = true;

		while (st1.size() > 0) {
			Stack<TreeNode> st2 = new Stack<>();

			while (st1.size() > 0) {
				TreeNode temp = st1.pop();
				System.out.print(temp.getData() + " ");
				if (direction) {
					if (temp.getLeft() != null) {
						st2.push(temp.getLeft());
					}

					if (temp.getRight() != null) {
						st2.push(temp.getRight());
					}
				} else {
					if (temp.getRight() != null) {
						st2.push(temp.getRight());
					}

					if (temp.getLeft() != null) {
						st2.push(temp.getLeft());
					}
				}
			}
			System.out.println();
			direction = !direction;
			st1 = st2;
		}
	}

	private static int heightOfTreeOp_4(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int left = heightOfTreeOp_4(root.getLeft());
		int rt = heightOfTreeOp_4(root.getRight());

		return Math.max(left, rt) + 1;

	}

	private static int sizeOfTreeNumberOfNodesOp_5(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int left = sizeOfTreeNumberOfNodesOp_5(root.getLeft());
		int rt = sizeOfTreeNumberOfNodesOp_5(root.getRight());

		return left + rt + 1;
	}

	private static void printLeafNodeOp_6(TreeNode root) {

		if (root == null) {
			return;
		}
		if (root.getLeft() == null && root.getRight() == null) {
			System.out.print(root.getData() + " ");
		}

		printLeafNodeOp_6(root.getLeft());
		printLeafNodeOp_6(root.getRight());
	}

	private static void printAllPathOfNodesOp_7(TreeNode root, int path[], int len) {

		if (root == null) {
			return;
		}
		path[len++] = root.getData();

		if (root.getLeft() == null && root.getRight() == null) {
			print(path, len);
		}
		printAllPathOfNodesOp_7(root.getLeft(), path, len);
		printAllPathOfNodesOp_7(root.getRight(), path, len);
	}

	private static void print(int path[], int len) {

		for (int i = 0; i < len; i++) {
			System.out.print(path[i] + " ");
		}
		System.out.println();
	}

	private static boolean isSameTreeOp_8(TreeNode root1, TreeNode root2) {

		if (root1 == null && root2 == null) {
			return true;
		}

		if (root1 == null || root2 == null) {
			return false;
		}

		return root1.getData() == root2.getData() && isSameTreeOp_8(root1.getLeft(), root2.getLeft())
				&& isSameTreeOp_8(root1.getRight(), root2.getRight());
	}

	private static boolean areMirrorTreeOp_9(TreeNode root1, TreeNode root2) {

		if (root1 == null && root2 == null) {
			return true;
		}

		if (root1 == null || root2 == null) {
			return false;
		}

		return root1.getData() == root2.getData() && areMirrorTreeOp_9(root1.getLeft(), root2.getRight())
				&& areMirrorTreeOp_9(root1.getRight(), root2.getLeft());
	}

	private static boolean isBSTOp_10(TreeNode root, int min, int max) {

		if (root == null) {
			return true;
		}

		if (min > root.getData() || max < root.getData()) {
			return false;
		}
		return isBSTOp_10(root.getLeft(), min, root.getData()) && isBSTOp_10(root.getRight(), root.getData(), max);
	}

	private static TreeNode leastCommonAncentorBSTOp_11(TreeNode root, int n1, int n2) {

		while (root != null) {

			if (root.getData() > n1 && root.getData() > n2) {
				root = root.getLeft();
			} else if (root.getData() < n1 && root.getData() < n2) {
				root = root.getRight();
			} else {
				break;
			}
		}
		return root;
	}

	private static TreeNode leastCommonAncentorOp_12(TreeNode root, int n1, int n2) {
		if (root == null) {
			return null;
		}

		if (root.getData() == n1 || root.getData() == n2) {
			return root;
		}

		TreeNode left = leastCommonAncentorOp_12(root.getLeft(), n1, n2);
		TreeNode rt = leastCommonAncentorOp_12(root.getRight(), n1, n2);

		if (left != null && rt != null) {
			return root;
		}

		return left != null ? left : rt;

	}

	static int currentLevel = 0;

	private static void leftViewPrintOp_13(TreeNode root, int nextLevel) {

		if (root == null) {
			return;
		}
		if (nextLevel > currentLevel) {
			System.out.println(root.getData());
			currentLevel = nextLevel;
		}
		leftViewPrintOp_13(root.getLeft(), nextLevel + 1);
		leftViewPrintOp_13(root.getRight(), nextLevel + 1);
	}

	static int currentlevel = 0;

	private static void rightViewPrintOp_14(TreeNode root, int nextLevel) {
		if (root == null) {
			return;
		}
		if (nextLevel > currentlevel) {
			System.out.println(root.getData());
			currentlevel = nextLevel;
		}

		rightViewPrintOp_14(root.getRight(), nextLevel + 1);
		rightViewPrintOp_14(root.getLeft(), nextLevel + 1);

	}

	private static void topViewPrintOp_15(TreeNode root) {
		if (root == null) {
			return;
		}

		leftSideData(root.getLeft());
		System.out.println();
		rightSideData(root);
	}

	private static void rightSideData(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.println(root.getData());
		rightSideData(root.getRight());
	}

	private static void leftSideData(TreeNode rootLeft) {

		if (rootLeft == null) {
			return;
		}
		leftSideData(rootLeft.getLeft());
		System.out.println(rootLeft.getData());
	}

	private static void daignollyPrintOp_16(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);

		while (q.size() > 0) {
			TreeNode temp = q.poll();
			if (temp == null) {
				if (q.size() == 0)
					return;

				System.out.println("");
				q.add(null);
			}

			else {

				while (temp != null) {

					System.out.print(temp.getData() + " ");

					if (temp.getLeft() != null) {
						q.add(temp.getLeft());
					}
					temp = temp.getRight();
				}

			}
		}

	}

	private static void verticalViewPrintOp_17(TreeNode root) {

		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0, root)); // IMP

		Map<Integer, List<Integer>> map = new TreeMap<>(); // IMP
		while (q.size() > 0) {
			Pair temp = q.poll();

			if (map.containsKey(temp.hd)) {
				map.get(temp.hd).add(temp.treenode.getData()); // //IMP
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(temp.treenode.getData());
				map.put(temp.hd, list); // //IMP
			}

			if (temp.treenode.getLeft() != null) {
				q.add(new Pair(temp.hd - 1, temp.treenode.getLeft()));
			}

			if (temp.treenode.getRight() != null) {
				q.add(new Pair(temp.hd + 1, temp.treenode.getRight()));
			}
		}

		for (Map.Entry<Integer, List<Integer>> m : map.entrySet()) {

			List<Integer> val = m.getValue();

			List<Integer> al = m.getValue();
			for (Integer pair : al) {
				System.out.print(pair + " ");
			}
			System.out.println();
		}

	}

	private static void bottomViewPrintOp_18(TreeNode root) {

		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0, root)); // IMP

		Map<Integer, Integer> map = new TreeMap<>(); // IMP
		while (q.size() > 0) {
			Pair temp = q.poll();
			map.put(temp.hd, temp.treenode.getData()); // //IMP

			if (temp.treenode.getLeft() != null) {
				q.add(new Pair(temp.hd - 1, temp.treenode.getLeft()));
			}

			if (temp.treenode.getRight() != null) {
				q.add(new Pair(temp.hd + 1, temp.treenode.getRight()));
			}
		}

		for (Map.Entry<Integer, Integer> m : map.entrySet()) {
			System.out.print(m.getValue() + " ");
		}

	}

	private static void boundaryTraveralPrintOp_19(TreeNode root) {
		if (root == null) {
			return;

		}

		leftBoundary(root);
		printLeafNodeOp_6(root);
		rightBoundary(root.getRight());
	}

	private static void rightBoundary(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.getRight() != null) {
			System.out.print(root.getData() + " ");
			leftBoundary(root.getRight());
		} else if (root.getLeft() != null) {
			System.out.print(root.getData() + " ");
			leftBoundary(root.getLeft());
		}
	}

	private static void leftBoundary(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.getLeft() != null) {
			System.out.print(root.getData() + " ");
			leftBoundary(root.getLeft());
		} else if (root.getRight() != null) {
			System.out.print(root.getData() + " ");
			leftBoundary(root.getRight());
		}
	}

	private static int daimeterPrintOp_20(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int left = heightOfTreeOp_4(root.getLeft());
		int right = heightOfTreeOp_4(root.getRight());

		int leftDaimeter = daimeterPrintOp_20(root.getLeft());

		int rightDaimeter = daimeterPrintOp_20(root.getLeft());

		int lengthOfTree = (left + right) + 1;
		int daimeter = Math.max(leftDaimeter, rightDaimeter);

		int result = Math.max(lengthOfTree, daimeter);
		System.out.println("Through root:" + lengthOfTree);
		System.out.println("Not Through root:" + daimeter);
		System.out.println("result:" + result);

		return result;
	}

}

class Pair {

	int hd;
	TreeNode treenode;

	public Pair(int hd, TreeNode treenode) {
		super();
		this.hd = hd;
		this.treenode = treenode;
	}

	public int getHd() {
		return hd;
	}

	public void setHd(int hd) {
		this.hd = hd;
	}

	public TreeNode getTreenode() {
		return treenode;
	}

	public void setTreenode(TreeNode treenode) {
		this.treenode = treenode;
	}

}

class TreeNode {

	private int data;
	private TreeNode left;
	private TreeNode right;

	public TreeNode(int data) {
		super();
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

}

/*

1.Insert operation in BST-1
20 val is inserted into left side of Root :40
30 val is inserted into Right side of Root :20
10 val is inserted into left side of Root :20
60 val is inserted into Right side of Root :40
50 val is inserted into left side of Root :60
70 val is inserted into Right side of Root :60
55 val is inserted into Right side of Root :50
2.Level order traversal is: byLevelOp_2
By-Level order traversal elements are:
40 
20 60 
10 30 50 70 
55 
3.Spiral/ZigZag traversal is: zigZagOp_3
40 
60 20 
10 30 50 70 
55 

4.Max depth of tree : maxDepthOfTreeOp_4
4

5.Size of tree  is : sizeOfTreeOp_5
8

6.Print leaf nodes : printLeafNodeOp_6
10 30 55 70 
7.Print All paths of tree : printAllPathOfNodesOp_7
40 20 10 
40 20 30 
40 60 50 55 
40 60 70 

8.Both are same tree : isSameTreeOp_8
isSametree:true

9.Print All paths of tree : areMirrorTreeOp_9
are Mirror :false

10.Print All paths of tree : isBSTOp_10
Is it BST  :true

11.Print LCM for two nodes : leastCommonAncentorBSTOp_11
60

12.Print LCM for two nodes : leastCommonAncentorOp_12
40

13.Left view lements are : leftViewPrintOp_13
40
20
10
55

14.Right view lements are : rightViewPrintOp_14
40
60
70
55

15.Top view lements are : topViewPrintOp_15
10
20

40
60
70

16.Daignol view lements are  (using levelorder concept): daignollyPrintOp_16
40 60 70 
20 30 50 55 
10 
17.Vertical view lements are  (using levelorder concept): verticalViewPrintOp_17
10 
20 
40 30 50 
60 55 
70 

18.Bottomview lements are  (using levelorder concept): bottomViewPrintOp_18
10 20 50 55 70 
19.Boundary traveral elements are  : boundaryTraveralPrintOp_19
40 20 10 30 55 70 60 
20.Daimeter of tree is  : daimeterPrintOp_20
Through root:1
Not Through root:0
result:1
Through root:1
Not Through root:0
result:1
Through root:3
Not Through root:1
result:3
Through root:1
Not Through root:0
result:1
Through root:1
Not Through root:0
result:1
Through root:3
Not Through root:1
result:3
Through root:6
Not Through root:3
result:6
daimeter:6



*/
