// method 1
// time o(n2) and space o(n)
class Solution {
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr, (a, b) -> (a[0] - b[0]));
        List<int []> list = new ArrayList<>();
        
        int n = arr.length;
        for(int i=0; i<n; i++){
            int start = arr[i][0];
            int end = arr[i][1];
            int len = list.size();
            
            if(len != 0 && list.get(len-1)[1] > start)
                continue;
            
            for(int j=i+1; j<n; j++){
                if(end > arr[j][0]){
                    if(end < arr[j][1])
                        end = arr[j][1];
                } else
                    break;
            }
            
            int temp[] = new int[2];
            temp[0] = start;
            temp[1] = end;
            
            if(len != 0 && list.get(len-1)[1] == start){
                temp[0] = list.get(len-1)[0];
                list.remove(len-1);
                list.add(temp);
            } else
                list.add(temp);
            
        }
         return list.toArray(new int[list.size()][]);
    }
}




// method 2
// time o(nlogn) and space o(n)
class Solution {
    public int[][] merge(int[][] arr) {
        List<int []> list = new ArrayList<>();
        
        if(arr.length == 0 || arr == null)
            return list.toArray(new int[0][]);
        
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        
        int start = arr[0][0];
        int end = arr[0][1];
        
        for(int []i: arr){
            if(i[0] <= end)
                end = Math.max(end, i[1]);
            else{
                list.add(new int[]{start, end});
                start = i[0];
                end = i[1];
            }
        }
        
        list.add(new int[]{start, end});
        return list.toArray(new int[0][]);
    }
}
