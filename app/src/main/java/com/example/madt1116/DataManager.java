package com.example.madt1116;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class DataManager {

    public static ArrayList<String> getRateFromECB() throws IOException {
        String rate = "Data were not retrieved";
        ArrayList<String> arrayList = new ArrayList<>();

        InputStream stream = downloadUrl(Constants.ECB_URL);
        try {
            //rate = XmlParser.getRateFromECB(stream, currencyCode);
            arrayList = XmlParser.getRateFromECB(stream);
        }
        finally {
            if (stream != null) {
                stream.close();
            }
        }
        return arrayList;
        //return rate;
    }

    private static InputStream downloadUrl(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000);
        conn.setConnectTimeout(15000);
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        conn.connect();
        return conn.getInputStream();
    }
}
