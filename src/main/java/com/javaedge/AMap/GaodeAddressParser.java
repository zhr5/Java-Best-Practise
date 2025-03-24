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
/*

针对地址标准化与匹配需求，当前主流方案可分为三类，以下是具体方案对比和实现建议：

        一、**推荐组合方案**（高德API+大模型）
        ```java
// 组合调用示例
public static AddressStandardization standardizeAddress(String rawAddress, String amapKey) {
        // 高德基础解析
        JSONObject amapResult = new JSONObject(gaodeAddressParser(rawAddress, amapKey));

        // 阿里云智能地址解析（需开通服务）
        String aliCloudResult = AliAddressParser.advancedParse(rawAddress);

        // 大模型兜底处理
        if (!isValid(amapResult) || !isValid(aliCloudResult)) {
        return callLLMStandardization(rawAddress); // 调用大模型API
        }

        return mergeResults(amapResult, aliCloudResult);
        }
        ```


        二、**主流服务对比**

        | 服务商       | 服务名称                  | 特点                                       | 适用场景                 | 接口示例                     |
        |------------|-----------------------|------------------------------------------|----------------------|--------------------------|
        | 高德地图       | 地址标准化API              | 地理精度高，支持逆地理编码                          | 需要坐标匹配的场景           | `geocode/geo`            |
        | 阿里云        | 智能地址解析               | 支持楼栋/单元级解析，专攻中文地址                     | 房产/物流领域             | `aligenie/address/parse` |
        | 百度地图       | 地址理解服务               | 支持地址成分分析，兼容非常规表述                      | 非结构化地址处理           | `place/v1/address`       |
        | 腾讯位置服务     | 地址模糊匹配               | 容错性强，支持相似度评分                          | 数据清洗场景             | `ws/geocoder/v1`         |
        | 通义千问大模型    | 定制化地址解析              | 通过prompt工程实现灵活解析                        | 非标地址处理             | 需自行封装API调用             |
        | 菜鸟地址服务     | 物流地址库（需企业合作）         | 覆盖全国95%以上小区，实时更新                      | 电商/物流行业            | 非公开API                 |

        三、**大模型定制方案**
        ```python
        # 通义千问地址解析示例（Python伪代码）
        def qwen_address_parse(address):
        prompt = """请将以下地址按要素拆分，输出JSON格式：
    {省}|{市}|{区}|[街道/镇]|{小区}|[楼栋]|[单元]|[房号]
    输入地址：{}""".format(address)

        response = dashscope.Generation.call(
        model='qwen-max',
        prompt=prompt
        )
        return parse_response(response)
        ```


        四、**实施建议**
        1. **服务选型原则**
        - 日均调用量<1万次：直接使用高德/阿里云现成API
        - 数据敏感性高：采用本地化部署的NLP模型（如阿里云PAI-LLM）
        - 需要楼栋级精度：组合使用菜鸟地址库+大模型修正

        2. **性能优化技巧**
        ```java
// 缓存层实现示例
public class AddressCache {
    private static LoadingCache<String, AddressStandardization> cache =
            CacheBuilder.newBuilder()
                    .maximumSize(100000)
                    .expireAfterWrite(24, TimeUnit.HOURS)
                    .build(new CacheLoader<String, AddressStandardization>() {
                        public AddressStandardization load(String key) {
                            return standardizeAddress(key, apiKey);
                        }
                    });
}
   ```


           3. **成本控制方案**
           - 优先处理低置信度结果（仅对匹配度<80%的数据调用大模型）
        - 采用异步批处理接口（如阿里云批量地址解析支持50条/请求）
        - 对静态数据建立预处理索引库

        **注意事项**：
        1. 使用高德/百度等地图服务需遵守其《地理信息使用协议》
        2. 大模型处理地址时建议添加格式校验层（防止幻觉数据）
        3. 涉及个人住址信息需符合《个人信息保护法》要求*/
