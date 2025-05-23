/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}  */

class Solution {
    public static int minTime(Node root, int target) {
        Map<Node, Node> parentMap = new HashMap<>();
        Node targetNode = buildParentMap(root, target, parentMap);

        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(targetNode);
        visited.add(targetNode);

        int time = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            time++;

            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();

                if (curr.left != null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    queue.add(curr.left);
                }
                if (curr.right != null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    queue.add(curr.right);
                }
                Node parent = parentMap.get(curr);
                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    queue.add(parent);
                }
            }
        }

        return time;
    }

    private static Node buildParentMap(Node root, int target, Map<Node, Node> parentMap) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        Node targetNode = null;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (curr.data == target) {
                targetNode = curr;
            }

            if (curr.left != null) {
                parentMap.put(curr.left, curr);
                queue.add(curr.left);
            }
            if (curr.right != null) {
                parentMap.put(curr.right, curr);
                queue.add(curr.right);
            }
        }

        return targetNode;
    }
}