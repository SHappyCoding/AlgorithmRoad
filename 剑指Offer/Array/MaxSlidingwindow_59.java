public class MaxSlidingwindow_59 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len=nums.length;
        if(len == 0 || k == 0)return new int[0];
        int[] max=new int[len-k+1];
        for(int i=0;i<len-k+1;i++){
            if(k==1)max[i]=nums[i];
            for(int j=i;j+1<i+k;j++){
                max[i]=Math.max(max[i],Math.max(nums[j],nums[j+1]));
            }
        }
        return max;
    }

    //双端队列
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int len=nums.length;
        if(len == 0 || k == 0) return new int[0];
        //双端队列，队首保存窗口的最大值
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[len - k + 1];
        for(int j = 0, i = 1 - k; j < len; i++, j++) {
            // 1、删除 deque 中对应的 nums[i-1]，如果恰巧nums[i-1]是上一次窗口里面的最大值，则删除这个队首
            if(i > 0 && deque.peekFirst() == nums[i - 1])
                deque.removeFirst();
            // 2、保持 deque 递减,所以一个窗口最大值就是队首，如果窗口的最后一个值小于要新添加的值，可以删除
            while(!deque.isEmpty() && deque.peekLast() < nums[j])
                deque.removeLast();
            deque.addLast(nums[j]);
            // 3、记录窗口最大值
            if(i >= 0)
                res[i] = deque.peekFirst();//返回队首的最大值，不弹出队首
        }
        return res;
    }

    public static void main(String[] args)
    {
        MaxSlidingwindow_59 sr=new MaxSlidingwindow_59();
        int[] a={1,3,-1,-3,5,3,6,7};
        //规定输入的k值都是都是有效的
        int[] b=sr.maxSlidingWindow(a,3);
        for(int e:b){
            System.out.print(e+"  ");
        }
        System.out.println();
        int[] c=sr.maxSlidingWindow2(a,3);
        for(int e:c){
            System.out.print(e+"  ");
        }
    }
}
