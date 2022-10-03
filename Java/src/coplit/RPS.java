package coplit;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class RPS {
    public static ArrayList<String[]> rockPaperScissors(int rounds) {
        // TODO:
        ArrayList<String[]>result = new ArrayList<>();

        return perm(rounds,new String[]{},result);
    }
    public static ArrayList<String[]>perm(int rounds,String[]play,ArrayList<String[]>result){
        if(rounds==0){
            result.add(play);
            return result;
        }
        String[]rps={"rock","paper","scissors"};

        for(int i=0;i<rps.length;i++){
            String current=rps[i];
            String[]concat= Arrays.copyOf(play,play.length+1);
            concat[concat.length-1]=current;

            result=perm(rounds-1,concat,result);
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<String[]> result = rockPaperScissors(5);
        for (String[]arr:result){
            for (String str:arr){
                System.out.print(str+" ");
            }
            System.out.println();
        }
    }
}
