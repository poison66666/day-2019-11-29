import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] array) {
        quickSortInter(array,0,array.length-1);
    }
    public static void quickSortInter(int[] a,int left, int right) {
        if(right - left < 50) {
            return;
        }
        //三数取中
       if(right - left + 1 >= 3) {
           int mid = left + (right - left) / 2;
           if (a[left] > a[mid]) {
               if (a[left] >= a[right]) {
                   if (a[mid] > a[right]) {
                       swap(a, left, mid);
                   } else {
                       swap(a, left, right);
                   }
               }else{
               }
           } else {
               if (a[mid] > a[right]) {
                   if (a[left] > a[right]) {

                   } else {
                       swap(a, left, right);
                   }
               } else {
                   swap(a, left, mid);
               }
           }
       }
        /*int pivotIndex = partition1(a,left,right);
        quickSortInter(a,left,pivotIndex-1);
        quickSortInter(a,pivotIndex+1,right);*/
        int[] pivotIndices = partition4(a,left,right);
        quickSortInter(a,left,pivotIndices[0]);
        quickSortInter(a,pivotIndices[1],right);
    }

    private static int partition1(int[] a,int left,int right) {
        int begin = left;
        int end = right;
        int pivot = a[left];
        while(begin < end) {
            while(begin < end && a[end] >= pivot) {
                end--;
            }
            while(begin < end && a[begin] <= pivot){
                begin++;
            }
            swap(a,begin,end);
        }
        swap(a,left,begin);
        return begin;
    }

    private static void swap(int[] a, int left, int right) {
           int tmp = a[left];
           a[left] = a[right];
           a[right] = tmp;
    }

    private static int partition2(int[] a,int left,int right) {
        int begin = left;
        int end = right;
        int pivot = a[left];
        while(begin < end) {
            while(begin < end && a[end] >= pivot) {
                end--;
            }
            a[begin] = a[end];
            while(begin < end && a[begin] <= pivot) {
                begin++;
            }
            a[end] = a[begin];
        }
        a[begin] = pivot;
        return begin;
    }

    private static int partition3(int[] a,int left, int right) {
        int pivot = a[left];
        int d = left + 1;
        for(int i = left + 1;i<=right;i++){
            if(a[i] < pivot){
                swap(a,i,d);
                d++;
            }
        }
        swap(a,d-1,left);
        return d-1;
    }

    private static int[] partition4(int[] a,int left,int right) {
        int pivot = a[left];
        int less = left;
        int great = right;
        int i = left;
        while(i <= great) {
            if(a[i] == pivot) {
                i++;
            }
            else if(a[i] < pivot){
                swap(a,i,less);
                less++;
                i++;
            }else {
                swap(a,i,great);
                great--;
            }
        }
        return new int[] {less-1,great+1};
    }

    public static void main(String[] args) {
        /*int[] a = {2,5,4,9,7,6,5,1,3,2};
        quickSort(a);
        System.out.println(Arrays.toString(a));*/
            int[] a = Lab.buildReversed(40000);
            QuickSort.quickSort(a);

    }
}

