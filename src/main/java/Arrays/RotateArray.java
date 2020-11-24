package Arrays;

class RotateArray {
    public void rotate(int[] nums, int k) {
        if(nums.length < 2 || k< 1){
            return;
        }
        //1st method
        // int[] copy = Arrays.copyOf(nums,nums.length);
        // for(int i =0;i< nums.length;i++){
        //      nums[getIndexAfterRotation(nums.length,i+k)] = copy[i]; 
        // }
        
        //2nd method brute force method
        // for(int i =1;i<= k%nums.length ;i++){
        //     int old = nums[nums.length -1];
        //     for(int p =0;p<nums.length;p++){
        //         int temp = nums[p];
        //         nums[p] = old;
        //         old = temp;
        //     }
        // }
        //3rd method
         k = k%nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
        
    }
    
    public int getIndexAfterRotation(int size,int k){
        return k%size;
    }
    
    public void reverse(int[] arry,int start,int end){
        while(start < end){
            int temp = arry[end];
            arry[end] = arry[start];
            arry[start] = temp;
            end--;
            start++;
        }
    }
    
}