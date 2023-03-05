import java.util.*;

public class arrayBasic{

    public static Scanner scn= new Scanner(System.in);

    public static void main(String[] args)
    {
        //  int[] students;
        //  students= new int[5];

        //  inputArr(students);
        //  printArr(students);

        System.out.println("Enter no. of ele:");
        int n=scn.nextInt();

        int[] array= new int[n];
        inputArr(array);

        int[] ans= minAndMax(array);

         System.out.println("Min ele: "+ans[0]);
         System.out.println("Max ele: "+ans[1]);
         System.out.println("Span of Array: "+spanOfArray(array));

         System.out.println("Enter ele to be searched");
         int ele= scn.nextInt();
         System.out.println("Ele was found: "+findEle(array,ele));
         
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

    // FIND MIN & MAX VALUE IN ARRAY
    public static int[] minAndMax(int[] arr)
    {
        // initialize max with minimum possible value 
        int max= Integer.MIN_VALUE;
        // initialize min with maximum possible value 
        int min= Integer.MAX_VALUE;

        for(int i=0; i<arr.length; i++)
        {
            if(arr[i]<min)
               min=arr[i];

            if(arr[i]>max)
               max=arr[i];
        }

        return new int[]{min,max};
    }

    // SPAN OF ARRAY i.e. MAX VAL-MIN VAL
    public static int spanOfArray(int arr[])
    {
        int[] minMax= minAndMax(arr);

        return minMax[1]-minMax[0];
    }

    // FIND ELEMENT IN ARRAY
    public static boolean findEle(int[] arr, int ele)
    {
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i]==ele)
            {
                System.out.println("Element was found at: "+i);
                return true;
            }
        }
        return false;
    }

    public static int findEle2(int[] arr, int ele)
    {
        int idx=-1;
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i]==ele)
            {
                idx=i;
                break;
            }
        }
        return idx;
    }

}
