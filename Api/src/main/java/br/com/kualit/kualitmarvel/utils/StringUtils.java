package br.com.kualit.kualitmarvel.utils;

public class StringUtils {

    private StringUtils(){}

    public static  String concat(String ... words) {
        var result = new StringBuilder();
        for (String word : words)
            result.append(word);
        return result.toString();
    }
}
