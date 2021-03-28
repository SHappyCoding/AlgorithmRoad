public class FindSequence_57_2 {
    //滑动窗口，左右边界只能向右移动。
    public int[][] findContinuousSequence(int target) {
        int i = 1; // 滑动窗口的左边界
        int j = 1; // 滑动窗口的右边界，左闭右开
        int sum = 0; // 滑动窗口中数字的和
        List<int[]> res = new ArrayList<>();

        while (i <= target / 2) {//只需搜索一半即可，即左边界到左点即可
            if (sum < target) {
                // 右边界向右移动
                sum += j;
                j++;
            } else if (sum > target) {
                // 左边界向右移动
                sum -= i;
                i++;
            } else {//相等的情况下，就记录结果
                int[] arr = new int[j-i];
                for (int k = i; k < j; k++) {
                    arr[k-i] = k;
                }
                res.add(arr);
                // 左边界向右移动
                sum -= i;
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }


    public static void main(String[] args)
    {
        FindSequence_57_2 sr=new FindSequence_57_2();
        int[][] a=sr.findContinuousSequence(9);
        for(int[] tl:a){
            System.out.print("[ ");
            for(int e:tl){
                System.out.print(e+" ");
            }
            System.out.print("],");
        }
    }
}
