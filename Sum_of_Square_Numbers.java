//Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.

// https://leetcode.com/problems/sum-of-square-numbers/description/?envType=daily-question&envId=2024-06-17


public class Sum_of_Square_Numbers{
    // here we know that, numbers(a and b) cant go beyond c,  and to satisfy   given condition, so just using two pointers technique.
    public boolean judgeSquareSum(int c) {
        
        if(c <= 2){
            return true;
        }
        long si = 0;// starting value of inary search
        long ei = (long)Math.sqrt(c);// ending value of binary search

        while(si <= ei){
            // just checking the conditions 
            if(si*si + ei*ei == c){
                return true;
            }
            else if(si*si + ei*ei < c){
                si++;
            }
            else{
                ei--;
            }
        }

        return false;
    }
}
