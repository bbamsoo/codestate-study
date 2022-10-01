package coplit;

public class Barcode {
    public static String barcode(int len) {
        // TODO:
        return aux("",len);
    }
    public static String aux(String str, int len){
        String chr="123";
        if(str.length()==len) return str;

        for(int i=0;i<chr.length();i++){
            String cur=str+chr.charAt(i);
            if(isValid(cur)){
                String founded=aux(cur,len);
                if(founded!=null) return founded;
            }
        }
        return null;
    }
    public static boolean isValid(String str){
        StringBuffer sb = new StringBuffer(str);
        String reverse = sb.reverse().toString();

        int half=(int)Math.floor((double)str.length()/2);
        for(int i=1;i<=half;i++){
            if(reverse.substring(0,i).equals(reverse.substring(i,i+i))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(barcode(4));
    }
}
