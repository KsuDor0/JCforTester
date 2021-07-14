package lesson6_1;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;



public class Main {
    private final static String HOST = "api.openweathermap.org";
    private final static String DATA = "data";
    private final static String VERSION = "2.5";
    private final static String FORECAST = "forecast";
    private final static String CITY = "Saint Petersburg";
    private final static String APPID =  "0c756b426b4a789928817a84761c6958";
    private final static String METRIC = "metric";

    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();

        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host(HOST)
                .addPathSegment(DATA)
                .addPathSegment(VERSION)
                .addPathSegment(FORECAST)
                .addQueryParameter("q", CITY)
                .addQueryParameter("appid", APPID)
                .addQueryParameter("units", METRIC)
                .build();
        System.out.println(url);
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        String body = Objects.requireNonNull(response.body()).string();
        System.out.println(body);
    }
}
