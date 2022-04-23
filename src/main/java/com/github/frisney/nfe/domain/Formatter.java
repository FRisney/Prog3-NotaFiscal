package com.github.frisney.nfe.domain;

public class Formatter {
    public static String padLeft(String subject,Integer length){
        return String.format("%1$" + length + "s", subject).replace(' ', '0');
    }
    public static String padRight(String subject,Integer length){
        return String.format("%1$-" + length + "s", subject).replace(' ', '0');
    }
}
