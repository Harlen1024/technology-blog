//pipeline类将爬虫数据传入数据库

package com.mysql.pipeline;

import com.mysql.dao.BiQuGeDao;
import com.mysql.entity.Biquge;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.sql.SQLException;

public class MysqlPipelineBiQuGe implements Pipeline {

    public void process(ResultItems resultItems, Task task) {

        BiQuGeDao biqigedao = new BiQuGeDao();
        Biquge biquge = new Biquge();

        String title = resultItems.get("title");             //标题
        String author = resultItems.get("author");           //作者
        String info = resultItems.get("info");               //简介
        String image = resultItems.get("image");             //头图
        String chapter = resultItems.get("chapter");         //章节
        String content = resultItems.get("content");         //内容

        biquge.setTitle(title);
        biquge.setAuthor(author);
        biquge.setInfo(info);
        biquge.setImage(image);
        biquge.setChapter(chapter);
        biquge.setContent(content);

        try {
            biqigedao.addBooks(biquge);
            biqigedao.addBook(biquge);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
