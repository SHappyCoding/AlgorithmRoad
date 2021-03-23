public class OverHalfnum_39 {

    //1、哈希：HashMap 统计各数字的数量，即可找出众数 。时间复杂度和空间复杂度都为O(N)

    //2、排序：中点的元素一定是众数

    //3、正负抵消：设众数票数为+1，非众数票数为-1，则所有数字的票数和>0
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0, count = 0;
        for(int num : nums){
            //若数组的前a个数字的票数和=0，则数组(n-a)个数字的票数和一定仍 >0 ，即后 (n-a) 个数字的众数仍为 x 。
            //利用票数和 =0缩小剩余数组区间
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        // 验证 x 是否为众数,题目给的是一定是有众数的
        for(int num : nums)
            if(num == x) count++;
        return count > nums.length / 2 ? x : 0; // 当无众数时返回 0
    }

    public static void main(String[] args)
    {
        OverHalfnum_39 sr=new OverHalfnum_39();
        int[] a={1,2,3,2,2,2,2,5,4,2};
        System.out.println(sr.majorityElement(a));

    }

}
