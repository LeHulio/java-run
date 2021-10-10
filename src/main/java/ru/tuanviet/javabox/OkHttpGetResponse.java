package ru.tuanviet.javabox;

import java.io.IOException;

public interface OkHttpGetResponse {
    String getResponse(String url) throws IOException;
}
