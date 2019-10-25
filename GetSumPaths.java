package ArraysAndStrings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GetSumPaths {
	public static List<List<Integer>> getSumPaths(int number){

        if(number == 0){
            List<List<Integer>> lls = new ArrayList<List<Integer>>();
            lls.add(new ArrayList<Integer>());
            return lls;
        }
        
        List<List<Integer>> toreturn = new ArrayList<List<Integer>>();
        for(int i = 1; i <= number; i ++){
            List<List<Integer>> llreturn = getSumPaths(number - i);
            for(List<Integer> ls : llreturn){
                ls.add(i);
                toreturn.add(ls);
            }
            
        }
        return toreturn;
    }
	public static void main(String[] args) {
System.out.println(getSumPaths(6));
	}

}
