public class MergedSort {

    public static void main(String[] args) {
        int[] x = {6,3,9,5,2,8};
        divide(x,0,5);
        for(int i=0 ; i<x.length ; i++) {
            System.out.print(x[i] + " ");
        }
    }

    public static void divide(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start+end)/2;
        divide(arr, start,mid);
        divide(arr, mid+1, end);
        conquer(arr,start,mid,end);
    }

    public static void conquer(int[] arr, int start, int mid, int end) {
        int[] merged = new int[end-start+1];
        int a = start;
        int b = mid+1;
        int x = 0;

        while(a<=mid && b<=end) {
            if(arr[a] <= arr[b]) {
                merged[x++] = arr[a++];
            }
            else {
                merged[x++] = arr[b++];
            }
        }
        while(a<=mid) {
            merged[x++] = arr[a++];
        }
        while(b<=end) {
            merged[x++] = arr[b++];
        }
        for(int i=0, j=start ; i<merged.length ; i++, j++) {
            arr[j] = merged[i];
        }
    }
}
