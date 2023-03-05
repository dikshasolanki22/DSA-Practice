import java.util.Scanner;

public class arrayAdvanced {

    public static Scanner scn= new Scanner(System.in);
    
    public static void main(String[] args)
    {
        int n=scn.nextInt();
        int arr[]= new int[n];

        for(int i=0; i<n; i++)
        {
            arr[i]= scn.nextInt();
        }

        reverseArray(arr);

    }


    public static void reverseArray(int[] arr)
    {
        // BRUTE FORCE APPROACH
        //    int[] arrCopy= new int[arr.length];

        //    for(int i=0; i<arr.length; i++)
        //    {
        //        arrCopy[arrCopy.length-1-i]= arr[i];
        //    }
        //    return arrCopy;
    }
}
