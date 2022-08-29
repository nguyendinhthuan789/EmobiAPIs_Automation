package emobi.apis.utilities;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Randoms {
    private static int randUpperRange = 9999;

    public static int generateRandomInt() {
        Random random = new Random();
        return random.nextInt(randUpperRange);
    }

    public static int generateRandomIntIntRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static double generateRandomDouble() {
        Random random = new Random();
        return random.nextDouble();
    }

    public static float generateRandomFloat() {
        Random random = new Random();
        return random.nextFloat();
    }

    public static int getRandomNumberInts(int min, int max) {
        Random random = new Random();
        return random.ints(min, (max + 1)).findFirst().getAsInt();
    }

    public static void getStreamOfRandomIntsWithRange(int num, int min, int max) {
        Random random = new Random();
        random.ints(num, min, max).sorted().forEach(System.out::println);
    }

    public static double getRandomIntegerBetweenRange(double min, double max) {
        double x = (int) (Math.random() * ((max - min) + 1)) + min;
        return x;
    }

    public static double getRandomDoubleBetweenRange(double min, double max) {
        double x = (Math.random() * ((max - min) + 1)) + min;
        return x;
    }

    public static double getRandomNumber() {
        double x = Math.random();
        return x;
    }

    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }

    public static String randomString() {
        int lenght = 21;
        String text = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(lenght);
        for (int i = 0; i < lenght; i++)
            sb.append(text.charAt(rnd.nextInt(text.length())));
        return sb.toString();
    }

    public static String randomStringInList(List<String> myList) {
        Random r = new Random();
        int randomitem = r.nextInt(myList.size());
        String randomElement = myList.get(randomitem);
        return randomElement;
    }

    public static void main(String[] args) {
        System.out.println("1111: " + randomString());
    }
}
