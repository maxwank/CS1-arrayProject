import java.util.Scanner;
import java.lang.Math;
public class Main
{
    public static void main(String[] args)
    {
        clear();
        System.out.println("running...");
        System.out.println();
        int[] numberArray={221, 17, 170, 136, 68, 85, 34, 17, 187, 51, 102, 119, 153, 85, 204, 85, 221};
        int[] sortedArrayS=selectionSort(numberArray);
        int[] sortedArrayB=bubbleSort(numberArray);
        System.out.println();
        System.out.println("The sorted array from selection sort is: ");
        printArray(sortedArrayS);
        System.out.println();
        System.out.println("The sorted array from bubble sort is: ");
        printArray(sortedArrayB);
        System.out.println();
        Scanner s=new Scanner(System.in);
        System.out.println("What number do you want to search for?");
        int searchValue=s.nextInt();
        System.out.println("Search value found at "  + linearSearch(numberArray, searchValue) + " from linear search");
        System.out.println("Search value found at "  + binarySearch(numberArray, searchValue) + " from binary search");
        System.out.println("The mean is "  + mean(numberArray));
        System.out.println("The median is "  + median(numberArray));
        System.out.println("The mode is "  + mode(numberArray));
        System.out.println("The gcf is "  + gcf(numberArray));
        System.out.println("The min is "  + min(numberArray));
        System.out.println("The max is "  + max(numberArray));
        System.out.println("The sum is "  + sum(numberArray));
        numberArray=reverse(numberArray);
        System.out.println("Is the function a palindrome: "  + isPalindrome(numberArray));
        System.out.println("Reversed Array:");
        printArray(numberArray);
        System.out.println();
        System.out.println("The smallest difference between numbers is "  + smallestDifference(numberArray));
        System.out.println("The numbers with the smallest difference are " + num1 + " and " + num2);
    }
    public static int num1;
    public static int num2;
    public static void collectValues() {
        System.out.println("How many values required?");
        int arrayLength;
        float valueAmt = 0;
        arrayLength = sc.nextInt();
        values = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            System.out.println("Type in values. Press enter after each value. #'s entered: " + (valueAmt));
            valueAmt++;
            values[i] = sc.nextInt();
            wait(100);
            clear();
        }
    }

    public static void clear() {

        System.out.print("\033[H\033[2J");
    }

    public static void printArray(int[] array)
    {
        for (int j : array) {
            System.out.print(j + " | ");
        }
        System.out.println();
    }

    public static int[] selectionSort(int[] array)
    {

        for (int bottom = 0; bottom <array.length-1; bottom ++) {
            int min = bottom;                                //assume first value is smallest
            for (int current = bottom + 1; current <array.length; current ++) {
                if (array[current] < array[min]) {       // check if the smallest value is greater than the current min
                    min = current;
                }
            }
            //swap function
            int temp = array[min];
            array[min] = array[bottom];
            array[bottom] = temp;
        }
        //sorts the array (selection sort)
        return array;
    }

    public static int[] bubbleSort(int[] array)
    {
        //sorts the array (selection sort)
        for(int i=0;i<array.length-1;i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    public static int linearSearch(int[] array, int searchValue)
    {
        //returns the position of the element or -1 if it is not in the list

        boolean found=false;
        int foundPosition=-1;
        for(int counter=0;counter<array.length;counter++) {
            if(array[counter]==searchValue) {
                found=true;
                foundPosition=counter;
            }
        }
        if(!found) {
            System.out.println(searchValue + " not found!");
        }
        return foundPosition;
    }

    public static int binarySearch(int[] array, int searchValue)
    {
        //returns the position of the element or -1 if it is not in the list
        bubbleSort(array);
        int bottom=0;
        int top=array.length;
        boolean found=false;
        int foundPosition=-1;
        int mid;
        while(!found && bottom<=top) {
            mid=(bottom+top)/2;
            if(array[mid]==searchValue) {
                found=true;
                foundPosition=mid;
            }
            else if(searchValue>array[mid]) {
                bottom=mid+1;
            }
            else {
                top=mid-1;
            }
        }
        if(found) {
           // System.out.println(searchValue + " was found at " + foundPosition);
        }
        else {
            System.out.println(searchValue + " was not found");
        }
        return foundPosition;
    }

    public static double mean(int[] array)
    {
        //returns the average
        //the sum function might be helpful here
        return (double)sum(array)/(double)array.length;
    }

    public static double median(int[] array)
    {
        double median;
        if(array.length%2==0) {
            median=(array[array.length/2]+array[array.length/2-1])/2.0;
        }
        else {
            median=array[array.length/2];
        }
        //returns the median or midpoint of the sorted array
        return median;
    }

    public static int mode(int[] array)
    {
        bubbleSort(array);
        int count2 = 0;
        int count1;
        int popular1;
        int popular2 =0;

        for (int i = 0; i < array.length; i++)
        {
            popular1 = array[i];
            count1 = 0;    //see edit

            for (int j = i + 1; j < array.length; j++)
            {
                if (popular1 == array[j]) count1++;
            }

            if (count1 > count2)
            {
                popular2 = popular1;
                count2 = count1;
            }

            else if(count1 == count2)
            {
                popular2 = Math.min(popular2, popular1);
            }
        }

        return popular2;
        //returns the number that occurs the most frequent amount of times
        //maybe a function that determines how many times a particular element appears would be helpful
    }

    public static int gcf(int[] array)
    {
        int gcf=1;
        int min=min(array); //17
        for (int i = min; i > 0 ; i--){
            boolean isGCF = true;
            for (int j=0; j<array.length; j ++){
                if (array[j]%i!=0){
                    isGCF=false;
                    j=array.length;             //breaks loop
                }
            }
            if (isGCF){
                gcf=i;
                i=0;                          //break outer loop
            }
        }
        return gcf;
    }

    public static int max(int[]array)
    {
        int max=array[0];
        //returns the largest number in the array
        for (int j : array) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }

    public static int min(int[]array)
    {
        int min=array[0];
        //returns the smallest number in the array
        for (int j : array) {
            if (j < min) {
                min = j;
            }
        }
        return min;
    }

    public static int sum(int[]array)
    {
        int sum=0;
        //returns the sum of all the numbers
        for (int j : array) {
            sum = sum + j;
        }
        return sum;
    }

    public static boolean isPalindrome(int[]array)
    {
      /*  boolean palindrome=false;
        int first = array.length - 1;
        int last = 0;
        int total = 0;

        for (int i = 0; i < array.length; i ++){
                int bottom = array[first];
                int top = array[last];
                if (top - bottom == 0){
                    total = total +1;
                    first = first - 1;
                    last = last - 1;
                } else if (total == array.length/2) {
                    palindrome = true;
                    break;
                } else {
                    palindrome = false;
                    break;
                }
            }

        //determines if the array is a palindrome or not
        //for example, {1, 2, 3, 2, 1} would return true
        return palindrome; */
        boolean isPalindrome = true;
        for (int i=0; i<array.length/2;i++){
            if (array[i]!=array[array.length-1-i]){
                return false;
            }
        }
        return isPalindrome;
    }

    public static int[] reverse(int[]array)
    {
        int n=array.length;
        int k=0;
        while(k<n/2) {
            int temp=array[k];
            array[k]=array[n-k-1];
            array[n-k-1]=temp;
            k=k+1;
        }
        //returns the reversed array
        //{1, 2, 3, 4, 5, 6} would return {6, 5, 4, 3, 2, 1}
        return array;
    }

    public static int smallestDifference(int[]array)
    {
           int smallestDiff=sum(array);
        int difference;
        for (int l : array) {
            for (int k : array) {
                difference = Math.abs(l - k);
                if (difference != 0 && difference < smallestDiff) {
                    smallestDiff = difference;
                    num1 = l;
                    num2 = k;
                }
            }
        }
        return smallestDiff;
    }
}