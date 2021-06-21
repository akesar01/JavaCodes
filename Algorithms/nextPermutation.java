// According to Wikipedia, a man named Narayana Pandita presented the following simple algorithm to solve this problem in the 14th century.

// Find the largest index k such that nums[k] < nums[k + 1]. If no such index exists, just reverse nums and done.
// Find the largest index l > k such that nums[k] < nums[l].
// Swap nums[k] and nums[l].
// Reverse the sub-array nums[k + 1:].
// This is kind of Standard Algorithm 
class Solution {
    public void nextPermutation(int[] arr) {
        int k;
        int n = arr.length;
        for(k=n-2;k>=0;k--)
        {
            if(arr[k+1]>arr[k])
            {
                break;
            }
        }
        if(k<0)
        {
            int i1 =0;
            int j1 =arr.length-1;
            while(i1<j1)
            {
                int a = arr[i1];
                arr[i1] = arr[j1];
                arr[j1] =a;
                i1++;
                j1--;
            }
            return ;
        }
        int l;
        for(l=n-1;l>=0;l--) if(arr[l]>arr[k]) break;
        
        int a = arr[k];
        arr[k] = arr[l];
        arr[l] = a;
        
        int i2 = k+1;
        int j2 = arr.length-1;
        while(i2<j2)
        {
            int a1 = arr[i2];
            arr[i2] = arr[j2];
            arr[j2] = a1;
            i2++; j2--;
        }
        
        
        
        
    }
}
