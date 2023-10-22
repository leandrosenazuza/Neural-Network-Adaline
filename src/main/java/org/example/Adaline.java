package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Adaline {

    File file = new File("erros.txt");
    FileWriter fw = new FileWriter(file);

    BufferedWriter writer = new BufferedWriter(fw);

    DataPortOR dataPortOR = new DataPortOR();

    Weight weight = new Weight();

    double alpha = 0;

    double weightAux = 0;

    double y = 0;

    double error = 0;

    double squareError = 0;

    public Adaline() throws IOException {
    }

    public void initiateWeights() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please, input the first weight value: ");
        weight.setW1(input.nextDouble());
        System.out.print("\nPlease, input the second weight value: ");
        weight.setW2(input.nextDouble());
        System.out.print("\nPlease, input the bias value: ");
        weight.setBias(input.nextDouble());
        System.out.print("\nPlease, input the learning rate: ");
        this.alpha = input.nextDouble();
    }

    public double calculateY(double x1, double x2) {
        return x1 * weight.getW1() + x2 * weight.getW2() + weight.getBias();
    }

    public double newWeight(double deltaWeight, double oldWeight) {
        return deltaWeight + oldWeight;
    }

    public double calculateWeight(double target, double x) {
        return this.alpha * (target - this.y) * x;
    }

    public double calculateBias(double target) {
        return this.alpha * (target - this.y);
    }

    public double calculateError(double target, double y) throws IOException {
        this.writer.write(" " + this.error);
        writer.newLine();
        return target - y;
    }

    public double calculateSquareError(double error) {
        return error * error;
    }

    public double calculateNewWeight(double error) {
        return error * error;
    }

    public void executeAdaline() {
        int i = 0;
        this.initiateWeights();
        try {
            System.out.println("W1: " + weight.getW1() + "; W2: " + weight.getW2() + "; bias: " + weight.getBias());

            do {
                y = calculateY(dataPortOR.getLine1()[0], dataPortOR.getLine1()[1]);
                System.out.print("\ny: " + y);
                this.error = calculateError(dataPortOR.getLine1()[2], y);
                System.out.print("\n Simple Error: " + this.error);
                this.squareError = calculateSquareError(this.error);
                System.out.print("\n Quadratic Error: " + this.squareError);

                weight.setW1(weight.getW1() + this.calculateWeight(dataPortOR.getLine1()[2], dataPortOR.getLine1()[0]));
                weight.setW2(weight.getW2() + this.calculateWeight(dataPortOR.getLine1()[2], dataPortOR.getLine1()[1]));
                weight.setBias(this.weight.getBias() + this.calculateBias(dataPortOR.getLine1()[2]));

                y = calculateY(dataPortOR.getLine2()[0], dataPortOR.getLine2()[1]);
                System.out.print("\ny: " + y);
                this.error = calculateError(dataPortOR.getLine2()[2], y);
                System.out.print("\n Simple Error: " + this.error);
                this.squareError = calculateSquareError(this.error);
                System.out.print("\n Quadratic Error: " + this.squareError);

                weight.setW1(weight.getW1() + this.calculateWeight(dataPortOR.getLine2()[2], dataPortOR.getLine2()[0]));
                weight.setW2(weight.getW2() + this.calculateWeight(dataPortOR.getLine2()[2], dataPortOR.getLine2()[1]));
                weight.setBias(this.weight.getBias() + this.calculateBias(dataPortOR.getLine2()[2]));

                y = calculateY(dataPortOR.getLine3()[0], dataPortOR.getLine3()[1]);
                System.out.print("\ny: " + y);
                this.error = calculateError(dataPortOR.getLine3()[2], y);
                System.out.print("\n Simple Error: " + this.error);
                this.squareError = calculateSquareError(this.error);
                System.out.print("\n Quadratic Error: " + this.squareError);

                weight.setW1(weight.getW1() + this.calculateWeight(dataPortOR.getLine3()[2], dataPortOR.getLine3()[0]));
                weight.setW2(weight.getW2() + this.calculateWeight(dataPortOR.getLine3()[2], dataPortOR.getLine3()[1]));
                weight.setBias(this.weight.getBias() + this.calculateBias(dataPortOR.getLine3()[2]));

                y = calculateY(dataPortOR.getLine4()[0], dataPortOR.getLine4()[1]);
                System.out.print("\ny: " + y);
                this.error = calculateError(dataPortOR.getLine4()[2], y);
                System.out.print("\n Simple Error: " + this.error);
                this.squareError = calculateSquareError(this.error);
                System.out.print("\n Quadratic Error: " + this.squareError);

                weight.setW1(weight.getW1() + this.calculateWeight(dataPortOR.getLine4()[2], dataPortOR.getLine4()[0]));
                weight.setW2(weight.getW2() + this.calculateWeight(dataPortOR.getLine4()[2], dataPortOR.getLine4()[1]));
                weight.setBias(this.weight.getBias() + this.calculateBias(dataPortOR.getLine4()[2]));

                if ((this.squareError) < 0.255) break;

            } while (true);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\n\n\nEquação final: ");
        System.out.println("f(x) = x1*" + this.weight.getW1() + " x2*" + this.weight.getW2() + " + " + this.weight.getBias() + "\n");

    }

}
