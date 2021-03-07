public class Searchnum_53_2 {
    public int missingNumber(int[] nums) {
        int j = nums.length;
        int i=0;
        //二分找左边界，左边界：满足nums[mid]!=mid的最小下标
        while(i<j){
            int mid=i+j>>1;  //下取整
            if(nums[mid]!=mid) j=mid;  //如果mid满足性质x
            else i=mid+1;
        }
        return i;
    }


    public static void main(String[] args)
    {
        Searchnum_53_2 sr=new Searchnum_53_2();
        int[] a={0,1,3};
        System.out.println(sr.missingNumber(a));

    }
}
