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
        System.out.println("Enter the elements:");
        inputArr(array);

      //  int[] ans= minAndMax(array);

       //  System.out.println("Min ele: "+ans[0]);
       //  System.out.println("Max ele: "+ans[1]);
       //  System.out.println("Span of Array: "+spanOfArray(array));

       //  System.out.println("Enter ele to be searched");
      //   int ele= scn.nextInt();
      //   System.out.println("Ele was found: "+findEle(array,ele));

         //   reverseArrayBruteForce(array);
          //  reverseArray(array);
          //  printArr(array);
          barChart(array);
         
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

    public static void reverseArrayBruteForce(int[] arr)
    {
        // This takes O(n) extra space
        int [] arrCopy= new int[arr.length];

        for(int i=0; i<arr.length; i++)
        {
            arrCopy[arr.length-1-i]= arr[i];
        }

        for(int i=0; i<arr.length; i++)
        {
            arr[i]= arrCopy[i];
        }
    }

    public static void reverseArray(int[] arr)
    {
        //By swapping till middle of the array by using two pointers
        int left=0;
        int right= arr.length-1;

        while(left<right)
        {
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;

        left++;
        right--;
        }
    }

    // Rotate an array by k 
    // positive k= move elements from right to left(end to front)
    // negative k= move elements from left to right(front to end)
    public static void kRotate(int k,int []arr)
    {
        k=k%arr.length; // bring k in range

        if(k<0) // For negative k, change it to positive
            k=k+arr.length;

        
        int left=0;
        int right= arr.length-1;
        
        reverseArrKRotate(arr,left,right);
        reverseArrKRotate(arr,left,k-1);
        reverseArrKRotate(arr,k,right);

    }

    public static void reverseArrKRotate(int[] arr,int start, int end)
    {
        while(start<end)
        {
            int temp= arr[start];
            arr[start]=arr[end];
            arr[end]=temp;

            start++;
            end--;
        }
    }

    public void rotateBruteForce(int[] nums, int k) {
        
        k=k%nums.length;
        if(k<0)
          k=k+nums.length;
          
        for(int j=0; j<k; j++)
        {
            int temp= nums[nums.length-1];

            for(int i=nums.length-1; i>0; i--)
            {
                nums[i]=nums[i-1];
            }
            nums[0]=temp;
        }
    }

    public void rotateLoveBabbar(int[] nums, int k) {
        
        int temp[]= new int[nums.length];

        for(int i=0; i<nums.length; i++)
        {
            temp[(i+k)%nums.length]=nums[i];
        }

        for(int i=0; i<nums.length; i++)
        {
            nums[i]=temp[i];
        }

    }

    public static void barChart(int[] arr)
    {

        int[] maxmin= minAndMax(arr);
        int max= maxmin[1];

        for(int y=max; y>0; y--)
        {
             for(int x=0;x<arr.length; x++)
            {
                int val=arr[x];
                if(y<=val)
                   System.out.print("*");
                else
                   System.out.print("-");
            }
            System.out.println();
        }
    }
}

