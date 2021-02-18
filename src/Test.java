import java.util.Set;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
//        SC1 s1 = new SC1();
//        s1.foo();
        SC s = new SC1();
        s.foo();
//        int x;
//        if(x == 9){
//            int x =8;
//        }
//        Set set = new TreeSet();
//        set.add(1);
//        set.add("2");
//        set.add(3);
        String x ="a";
        x.concat(x);
        System.out.println(x);
    }
}
class SC{
     void foo(){
        System.out.println("sc");
    }
}
class SC1 extends SC{
     void foo(){
        System.out.println("sc1");
    }
}
