package com.xpc.log.productor.application;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xpc.log.productor.po.LogBase;
import com.xpc.log.productor.po.SearchDisplay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.Random;

/***
 * @author Tongbo Wang
 * @date 2022/10/14 11:49 上午 周五
 * @jdk jdk1.8.0
 * @version 1.0
 ***/
/**
 * 日志行为数据模拟
 */

public class LogProductMain {

    private final static Logger logger = LoggerFactory.getLogger(LogBase.class);
    private static Random rand = new Random();


    public static void main(String[] args) {

        // 参数一：控制发送每条的延时时间，默认是0
        int delay = args.length > 0 ? Integer.parseInt(args[0].trim()) : 0;

        // 参数二：循环遍历次数
        int loop_len = args.length > 1 ? Integer.parseInt(args[1].trim()) : 1000;

        // 生成数据
        generateLog(delay, loop_len);
    }

    private static void generateLog(int delay, int loop_len) {

        for (int i = 0; i < loop_len; i++) {

            int flag = rand.nextInt(2);

            switch (flag) {
                case (0):
                    //曝光
                    SearchDisplay searchDisplay = generateDisplay();
                    String jsonString = JSON.toJSONString(searchDisplay);

                    //控制台打印
                    logger.info(jsonString);
                    break;

                case (1):

                    JSONObject json = new JSONObject();

                    json.put("common", generateComFields());

                    // 曝光信息
                    json.put("display",generateDisplay());
                    //时间
                    //long millis = System.currentTimeMillis();

                    //控制台打印
                    logger.info(json.toJSONString());
                    break;
            }

            // 延迟
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 公共字段设置
     */
    private static JSONObject generateComFields() {

        LogBase logBase = new LogBase();

        int flag;

        //生成匿名id
        logBase.setAnonymous_id(
                getRandomString(14,0)
                + "-"
                + getRandomString(15,0)
                + "-"
                + rand.nextInt(7)
                + "-"
                + getRandomString(14,0)
        );

        //生成应用信息
        int app_flag = rand.nextInt(2);
        switch (app_flag){
            case (0):
                logBase.setApp("xpc_app");
                break;
            case (1):
                logBase.setApp("xpc_web");
                break;
            case (2):
                logBase.setApp("");
                break;
        }

        //生产浏览器信息
        flag = rand.nextInt(6);
        switch (flag) {
            case (0):
                logBase.setBrowser("Chrome");
                break;
            case (1):
                logBase.setBrowser("Edge");
                break;
            case (2):
                logBase.setBrowser("Firefox");
                break;
            case (3):
                logBase.setBrowser("Opera");
                break;
            case (4):
                logBase.setBrowser("360");
                break;
            case (5):
                logBase.setBrowser("QQ");
                break;
            case (6):
                logBase.setBrowser("safari");
                break;
        }

        //debug
        flag = rand.nextInt(1);
        switch (flag) {
            case (0):
                logBase.setDebug("true");
                break;
            case (1):
                logBase.setDebug("false");
                break;
        }

        // 设备
       flag = rand.nextInt(2);
        switch (flag) {
            case 0:
                logBase.setDevice("iphone");
                break;
            case 1:
                logBase.setDevice("xiaomi");
                break;
            case 2:
                logBase.setDevice("huawei");
                break;
            case 3:
                logBase.setDevice("vivo");
                break;
            case 4:
                logBase.setDevice("oppo");
                break;
        }

        //设备id
        logBase.setDevice_id(getRandomString(32,0));

        //event 事件名称
        logBase.setEvent("sqSearchDisplay");

        //ip
        logBase.setIp(getRandomIp());

        //is_first_day
        flag = rand.nextInt(1);
        switch (flag) {
            case (0):
                logBase.setIs_first_day("true");
                break;
            case (1):
                logBase.setIs_first_day("false");
                break;
        }

        //is_first_time
        flag = rand.nextInt(1);
        switch (flag) {
            case (0):
                logBase.setIs_first_time("true");
                break;
            case (1):
                logBase.setIs_first_time("false");
                break;
        }

        //os
        flag = rand.nextInt(3);
        switch (flag){
            case 0:
                logBase.setOs("Windows");
                break;
            case 1:
                logBase.setOs("Mac OS");
                break;
            case 2:
                logBase.setOs("iphone");
                break;
            case 3:
                logBase.setOs("andirod");
                break;
        }

        //project
        logBase.setProject("test");

        //sa_id
        logBase.setSa_id(
                getRandomString(14,0)
                        + "-"
                        + getRandomString(15,0)
                        + "-"
                        + rand.nextInt(7)
                        + "-"
                        + getRandomString(14,0)
        );

        //track_id
        logBase.setTrack_id(getRandomString(9,1));

                        /*
        "verify_type": "认证机构",
        "vipType": "普通会员"
         */
        //type
        logBase.setType("track");

        //ua
        logBase.setUa("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36");

        //user_id
        logBase.setUser_id(getRandomString(8,1));

        //uuid
        logBase.setUuid(
                getRandomString(8,0)
                + "-"
                + getRandomString(4,0)
                + "-"
                + getRandomString(4,0)
                + "-"
                + getRandomString(4,0)
                + "-"
                + getRandomString(12,0)
        );

        //verify_type
        flag = rand.nextInt(3);
        switch (flag){
            case 0:
                logBase.setVerify_type("未认证");
                break;
            case 1:
                logBase.setVerify_type("认证机构");
                break;
            case 2:
                logBase.setVerify_type("认证个人");
                break;
            case 3:
                logBase.setVerify_type("未登录");
                break;
        }

        //vip_type
        flag = rand.nextInt(4);
        switch (flag){
            case 0:
                logBase.setVip_type("非会员");
                break;
            case 1:
                logBase.setVip_type("普通会员");
                break;
            case 2:
                logBase.setVip_type("超级会员");
                break;
            case 3:
                logBase.setVip_type("黑钻会员");
                break;
            case 4:
                logBase.setVip_type("未登录");
        }

        return (JSONObject) JSON.toJSON(logBase);
    }

    /**
     * 搜索曝光事件
     */
    private static SearchDisplay generateDisplay() {

        SearchDisplay searchDisplay = new SearchDisplay();

        //display_type
        searchDisplay.setDisplay_type("sqSearchDisplay");

        //item_id BT8vXDwa7fdLpO
        searchDisplay.setItem_id(
                getRandomString(14,3)
        );

        //item_type
        searchDisplay.setItem_type(
                getCONTENT()
        );

        //page_x
        searchDisplay.setPage_x(
                rand.nextInt(4)
        );

        //page_y
        searchDisplay.setPage_y(
                rand.nextInt(15)
        );

        //page_index
        searchDisplay.setPage_index(
                rand.nextInt(100)
        );

        //host
        searchDisplay.setHost("www.xinpianchang.com");

        //param
        searchDisplay.setParam("");

        //referer
        searchDisplay.setReferer("");

        //url
        searchDisplay.setUrl(
                "https://www.xinpianchang.com/search?kw="
                + getCONTENT()
                + "&from=historySearch"
        );

        //event_time
        searchDisplay.setEvent_time(
                System.currentTimeMillis()
        );


        return searchDisplay;
    }

    /**
     * 为各个事件类型的公共字段（时间、事件类型、Json数据）拼接
     */
    private static JSONObject packEventJson(String eventName, JSONObject jsonObject) {

        JSONObject eventJson = new JSONObject();

        eventJson.put("ett", (System.currentTimeMillis() - rand.nextInt(99999999)) + "");
        eventJson.put("en", eventName);
        eventJson.put("kv", jsonObject);

        return eventJson;
    }

    /**
     * 获取随机字母组合
     *
     * @param length 字符串长度
     */
    private static String getRandomChar(Integer length) {

        StringBuilder str = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            // 字符串
            str.append((char) (65 + random.nextInt(26)));// 取得大写字母
        }

        return str.toString();
    }

    /**
     * 获取随机字母数字组合
     *
     * @param length 字符串长度
     */
    private static String getRandomCharAndNumr(Integer length) {

        StringBuilder str = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {

            boolean b = random.nextBoolean();

            if (b) { // 字符串
                // int choice = random.nextBoolean() ? 65 : 97; 取得65大写字母还是97小写字母
                str.append((char) (65 + random.nextInt(26)));// 取得大写字母
            } else { // 数字
                str.append(String.valueOf(random.nextInt(10)));
            }
        }

        return str.toString();
    }

    /**
     * 生成字母+数字随机串
     * length用户要求产生字符串的长度
     */
    public static String getRandomString(int length,int flag){

        String str = null;

        int number = 0;

        Random random=new Random();

        StringBuffer sb=new StringBuffer();

        switch (flag) {
            case 0:
                str="abcdefghijklmnopqrstuvwxyz0123456789";
                for(int i=0;i<length;i++){
                    number=random.nextInt(36);
                    sb.append(str.charAt(number));
                }
                break;
            case 1:
                str = "0123456789";
                for(int i=0;i<length;i++){
                    number=random.nextInt(10);
                    sb.append(str.charAt(number));
                }
                break;
            case 2:
                str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
                for(int i=0;i<length;i++){
                    number=random.nextInt(62);
                    sb.append(str.charAt(number));
                }
                break;
        }

        return sb.toString();
    }

    /**
     * 生成单个汉字
     */
    private static char getRandomChar() {

        String str = "";
        int hightPos; //
        int lowPos;

        Random random = new Random();

        //随机生成汉子的两个字节
        hightPos = (176 + Math.abs(random.nextInt(39)));
        lowPos = (161 + Math.abs(random.nextInt(93)));

        byte[] b = new byte[2];
        b[0] = (Integer.valueOf(hightPos)).byteValue();
        b[1] = (Integer.valueOf(lowPos)).byteValue();

        try {
            str = new String(b, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println("错误");
        }

        return str.charAt(0);
    }

    /**
     * 拼接成多个汉字
     */
    private static String getCONTENT() {

        StringBuilder str = new StringBuilder();

        for (int i = 0; i < rand.nextInt(20); i++) {
            str.append(getRandomChar());
        }

        return str.toString();
    }

    /**
     * 获取随机ip
     * @return
     */
    public static String getRandomIp() {
        // 指定 IP 范围
        int[][] range = {
                {607649792, 608174079}, // 36.56.0.0-36.63.255.255
                {1038614528, 1039007743}, // 61.232.0.0-61.237.255.255
                {1783627776, 1784676351}, // 106.80.0.0-106.95.255.255
                {2035023872, 2035154943}, // 121.76.0.0-121.77.255.255
                {2078801920, 2079064063}, // 123.232.0.0-123.235.255.255
                {-1950089216, -1948778497}, // 139.196.0.0-139.215.255.255
                {-1425539072, -1425014785}, // 171.8.0.0-171.15.255.255
                {-1236271104, -1235419137}, // 182.80.0.0-182.92.255.255
                {-770113536, -768606209}, // 210.25.0.0-210.47.255.255
                {-569376768, -564133889}, // 222.16.0.0-222.95.255.255
        };

        Random random = new Random();
        int index = random.nextInt(10);
        String ip = num2ip(range[index][0] + random.nextInt(range[index][1] - range[index][0]));
        return ip;
    }

    /**
     * 将十进制转换成IP地址
     */
    public static String num2ip(int ip) {
        int[] b = new int[4];
        b[0] = (ip >> 24) & 0xff;
        b[1] = (ip >> 16) & 0xff;
        b[2] = (ip >> 8) & 0xff;
        b[3] = ip & 0xff;
        // 拼接 IP
        String x = b[0] + "." + b[1] + "." + b[2] + "." + b[3];
        return x;
    }
}
