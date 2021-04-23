public class Finddisappearnum_448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res=new LinkedList<>();
        int len=nums.length,i=0;
        while(i<len){
            while(nums[i]!=i+1 && nums[nums[i]-1]!=nums[i]){ //当前的值不在顺序且值所在顺序的地方不是这个值交换
//                    int t1=nums[i];     //首先保存一个交换的值
//                    int t2=nums[i]-1;   //保存要交换的下标，如果不保存这个，num[i]经过第一步就会变了
//                    nums[i]=nums[t2];
//                    nums[t2]=t1;
                    swap(nums,i,nums[i]-1);

            }
            i++;
        }
        for(i=0;i<len;i++){
            if(nums[i]!=i+1)res.add(i+1);   //我们从0开始所以就要+1
        }
        return res;

    }
    public void swap(int[] nums,int i,int j){
        int temp=nums[j];
        nums[j]=nums[i];
        nums[i]=temp;
    }


    public List<Integer> findDisappearedNumbers2(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;  //将num变成下标
            nums[x] += n;   //对应下标的位置的数增加n
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        Finddisappearnum_448 sr=new Finddisappearnum_448();
        int[] a={4,3,2,7,8,2,3,1};
        List<Integer> res=sr.findDisappearedNumbers(a);
        for(Integer e:res){
            System.out.print(e+" ");
        }
    }
}
