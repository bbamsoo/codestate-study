package coplit;

public class Ocean {
    public static long ocean(int target, int[] type) {
        // TODO:
        long[]bag = new long[target+1];
        bag[0]=1;
        for(int i=0;i<type.length;i++){
            for(int j=1;j<=target;j++){
                if(type[i]<=j){
                    bag[j]+=bag[j-type[i]];
                }
            }
        }
        return bag[target];
    }

    public static void main(String[] args) {
        System.out.println(ocean(30,new int[]{5,6,7}));
    }
}
