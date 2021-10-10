package ru.tuanviet.javabox;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class OkHttpResponse implements OkHttpGetResponse {
    private final String nameResponse;

    public OkHttpResponse(String adress) throws IOException {
        this.nameResponse = getResponse(adress);
    }

    @Override
    public String getResponse(String adress) throws IOException {
        OkHttpClient client = new OkHttpClient()
                .newBuilder()
                .connectTimeout(40, TimeUnit.SECONDS)
                .readTimeout(40, TimeUnit.SECONDS)
                .writeTimeout(40, TimeUnit.SECONDS)
                .build();
        String url = HttpUrl
                .parse(adress)
                .newBuilder()
                .build()
                .toString();
        Request request = new Request
                .Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        String responseBody = response.body().string();
        return responseBody;
    }

    public String getNameResponse() {
        return nameResponse;
    }
}
