package com.ankita;

public class SegmentTree {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 3, 10, 9, 4};
        System.out.println("starting construction: ");
        Node root = constructSegmentTree(arr, 0, arr.length - 1);
        System.out.println("construction done !!");
        printTree(root);

        // add a range query method
        rangeQuery(0,3, root);
    }

    private static void rangeQuery(int i, int i1, Node root) {
    }

    private static void printTree(Node root) {
        if (root == null) {
            return;
        }
        System.out.println("max value from range: " + root.leftRange + " to range : " + root.rightRange + " is " + root.value);
        printTree(root.left);
        printTree(root.right);
    }

    private static Node constructSegmentTree(int[] arr, int leftRange, int rightRange) {
        if (leftRange > rightRange) {
            return null;
        }
        if (leftRange == rightRange) {
            return new Node(arr[leftRange], null, null, leftRange, rightRange);
        }

        int childLeftRange = (leftRange + rightRange) / 2;
        int childRightRange = childLeftRange + 1;

        Node left = constructSegmentTree(arr, leftRange, childLeftRange);
        Node right = constructSegmentTree(arr, childRightRange, rightRange);

        int currentVal = Math.max(left.value, right.value);

        return new Node(currentVal, left, right, leftRange, rightRange);
    }
}

class Node {
    int value;
    int leftRange;
    int rightRange;
    Node left;
    Node right;

    Node(int val, Node left, Node right, int leftRange, int rightRange) {
        this.value = val;
        this.left = left;
        this.right = right;
        this.leftRange = leftRange;
        this.rightRange = rightRange;
    }
}
