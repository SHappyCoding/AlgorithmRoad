public class Add_65 {
    //n+c变成进位为0时异或操作的结果
    public int add(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }

    public static void main(String[] args) {
        Add_65 sr=new Add_65();
        System.out.println(sr.add(20,17));
    }
}
