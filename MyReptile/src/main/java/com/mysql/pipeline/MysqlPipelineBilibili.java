package com.mysql.pipeline;

import com.mysql.dao.BilibiliDao;
import com.mysql.entity.Bilibili;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.sql.SQLException;

public class MysqlPipelineBilibili implements Pipeline {

    public void process(ResultItems resultItems, Task task) {

        BilibiliDao bilidao = new BilibiliDao();
        Bilibili bili = new Bilibili();

        String title = resultItems.get("title");         //标题
        String image = resultItems.get("image");         //图片
        String up = resultItems.get("up");               //up
        String info = resultItems.get("info");           //简介
        String part = resultItems.get("part");           //分p
        String date = resultItems.get("date");           //时间截

        bili.setTitle(title);
        bili.setImage(image);
        bili.setUps(up);
        bili.setInfo(info);
        bili.setPart(part);
        bili.setDates(date);

        try {
            bilidao.addDatas(bili);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
