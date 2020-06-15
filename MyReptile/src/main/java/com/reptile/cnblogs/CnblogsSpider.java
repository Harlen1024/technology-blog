package com.reptile.cnblogs;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.model.HttpRequestBody;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.utils.HttpConstant;

import java.util.List;

public class CnblogsSpider implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000)
            .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");

    public static final String URL_LIST = "https://www.cnblogs.com/mvc/AggSite/PostList.aspx";

    public static int pageNum = 1;

    public void process(Page page) {

        if (page.getUrl().regex("^https://www\\.cnblogs\\.com$").match()) {
            try {
                page.addTargetRequests(page.getHtml().xpath("//*[@id=\"post_list\"]/div/div[@class='post_item_body']/h3/a/@href").all());
                pageNum++;
              //模拟post请求
                Request req = new Request();
                req.setMethod(HttpConstant.Method.POST);
                req.setUrl("https://www.cnblogs.com/mvc/AggSite/PostList.aspx");
                req.setRequestBody(HttpRequestBody.json("{CategoryType: 'SiteHome', ParentCategoryId: 0, CategoryId: 808, PageIndex: " + pageNum
                        + ", TotalPostCount: 4000,ItemListActionName:'PostList'}", "utf-8"));
                page.addTargetRequest(req);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (page.getUrl().regex(URL_LIST).match() && pageNum <= 200) {
            try {
                Thread.sleep(5000);
                List<String> urls = page.getHtml().xpath("//*[@class='post_item']//div[@class='post_item_body']/h3/a/@href ").all();
                page.addTargetRequests(urls);
                //模拟post请求
                Request req = new Request();
                req.setMethod(HttpConstant.Method.POST);
                req.setUrl("https://www.cnblogs.com/mvc/AggSite/PostList.aspx");
                req.setRequestBody(HttpRequestBody.json("{CategoryType: 'SiteHome', ParentCategoryId: 0, CategoryId: 808, PageIndex: " + ++pageNum
                        + ", TotalPostCount: 4000,ItemListActionName:'PostList'}", "utf-8"));
                page.addTargetRequest(req);
                System.out.println("CurrPage:" + pageNum + "#######################################");

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // 获取页面需要的内容,这里只取了标题，其他信息同理。
            System.out.println("抓取的内容：" + page.getHtml().xpath("//a[@id='cb_post_title_url']").get());
        }
    }

    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new CnblogsSpider()).addUrl("https://www.cnblogs.com").thread(3).run();
    }
}