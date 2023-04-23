import java.util.Scanner;

public class arrayAdvanced {

    public static Scanner scn= new Scanner(System.in);
    
    public static void main(String[] args)
    {
        System.out.println("Enter no. of ele for arr1:");
        int n=scn.nextInt();

        System.out.println("Enter no. of ele for arr2:");
        int m=scn.nextInt();

        int[] array1= new int[n];
        System.out.println("Enter "+n+" elements for arr1:");
        inputArr(array1);

        int[] array2= new int[m];
        System.out.println("Enter "+m+" elements for arr2:");
        inputArr(array2);

        int [] res= sumOfTwoArrays(array1,array2);
        printArr(res);

    }

    public static void inputArr(int[] arr)
    {
        for(int i=0; i<arr.length; i++)
        {
            System.out.println("Enter ele: ");
            arr[i]= scn.nextInt();
        }

    }

    public static void printArr(int[] arr)
    {
        for(int i=0; i<arr.length; i++)
        {
            System.out.println("Array ele: "+arr[i]);
        }
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

    public static int[] sumOfTwoArrays(int []arr1,int[] arr2)
    {
        int resArrSize= Math.max(arr1.length, arr2.length)+1;
        int[] resArr= new int[resArrSize];

        int i= arr1.length-1;
        int j= arr2.length-1;
        int k= resArrSize-1;

        int carry=0;
        int sum=0;
        int val=0;


        while(i>=0 || j>=0 || carry!=0)
        {
            int val1= (i>=0)?arr1[i]:0;
            int val2= (j>=0)?arr2[j]:0;

            sum=val1 + val2 +carry;
            carry= sum/10;
            val=sum%10;

            resArr[k]= val;

            i--; j--; k--;
        }

        return resArr;
    }

    public static int[] differenceOfTwoArrays(int[] arr1, int[] arr2)
    {
        int resArrSize= Math.max(arr1.length, arr2.length);
        int[] resArr= new int[resArrSize];

        int i=arr1.length-1;
        int j=arr2.length-1;
        int k=resArr.length-1;


        while(i>=0 || j>=0)
        {
            int val1=
            int val2= 

            i--; j--; k--;
        }


        return resArr;
    }
}
