package swordoffer;

/**
 * 给定一个二维数组 nxn
 * 从左到右递增
 * 从上到下递增
 * 找到该矩阵中的一个数
 *
 */
public class TwoDimensionsArraySearch {
    public boolean Find(int target, int [][] array) {
        if (array != null && array.length > 0 && array[0].length > 0){
            int yLength = array.length;
            int xLength = array[0].length;

            //init start position.
            int x = 0;
            int y = yLength - 1;
            while(x < xLength && y >= 0) {
                if (array[y][x] > target) {
                    y--;

                } else if (array[y][x] < target) {
                    x++;
                } else {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    public static void main(String args[]) {
        int[][] r = new int [0][1];
        TwoDimensionsArraySearch t = new TwoDimensionsArraySearch();
        t.Find(1, r);

    }

}
