package com.javaedge.baidubce;

import okhttp3.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class address {

    public static final String API_KEY = "ZriwdCLjcbUUSmrA9rdxrIcO";
    public static final String SECRET_KEY = "dLR24gjsmPRcUnbntujtIhDrRM6ImSqL";

    static final OkHttpClient HTTP_CLIENT = new OkHttpClient().newBuilder().build();

    public static void main(String []args) throws IOException, JSONException {
        MediaType mediaType = MediaType.parse("application/json");
        //1//RequestBody body = RequestBody.create(mediaType,  "{\"text\":\"潮州市湘桥区金马大道与金碧路交界处北侧裕和天地花园六幢一梯401号\"}");
        // 2//RequestBody body = RequestBody.create(mediaType,  "{\"text\":\"潮州市湘桥区裕和天地花园-六幢-一梯-401\"}");
        // 3//RequestBody body = RequestBody.create(mediaType,  "{\"text\":\"裕和天地花园-六幢-一梯-401\"}");
        // 4//
        // 4//RequestBody body = RequestBody.create(mediaType,  "{\"text\":\"潮州市湘桥区裕和天地花园-6幢-1梯-401\"}");
        // 5//
        //RequestBody body = RequestBody.create(mediaType,  "{\"text\":\"潮州市湘桥区裕和天地花园-6号楼-1单元-401\"}");
        RequestBody body = RequestBody.create(mediaType,  "{\"text\":\"潮州市湘桥区裕和天地花园-6号楼-1单元-101\"}");
        Request request = new Request.Builder()
                .url("https://aip.baidubce.com/rpc/2.0/nlp/v1/address?access_token=" + getAccessToken())
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        Response response = HTTP_CLIENT.newCall(request).execute();
        System.out.println(response.body().string());

    }
    //{"lat":23.663353,"detail":"金马大道与金碧路交界处北侧裕和天地花园六幢一梯401号","town":"桥东街道","phonenum":"","city_code":"445100","province":"广东省","person":"","lng":116.684338,"province_code":"440000","text":"潮州市湘桥区金马大道与金碧路交界处北侧裕和天地花园六幢一梯401号","county":"湘桥区","city":"潮州市","county_code":"445102","town_code":"445102007","log_id":1889576848184060628}
    //{"lat":23.663353,"detail":"裕和天地花园-六幢-一梯-401","town":"桥东街道","phonenum":"","city_code":"445100","province":"广东省","person":"","lng":116.684338,"province_code":"440000","text":"潮州市湘桥区裕和天地花园-六幢-一梯-401","county":"湘桥区","city":"潮州市","county_code":"445102","town_code":"445102007","log_id":1889577226990952645}
    //{"lat":0,"detail":"裕和天地花园-六幢-一梯-401","town":"花园乡","phonenum":"","city_code":"","province":"","person":"","lng":0,"province_code":"","text":"裕和天地花园-六幢-一梯-401","county":"","city":"","county_code":"","town_code":"","log_id":1889579422808143880}
    //{"lat":23.663353,"detail":"裕和天地花园-6幢-1梯-401","town":"桥东街道","phonenum":"","city_code":"445100","province":"广东省","person":"","lng":116.684338,"province_code":"440000","text":"潮州市湘桥区裕和天地花园-6幢-1梯-401","county":"湘桥区","city":"潮州市","county_code":"445102","town_code":"445102007","log_id":1889583550499472700}
    //{"lat":23.663353,"detail":"裕和天地花园-6号楼-1单元-401","town":"桥东街道","phonenum":"","city_code":"445100","province":"广东省","person":"","lng":116.684338,"province_code":"440000","text":"潮州市湘桥区裕和天地花园-6号楼-1单元-401","county":"湘桥区","city":"潮州市","county_code":"445102","town_code":"445102007","log_id":1889583937741338416}
    //{"lat":23.663353,"detail":"裕和天地花园-6号楼-1单元-101","town":"桥东街道","phonenum":"","city_code":"445100","province":"广东省","person":"","lng":116.684338,"province_code":"440000","text":"潮州市湘桥区裕和天地花园-6号楼-1单元-101","county":"湘桥区","city":"潮州市","county_code":"445102","town_code":"445102007","log_id":1889584199224950871}

    /**
     * 从用户的AK，SK生成鉴权签名（Access Token）
     *
     * @return 鉴权签名（Access Token）
     * @throws IOException IO异常
     */
    static String getAccessToken() throws IOException, JSONException {
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "grant_type=client_credentials&client_id=" + API_KEY
                + "&client_secret=" + SECRET_KEY);
        Request request = new Request.Builder()
                .url("https://aip.baidubce.com/oauth/2.0/token")
                .method("POST", body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        Response response = HTTP_CLIENT.newCall(request).execute();
        return new JSONObject(response.body().string()).getString("access_token");
    }
}

/*
    请求参数
            参数	类型	是否必选	描述
            text	string	是	待识别的文本内容，不超过1000字节
    返回参数
        参数	说明	描述
        log_id	uint64	请求唯一标识码
        text	string	原始输入的文本内容
        province	string	省（直辖市/自治区）
        province_code	string	省国标code
        city	string	市
        city_code	string	城市国标code
        county	string	区（县）
        county_code	string	区县国标code
        town	string	街道（乡/镇）
        town_code	string	街道/乡镇国标code
        person	string	姓名
        detail	string	详细地址
        phonenum	string	电话号码
        lat	float	纬度（百度坐标，仅供参考）
        Ing	float	经度（百度坐标，仅供参考）*/
