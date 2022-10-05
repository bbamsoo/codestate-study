package coplit;
import java.util.*;

public class Chicken {
    public static ArrayList<Integer[]> newChickenRecipe(int[] stuffArr, int choiceNum) {
        // TODO:
        ArrayList<Integer> freshArr = new ArrayList<>();
        for(int i=0;i<stuffArr.length;i++){
            String str=String.valueOf(stuffArr[i]);
            int[]element=str.chars().filter(c->c=='0').toArray();
            if(element.length<=2){
                freshArr.add(stuffArr[i]);
            }
        }
        Collections.sort(freshArr);
        if(freshArr.size()==0||freshArr.size()<choiceNum) return null;

        ArrayList<Integer[]>result = new ArrayList<>();
        boolean[]visited = new boolean[freshArr.size()];

        return perm(choiceNum,new Integer[]{},result,freshArr,visited,0);
    }
    public static ArrayList<Integer[]> perm(int choiceNum, Integer[] bucket, ArrayList<Integer[]> result, ArrayList<Integer> freshArr, boolean[] visited, int depth){
        if(depth==choiceNum){
            result.add(bucket);
            return result;
        }
        for(int i=0;i<freshArr.size();i++){
            if(!visited[i]){
                visited[i]=true;
                Integer[]concat=Arrays.copyOf(bucket,bucket.length+1);
                concat[concat.length-1]=freshArr.get(i);
                result=perm(choiceNum,concat,result,freshArr,visited,depth+1);
                visited[i]=false;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer[]>result = newChickenRecipe(new int[]{11, 1, 10, 1111111111, 10000},4);
        for (Integer[]arr:result){
            for(int num:arr){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
}
