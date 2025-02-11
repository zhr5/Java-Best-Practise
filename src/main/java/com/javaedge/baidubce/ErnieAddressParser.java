package com.javaedge.baidubce;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ErnieAddressParser {

    // 百度智能云的 ERNIE API 地址   https://aip.baidubce.com/rpc/2.0/nlp/v1/address
    private static final String ERNIE_API_URL = "https://aip.baidubce.com/rpc/2.0/ai_custom/v1/wenxinworkshop/chat/completions";

    // 获取 Access Token 的 URL
    private static final String AUTH_URL = "https://aip.baidubce.com/oauth/2.0/token";

    // 你的 API Key 和 Secret Key
    private static final String API_KEY = "your_api_key";
    private static final String SECRET_KEY = "your_secret_key";

    // 获取 Access Token
    public static String getAccessToken() {
        try {
            String url = AUTH_URL + "?grant_type=client_credentials&client_id=" + API_KEY + "&client_secret=" + SECRET_KEY;
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JSONObject jsonResponse = new JSONObject(response.toString());
            return jsonResponse.getString("access_token");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 调用 ERNIE API 解析地址
    public static String parseAddressWithErnie(String address, String accessToken) {
        try {
            // 构建请求体
            JSONObject requestBody = new JSONObject();
            requestBody.put("messages", new JSONArray()
                    .put(new JSONObject().put("role", "user").put("content", "解析以下地址：" + address))
            );

            // 发送 POST 请求
            HttpURLConnection connection = (HttpURLConnection) new URL(ERNIE_API_URL + "?access_token=" + accessToken).openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = requestBody.toString().getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // 读取响应
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // 解析响应
            JSONObject jsonResponse = new JSONObject(response.toString());
            return jsonResponse.getJSONArray("choices")
                    .getJSONObject(0)
                    .getJSONObject("message")
                    .getString("content");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        // 获取 Access Token
        String accessToken = getAccessToken();
        if (accessToken == null) {
            System.out.println("Failed to get access token.");
            return;
        }

        // 待解析的地址
        String address = "深圳市宝安区xx大道xx小区1号楼2单元101";

        // 调用 ERNIE API 解析地址
        String result = parseAddressWithErnie(address, accessToken);
        System.out.println("解析结果：" + result);
    }
}
