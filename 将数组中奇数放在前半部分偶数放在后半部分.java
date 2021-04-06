输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

 

class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        //左右上下，l,r,t,b;
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while(true) {
            //打印第一行
            for(int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right.
            //若上边界大于了下边界，则打印完毕，否则t往下移动一行
            if(++t > b) break;

            //打印最右边一行
            for(int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
            //若左边界大于了右边界，则打印完毕，否则r往左移动一行
            if(l > --r) break;

            //打印最下边一行
            for(int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
            //若下边界大于了上边界，则打印完毕，否则b往上移动一行
            if(t > --b) break;

            //打印最左边一行
            for(int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top.
            //若左边界大于了有边界，则打印完毕，否则l往右移动一行
            if(++l > r) break;
        }
        return res;
    }
}

