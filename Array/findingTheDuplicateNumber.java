class Solution {
    public int findDuplicate(int[] arr) {
        int slow = arr[0];
        int fast = arr[0];
        
        do{
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while(slow != fast);
        
        fast = arr[0];
        while(fast != slow){
            slow = arr[slow];
            fast = arr[fast];
        }
        
        return fast;
    }
}
