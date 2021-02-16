public class InsertSort {
    /**
     * 插入排序：
     * 很像摸牌时，手上的牌都是有序的
     * 从桌子上摸一张时会在手上的牌中，从右到左进行比较，将这张牌插入到正确位置
     * 稳定性：稳定
     * 时间复杂度：O(N^2)
     */
    public static void Insert_sort(int[] A) {
        int len=A.length;
        int key=0;
        int i=0;
        for(int j=1;j<len;j++) {
            key = A[j];//摸牌
            i = j - 1;
            while (i >= 0 && A[i] > key) {//在手上的牌中，从右到左进行比较
                A[i + 1] = A[i];
                i--;
            }
            A[i + 1] = key;
        }
    }
    public static void main(String[] args) {
        int[] a={-2,1,-3,4,-1,2,1,-5,4};
        Insert_sort(a);
        for(int i: a){
            System.out.print(i+"  ");
        }

    }
}
