// Last updated: 7/9/2026, 10:07:10 AM
import java.util.*;

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord,
                                          List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();

        if (!dict.contains(endWord))
            return result;

        Map<String, List<String>> parents = new HashMap<>();

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        boolean found = false;

        while (!queue.isEmpty() && !found) {

            int size = queue.size();
            Set<String> currentLevel = new HashSet<>();

            for (int i = 0; i < size; i++) {

                String word = queue.poll();
                char[] arr = word.toCharArray();

                for (int j = 0; j < arr.length; j++) {

                    char old = arr[j];

                    for (char c = 'a'; c <= 'z'; c++) {

                        arr[j] = c;
                        String next = new String(arr);

                        if (!dict.contains(next))
                            continue;

                        if (!visited.contains(next)) {

                            if (!currentLevel.contains(next)) {
                                queue.offer(next);
                                currentLevel.add(next);
                            }

                            parents.putIfAbsent(next, new ArrayList<>());
                            parents.get(next).add(word);

                            if (next.equals(endWord))
                                found = true;
                        }
                    }

                    arr[j] = old;
                }
            }

            visited.addAll(currentLevel);
        }

        if (!found)
            return result;

        List<String> path = new ArrayList<>();
        path.add(endWord);

        backtrack(endWord, beginWord, parents, path, result);

        return result;
    }

    private void backtrack(String word,
                           String beginWord,
                           Map<String, List<String>> parents,
                           List<String> path,
                           List<List<String>> result) {

        if (word.equals(beginWord)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            result.add(temp);
            return;
        }

        if (!parents.containsKey(word))
            return;

        for (String parent : parents.get(word)) {
            path.add(parent);
            backtrack(parent, beginWord, parents, path, result);
            path.remove(path.size() - 1);
        }
    }
}