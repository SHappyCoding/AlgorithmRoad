public class FindMedia_4 {

    //直接找中位数的位置即可
    public double findMedianSortedArrays2(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {  //找中位数一定要循环len/2+1次
            left = right;
            if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {//A数组没有遍历完的情况下，如果B数组遍历完了或者A[aStart] < B[bStart]则right变为A中的数
                right = A[aStart++];
            } else {
                right = B[bStart++];
            }
        }
        if ((len & 1) == 0)  //偶数就是两个数两个数相除
            return (left + right) / 2.0;
        else
            return right;
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int left=(n+m+1)/2;
        int right=(n+m+2)/2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        if(m==0) return (nums2[left-1]+nums2[right-1])*0.5;
        if(n==0) return (nums1[left-1]+nums1[right-1])*0.5;
        return (getKth(nums1, 0, m - 1, nums2, 0, n - 1, left) + getKth(nums1, 0, m - 1, nums2, 0, n - 1, right)) * 0.5;
    }
    //得到两个有序数组第k个数，k表示求的第k个数
    private int getKth(int[] nums1,int s1,int e1,int[] nums2,int s2,int e2,int k){
        int len1=e1-s1+1;
        int len2=e2-s2+1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return getKth(nums2, s2, e2, nums1, s1, e1, k);
        if(len1==0) return nums2[s2+k-1];  //解子问题，当一个数组全部删除了，那次时s1=e1+1,所以len1=e1-s1+1=0
        if(k==1){
            return Math.min(nums1[s1], nums2[s2]);  //解子问题
        }
        int i = s1 + Math.min(len1, k / 2) - 1;  //len比较小的话可以直接取
        int j = s2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {  //分解子问题
            //如果第一个数组的k/2大于第二个，则第k个数出现在[s1,e1]和[j+1,e2]中
            return getKth(nums1, s1, e1, nums2, j + 1, e2, k - (j - s2 + 1));
        }
        else {
            return getKth(nums1, i + 1, e1, nums2, s2, e2, k - (i - s1 + 1));
        }
    }



    public static void main(String[] args) {
        FindMedia_4 m4=new FindMedia_4();
        int[] a={1,2,5,7,9};
        int[] b={1,6,7,8,10};
        System.out.println(m4.findMedianSortedArrays(a,b));
    }
}
