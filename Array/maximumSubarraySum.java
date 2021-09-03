// method 1
// time 0(n3)


class Solution{

 
    int maxSubarraySum(int arr[], int n){
        
        int max = 0;
         for(int i=0; i<n; i++){
             for(int j=i; j<n; j++){
                 int sum = 0;
                 for(int k=i; k<=j; k++)
                    sum += arr[k];
                    
                    max = Math.max(sum, max);
             }
         }
        return max;
    }
    
}



// method 2
// time o(n2)


class Solution{

 
    int maxSubarraySum(int arr[], int n){
        
        int max = Integer.MIN_VALUE;
         for(int i=0; i<n; i++){
             int sum = 0;
             for(int j=i; j<n; j++){
                 sum += arr[j];
                 
                 max = Math.max(max, sum);
             }
         }
        return max;
    }
    
}

// kADANE'S ALGO
// time o(n) and space o(1)

class Solution{

 
    int maxSubarraySum(int arr[], int n){
        
        int max = Integer.MIN_VALUE;
        // IDEA of kadane's algo is, if you get negative value then initialize the sum value
        // to zero or else
        // keep on adding the values to sum;
        
        
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += arr[i];
            
            if(sum > max)
                max = sum;
            if(sum < 0)
                sum = 0;
        }
        
        return max;
    }
    
}
