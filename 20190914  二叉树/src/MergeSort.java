import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] array) {mergeSortInter(array,0,array.length);}

    private static void mergeSortInter(int[] array, int low, int high) {
        if(low >= high-1){
            return;
        }
        int mid = (low+high)/2;
        mergeSortInter(array,low,mid);
        mergeSortInter(array,mid,high);
        merge(array,low,mid,high);
    }

    //[low,high)
    public static void merge(int[] a,int low,int mid,int high){
        int i = low;
        int j = mid;
        int length = high - low;
        int[] b = new int[length];
        int k = 0;
        while(i < mid && j < high) {
            if(a[i] <= a[j]){
                b[k++] = a[i++];
            }else{
                b[k++] = a[j++];
            }
        }
        while(i < mid){
            b[k++] = a[i++];
        }
        while(j < high){
            b[k++] = a[j++];
        }
        for(int x = 0;x<length;x++) {
            a[low+x] = b[x];
        }
    }

    public static void main(String[] args) {
        int[] a = {1,5,7,2,3,5,1,6};
        mergeSort(a);
        System.out.println(Arrays.toString(a));
    }
}
