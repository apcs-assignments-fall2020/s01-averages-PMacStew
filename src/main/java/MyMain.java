public class MyMain {

    // Returns the mean of the 2D array mat
    public static double mean(double[][] mat) { 
        double total = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) 
                total += mat[i][j];
        }
        return total / (mat.length * mat[0].length);
    }

    // Returns the median of the 2D array mat
    public static double median(double[][] mat) { 
        if (mat.length % 2 == 0) 
            return (mat[mat.length / 2 - 1][mat[0].length - 1] + mat[mat.length / 2][0]) / 2;
        else {
            if (mat[0].length % 2 == 0)
                return (mat[(mat.length - (mat.length % 2)) / 2][mat[0].length / 2 - 1] + mat[(mat.length - (mat.length % 2)) / 2][mat[0].length / 2]) / 2;
            else
                return mat[(mat.length - (mat.length % 2)) / 2][(mat.length - (mat.length % 2)) / 2];
        }
    }
    

    // Returns the mode of the 2D array mat
    public static double mode(double[][] mat) { 
        int count = 0;
        int[][] amounts = new int[mat.length * mat[0].length][3];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                count = 0;
                for (int k = 0; k < mat.length; k++) {
                    for (int l = 0; l < mat[0].length; l++) {
                        if (mat[i][j] == mat[k][l])
                            count++;
                    }
                }
                amounts[i * mat.length + j][0] = count;
                amounts[i * mat.length + j][1] = i;
                amounts[i * mat.length + j][2] = j;
            }
        }
        int[] max = {amounts[0][0], 0, 0};
        for (int i = 0; i < mat.length; i++) {
            if (Math.max(amounts[i][0], max[0]) == amounts[i][0]) {
                max[0] = amounts[i][0];
                max[1] = amounts[i][1];
                max[2] = amounts[i][2];
            }
        }
        return mat[max[1]][max[2]];
    }


    public static void main(String[] args) {
        // Write some code here to test your methods!
    }
}
