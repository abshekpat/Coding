package Strings;

public class Test1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int arr[] = { 1, 3, 5, 7, 9, 11, 13};
        int arr1[] = { 2, 4, 5, 8, 10, 12, 14};
        findmissing(arr, arr1);

    }

    private static void findmissing(int[] arr, int [] arr1) {
        // TODO Auto-generated method stub
        int i = 0, j=0, m = arr.length, n = arr1.length, k=0;
        int arr2[] = new int[m+n];
        while(i<m && j <n)
        {
            if(arr[i]<arr1[j])
            {
                arr2[k] = arr[i];
                i++;
                k++;
            }
            else
            {
                arr2[k] = arr1[j];
                j++;
                k++;
            }
        }
        while(i<m)
        {
            arr2[k]=arr[i];
            k++;
            i++;
        }
        while(j<n)
        {
            arr2[k]=arr1[j];
            k++;
            j++;
        }
        for(int l =0;l<arr2.length;l++)
            System.out.println(arr2[l]);

    }

}
