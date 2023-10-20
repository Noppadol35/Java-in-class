public class recusive {
    public static void main(String[] args) {
        int ans = calpower(10);
        System.out.println(ans);
    }

    public static int calpower(int ans) {
        if(ans == 0) return 1;
        {
            return 2 * calpower(ans - 1);
        }        
    }
}
