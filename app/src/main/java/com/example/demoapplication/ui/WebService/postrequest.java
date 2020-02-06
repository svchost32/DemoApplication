package com.example.demoapplication.ui.WebService;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class postrequest {
    public String dataget() throws IOException {
        URL url = new URL("http://192.168.1.243:8989/webservice");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type","");

        return null;
    }
}
