package MachineLearning;

import java.util.Random;

import MachineLearning.Libraries.Neuron;

public class NeutronTest {
    public static void main(String args[]) {
        point[] training = new point[100000];
        
        Neuron neuron = new Neuron(2, 0.5);

        for (int i = 0; i < training.length; i++) {
            double x = 2 * new Random().nextDouble() - 1;
            double y = 2 * new Random().nextDouble() - 1;
            double b = 1;
            int answer = 1;
            if (y < f(x)) {
                answer = 0;
            }
            double[] inputs = {x, y, b};
            training[i] = new point(inputs, answer);
            neuron.train(training[i].input(), training[i].output());
        }

        double success = 0.0;

        for (int i = 0; i < training.length; i++) {
            double guess = neuron.feedforward(training[i].input());
            if (Double.compare(guess, Double.valueOf(0.5)) > 0.5 && training[i].output() > 0.5 || Double.compare(guess, Double.valueOf(0.5)) < 0.5 && training[i].output() < 0.5){
                success++;
            }
        }
        System.out.println(success/training.length);
        neuron.printFormulaEstimate();
    }

    public static double f(double x){
        return(3*x+0.4);
    }
}

class point {
    double[] inputs;
    int answer;
    public point(double[] i, int a){
        inputs = i;
        answer = a;
    }

    public double[] input() {
        return inputs;
    }

    public int output() {
        return answer;
    }
}