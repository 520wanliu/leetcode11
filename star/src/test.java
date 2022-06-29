public class test {
    public static int digui(int n){
        if(n <= 1) return 1;
        else{
            return digui(n - 1) + digui(n - 2);
        }
    }

    public static void main(String[] args) {
       String s = "23";
        char c = s.charAt(0);
        System.out.println(c);
    }

}
