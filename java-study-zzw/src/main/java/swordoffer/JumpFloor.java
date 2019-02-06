package swordoffer;

public class JumpFloor {
    public int JumpFloor(int target) {
        if(target < 1){
            return 0;
        } else if (target == 1){
            return 1;
        } else {
            int pStart = 1;
            int pEnd = 2;
            while (target-- > 2){
                pEnd += pStart;
                pStart = pEnd - pStart;
            }
            return pEnd;
        }
    }


    //f(n) = f(1) + f(2) + ... + f(n-1) +1
    public int JumpFloorII(int target) {
        return 1 << target - 1;
    }
}
