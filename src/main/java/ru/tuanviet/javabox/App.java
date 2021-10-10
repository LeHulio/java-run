package ru.tuanviet.javabox;

import java.io.IOException;
import java.util.List;

public class App {
    private final static int COUNT = 3;

    private static void print(List<String> nameList, List<String> nounList) {
        for (int i = 0; i < COUNT; i++) {
            System.out.println(GenerateRandomFullNames.generateRandomFullName(nameList, nounList));
        }
    }

    public static void main(String[] args) throws IOException {

        OkHttpResponse responseName = new OkHttpResponse("https://api.npoint.io/f744aa71f0b7c142f0fd");
        OkHttpResponse responseNoun = new OkHttpResponse("https://api.npoint.io/a742b65192a1e1e22858");
        NamesParser name = new NamesParser();
        NounsParser noun = new NounsParser();
        List<String> nameList = name.responseToList(responseName.getNameResponse());
        List<String> nounList = noun.responseToList(responseNoun.getNameResponse());
        print(nameList, nounList);

    }


}
