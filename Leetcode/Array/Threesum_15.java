public class Threesum_15 {

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        int len = nums.length;
        if(len<3)return new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        //排序
        Arrays.sort(nums);
        //双指针
        for(int i = 0;i < len;++i) {
            //若nums[i]>0:因为已经排序好，所以后面不可能有三个数加和等于 0，直接返回结果。
            if(nums[i] > 0) return lists;
            //每个元组的第一个元素一定不能一样，这样就可以避免重复解。
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int curr = nums[i];
            int L = i+1, R = len-1;
            while (L < R) {
                int tmp = curr + nums[L] + nums[R];
                if(tmp == 0) {  //判断了一个之后，中间还是有可能得到和为nums[L] + nums[R]=-nums[i]的两个数
                    List<Integer> list = new ArrayList<>();
                    list.add(curr);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    lists.add(list);
                    //跳过第二个枚举过的值，从前往后,为什么放在这里判断，不放在每一次枚举k时的例子呢：
                    //可能出现[-2,0,2],[-2,1,1],你枚举第二个的时候，如果没有找到结果值，第三个相同的值是可以作为第三个值的
                    //也就是说只有得到一个结果之后，才去去重：删除第二个相同的数，第三个相同的数。
                    while(L < R && nums[L+1] == nums[L]) ++L;
                    //跳过第三个枚举过的值，从后往前
                    while (L < R && nums[R-1] == nums[R]) --R;
                    ++L;
                    --R;
                } else if(tmp < 0) {
                    ++L;
                } else {
                    --R;
                }
            }
        }
        return lists;
    }
    public static void main(String[] args) {
        Threesum_15 sr=new Threesum_15();
        int[] a={-1,0,1,2,-1,-4};
        List<List<Integer>> res=sr.threeSum2(a);
        for(List ls:res){
            System.out.print("[");
            for(Object e:ls)System.out.print((int)e+" ");
            System.out.print("]"+"\n");
        }
    }
}
