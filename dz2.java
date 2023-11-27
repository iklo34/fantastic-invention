import java.util.ArrayList;
import java.util.Arrays;

public class dz2 {
    public static void main(String[] args) {
        int[] numb = {17, -6, 5, 4, 7};
        int[] numb1={1,2,3,4,6};
        int[] numb2={17, -6, 5, 4, 7};
        int[] a={1,2,4,6,7,8};
        String s ="tenet";
        smallest(numb);
        buble(numb);
        factorial(6);
        summaPar(numb);
        proste(41);
        kilkistGolosn("Hello my name is bro");
        seredne(numb);
        NSD(12,18);
        Anagramnist("rotor","rrtoo");
        FiboRec(5);
        prop(a,10);
        Polindrom(s);
        ZrostPosli(numb1);
        BilshaRiznica(numb);
      Pik(numb2);
      int[] mas1 = {1, 2, 3, 4, 5};
      int[] mas2 = {3, 4, 5, 6, 7};
      SpilniElems(mas1,mas2);
    }

    public static void smallest(int[] numbs) {
        int small = 0;
        for (int numb : numbs) {
            if (small > numb) {
                small = numb;
            }
        }
        System.out.println(small);

    }

    public static void buble(int[] numb) {
        for (int j = 0; j < numb.length; j++) {
            for (int i = 0; i < numb.length - 1; i++) {
                if (numb[i] > numb[i + 1]) {
                    int temp = numb[i];
                    numb[i] = numb[i + 1];
                    numb[i + 1] = temp;
                }}
        }
        for (int i : numb) {
            System.out.println(i);
        }
    }
    public static void factorial(int a){
        int b=1;
        for (int i = 1; i <a+1 ; i++) {
b=i*b;
        }
        System.out.println(b);
    }
    public static void summaPar(int[] numbs){
        int vidp=0;
        for (int i = 0; i < numbs.length ; i++) {
            if (numbs[i]%2==0){vidp+=numbs[i];}
        }
        System.out.println(vidp);
    }
    public static void proste(int a){int count=0;
        for (int i = 1; i <a+1 ; i++) {
           if (a%i==0){count++;}
        }
        if (count>2){
            System.out.println("ne proste");
        }
        else {
            System.out.println("proste");
        }
    }
    public static void kilkistGolosn(String s){
        s=s.toLowerCase();int howMch=0;
        for (int i = 0; i <s.length() ; i++) {
            char a=s.charAt(i);
if (a == 'a' || a == 'e' || a== 'i' || a == 'o' || a == 'y' ||a=='u'){howMch++;}
        }
        System.out.println(howMch);
    }
    public static void seredne(int[] numbs){
        double sum=0;
        for (int numb : numbs) {
            sum += numb;
        }
        sum=sum/ numbs.length;
        System.out.println(sum);
    }
    public static void NSD(int a,int b){
        while (b!=0){
            int c=b;
            b=a%b;
            a=c;
        }
        System.out.println(a);
    }
    public static void FiboRec(int n){
        int t=0;
        if (n<=1){
            System.out.println(n);
        }
        else {
            t=(n-1)+(n-2);
        } System.out.println(t);
    }
    public static void prop(int[]a,int N){
        ArrayList<Integer> contain=new ArrayList<>();
        ArrayList<Integer> missed=new ArrayList<>();
        for (int i = 0; i < a.length ; i++) {
            contain.add(a[i]);
        }
        for (int i = 1; i <=N ; i++) {
            if(!contain.contains(i)){
                missed.add(i);}
        }for (int o:missed){
            System.out.println(o);
        }
    }
    public static void Polindrom(String str){
        str =str.replaceAll("\\s"," ").toLowerCase();int start=0;int end=str.length()-1;
        for (int i = 0; i <end ; i++) {
            if (str.charAt(start)!=str.charAt(end)){
                System.out.println("ne ");break;
            }
            start++;end--;
        }System.out.println("palindrom");
    }
    public static void Anagramnist(String a,String b){
        a = a.replaceAll("\\s", "").toLowerCase();
        b = b.replaceAll("\\s", "").toLowerCase();
        char[] charArray1 = a.toCharArray();
        char[] charArray2 = b.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        if (Arrays.equals(charArray1, charArray2)){
            System.out.println("Anagram");
        }
        else {
            System.out.println("non anagram");}
    }
    public static void ZrostPosli(int[] a){
        int max=a[1]-a[0];
        for (int i = 0; i <a.length-2 ; i++) {
            if(max<a[i+2]-a[i+1]){
                max=a[i+2]-a[i+1];
            }
        }
        System.out.println(max);
    }
    public static void BilshaRiznica(int[] a){
        for (int j = 0; j < a.length; j++) {
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }}
        }
        System.out.println(a[a.length-1]-a[0]);
    }
    public static void Pik(int[] a){
        int pik= 0;
        for (int i = 0; i <a.length-2 ; i++) {
            if (a[i]<a[i+1] && a[i+1]>a[i+2]){
                pik=a[i+1];
            }
        }
        System.out.println(pik);
    }
    public static void SpilniElems(int[] a,int[] b){
        ArrayList<Integer> mas1=new ArrayList<>();
        for (int i = 0; i < a.length ; i++) {
            mas1.add(a[i]);
        }
        ArrayList<Integer> spilni=new ArrayList<>();
        for (int i = 0; i < b.length ; i++) {
            if (mas1.contains(b[i])){
                spilni.add(b[i]);
            }
        }
        for (int o:spilni){
            System.out.println(o);
        }
    }
    }

