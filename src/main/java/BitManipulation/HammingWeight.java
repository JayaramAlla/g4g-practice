package BitManipulation;

//Number of 1's in a number
public class HammingWeight {
    /*
     * created by Jayaram on 08/12/19
     */

    /*
    The loop continues as long as there is at least a 1 in the number otherwise n will be 0.
(n&1) will only be 1 if the bit at least significant place is 1. At that time we increment the count by 1.
In the next line we right-shift the number by 1 position with zero fill, so that only 0's are added to the number on shifting.
     */
    public int hammingWeight1(int n) {
        int count = 0;
        while(n!=0) {
            count += (n&1);
            n>>>=1;
        }
        return count;
    }



//The n-1 will flip the right most 1 to 0 and the bits at its right .
//n& (n-1) will remove 1 in binary per time.
//iterative times is same as the number of 1 in the n

    public int hammingWeight(int n) {
        int count =0;
        while (n!=0){
            n= n&(n-1);
            count++;
        }
        return count;
    }
}
