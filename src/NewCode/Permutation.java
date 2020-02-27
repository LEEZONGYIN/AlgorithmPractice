package NewCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutation {

    public ArrayList<String> Permutation(String str) {

        char[] ch = str.toCharArray();
        ArrayList<String> list = new ArrayList<>();
        if (str!=null&&str.length()>0){
            PermutationHelper(ch,0,list);
            Collections.sort(list);

        }
        return list;

    }

    public static void PermutationHelper(char[] ch,int i,ArrayList<String> list){
        if (i == ch.length-1){
            String str = String.valueOf(ch);
            if (!list.contains(str)){
                list.add(str);
            }
        }else {
            for (int j = i;j<ch.length;j++){
                swap(ch,i,j);
                PermutationHelper(ch,i+1,list);
                swap(ch,i,j);
            }
        }
    }

    public static void swap(char[] ch,int i,int j){
        char temp  = ch[i];
        ch[i] = ch[j];
        ch[j]= temp;
    }

    public static void main(String[] args) {
        Permutation p = new Permutation();
        System.out.println(p.Permutation("abc").toString());
    }

}
