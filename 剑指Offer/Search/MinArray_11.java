public class MinArray_11 {

    //找性质边界！我们考虑数组中的最后一个元素 x(引申到搜索区域的高端点)，对于数组的最小元素，最小元素的右边一定小于等于x，最小值左侧的元素，它们的值一定都大于等于 。
    // 这就将数组分成了两个区域。这里由于两个区域性质不是互斥的，需要将等于单独考虑。
    public int minArray(int[] numbers) {
        int i = 0,j = numbers.length - 1;
        //找<=numbers[j]的左边界
        while (i < j) {
            int mid = i+j>>1;
            if (numbers[mid] < numbers[j])j = mid;
            else if (numbers[mid] > numbers[j])i=mid+1;
            else j--;  //相等时将j左移一个
        }
        return numbers[i];
    }


    public static void main(String[] args)
    {
        MinArray_11 sr=new MinArray_11();
        //int[] a={5,7,7,8,8,10};
        int[] a={3,4,5,1,2};

        System.out.println(sr.minArray(a));

    }
}

