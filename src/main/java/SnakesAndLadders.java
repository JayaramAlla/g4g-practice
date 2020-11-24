import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SnakesAndLadders {
    /*
     * created by Jayaram on 11/07/20
     */
    //0, 0, 0, 0 , 0 , 90, 0 ,3 ,12
    public int getMinNumberRolls(int[] board){
        int rolls = 1;
        Queue<Integer> currentLevel = new LinkedList();
        currentLevel.add(1);
        currentLevel.add(2);
        currentLevel.add(3);
        currentLevel.add(4);
        currentLevel.add(5);
        currentLevel.add(6);

        int size ;
        Set<Integer> traveresedIndexes = new HashSet<>();
        while(true){//0 0 0 0 0 0
            int i = 0;
            size = currentLevel.size();
            while(i < size){

                Integer val = (Integer) ((LinkedList) currentLevel).pop();
                if(val.equals(99)){
                    return rolls;
                }
                traveresedIndexes.add(val);
                if(board[val]> 0){
                    if(board[val] == 99){
                        return rolls;
                    }
                    if(!traveresedIndexes.contains(board[val])){
                        ((LinkedList<Integer>) currentLevel).add(board[val]);
                    }

                } else{

                    for(int j = 1;j< 6;j++){
                        if(traveresedIndexes.contains(val+j)){
                            currentLevel.add(val+j);
                        }
                    }
                }
                i++;
            }
            rolls++;
        }
    }

    public static void main(){
        int[] board = new int[100];
        board[5] = 90;
    }
}
