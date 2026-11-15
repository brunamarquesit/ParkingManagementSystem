
package Java;

public class VehicleDataStructures {

    // DOUBLY LINKED LIST
    static class Node {
        String plate;
        Node previous;
        Node next;

        Node(String plate) {
            this.plate = plate;
        }
    }

    static class DoublyLinkedList {
        Node head;
        Node tail;

        void add(String plate) {
            Node newNode = new Node(plate);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.previous = tail;
                tail = newNode;
            }
        }

        void display() {
            Node current = head;

            while (current != null) {
                System.out.println(current.plate);
                current = current.next;
            }
        }
    }

    // BINARY SEARCH TREE
    static class TreeNode {
        String plate;
        TreeNode left;
        TreeNode right;

        TreeNode(String plate) {
            this.plate = plate;
        }
    }

    static class BinaryTree {
        TreeNode root;

        void insert(String plate) {
            root = insertNode(root, plate);
        }

        TreeNode insertNode(TreeNode node, String plate) {
            if (node == null) {
                return new TreeNode(plate);
            }

            if (plate.compareTo(node.plate) < 0) {
                node.left = insertNode(node.left, plate);
            } else if (plate.compareTo(node.plate) > 0) {
                node.right = insertNode(node.right, plate);
            }

            return node;
        }

        boolean search(String plate) {
            TreeNode current = root;

            while (current != null) {
                int result = plate.compareTo(current.plate);

                if (result == 0) {
                    return true;
                }

                current = result < 0
                    ? current.left
                    : current.right;
            }

            return false;
        }
    }
}
