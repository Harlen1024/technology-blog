package com.mysql.dao;

import com.mysql.db.DBUtil;
import com.mysql.entity.Bilibili;
import com.mysql.entity.Biquge;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BilibiliDao {

    //静态的标题，图片，up主，简介，分p
    public void addDatas(Bilibili bl) throws SQLException {

        // 获得数据库连接
        Connection conn = DBUtil.getConnection();

        String sql = "insert into bilibili (title,image,ups,info,part,date)values(?,?,?,?,?,?)";

        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1,bl.getTitle());
        ptmt.setString(2,bl.getImage());
        ptmt.setString(3,bl.getUps());
        ptmt.setString(4,bl.getInfo());
        ptmt.setString(5,bl.getPart());
        ptmt.setString(6,bl.getDates());

        ptmt.execute();
    }

    //动态的播放数，弹幕数
    public void addData(Bilibili bl) throws SQLException {

        // 获得数据库连接
        Connection conn = DBUtil.getConnection();

        String sql = "update bilibili set play=?,barrage=?where id=?";

        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1,bl.getPlay());
        ptmt.setString(2,bl.getBarrage());
        ptmt.setInt(3,bl.getId());


        ptmt.execute();
    }
}
