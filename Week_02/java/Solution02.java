import java.util.*;

public class Solution02 {

    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 1, 2, 2, 3};
        nthUglyNumber(10);
    }

    //242. 有效的字母异位词
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            num[t.charAt(i) - 'a']--;
            if (num[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    //1.两数之和
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp) && i > map.get(temp)) {
                res[0] = map.get(temp);
                res[1] = i;
                return res;
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }

    class Node {
        int val;
        List<Node> children;

        Node(int val) {
            val = val;
        }
    }

    //589. N叉树的前序遍历
    public List<Integer> preorder(Node root) {
        List<Integer> l1 = new ArrayList<>();
        dfs(root, l1);
        return l1;
    }

    public void dfs(Node root, List<Integer> l1) {
        if (root == null) {
            return;
        }
        l1.add(root.val);
        for (Node n : root.children) {
            dfs(n, l1);
        }
    }

    //前K个高频元素
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> (map.get(n1) - map.get(n2)));
        for (Integer key : map.keySet()) {
            pq.add(key);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }

    //丑树
    public static int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(1L);
        long temp = 0l;
        while (n != 0) {
            if (temp != pq.peek()) {
                temp = pq.poll();
                n--;
                pq.add(temp * 2);
                pq.add(temp * 3);
                pq.add(temp * 5);
            } else {
                pq.poll();
            }

        }
        return (int) temp;
    }
}
