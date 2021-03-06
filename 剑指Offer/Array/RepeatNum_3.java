public class RepeatNum_3 {
    //set保存数据，数字出现第二次即退出
    public int findRepeatNumber(int[] nums) {
        Set<Integer> st=new HashSet<Integer>();
        int len=nums.length;
        int i=0;
        while(i<len){
            //add方法当元素不存在时返回true
            if(!st.add(nums[i++]))return nums[i-1];
        }
        return -1;
    }

    //用一个相同长度的数组保存出现的数字
    public int findRepeatNumber1(int[] nums) {
        int len=nums.length;
        int[] bucket = new int[len];
        for (int i = 0; i < len; i++) {
            if (bucket[nums[i]] != 0) {
                // 如果存在，则直接返回
                return nums[i];
            }
            // 不存在，将当前元素作为索引，变为1，表示num[i]元素出现了一次
            bucket[nums[i]] = 1;
        }
        //如果没有重复返回-1
        return -1;
    }

    //原地重置
    //如果没有重复数字，那么正常排序后，数字i应该在下标为i的位置，反之就是有重复数字
    public int findRepeatNumber2(int[] nums) {
        int temp;
        for(int i=0;i<nums.length;i++){
            while (nums[i]!=i){//如果当前元素不是排序之后的位置
                //检查排序之后的位置的元素和当前元素是否相等，如果相等则有重复元素
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                //不相等，将nums[i]交换到正常排序的位置
                temp=nums[i];
                nums[i]=nums[temp];
                nums[temp]=temp;
            }
        }
        return -1;
    }


    public static void main(String[] args)
    {
        RepeatNum_3 sr=new RepeatNum_3();
        int[] a={2,3,1,0,2,5,3};
        int key=sr.findRepeatNumber(a);
        System.out.println(key);
        key=sr.findRepeatNumber1(a);
        System.out.print(key);

    }
}
