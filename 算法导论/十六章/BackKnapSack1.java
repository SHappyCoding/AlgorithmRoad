public class BackKnapSack {


    //回溯法
    public static int getMaxValue(Goods[] goods, int capacity)
    {
        return getMaxValue_re(goods, goods.length - 1, capacity);
    }

    public static int getMaxValue_re(Goods[] goods, int goods_num, int capacity)
    {
        int result = 0;
        if (goods_num == -1 || capacity == 0)
            result = 0;
        else if (goods[goods_num].weight > capacity)  //包此时不能装下这个货物
            result = getMaxValue_re(goods, goods_num - 1, capacity);
        else  //包能装下货物，再去比较装这个货物和不装这个货物得到的最优值
            result = Math.max(getMaxValue_re(goods, goods_num - 1, capacity),
                    getMaxValue_re(goods, goods_num - 1, capacity - goods[goods_num].weight) + goods[goods_num].value);
        return result;
    }


    public static void main(String[] args) {
        BackKnapSack knapsack = new BackKnapSack();
        Goods[] goods=new Goods[]{
                new Goods(2,6),
                new Goods(2,3),
                new Goods(6,5),
                new Goods(5,4),
                new Goods(4,6),
        };
        int weight = 10;
        System.out.print(knapsack.getMaxValue(goods, weight));
    }

}
