// method 1
// time o(n) and space o(n)

class Solve {
    int[] findTwoElement(int arr[], int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i: arr)
            map.put(i, map.getOrDefault(i, 0) + 1);
            

        int mis = -1, rep = -1;
        for(int i=1; i<=n; i++){
            if(map.containsKey(i)){
                if(map.get(i) > 1)
                    rep = i;
            } else
                mis = i;
        }
        
        int ans[] = new int[2];
        ans[0] = rep;
        ans[1] = mis;
        
        return ans;
    }
}

// method 2
// time o(n) and space o(1)

class Solve {
    int[] findTwoElement(int arr[], int n) {
        int sum1 = 0, sum2 = 0;
        
        // sum of elements
        for(int i=1; i<=n; i++)
            sum1 += i;
        for(int i: arr)
            sum2 += i;
            
        int const1 = sum1 - sum2;
        
        // square of sum
        sum1 = 0;
        sum2 = 0;
        for(int i=1; i<=n; i++)
            sum1 += i*i;
        for(int i: arr)
            sum2 += i*i;
 
        int const2 = sum1 - sum2;

        const2 = const2/const1;
        
        int mis = (const1 + const2)/2;
        int rep = const2 - mis;
       
        int ans[] = {rep, mis}; 
        return ans;
    }
}


// method 3
// time o(n) and space o(1)
// using bit magic


class Solve {
    int[] findTwoElement(int arr[], int n) {
        int xor = 0;
        for(int i: arr)
            xor ^= i;
            
        for(int i=1; i<=n; i++)
            xor ^= i;
            
        // find the set bit
        int setBit = xor & ~(xor-1);
        
        int x = 0; // bucket having set bit;
        int y = 0;  // bucket not having set bit;
        
        for(int i=0; i<n; i++){
            if((arr[i]&setBit) != 0)
                x ^= arr[i];
            else
                y ^= arr[i];
        }
        
        for(int i=1; i<=n; i++){
            if((i&setBit) != 0)
                x ^= i;
            else
                y ^= i;
        }
        
        boolean flagX = false;
        boolean flagY = false;
        
        for(int i: arr){
            if(i == x)
                flagX = true;
            if(i == y)
                flagY = true;
        }
        
        int ans[] = new int[2];
        
        // reapeating
        ans[0] = flagX == true ? x : (flagY == true ? y : x);
        // missing
        ans[1] = flagX == false ? x : (flagY == false ? y : x);
        
        return ans;
    }
}
 

// method 4
// using swap sort
// time o(n) and space o(1)

class Solve {
    int[] findTwoElement(int arr[], int n) {
        int mis = -1;
        int rep = -1;
        
        int i = 0; 
        while(i<n){
            if(arr[i] == arr[arr[i]-1])
                i++;
            else
                swap(arr, i, arr[i]-1);
        }
        
        for(i=0; i<n; i++){
            if(arr[i] != i+1){
                mis = i+1;
                rep = arr[i];
            }
        }
        
        int ans[] = {rep, mis};
        return ans;
        
    }
    
    private static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}
