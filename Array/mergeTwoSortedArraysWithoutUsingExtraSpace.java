// method 1
// time o(nm) and space o(1)


// some big test cases are failing
class Solution
{
    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        int i=0, j=0;
        
        while(i<n){
            if(arr1[i] > arr2[0]){
                long temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;
             
            
            if(m >= 2 && arr2[0] > arr2[1])
                arrangeElementsInSortedWay(arr2);
                
            } 
            
        i++;
           
        }
        
    }
    
    
    private static void arrangeElementsInSortedWay(long arr[]){
        int n = arr.length;
        long val = arr[0];
        
        int i=1;
        for(; i<n; i++){
            if(val >= arr[i])
                arr[i-1] = arr[i];
            else 
                break;
        }
        
        if(i != n)
            arr[i-1] = val;
        
    }
    
}


// method 2
// time o(nlogn) + o(mlogm)

class Solution
{
    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        int j=0;
        int i=n-1;
        
        
        while(i>=0 && j<m){
            if(arr2[j] < arr1[i]){
                long temp = arr2[j];
                arr2[j] = arr1[i];
                arr1[i] = temp;
            }
            i--;
            j++;
        }
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
    }
}
