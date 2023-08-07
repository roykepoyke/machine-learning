package MachineLearning;

import MachineLearning.Libraries.Matrix;

public class FeatureTest {
    public static void main(String[] args) {
        Matrix M1 = new Matrix(3, 3);
        Matrix M2 = new Matrix(3, 3);
        Matrix result = new Matrix(3, 3);
        
        for (int i = 0; i < M1.rows; i++){
            for (int j = 0; j < M1.cols; j++){
                M1.data[i][j] = i + 1;
                M2.data[i][j] = i + 1;
            }
        }
        //result = Matrix.sub(M1, M2);
        M1.print();
        M2.print();
        result = Matrix.multiply(M1, M2);
        result.print();
        
        //result.print();
    }
}