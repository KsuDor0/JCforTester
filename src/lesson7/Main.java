package lesson7;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.util.Scanner;


public class Main {

    private final CloseableHttpClient httpClient = HttpClients.createDefault();
    private static String result;
    private static final String api = "&appid=0c756b426b4a789928817a84761c6958";
    public static String weatherFiveDay = "http://api.openweathermap.org/data/2.5/forecast?q=";
    public static void main(String[] args) throws Exception {

        Main obj = new Main();
        Scanner in = new Scanner(System.in);

        while (true){
            System.out.print("Введите город: ");
            StringBuilder sb = new StringBuilder(weatherFiveDay + in.nextLine() + api + "&units=metric");
            try {
                obj.sendGet(sb.toString());
            } catch(Exception ex) {
                System.out.println(ex.getMessage());
            }

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            if (result.contains("404")) {
                System.out.println("city not found");
            } else {
                WeatherResponse weatherResponse = gson.fromJson(result, WeatherResponse.class);
                String cod = weatherResponse.getCod();
                System.out.println(cod);
                for (WeatherResponse.WeatherList el : weatherResponse.getList()) {
                    System.out.printf("В городе %s на дату %s ожидается %s, температура - %s%n", weatherResponse.getCity().getName(), el.getDtTxt(), el.getWeather().get(0).getDescription(), el.getMain().getTemp());
                }
                System.out.println("Продолжить? Да(y)/Нет(n)");
                String cont = in.nextLine();
                if (cont.equals("n")) {
                    break;
                }
            }
        }
        in.close();
        obj.close();
    }

    private void close() throws IOException {
        httpClient.close();
    }

    private void sendGet(String api) throws Exception {

        HttpGet request = new HttpGet(api);

        try (CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
            }

        }
    }
}
