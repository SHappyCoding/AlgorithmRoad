public class Twosum_57 {

    //碰撞指针，i从0往右走，j从n-1往左走
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while(i < j) {
            int s = target-nums[i] ;  //用减法避免溢出
            if(s < nums[j]) j--; // nums[i]+nums[j]>target j向左移动
            else if(s > nums[j]) i++;  //num[i]+nums[j]<target i向右移动
            else return new int[] { nums[i], nums[j] };
        }
        return new int[0];
    }

    //找小于target的右边界
    public int bsearch(int[] nums,int l,int r,int target){
        while(l<r){
            int mid=l+r+1>>1;
            if(target<nums[mid]) l=mid;  //如果mid满足性质y
            else r=mid-1;
        }
        return l;
    }



    public static void main(String[] args)
    {
        Twosum_57 sr=new Twosum_57();
        int[] a={10,26,30,31,47,60};
        int[] b=sr.twoSum(a,40);
        for(int e:b){
            System.out.println(e+" ");
        }

    }
}
