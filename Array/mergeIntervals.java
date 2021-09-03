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
        if(arr.length <= 1)
            return arr;
        
        Arrays.sort(arr, (a, b) -> (a[0] - b[0]));
        
        List<int[]> list = new ArrayList<>();
        for(int [] i: arr){
            if(list.size() == 0 || list.get(list.size() - 1)[1] < i[0])
                list.add(i);
            else
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], i[1]);
        }
        
        return list.toArray(new int[list.size()][]);
    }
}


// another way

 
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
          ArrayList<Interval> result = new ArrayList<>();
        
        // sort list by interval's start time
        Collections.sort(intervals, new Comparator<Interval>(){

            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start != o2.start) {
                    return o1.start - o2.start;
                } else {
                    return o1.end - o2.end;
                }
            }
        });
        
        for (int i = 0; i < intervals.size() - 1; i++) {
            Interval i1 = intervals.get(i);
            Interval i2 = intervals.get(i + 1);
            if (i1.end < i2.start) {
                // i1 goes completely before i2
                result.add(i1);
            } else {
                // overlapping, then merge these two intervals
                i1.start = Math.min(i1.start, i2.start);
                i1.end = Math.max(i1.end, i2.end);
                intervals.remove(i + 1);
                i--;
            }
        }
        // don't forget to add the last interval which is the merging interval
        result.add(intervals.get(intervals.size() - 1));
        return result; 

    }
}
