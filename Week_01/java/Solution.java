import java.util.*;

public class Solution {

    /**
     * 26：删除数组中的重复项
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int num = 1;
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != temp) {
                num++;
                nums[num - 1] = nums[i];
                temp = nums[i];
            }
        }
        return num;
    }

    /**
     * 189：旋转数组
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    public void reverse(int[] nums,int start,int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }


    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
        }
    }

    /**
     * 21：合并两个有序链表
      * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode pre=new ListNode(0);
        ListNode prev=pre;
        while(l1!=null && l2!=null ){
            if(l1.val<=l2.val){
                prev.next=l1;
                l1=l1.next;
            }else{
                prev.next=l2;
                l2=l2.next;
            }
            prev=prev.next;
        }
        prev.next=l1==null?l2:l1;
        return pre.next;
    }

    /**
     * 合并两个有序数组
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int n1=m-1;
        int n2=n-1;
        int p=m+n-1;
        while(n1>=0 && n2>=0){
            if(nums1[n1]<=nums2[n2]){
                nums1[p]=nums2[n2];
                n2--;
            }else{
                nums1[p]=nums1[n1];
                n1--;
            }
            p--;
        }
        System.arraycopy(nums2,0,nums1,0,n2+1);

    }

    /**
     * 1:两数之和
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int temp=target-nums[i];
            if(map.containsKey(temp) && i!=map.get(temp)){
                result[0]=map.get(temp);
                result[1]=i;
                return result;
            }
            map.put(nums[i],i);
        }
        return result;
    }

    /**
     * 移动零
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if(nums==null){
            return;
        }
        int n=0;
        for(int i=0;i<nums.length;i++){
            if(0!=nums[i]){
                n++;
                nums[n-1]=nums[i];
                if(n-1!=i){
                    nums[i]=0;
                }
            }
        }
    }

    /**
     * 66：加一
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            digits[i]++;
            digits[i]%= 10;
            if(digits[i]!=0){
                return digits;
            }
        }
        digits=new int[digits.length+1];
        digits[0]=1;
        return digits;
    }

    /**
     * 42:接雨水
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int sum=0;
        Stack<Integer> stack=new Stack();
        int cur=0;
        while(cur<height.length){
            while(!stack.empty() && height[cur]>height[stack.peek()]){
                int h=height[stack.pop()];
                if(stack.empty()){
                    break;
                }
                int distance=cur-stack.peek()-1;
                int min=Math.min(height[stack.peek()],height[cur]);
                sum=sum+distance*(min-h);

            }
            stack.push(cur);
            cur++;
        }
        return sum;
    }

}
