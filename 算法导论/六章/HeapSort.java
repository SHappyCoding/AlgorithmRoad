public class HeapSort {
    /**
     * 堆排序：以大根堆为例子
     * 由数组实现的原地排序，每次弹出堆根也就是最大值，再进行调整堆
     * 稳定性：不稳定
     * 时间复杂度：O(nlgn)
     */
    private int Heap_size=0; //堆的元素个数-1
    public static int Parent(int i){return (i-1)/2;}//向下取整
    public static int LEFT(int i){return 2*i+1;}
    public static int RIGHT(int i){return 2*i+2;}
    //保持堆
    public void MAX_HEAPIFY(int[] A,int i) {
        int la=LEFT(i);
        int ra=RIGHT(i);
        int largest;
        //最大值下标保存为largest
        if(la<=Heap_size && A[la]>A[i])largest=la;
        else largest=i;
        if(ra<=Heap_size && A[ra]>A[largest])largest=ra;
        //如果i=largest，算法结束
        if(largest!=i){
            //否则，交换A[i]与A[largest]，递归调用
            Swap(A,i,largest);
            MAX_HEAPIFY(A,largest);
        }
    }

    //交换值
    public void Swap(int[] A,int i,int j) {
        int temp=A[i];
        A[i]=A[j];
        A[j]=temp;
    }

    //建堆
    public void BUILD_MAX_HEAP(int[] A) {
        Heap_size=A.length-1;
        for(int i=(A.length-1)/2;i>=0;i--)MAX_HEAPIFY(A,i);
    }

    //堆排序，大根堆排完序之后数组里面是从小到大的顺序
    public void Heap_sort(int[] A) {
        //将数组变为一个最大堆
        BUILD_MAX_HEAP(A);
        //每次输出堆根结点，并调整堆
        for(int i=A.length-1;i>=1;i--){
            Swap(A,0,Heap_size);
            Heap_size--;
            MAX_HEAPIFY(A,0);
        }
    }
    
    //返回堆最大值
    public int Heap_Maximum(int[] A){return A[0];}

    //去掉堆中最大值并返回
    public int Heap_Extract_max(int[] A){
        if(Heap_size<1) {
            System.out.print("堆中没有元素,返会0");
            return 0;
        }
        int max=A[0];
        A[0]=A[Heap_size-1];
        Heap_size--;
        MAX_HEAPIFY(A,0);
        return max;
    }

    //将A[i]赋值为key
    public void Heap_increase_key(int[] A,int i,int key){
        if(key<A[i]) {
            System.out.print("key值小于"+A[i]+",不能更改值");
            return;
        }
        if(i==0)return;
        A[i]=key;
        while(i>0 && A[i]>A[Parent(i)]) {
            Swap(A,i,Parent(i));
            i=Parent(i);
        }
    }

    //插入一个元素key
    public void Max_Heap_insert(int[] A,int key){
        Heap_size++;
        A[Heap_size-1]=Integer.MIN_VALUE;
        Heap_increase_key(A,Heap_size-1,key);
    }


    public static void main(String[] args) {
        HeapSort hs=new HeapSort();
        int[] a={-2,1,-3,4,-1,2,3,-4};
        hs.Heap_sort(a);
        for(int i: a){
            System.out.print(i+"  ");
        }
    }
}
