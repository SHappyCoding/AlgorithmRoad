public class Rand7_470 {
    //返回[1，7]的随机整数
    public int rand7(){
        return (int)(Math.random()*100+1); //Math.random()返回[0.0 - 1.0)的随机数
    }
    public int rand10() {
        int row, col, idx;
        do {
            row = rand7();
            col = rand7();
            idx = col + (row - 1) * 7;  //返回的范围就是[1，49]等概率
        } while (idx > 40); //去掉大于40的
        return 1 + (idx - 1) % 10;      //对[1,40]的变成[1，10]，这个和1 + idx % 10是等价的
    }
    public int rand10_2() {
        while (true){
            int num = (rand7() - 1) * 7 + rand7();
            // 如果在40以内，那就直接返回
            if(num <= 40) return 1 + num % 10;
            // 说明刚才生成的在41-49之间，利用随机数再操作一遍
            num = (num - 40 - 1) * 7 + rand7();     //返回的范围就是[1，63]等概率
            if(num <= 60) return 1 + num % 10;      //只需要舍弃三个数即可
            // 说明刚才生成的在61-63之间，利用随机数再操作一遍
            num = (num - 60 - 1) * 7 + rand7();     //返回的范围就是[1，21]等概率
            if(num <= 20) return 1 + num % 10;      //只需要舍弃1个数即可
        }
    }

    public static void main(String[] args) {
        Rand7_470 sr=new Rand7_470();
        System.out.println(sr.rand10());
    }
}
