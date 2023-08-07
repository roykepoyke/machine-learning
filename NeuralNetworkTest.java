package MachineLearning;

import MachineLearning.Libraries.NeuralNetwork;

public class NeuralNetworkTest {
    public static void main(String args[]) {
        int layerSizes[] = {2, 4, 1};
        NeuralNetwork nn = new NeuralNetwork(layerSizes);
        nn.setLearningRate(1);

        double[][] inputs = {{0, 0}, {1, 0}, {0, 1}, {1, 1}};
        double[][] targets = {{0}, {1}, {1}, {0}};
        int training = 10000;

        for (int i = 0; i < training; i++){
            nn.train(inputs[i % inputs.length], targets[i % inputs.length]);
        }

        double success = 0;
        int guessing = 100;
        double error = 0;

        // predict 100 tests
        for (int i = 0; i < guessing; i++) {
            double[] answer = nn.predict(inputs[i % inputs.length]);

            for (int j = 0; j < answer.length; j++) {
                error += Math.abs(targets[i % inputs.length][j] - answer[j]);
                if (Math.round(answer[j]) == targets[i % inputs.length][j]){
                    success++;
                }
            }
        }

        nn.mapPrint();
        nn.infoPrint(training, guessing, success, error);
        nn.weightsPrint();

        //NeuralNetwork nn2 = NeuralNetwork.copy(nn);
    }
}
