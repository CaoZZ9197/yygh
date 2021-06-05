import java.util.*;

class mycom implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        String s1 = (String)o1+o2;
        String s2 = (String)o2+o1;
        return s1.compareTo(s2);
    }
}

public class tt {
    public static void main(String[] args){
        List li =new ArrayList<>();


        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        while (n-- > 0) {
            String[] strs = cin.nextLine().split(" ");
            int sum = 0;
            for (int i = 1; i <= Integer.parseInt(strs[0]); i++) {
                sum += Integer.parseInt(strs[i]);
            }
            System.out.println(sum);
        }

    }
}
