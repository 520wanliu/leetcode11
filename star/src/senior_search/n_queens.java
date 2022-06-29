package senior_search;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName n_queens
 * @Description TODO
 * @Author 橙子
 * @Date 2022-05-17 17:07
 * @Version 1.0
 */

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<Integer> lie = new ArrayList<>();
        List<Integer> pie = new ArrayList<>();
        List<Integer> na = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        _nqueens(0,n,lie,pie,na,res);
        return res;
    }
    public void _nqueens(int hang ,int n ,List<Integer> lie,List<Integer> pie ,List<Integer> na,List<List<String>> res){
        //terminate
        if(lie.size()==n && pie.size()==n && na.size()==n){
            //存放中间结果
            List<String> list = new ArrayList<>();
            for(int j=0; j<n; j++){
                String str = "";
                //对回溯寻找到的点所在的列之前和之后赋值字符串“.”，对当前所在的列赋值字符串“Q”
                for(int k = 0; k<lie.get(j); k++){
                    str += ".";
                }
                str+="Q";
                for(int k=0;k<n-lie.get(j)-1;k++){
                    str+=".";
                }

                list.add(str);
            }
            res.add(list);
            return;
        }
        //process
        //drill down
        for(int i=0;i<n;i++){
            //循环遍历每列，若当前点所在的列及对角线都没有皇后，可选，否则跳过
            boolean a = !lie.contains(i);
            boolean b = !pie.contains(i+hang);
            boolean c = !na.contains(hang-i);
            if(!lie.contains(i)&&!pie.contains(i+hang)&&!na.contains(hang-i)){
                lie.add(i);
                pie.add(i+hang);
                na.add(hang-i);
                _nqueens(hang+1,n,lie,pie,na,res);
                lie.remove((Integer)i);
                pie.remove((Integer)(i+hang));
                na.remove((Integer)(hang-i));
            }
        }
        // reverse
    }
}
