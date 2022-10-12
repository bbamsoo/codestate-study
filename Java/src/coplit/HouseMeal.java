package coplit;
import java.util.*;

public class HouseMeal {
    public static ArrayList<String[]> missHouseMeal(String[] sideDishes) {
        // TODO:
        Stack<String> stack = new Stack<>();
        ArrayList<String[]>result = new ArrayList<>();
        Arrays.sort(sideDishes);
        result=search(stack,0,sideDishes,result);
        result.sort((o1,o2)->Arrays.toString(o1).compareTo(Arrays.toString(o2)));

        return result;
    }
    public static ArrayList<String[]>search(Stack<String>stack,int idx,String[]sideDishes,ArrayList<String[]>result){
        if(idx>=sideDishes.length){
            String[]arr=stack.toArray(new String[0]);
            result.add(arr);
            return result;
        }
        else{
            stack.push(sideDishes[idx]);
            search(stack,idx+1,sideDishes,result);
            stack.pop();
            search(stack,idx+1,sideDishes,result);
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<String[]> output = missHouseMeal(new String[]{"egg", "kimchi", "fishSoup"});
        for (String[] arr:output){
            for (String str:arr){
                System.out.print(str+" ");
            }
            System.out.println();
        }
    }
}
