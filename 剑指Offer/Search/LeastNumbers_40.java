public class LeastNumbers_40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        randomizedSelected(arr, 0, arr.length - 1, k);
        //用快排将前k小的数字找到，将数组前k个数赋值给res即可
        int[] res = new int[k];
        for (int i = 0; i < k; ++i) {
            res[i] = arr[i];
        }
        return res;
    }

    //寻找前k个数
    private void randomizedSelected(int[] arr, int l, int r, int k) {
        if (l >= r) {
            return;
        }
        int pos = randomizedPartition(arr, l, r);
        int num = pos - l + 1;
        if (k == num) {
            return;
        } else if (k < num) {//前面一部分的数组长度大于k，说明找的数太多了，还得向左边找//前面一部分的数组长度小于k，说明找的数不够，还得向右边找
            randomizedSelected(arr, l, pos - 1, k);
        } else {//前面一部分的数组长度小于k，说明找的数不够，还得向右边找
            randomizedSelected(arr, pos + 1, r, k - num);
        }
    }

    // 基于随机的划分快排
    private int randomizedPartition(int[] nums, int l, int r) {
        //在l-r之间取一个随机值
        int i = new Random().nextInt(r - l + 1) + l;
        //将中枢元素放到最后
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    //
    private int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {//l-i表示小于中枢元素的部分
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    //交换数组两个元素
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        LeastNumbers_40 sr=new LeastNumbers_40();
        int[] a={3,1,2};
        int[] c=sr.getLeastNumbers(a,2);
        for(int e:c){
            System.out.print(e+"  ");
        }
    }
}
