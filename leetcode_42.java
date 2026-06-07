class leetcode_42{
    public int trap(int[] height) {
        if (height == null || height.length < 3) return 0;
        int len = height.length;
        int lMax= height[0], rMax = height[len-1];
        int left = 1, right = len-2;
        int water =0;
        while(left<=right){
            if(lMax<=rMax){
                //do left max
                if (lMax > height[left]) {
                    water += lMax - height[left];
                } else {
                    lMax = height[left];
                }
                left++;
            }
            else{
                //do right max
                if (rMax > height[right]) {
                    water += rMax - height[right];
                } else {
                    rMax = height[right];
                }
                right--;
            }
        }
        return water;
    }
}