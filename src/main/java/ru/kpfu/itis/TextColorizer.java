package ru.kpfu.itis;

public class TextColorizer {

    public static final String RESET = "\033[0m";
    public static final String BLACK = "\033[0;30m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String BLUE = "\033[0;34m";
    public static final String PURPLE = "\033[0;35m";
    public static final String CYAN = "\033[0;36m";
    public static final String WHITE = "\033[0;37m";

    // Методы для печати текста определенного цвета
    public static String makeRed(String text) {
        return RED + text + RESET;
    }

    public static String makeGreen(String text) {
        return GREEN + text + RESET;
    }

    public static String makeYellow(String text) {
        return YELLOW + text + RESET;
    }

    public static String makeBlue(String text) {
        return BLUE + text + RESET;
    }

    public static String makePurple(String text) {
        return PURPLE + text + RESET;
    }

    public static String makeCyan(String text) {
        return CYAN + text + RESET;
    }

    public static String makeWhite(String text) {
        return WHITE + text + RESET;
    }
}
