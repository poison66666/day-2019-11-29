import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Sort {
    //插入排序(每次选择无序区间的第一个元素，在有序区间进行合适的插入)
    public static void insertSort(int[] array) {
        //nanoTime();    (记录时间)
        for(int i = 1;i<array.length;i++){
            //有序 [0,i)
            //无序 [i,array.length)
            int key = array[i];
            int j;
            for(j = i - 1;j>=0;j--){
                if(array[j] <= key) {
                    break;
                } else{
                    array[j+1] = array[j];
                }
            }
            array[j+1] = key;
        }
    }

    public static void insertSort0(int[] array) {
        for(int i = 1;i < array.length ; i++){
            int key =array[i];
            int j;
            for(j = i - 1;j>=0&&array[j]>key;j--){
                array[j+1] = array[j];
            }
            array[j+1] = key;
        }
    }

    public static void shellSort(int[] array) {
        int gap = array.length;
        while(true) {
            gap = gap/3 + 1;
            insertSortWithGap(array,gap);
            if(gap == 1){
                break;
            }
        }
    }
    //希尔排序
    public static void insertSortWithGap(int[] array,int gap){
       for(int i = 1;i<array.length;i++){
           int key = array[i];
           int j;
           for(j = i - gap;j>=0 && array[j]>key;j--){
               array[j+gap] = array[j];
           }
           array[j+gap] = key;
       }
    }

    //选择排序
    public static void  selectSort(int[] array) {
        //每次选最大的放到无序区间的最后
        //每次从无序区间选择最大或最小的数，放到最后或者最前
        /*无序区间[0,array.length-i)
        有序区间[array.length-i,array.length)*/
        for(int i = 0;i<array.length-1;i++){ //寻找次数
            int max = 0;
            for(int s = 1;s <array.length-i;s++){ //寻找最大值
                if(array[s] > array[max]) {
                    max = s;
                }
            }
            swap(array,max,array.length-i-1);
        }
    }


    public static void selectSort1(int[] array) {
        /*有序区间[0，i);
        无序区间[i,array.length)*/
        for(int i = 0;i<array.length-1;i++){
            int min = i;
            for(int j = i+1;j<array.length;j++){
                if(array[j]<array[min]){
                    min = j;
                }
            }
            swap(array,min,i);
        }
    }

    //双向选择排序
    public static void selectSort2(int[] array) {
        //无序区间[begin,end]
        int begin = 0;
        int end = array.length-1;
        while(begin < end) {
            int min = begin;
            int max = begin;
            for(int j = begin+1;j<=end;j++){
                if(array[j]<array[min]){
                    min = j;
                }
                if(array[j]>array[max]) {
                    max = j;
                }
            }
            swap(array,min,begin);
            if(max == begin){
                max = min;
            }
            swap(array,max,end);
            begin++;
            end--;
        }
    }

    //堆排序
    public static void heapSort(int[] array) {
        createHeapBig(array,array.length);
        for(int i = 0;i<array.length-1;i++){
            //最后的数依次和0进行交换，在调整为大根堆
            swap(array,0,array.length-i-1);
            shiftDownBig(array,0,array.length-1-i);
        }
    }

    public static void createHeapBig(int[] array,int s) {
        for(int i = (s-2)/2;i>=0;i--){
            shiftDownBig(array,i,array.length);
        }
    }

    public static void shiftDownBig(int[] array,int index,int size) {
        int left = index*2+1;
        int max = left;
        while(left < size){
            int right = left + 1;
            if(right < size){
                if(array[left]<array[right]) {
                    max = right;
                }
            }
            if(array[index] < array[max]){
                swap(array,index,max);
                index = max;
                left = index*2+1;
            } else{
                break;
            }
        }
    }

    public static void testRight() {
        int[] a = {2,3,7,9,4,5,6,9,1,4,7,8};
        int[] b= a.clone();
        bubbleSort(b);
        System.out.println(Arrays.toString(b));

        int[] c =a.clone();
        Arrays.sort(c);
        System.out.println(Arrays.toString(c));

        System.out.println(Arrays.equals(b,c));
    }

    public static void testSpeed() {
        Random random = new Random(20190924);
        int[] a = new int[10*10000];
        for(int i = 0;i<10*10000;i++){
            a[i] = random.nextInt(10*10000);
        }
        long begin = System.nanoTime();
        bubbleSort(a);
        long end = System.nanoTime();

        double ms = (end - begin) *1.0/1000/1000;
        System.out.printf("一共耗时：%.5f 毫秒%n",ms);
    }

    //冒泡排序(在无序区间，通过相邻数的比较，将最大的数冒到最后)
    public static void bubbleSort(int[] array) {
       for(int i = 0;i<array.length-1;i++){
           boolean isSort = true;
           for(int j = 0;j<array.length-1-i;j++){
               if(array[j+1]<array[j]) {
                   swap(array,j,j+1);
                   isSort = false;
               }
           }
           if(isSort){
               return;
           }
       }
    }

    public static void swap(int[] array,int i , int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        testRight();
        testSpeed();
    }
}
