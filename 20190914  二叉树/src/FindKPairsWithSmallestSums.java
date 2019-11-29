import java.util.List;
import java.util.Queue;

public class FindKPairsWithSmallestSums {
    public static class Pair implements Comparable<Pair>{
        int u;
        int v;

        @Override
        public int compareTo(Pair o) {
            return (o.u + o.v - (u + v));
        }
    }
    /*public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
       for(int u:nums1){
           for(int v : nums2){
               Pair p = new Pair(u,v);
               if(queue.size() < k) {
                   queue.offer(p);
               }
           }
        }
    }*/

    public static void main(String[] args) {
        //Queue<> queue = new
    }
}
