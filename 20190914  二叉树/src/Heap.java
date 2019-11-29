import java.util.Arrays;
import java.util.Random;

public class Heap {
    public static void shiftDowmSmall(int[] array,int index,int size){
        int left = index*2 +1;
        while(left < size){
            int right = left + 1;
            int min = left;
            if(right < size){
                if(array[right] < array[left]) {
                    min =right;
                }
            }
            if(array[index] > array[min]) {
                swap(array,index,min);
                index = min;
                left = 2*index+1;
            } else{
                break;
            }
        }
    }
    public static void shiftDowmBig(int[] array,int index,int size){
        int left = index * 2 + 1;

        while(left < size){
            int right = left + 1;
            int max = left;
            if(right < size){
                if(array[left] < array[right]){
                    max = right;
                }
            }
            if(array[index] < array[max]){
                swap(array,index,max);

                index = max;
                left = index*2+1;
            }else{
                break;
            }
        }
    }

    private static void swap(int[] array,int index,int size){
        int t = array[index];
        array[index] = array[size];
        array[size] = t;
    }

    public static void createHeapSmall(int[] a ,int s){
        for(int i = (s-1)/2;i>=0;i--){
            shiftDowmSmall(a,i,s);
        }
    }

    public static void createHeapBig(int[] a,int s) {
        for(int i = (s-1)/2;i>=0;i--){
            shiftDowmBig(a,i,s);
        }
    }

    public static void main(String[] args) {
        int[] small = {39,15,3,18,40,5,6,51,52,70};
        shiftDowmSmall(small,0,small.length);
        System.out.println(Arrays.toString(small));
        System.out.println("=====================");
        int[] big = new int[]{100, 50, 30, 25, 40, 80, 70, 10, 5, 20, 30, 60, 70, 60, 70, 5};
        shiftDowmBig(big,2,big.length);
        System.out.println(Arrays.toString(big));
        System.out.println("=====================");
        int[] t = new int[10];
        Random random = new Random(20190923);
        for(int i = 0;i<10;i++){
            t[i] = random.nextInt(20);
        }
        System.out.println(Arrays.toString(t));
        createHeapBig(t,t.length);
        System.out.println(Arrays.toString(t));
        System.out.println("======================");
        int[] a = {9,4,1,3,7,1,2,2,9,8};
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void shiftUpSmall(int[] array,int i) {
        while (i != 0){
            int p = (i - 1)/2;
            if(array[p] <= array[i]) {
                break;
            }
            swap(array,p,i);
            i = p;
        }
    }

    public static void heapSort(int[] array) {
        createHeapBig(array,array.length);
        for(int i =0;i<array.length-1;i++){
            swap(array,0,array.length-i-1);
            shiftDowmBig(array,0,array.length-i-1);
        }
    }
}
