package com.deteccaofraude;

import java.util.Random;

public class FraudeDetector {
    public static boolean isFraudulent(double valor, boolean internacional) {
        if (valor > 10000 || internacional) {
            return true;
        }
        // Simulação aleatória de fraude
        return new Random().nextInt(10) == 0;
    }
}
