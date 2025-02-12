package com.javaedge.AMap;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GaodeAddressParser {

    // 高德地图地址解析方法
    public static String gaodeAddressParser(String address, String apiKey) {
        try {
            // 构建请求URL
            String urlString = "https://restapi.amap.com/v3/geocode/geo?address=" + address + "&key=" + apiKey;
            URL url = new URL(urlString);

            // 发送HTTP GET请求
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // 读取响应
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // 解析JSON响应
            JSONObject jsonResponse = new JSONObject(response.toString());
            if (jsonResponse.getString("status").equals("1")) {
                JSONArray geocodes = jsonResponse.getJSONArray("geocodes");
                if (geocodes.length() > 0) {
                    JSONObject firstResult = geocodes.getJSONObject(0);
                    return firstResult.toString(); // 返回结构化地址信息
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // 解析失败返回null
    }

    public static void main(String[] args) {
        String address = "潮州市湘桥区金马大道与金碧路交界处北侧裕和天地花园六幢一梯401号";
        String address1 = "潮州市湘桥区裕和天地花园-六幢-一梯-401";
        String apiKey = "fe44ee04444d1a19ba56d2f9a172fa4e"; // 替换为你的高德API Key

        // 调用地址解析方法
        String result = gaodeAddressParser(address, apiKey);
        String result1 = gaodeAddressParser(address1, apiKey);
        System.out.println(result);
        System.out.println(result1);
    }
}

//{"country":"中国","formatted_address":"广东省潮州市湘桥区金马大道","city":"潮州市","adcode":"445102","level":"道路","building":{"name":[],"type":[]},"number":[],"province":"广东省","citycode":"0768","street":"金马大道","district":"湘桥区","location":"116.677011,23.656237","neighborhood":{"name":[],"type":[]},"township":[]}
// {"country":"中国","formatted_address":"广东省潮州市湘桥区","city":"潮州市","adcode":"445102","level":"区县","building":{"name":[],"type":[]},"number":[],"province":"广东省","citycode":"0768","street":[],"district":"湘桥区","location":"116.628343,23.675104","neighborhood":{"name":[],"type":[]},"township":[]}