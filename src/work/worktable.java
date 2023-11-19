package work;

public class worktable {
    public static void main(String[] args) {

    }
}
abstract class Animal {
private String name;
    public abstract void move();
    public void pintname(){
        System.out.println(name);}
}
class Bobr extends Animal{
    @Override
    public void move(){};
}