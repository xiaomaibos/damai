package cn.ecnu.damai.util;

import cn.ecnu.damai.entity.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.common.*;
import com.arronlong.httpclientutil.exception.HttpProcessException;
import org.apache.http.Header;
import org.apache.http.HttpStatus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

/**
 * 大麦网爬取类
 *
 * @author zzzz76
 */
public class DamaiCrawler {

    private HttpClientFactory httpClientFactory = HttpClientFactory.httpClientFactory;

    // 同步爬取
    public String synCrawl(String code, Program program) {
        String errStatus = null;
        try {
            HttpResult httpResult = crawlProgram(code);
            if(httpResult.getStatusCode() == HttpStatus.SC_OK) {
                String json = RegUtil.regFind(httpResult.getResult(), "__jp0\\(([\\s\\S]*)\\)");
                transform(json, program);

                String destUrl = "../damFile/program/" + code + ".jpg";

                String savePath =  DamaiCrawler.class.getResource("/").getPath().
                        replace("WEB-INF/classes/", "damFile/program/");
                File saveDir = new File(savePath);
                if(!saveDir.exists()){
                    saveDir.mkdirs();
                }
                File file = new File(saveDir + "/" +code + ".jpg");
                downImage(program.getImage(), file);
                program.setImage(destUrl);

            } else {
                errStatus = "RESPONSE_ERROR";
            }
        } catch (HttpProcessException e) {
            e.printStackTrace();
            errStatus = "HTTP_ERROR";
        } catch (ParseException e) {
            e.printStackTrace();
            errStatus = "PARSE_ERROR";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            errStatus = "FILE_ERROR";
        }
        return errStatus;
    }

    // 爬取演出，场次，票档
    private HttpResult crawlProgram(String code) throws HttpProcessException {
        String url = "https://detail.damai.cn/subpage?apiVersion=2.0&dmChannel=pc@damai_pc&bizCode=ali.china.damai&scenario=itemsku&callback=__jp0&itemId=" + code;

        //配置Header
        Header[] headers = HttpHeader.custom()
                .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.71 Safari/537.36")
                .acceptLanguage("en-GB,en;q=0.8")
                .referer("https://detail.damai.cn/item.htm?&id=" + code)
                .build();

        //配置请求参数
        HttpConfig config = HttpConfig.custom()
                .headers(headers)
                .timeout(1000)
                .url(url)
                .encoding("utf-8")
                .client(httpClientFactory.build())
                .method(HttpMethods.GET);

        return HttpClientUtil.sendAndGetResp(config);
    }

    // 下载图片
    private void downImage(String sourUrl, File destUrl) throws HttpProcessException, FileNotFoundException {
        //配置Header
        Header[] headers = HttpHeader.custom()
                .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.71 Safari/537.36")
                .acceptLanguage("en-GB,en;q=0.8")
                .build();

        //配置请求参数
        HttpConfig config = HttpConfig.custom()
                .headers(headers)
                .timeout(1000)
                .url(sourUrl)
                .encoding("utf-8")
                .client(HttpClientFactory.httpClientFactory.build())
                .method(HttpMethods.GET)
                .out(new FileOutputStream(destUrl));

        HttpClientUtil.down(config);
    }

    // 将爬取结果转换成目标格式
    private void transform(String json, Program program) throws ParseException {
        JSONObject obj = JSON.parseObject(json);
        // 获取节目信息
        JSONObject info = obj.getJSONObject("itemBasicInfo");
        program.setTitle(info.getString("projectTitle"));

        String priceRange = info.getString("priceRange");
        String lowPrice = RegUtil.regFind(priceRange, "￥(\\d+)");
        String highPrice = RegUtil.regFind(priceRange, "- ￥(\\d+)");
        program.setLowPrice(lowPrice);
        program.setHighPrice(highPrice);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmm");
        Date startTime = simpleDateFormat.parse(info.getString("sellingStartTime"));
        Date endTime = new Date(startTime.getTime() + 48 * 3600 * 1000);
        program.setStartTime(startTime);
        program.setEndTime(endTime);

        program.setAddress(info.getString("venueName"));
        program.setImage(info.getString("mainImageUrl"));
        program.setExplain("不支持退票...");
        program.setDetail("演出介绍...");
        program.setNotice("需要提前入场...");

        program.setCity(new City());
        String cityName = info.getString("cityName");
        program.getCity().setName(cityName.substring(0, cityName.length() - 1));

        program.setCategoryId(Integer.parseInt(info.getString("categoryId")) % 10 + 1);

        // 获取所有场次信息
        JSONArray views = obj.getJSONObject("performCalendar").getJSONArray("performViews");
        program.setShows(new HashSet<>());
        for (Object view: views) {
            JSONObject vi = (JSONObject)view;
            Show show = new Show();
            show.setName(vi.getString("performName"));
            long showTime = Long.parseLong(vi.getString("performDateTS"));
            show.setTime(new Date(showTime));

            JSONArray skus = obj.getJSONObject("perform").getJSONArray("skuList");
            show.setLevels(new HashSet<>());
            for (Object sku : skus) {
                JSONObject sk = (JSONObject)sku;
                Level level = new Level();
                level.setName(sk.getString("priceName"));
                level.setPrice(RegUtil.regFind(sk.getString("price"), "(\\d+)"));
                level.setTotalCount(80);
                level.setLeftCount(80);
                level.setLimitCount(Integer.valueOf(sk.getString("salableQuantity")));
                show.getLevels().add(level);
            }
            program.getShows().add(show);
        }

    }

}
