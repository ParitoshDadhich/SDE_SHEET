class Solution {
    public void sortColors(int[] arr) {
        int start = 0;
        int tra = 0;
        int end = arr.length-1;
        
        while(tra <= end){
            if(arr[tra] == 0){
                swap(arr, start, tra);
                start++;
                tra++;
            } else if(arr[tra] == 2){
                swap(arr, tra, end);
                end--;
            } else
                tra++;
        }
    }
    
    private static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}
 
