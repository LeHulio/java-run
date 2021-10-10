package ru.tuanviet.javabox;

import java.util.List;
import java.util.Locale;

public class GenerateRandomFullNames {

    public static String generateRandomFullName(List<String> name, List<String> noun) {
        int indexName = (int) (Math.random() * (name.size() - 1));
        int indexNoun = (int) (Math.random() * (noun.size() - 1));

        String nameStr = name.get(indexName).toLowerCase(Locale.ROOT);
        String nounStr = noun.get(indexNoun).toLowerCase(Locale.ROOT);

        StringBuilder fullNameBuilder = new StringBuilder();
        String fullName = fullNameBuilder
                .append(getValidName(nameStr))
                .append(" ")
                .append(getValidName(nounStr)).toString();


        return fullName;
    }

    private static String getValidName(String name) {
        StringBuilder nameBuilder = new StringBuilder();
        nameBuilder.append(name.substring(0, 1).toUpperCase(Locale.ROOT))
                .append(name.substring(1));
        return nameBuilder.toString();
    }
}
