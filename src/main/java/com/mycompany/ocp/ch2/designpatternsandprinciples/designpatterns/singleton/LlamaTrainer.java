package com.mycompany.ocp.ch2.designpatternsandprinciples.designpatterns.singleton;

public class LlamaTrainer {
    public boolean feedLamas(int numberOfLamas) {
        int amountNeeded = 5 * numberOfLamas;
        HayStorage hayStorage = HayStorage.getInstance();
        if (hayStorage.getQuantity() < amountNeeded) {
            hayStorage.addHay(amountNeeded + 10);
        }
        boolean fed = hayStorage.removeHay(amountNeeded);
        if (fed) System.out.println("Llamas have been fed");
        return fed;
    }

    public static void main(String[] args) {
        new LlamaTrainer().feedLamas(5);
    }
}
