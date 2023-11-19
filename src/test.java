public class test {
    public static void main(String[] args) {
        System.out.println(counter(123));
        System.out.println(counter(123956));
        System.out.println(counter(1));
    }
    public static int counter(int num){
        int suma=0;
        while (num>0){
            suma+=num%10;
            num /=10;
        }
   return suma;}
}
