public class CountSort {
    public int[] countSort3(int[] A) {
        // 1、找出数组A中的最大值、最小值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : A) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        // 2、初始化计数数组count，数组大小为max-min+1，里面的初值都为0
        int[] count = new int[max-min+1];
        // 对计数数组各元素赋值
        for (int num : A) {
            // A中的元素要减去最小值，再作为新索引
            count[num-min]++;
        }
        for(int i: count){
            System.out.print(i+"  ");
        }
        System.out.printf("\n");
        // 3、计数数组变形，新元素的值是前面元素累加之和的值
        for (int i=1; i<count.length; i++) {
            count[i] += count[i-1];  
        }
        for(int i: count){
            System.out.print(i+"  ");
        }
        System.out.printf("\n");
        // 4、创建结果数组
        int[] result = new int[A.length];
        // 5、遍历A中的元素，填充到结果数组中去，从后往前遍历,保证相同元素大的排在后面(稳定)
        for (int j=A.length-1; j>=0; j--) {
            result[count[A[j]-min]-1] = A[j];//找到A[j]在排序之后的位置放进去：count[A[j]-min]-1
            count[A[j]-min]--;
//            for(int i: count){
//                System.out.print(i+"  ");
//            }
//            System.out.printf("\n");
//            for(int i: result){
//                System.out.print(i+"  ");
//            }
//            System.out.printf("\n");
        }
        return result;
    }
    public static void main(String[] args) {
        CountSort m4=new CountSort();
        int[] a={95,94,91,98,99,90,93,91,92};
        int[] b=m4.countSort3(a);
        for(int i: b){
            System.out.print(i+"  ");
        }
    }
}
