// Last updated: 7/9/2026, 10:07:00 AM
import java.util.*;

class Solution {

    private Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node clone = new Node(node.val);
        map.put(node, clone);

        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
}