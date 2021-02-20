public int rob(int[] nums) {
        int p1=0,p2=0,cur=0;
        int len=nums.length;
        for(int k=0;k<len;k++){
            cur=Math.max(p1+nums[k],p2);
            p1=p2;
            p2=cur;
        }
        return cur;
    }
