package coplit;

import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

public class ChocoStick {
    public static ArrayList<Integer[]> divideChocolateStick(int M, int N) {
        // TODO:
        ArrayList<Integer[]> result = new ArrayList<>();
        int GCD = gcd(M,N);

        int sqrt=(int)Math.floor(Math.sqrt(GCD));
        for(int i=1;i<=sqrt;i++){
            if(GCD%i==0){
                result.add(new Integer[]{i,M/i,N/i});
                if(i*i<GCD){
                    int j=GCD/i;
                    result.add(new Integer[]{j,M/j,N/j});
                }
            }
        }
        Collections.sort(result, new Comparator<Integer[]>(){
            @Override
            public int compare(Integer[] o1, Integer[] o2){
                return o1[0].compareTo(o2[0]);
            }
        });
        return result;
    }
    public static int gcd(int m, int n){
        if(m%n==0) return n;
        return gcd(n,m%n);
    }

    public static void main(String[] args) {
        ArrayList<Integer[]> output = divideChocolateStick(4, 8);
        for (Integer[]arr:output){
            for (Integer n:arr){
                System.out.print(n+" ");
            }
            System.out.println();
        }
    }
}
