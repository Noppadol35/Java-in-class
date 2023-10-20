public class MinMaxDemo {
    public static void main(String[] args){
        int a[] ={-128, 65, -235, 99, 0, 26};
        int minIndex= findMinIdx(a);
        //int maxIndex= findMinIdx(a);
        System.out.println("min value is a["+minIndex+"]="+a[minIndex]); //System.out.println("max value is a"+maxIndex+"]="+a[maxIndex]);
           }
           public static int findMinIdx(int[] a){
              int k, minIdx=0;
              for(k=1;k<a.length;k++){
                 if(a[k]<a[minIdx])
                 {
        minIdx=k; }
              }
              return minIdx;
    }
}
