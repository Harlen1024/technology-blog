package com.reptile.bilibili;

import com.mysql.dao.BilibiliDao;
import com.mysql.entity.Bilibili;

import com.mysql.pipeline.MysqlPipelineBilibili;
import com.tool.SplitJson;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;


import java.sql.SQLException;

import static com.reptile.json.GetHttpInterface.GetHttpInterface;

public class BilibiliReptile implements PageProcessor{

    //设置拼接的url变量
    //爬取av号从1至1000000
    private static int start =1;
    private static int end =1000000;

    //设置网站相关配置
    //重试次数和抓取间隔
    private Site site = Site.me().setRetryTimes(5).setSleepTime(0).setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36");

    public synchronized void process(Page page) {

        //视频标题
        page.putField("title",page.getHtml().xpath("//h1[@class='video-title']/span/text()").get());
        //如果title为空则跳过
        if (page.getResultItems().get("title") == null) {
            page.setSkip(true);
        }

        //标题图
        page.putField("image",page.getHtml().xpath("/html/head/meta[10]").get());

        //up
        page.putField("up",page.getHtml().xpath("//div[@class='name']/a[1]/text()").get());

        //简介
        page.putField("info",page.getHtml().xpath("//div[@class='u-info']/div[2]/text()").get());

        //分p
        page.putField("part",page.getHtml().xpath("//*[@id=\"multi_page\"]/div[1]/div/span/text()").get());

        //时间戳
        page.putField("date",page.getHtml().xpath("//div/time/text()").get());
    }

    public Site getSite() {
        // TODO Auto-generated method stub
        return site;
    }

    public static void main(String[] args) throws SQLException {

        int id = 1;

        BilibiliDao bilidao = new BilibiliDao();
        Bilibili bilibili = new Bilibili();

        SplitJson sj = new SplitJson();

        while (start<end) {

            Spider.create(new BilibiliReptile()).addUrl("https://www.bilibili.com/video/av" + start + "/")
                    //输出到控制台
                    .addPipeline(new ConsolePipeline())
                    //传输到数据库
                   // .addPipeline(new MysqlPipelineBilibili())
                    //开启5个线程抓取
                    .thread(5)
                    //启动爬虫
                    .run();

            String str = GetHttpInterface("https://api.bilibili.com/x/web-interface/archive/stat?aid=" + start);

            if((sj.splitCode(str)).equals("0"))
            {
                bilibili.setId(id);
                bilibili.setPlay(sj.splitView(str));
                bilibili.setBarrage(sj.splitDanmaku(str));
                bilidao.addData(bilibili);
                System.out.println(str);
                System.out.println("view:" + sj.splitView(str));
                System.out.println("danmuke:" + sj.splitView(str));
                id++;
            }

            start++;

        }
    }
}