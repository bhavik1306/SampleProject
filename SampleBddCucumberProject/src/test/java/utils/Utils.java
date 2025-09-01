package utils;

import java.util.Random;
import java.util.UUID;

public class Utils {

    public static String randomEmailCreation(){
        String uniqueId = UUID.randomUUID().toString();
        return String.format("user_%s@Xyz.com", uniqueId);
    }

    public static int randonNumerGenerator(){
        Random rand = new Random();
        int min = 100_000_000;
        int max = 999_999_999;
        int randomNineDigit = rand.nextInt(max - min + 1) + min;

        System.out.println("Random 9-digit number: " + randomNineDigit);
        return randomNineDigit;
    }
}
