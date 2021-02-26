public class QuickSort {
    /**
     * 快速排序：
     * 先确定一个主元(也就是需要排序的元素)
     * 将序列分成<=x的区域和大于x的区域，主元最后在中间
     * 稳定性：不稳定
     * 时间复杂度：O(nlgn)
     */
    public void quicksort(int[] A,int p,int r) {
        int q=0;
        if(p<r){
            q=Partion(A,p,r);
            quicksort(A,p,q-1);
            quicksort(A,q+1,r);
        }
    }
    public int Partion(int[] A,int p,int r){
        int temp=0;
        int x=A[r];
        int i=p-1;
        for(int j=p;j<r;j++){//A[j]>x时就继续向前走，i+1～j表示大于x的值
            if(A[j]<=x) {
                i++;
                temp = A[j];//>x区域的第一个数和A[j]进行交换，此时i++，表示>=x区域扩充了一个数
                A[j] = A[i];
                A[i] = temp;
            }
        }
        temp=A[r];//最后交换x和>x的第一个数
        A[r]=A[i+1];
        A[i+1]=temp;
        return i+1;//返回此时主元所在的位置
    }
    public static void main(String[] args) {
        QuickSort m4=new QuickSort();
        int[] a={-2,1,-3,4,-1,2,1,-5,4};
        m4.quicksort(a,0,a.length-1);
        for(int i: a){
            System.out.print(i+"  ");
        }

    }
}
