import java.util.Arrays;
import java.util.Random;

interface SortMethod {
    String getName();
    void sort(int[] a);
}



class InsertSortMethod implements SortMethod {

    @Override
    public String getName() {
        return "插入排序";
    }

    @Override
    public void sort(int[] a) {
        Sort.insertSort(a);
    }

}

class selectSortMethod implements SortMethod {

    @Override
    public String getName() {
        return "选择排序";
    }
    @Override
    public void sort(int[] a) {
        Sort.selectSort(a);
    }
}

class shellSortMethod implements SortMethod {

    @Override
    public String getName() { return "希尔排序"; }
    @Override
    public void sort(int[] a) { Sort.shellSort(a); }
}

class heapSortMethod implements SortMethod {

    @Override
    public String getName() {
        return "堆排序";
    }
    @Override
    public void sort(int[] a) {
        Sort.heapSort(a);
    }
}

class bubbleSortMethod implements SortMethod {

    @Override
    public String getName() {
        return "冒泡排序";
    }
    @Override
    public void sort(int[] a) { Sort.bubbleSort(a); }
}

class quickSortMethod implements SortMethod {

    @Override
    public String getName() {
        return "快速排序";
    }
    @Override
    public void sort(int[] a) { QuickSort.quickSort(a); }
}

class mergeSortMethod implements SortMethod {

    @Override
    public String getName() {
        return "归并排序";
    }
    @Override
    public void sort(int[] a) { MergeSort.mergeSort(a); }
}


public class Lab {
    //定义插入排序的方法
      private static SortMethod[] methods = {
             // new InsertSortMethod(),
           // new shellSortMethod(),
             /* new   selectSortMethod(),
            new heapSortMethod(),
            new bubbleSortMethod(),*/
            //
         new quickSortMethod(),
            //new mergeSortMethod(),
      };


      public static int[] buildRandom(int n) {
          Random random = new Random(20190924);
          int[] r = new int[n];
          for(int i = 0;i<n;i++){
              r[i] = random.nextInt(n);
          }
          return r;
      }

      public static int[] buildSorted(int n) {
          Random random = new Random(20190924);
          int[] r = new int[n];
          for(int i = 0;i<n;i++){
              r[i] = random.nextInt(n);
          }
          Arrays.sort(r);
          return r;
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
    private static void insertSortWithGap(int[] array,int gap){
        for(int i = 1;i<array.length;i++){
            int key = array[i];
            int j;
            for(j = i - gap;j>=0 && array[j]>key;j--){
                array[j+gap] = array[j];
            }
            array[j+gap] = key;
        }
    }

    public static int[] buildReversed(int n) {
        Random random = new Random(20190924);
        int[] r = new int[n];
        for(int i = 0;i<n;i++){
            r[i] = random.nextInt(n);
        }
        shellSort(r);
        return r;
    }

    public static int[] buildEquals(int n) {
          return new int[n];
    }

    public static void main(String[] args) {
        for(int i = 1;i<=4;i++){
            int n = i*50000;
            int[] random = buildRandom(n);
            int[] sorted = buildSorted(n);
            int[] reversed = buildReversed(n);
            int[] equals = buildEquals(n);

            for(SortMethod method : methods) {
                int[] a = random.clone();
                long begin = System.nanoTime();
                method.sort(a);
                long end = System.nanoTime();
                double ms = (end - begin) * 1.0/1000/1000;
                System.out.printf("随机情况下:%s:耗时 %.5f 毫秒%n",method.getName(),ms);
            }
            System.out.println("------------");
            for(SortMethod method : methods) {
                int[] a = sorted.clone();
                long begin = System.nanoTime();
                method.sort(a);
                long end = System.nanoTime();
                double ms = (end - begin) * 1.0/1000/1000;
                System.out.printf("有序情况下:%s:耗时 %.5f 毫秒%n",method.getName(),ms);
            }
            System.out.println("=================");
            for(SortMethod method : methods) {
                int[] a = reversed.clone();
                long begin = System.nanoTime();
                method.sort(a);
                long end = System.nanoTime();
                double ms = (end - begin) * 1.0/1000/1000;
                System.out.printf("逆序情况下:%s:耗时 %.5f 毫秒%n",method.getName(),ms);
            }
            System.out.println("*********************");
            for(SortMethod method : methods) {
                int[] a = equals.clone();
                long begin = System.nanoTime();
                method.sort(a);
                long end = System.nanoTime();
                double ms = (end - begin) * 1.0/1000/1000;
                System.out.printf("相等情况下:%s:耗时 %.5f 毫秒%n",method.getName(),ms);
            }
            System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&");


        }
    }
}
