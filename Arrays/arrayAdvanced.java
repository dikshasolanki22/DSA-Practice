import java.util.Scanner;

import javax.swing.plaf.synth.SynthStyle;

public class arrayAdvanced {

    public static Scanner scn= new Scanner(System.in);
    
    public static void main(String[] args)
    {
        System.out.println("Enter no. of ele for arr1:");
        int n=scn.nextInt();

        // System.out.println("Enter no. of ele for arr2:");
        // int m=scn.nextInt();

        int[] array1= new int[n];
        System.out.println("Enter "+n+" elements for arr1:");
        inputArr(array1);

        // int[] array2= new int[m];
        // System.out.println("Enter "+m+" elements for arr2:");
        // inputArr(array2);

        // int [] res= sumOfTwoArrays(array1,array2);
        // printArr(res);

       // int [] res= differenceOfTwoArrays(array1,array2);
        // printArr(res);
        

        // int[] inv= inverseOfArray(array1);
        // printArr(inv);

      //  printAllSubsets(array1);

      System.out.println("Enter target ele to be searched(binary search):");
      int target=scn.nextInt();
      int idx= binarySearch(array1,target);
      System.out.println("Ele found at position (binary search):"+idx);
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
        int carry=0;


        while(i>=0)
        {
            int val1= arr1[i]-carry;
            int val2= (j<0)?0:arr2[j];

            if(val1<val2)
            {
                val1+=10;
                carry=1;
            }
            else
            {
                carry=0;
            }

            int diff= val1-val2;

            resArr[k]=diff;

            i--; j--; k--; 
        }
         return resArr;
    }

    public static int[] inverseOfArray(int arr[])
    {
        int[] inverse= new int[arr.length];

        for(int i=0; i<arr.length; i++)
        {
            int indx= arr[i];
            int val=i;

            inverse[indx]=val;
        }
        return inverse;
    }

    public static void printAllSubArrays(int arr[])
    {
        int n= arr.length;

        for(int i=0; i<n; i++)
        {
            for(int j=0 ; j<n-i; j++)
            {
                for(int k=0; k<=j; k++)
                {
                    System.out.print(arr[i+k]+"\t");
                }
                System.out.println();
            }
        }
    }

    public static void printAllSubsets(int arr[])
    {
        int numSubsets= (int) Math.pow(2,arr.length);
        int power= (int) Math.pow(10, arr.length-1);

        for(int count=0; count<numSubsets; count++)
        {
            int binary= getBinary(count);
            int pow=power;

            for(int i=0; i<arr.length; i++)
            {
                int digit= binary/pow;
                int rem=binary%pow;

                if(digit==0)
                  System.out.print("-\t");
                else
                System.out.print(arr[i]+"\t");

                binary=rem;
                pow/=10;
            }
            System.out.println();
        }


    }

    public static int getBinary(int num)
    {
        int ans=0;
        int pow=1;

        while(num!=0)
        {
            int rem=num%2;
            num/=2;

            ans+=(rem*pow);
            pow*=10;

        }
        return ans;
    }

    public static int binarySearch(int[] arr, int target)
    {
        int idx=-1;

        int left=0, right=arr.length-1;

        while(left<=right)
        {
            int mid= (left+right)/2;

            if(arr[mid]==target)
                return mid;
            else if(arr[mid]<target)
            {
                left=mid+1;
            }
            else if(arr[mid]>target)
            {
                right=mid-1;
            }
        }
        return idx;
    }

    public static int[] ceilFloor(int arr[], int data)
    {
        int left=0, right=arr.length-1;
        int ceil=-1,floor=-1;

        while(left<=right)
        {
            int mid=(left+right)/2;

            if(arr[mid]==data)
            {
                ceil=floor=data;
                break;
            }
            else if(arr[mid]<data)
            {
                if(arr[mid]>floor)
                    floor=arr[mid];
                left=mid+1;
            }
            else if(arr[mid]>data)
            {
                if(arr[mid]>ceil)
                    ceil=arr[mid];
                right=mid-1;
            }
        }

        return new int[]{ceil,floor};
    }

    public int[] twoSum(int[] nums, int target) 
    {
        int[] pair= new int[2];

       for(int i=0; i<nums.length; i++)
       {
           int secondEle= target-nums[i];

            for(int j=0; j<nums.length; j++)
            {
                if(i!=j && nums[j]==secondEle)
                    {
                        pair[0]=i;
                        pair[1]=j;
                        break;
                    }
            }
       } 
       return pair;
    }


}
