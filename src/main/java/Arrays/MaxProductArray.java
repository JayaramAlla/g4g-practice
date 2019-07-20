package Arrays;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

public class MaxProductArray {
    /*
     * created by Jayaram on 20/07/19
     * You are given an array A containing N integers. The special product of each ith integer in this array is defined as the product of the following:<ul>

LeftSpecialValue: For an index i, it is defined as the index j such that A[j]>A[i] (i>j). If multiple A[j]’s are present in multiple positions, the LeftSpecialValue is the maximum value of j.

RightSpecialValue: For an index i, it is defined as the index j such that A[j]>A[i] (j>i). If multiple A[j]s are present in multiple positions, the RightSpecialValue is the minimum value of j.

Write a program to find the maximum special product of any integer in the array.

Input: You will receive array of integers as argument to function.

Return: Maximum special product of any integer in the array modulo 1000000007.

Note: If j does not exist, the LeftSpecialValue and RightSpecialValue are considered to be 0.

Constraints 1 <= N <= 10^5 1 <= A[i] <= 10^9
     */

    private class SolutionMine {
        public int maxSpecialProduct(ArrayList<Integer> A) {
            int[] val1 = new int[A.size()];
            //int[] val2 = new int[A.size()];
            int leftMax = 0;
            int rightMax = 0;
            Long max = 0L;
            // Stack<Integer> leftIndexes = new Stack<Integer>();
            int[] leftIndexes = new int[A.size()];
            int l = 0;
            // Stack<Integer> rightIndexes = new Stack<Integer>();
            int r = 0;
            int[] rightIndexes = new int[A.size()];
            leftIndexes[l]=0;
            rightIndexes[r]= A.size()-1;
            for(int i =1;i< A.size() ;i++){
                while(l >= 0 && A.get(i) >= A.get(leftIndexes[l]) ){
                    l--;
                }

                if(l >= 0 && A.get(i) < A.get(leftIndexes[l])){
                    leftMax = leftIndexes[l];
                }else {
                    leftMax = 0;
                }
                if(l < 0){
                    l = 0;
                    leftIndexes[l]= i;
                }else {
                    leftIndexes[++l]= i;
                }

                val1[i]= leftMax;
                //System.out.print("L "+leftMax+" ");

            }
            for(int j = A.size() -2; j >= 0;j--){
                while(r >= 0 && A.get(j) >= A.get(rightIndexes[r]) ){
                    r--;
                }

                if(r >= 0 && A.get(j) < A.get(rightIndexes[r])){
                    rightMax = rightIndexes[r];
                }else {
                    rightMax = 0;
                }
                if(r < 0){
                    r = 0;
                    rightIndexes[r]= j;
                }else {
                    rightIndexes[++r]= j;
                }
                //System.out.print("r "+rightMax+", ");
                Long multi = 1l*rightMax*val1[j];
                if(multi > max){
                    max = multi;
                }
            }
            return max.intValue()%1000000007;

        }

    }

    private class SolutionEditorial {
        public int maxSpecialProduct(ArrayList<Integer> A) {
            int n = A.size();
            int[] left = new int[n];
            int[] right = new int[n];

            Deque<Integer> q = new ArrayDeque<>();
            q.addLast(0);

            for(int i = 1; i < n; i++){
                while(!q.isEmpty()){
                    if(A.get(q.getLast()) > A.get(i)) break;
                    q.removeLast();
                }
                left[i] = (q.isEmpty()) ? 0 : q.getLast();
                q.addLast(i);
            }
            q = new ArrayDeque<>();
            q.addLast(n - 1);
            for(int i = n - 2; i >= 0; i--){
                while(!q.isEmpty()){
                    if(A.get(q.getLast()) > A.get(i)) break;
                    q.removeLast();
                }
                right[i] = (q.isEmpty()) ? 0 : q.getLast();
                q.addLast(i);
            }
            long mx = -1;
            for(int i = 0; i < n; i++){
                mx = Long.max(mx, 1L * left[i] * right[i]);
            }
            return (int)(mx % 1000000007);
        }
    }

    public class SolutionFastest {
        public int maxSpecialProduct(ArrayList<Integer> A) {
            int n = A.size();
            if(n==0)
                return 0;
            int left[] = new int[n];
            left[0] = 0;
            for(int i=1;i<n;i++)
            {
                int j = i-1;
                while(j>0){
                    if(A.get(i)<A.get(j)){
                        left[i] = j;
                        break;
                    }
                    j = left[j];
                }
            }
            int right[] = new int[n];
            for(int i=n-2;i>=0;i--)
            {
                int j = i+1;
                while(j>0)
                {
                    if(A.get(i)<A.get(j))
                    {
                        right[i] = j;
                        break;
                    }
                    j = right[j];
                }
            }
            long max = 0;
            for(int i=0;i<n;i++)
                max = Math.max((long)left[i]*right[i], max);
            return (int)(max%1000000007);
        }
    }

    public class SolutionLightWeight {
        private ArrayList<Integer> leftSpecialV(ArrayList<Integer> A){

            ArrayList<Integer> r = new ArrayList<>();
            Stack<Integer> s = new Stack<>();
            for(int i=0;i<A.size();i++){
                while(!s.empty() && A.get(s.peek()) <= A.get(i)){
                    s.pop();
                }

                if(s.empty()){
                    r.add(0);
                }
                else{
                    r.add(s.peek());
                }
                s.push(i);
            }

            return r;
        }

        private ArrayList<Integer> rightSpecialV(ArrayList<Integer> A){

            ArrayList<Integer> r = new ArrayList<>();
            Stack<Integer> s = new Stack<>();
            for(int i=A.size()-1;i>=0;i--){
                while(!s.empty() && A.get(s.peek()) <= A.get(i)){
                    s.pop();
                }

                if(s.empty()){
                    r.add(0,0);
                }
                else{
                    r.add(0,s.peek());
                }
                s.push(i);
            }

            return r;
        }

        public int maxSpecialProduct(ArrayList<Integer> A) {
            ArrayList<Integer> l = leftSpecialV(A);
            ArrayList<Integer> r = rightSpecialV(A);

            long product=0, res= 0;

            for(int i=0;i<A.size();i++){
                res= (long)l.get(i) * (long)r.get(i);
                if(product < res){
                    product  = res;
                }
            }

            return (int)(product%1000000007);
        }
    }
}
