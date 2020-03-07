package SlidingWindow;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class simpleSlide {
    /*
     * created by Jayaram on 04/11/19
     */

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        

    }

    private class Solution {
        //Not working missing some cases



        public int subarraysIntution(int[] nums, int k) {
            int i =0,j=0;
            int oddCount = 0;
            int arrysCount = 0;
            while(i<nums.length && j< nums.length){
                System.out.println("new loop i "+i+" j "+j);
                if(nums[j]%2 == 1){
                    oddCount ++;
                }
                if(oddCount == k ){
                    System.out.println("adding for i "+i+" j "+j);
                    arrysCount++;
                }
                if(oddCount == k  && (j == nums.length-1 || nums[j+1]%2 == 1  )){
                    System.out.println("2 i "+i+" j "+j);
                    while(oddCount == k && i <= j){
                        if(nums[i]%2 == 1){
                            System.out.println("removing for i "+i+" j "+j);
                            oddCount--;
                        }else {
                            System.out.println("adding for i "+i+" j "+j);
                            arrysCount++;
                        }
                        i++;
                    }
                }
                j++;
            }
            return arrysCount;
        }

        public int numberOfSubarraysSlidingWindow(int[] nums, int k) {
            return atMost(nums,k)-atMost(nums,k-1);
        }

        public int atMost(int[] nums, int k){
            int i=0,res = 0;
            for(int j=0;j<nums.length;j++){
                k -= nums[j]%2;
                while(k < 0){
                    k += nums[i++]%2;
                }
                res += j -i+1;
            }
            return res;
            }

        public int numberOfSubarrays1(int[] a, int m) {
            int count = 0;
            int[] prefix = new int[a.length];
            int odd = 0;

            for (int i = 0; i < a.length; i++) {
                prefix[odd]++;
                System.out.println(prefix);

                // if array element is odd
                if ((a[i] & 1) == 1) {
                    odd++;
                    System.out.println(" i "+i+" odd "+odd);
                }

                // when number of odd elements>=M
                if (odd >= m) {
                    count += prefix[odd - m];
                    System.out.println("i "+i+"count "+count+" odd "+odd);
                }
                System.out.println("------------------------");
            }

            return count;
        }


//        ---------------------------------------------------------------------------------------------------------

        public int numberOfSubarrays3(int[] nums, int k) {
            int ans = 0;
            int left = 0;
            int leftCount = 1;
            int count = 0;

            for(int n : nums) {
                count += n%2;

                if(count > k ) {
                    count--;
                    left++;
                    leftCount=1;
                }

                if(count == k) {
                    while(nums[left]%2 == 0){
                        left++;
                        leftCount++;
                    }
                    ans += leftCount;
                }
            }

            return ans;
        }
//------------------------------------------------------------------------------------------------

        public int numberOfSubarrays2(int[] nums, int k) {
            int l=0, r=1,  n=nums.length, odd=0;
            int cnt= 0;
            while (l<n && r<=n){
                if(odd<k)  {
                    odd += (nums[r-1]&1)==1 ? 1 : 0;
                }
                if(odd==k){
                    cnt++;
                    int l1=l;
                    while (l<r && !isOdd(nums[l])){
                        l++;
                        cnt++;
                    }
                    if(r<n && !isOdd(nums[r])) {
                        r++;
                        l=l1;
                    } else  {
                        r++;
                        l++;
                        odd--;
                    }
                }else r++;
            }
            return cnt;
        }
        public boolean isOdd(int n){
            return (n&1)==1;
        }

//------------------------------------------------------------------------------------------------

        public int numberOfSubarrays4(int[] nums, int k) {
            int i=0,j=0,cnt=0;
            while(j<nums.length){
                while(j<nums.length && k>0){
                    if(nums[j]%2==1){
                        k--;
                    }
                    j++;
                }
                int jl=j;
                while(jl<nums.length && nums[jl]%2==0)jl++;
                while(k==0){
                    cnt+=(jl-j+1);
                    if(nums[i]%2==1){
                        k++;
                    }
                    i++;
                }
                j=jl;
            }
            return cnt;
        }
//----------------------------------------------------------------------------

    }


}
