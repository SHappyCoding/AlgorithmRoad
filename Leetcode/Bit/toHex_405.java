public class toHex_405 {
    char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    public String getHex(int num) {
        if(num == 0) return "0";
        String result = "";
        while(num != 0){
            int x = num & 0xF; //不断的和15进行异或，相当于num%16
            result = map[(x)] + result;  //每次都是低位加在最后，高位加在前面
            num = (num >>> 4);  //每次向后移动4位也就是相当于num/16
        }
        return result;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        toHex_405 sr=new toHex_405();
        System.out.println(sr.getHex(a));
    }
}
