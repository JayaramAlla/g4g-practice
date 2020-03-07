package Interviews;

import java.util.Stack;

public class LordOfTheRings {
    /*
     * created by Jayaram on 20/01/20
     */

    public static void main(String[] args) {
        int[] arry = {-5, 10, -5, -7,15,-20};
        //maintaining stack
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < arry.length ;i++){
            if(arry[i] > 0 ){
                stack.push(arry[i]);
            }else{
                while (stack.size() > 0 && stack.peek() > 0 && stack.peek() < Math.abs(arry[i])){
                    stack.pop();
                }

                if(stack.size() == 0 || stack.peek() < 0 ){
                    stack.push(arry[i]);
                }
            }
        }

        for(Integer val :stack){
            System.out.print(val+" ");
        }
    }
}
