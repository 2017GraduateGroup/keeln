package com.keeln.mappertest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by keeln on 17/3/13.
 */
//@RunWith(SpringRunner.class)
//@SpringBootApplication
//@SpringBootTest
public class UserMapperTest {

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
            // System.out.println("同时 从这里也能看出 即便return了，仍然会执行finally的！");
        }
    }

    public static void main(String[] args) throws IOException, JSONException {
        JSONObject json = readJsonFromUrl("http://apis.haoservice.com/lifeservice/travel/scenery?key=4957925b82a8489c8d57a38dc205302c&pid=32&cid=&page=1&paybyvas=false");
        System.out.println(json.toString());
        System.out.println(((JSONObject) json.get("content")).get("address"));
    }
}
