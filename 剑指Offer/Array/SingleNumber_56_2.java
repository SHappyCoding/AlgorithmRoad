public class SingleNumber_56_2 {
    //排序
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int len =nums.length,i;
        for(i=0;i<len;i+=3){
            if(i==len-1)break;
            if(nums[i]==nums[i+1]) continue; //三个连续的数一定会排在一起，三个三个一起出现，此时只要比较前两个即可
            else break;
        }
        return nums[i];
    }

    //状态机，统计1的个数
    public int singleNumber2(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }

    //统计1的个数
    public int singleNumber3(int[] nums) {
        int[] counts = new int[32]; //创立一个32位的数组
        for(int num : nums) {
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1; //统计每个数字在对应二进制位上出现1的个数
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;  //对各个位置的进行模3操作得到最后的值，得到只出现一次的数字 的第 (31 - i) 位，恢复第 i 位的值到 res
        }
        return res;
    }

    public static void main(String[] args)
    {
        SingleNumber_56_2 sr=new SingleNumber_56_2();
        int[] a={3,3,1,3};
        System.out.println(sr.singleNumber(a));

    }
}
