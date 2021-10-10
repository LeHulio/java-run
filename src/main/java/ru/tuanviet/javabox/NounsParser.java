package ru.tuanviet.javabox;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class NounsParser implements ParseToListInterface {

    public NounsParser() {
    }

    @Override
    public List<String> responseToList(String responseNoun) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<String>>() {
        }.getType();
        List<String> list = gson.fromJson(responseNoun, listType);
        return list;
    }


}
