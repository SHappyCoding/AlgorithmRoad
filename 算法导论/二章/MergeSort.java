public class MergeSort {
    /**
     * 归并排序：
     * 分解：将n个无序的牌分解成n/2个有序的牌
     * 解决：对两副子集牌递归的排序
     * 合并：合并两幅排好序的牌，每次从两个牌顶选一个最小的牌，插入手牌，开始没有手牌(也就是辅助数组)
     * 稳定性：稳定
     * 时间复杂度：O(nlgn)  空间复杂度：O(n)
     */
    public static void Merge_sort(int[] A,int l,int r) {
        if(l>=r)return;
        //分解
        int mid=l+((r-l)>>1);//>>的优先级别比较低（(r - l)>>1）需要括号，括号不能省
        //解决
        Merge_sort(A,l,mid);
        Merge_sort(A,mid+1,r);
        //合并
        Merge(A,l,mid,r);
    }

    //合并
    public static void Merge(int[] A,int p,int q,int r) {
        //两个待合并数组的长度
        int n1=q-p+1;
        int n2=r-q;
        //创建两个数组，将A数组里面的p-q-r分别复制到这两个数组中去
        int[] la=new int[n1+1];
        int[] ra=new int[n2+1];
        for(int i=0;i<n1;i++)la[i]=A[p+i];
        for(int i=0;i<n2;i++)ra[i]=A[q+1+i];
        la[n1]=Integer.MAX_VALUE;//设置哨兵，避免检查
        ra[n2]=Integer.MAX_VALUE;
        int i=0,j=0;
        //合并到最后，两个创建的数组都是剩下哨兵。
        for(int k=p;k<=r;){
            if(la[i]<=ra[j])A[k++]=la[i++];
            else A[k++]=ra[j++];
        }
    }
    public static void main(String[] args) {
        int[] a={-2,1,-3,3,-1,2,-4,4};
        Merge_sort(a,0,a.length-1);
        for(int i: a){
            System.out.print(i+"  ");
        }

    }
}
