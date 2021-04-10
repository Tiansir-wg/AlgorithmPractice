public class NC140 {
    public int[] MySort(int[] arr) {
        QuickSort(arr,0,arr.length - 1);
        return arr;
    }

    public void QuickSort(int[] arr, int start, int end){
        if(start < end){
            int pivot = getPivot(arr,start,end);
            QuickSort(arr,start,pivot - 1);
            QuickSort(arr,pivot + 1,end);
        }
    }

    private int getPivot(int[] arr,int start,int end){
        int temp = arr[start];
        while(start < end){
            // 注意等于号
            while(arr[end] >= temp && start < end) end--;
            arr[start] = arr[end];
            while(arr[start] <= temp && start < end) start ++;
            arr[end] = arr[start];
        }
        arr[start] = temp;
        return start;
    }

    public static void main(String[] args) {
        NC140 nc140 = new NC140();
        int[] arr = {5,1,6,2,5};
        nc140.MySort(arr);
        for(int i = 0;i < arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
