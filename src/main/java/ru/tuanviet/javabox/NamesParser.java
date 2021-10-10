package ru.tuanviet.javabox;

import com.google.gson.Gson;

import java.util.List;

public class NamesParser implements ParseToListInterface {

    @Override
    public List<String> responseToList(String responseName) {
        Gson gson = new Gson();
        NamesResponse list = gson.fromJson(responseName, NamesResponse.class);
        return list.getNames();

    }
}
