public class Exchange_21 {
    //首尾指针
    public int[] exchange(int[] nums) {
        int i=0,j=nums.length-1,temp;
        while(i<j){
            //i从前往后搜索偶数
            while(i<j && (nums[i]&1)==1)i++;
            //j从后往前搜索奇数
            while(i<j && (nums[j]&1)==0)j--;
            temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
        return nums;
    }


    //快慢指针
    public int[] exchange2(int[] nums) {
        int low = 0, fast = 0,temp;
        while (fast < nums.length) {
            //快指针从前向后找奇数
            if ((nums[fast] & 1 )==1) {
                temp=nums[low];
                nums[low]=nums[fast];
                nums[fast]=temp;
                //low的作用是指向下一个奇数应当存放的位置
                low ++;
            }
            fast ++;
        }
        return nums;
    }

    public static void main(String[] args) {
        Exchange_21 mq = new Exchange_21();
        int[] a={1,2,3,4};
        mq.exchange(a);
        for(int e:a){
            System.out.printf(e+" ");
        }
        System.out.println();
        int[] b={1,2,3,4};
        mq.exchange2(b);
        for(int e:b){
            System.out.printf(e+" ");
        }
    }
}
